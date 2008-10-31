class AlbumController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ albumInstanceList: Album.list( params ) ]
    }

    def show = {
        def artistName = params.artistName.decodeArtistName()
        def albumTitle = params.albumTitle.decodeAlbumTitle()
        
        def albumInstance = Album.withCriteria(uniqueResult: true) {
            eq 'title', albumTitle
            artist {
                eq 'name', artistName
            }
        }

        if(!albumInstance) {
            flash.message = "Album not for artist ${artistName} with album title ${albumTitle}"
            redirect(action:list)
        }
        else { return [ albumInstance : albumInstance ] }
    }

    def addTrack = {
        def album = Album.get(params.albumId)
        album.addToTracks name: params.trackName
        render template: 'tracks', model:[tracks: album.tracks]
    }
    
    def delete = {
        def albumInstance = Album.get( params.id )
        if(albumInstance) {
            albumInstance.delete()
            flash.message = "Album ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Album not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def albumInstance = Album.get( params.id )

        if(!albumInstance) {
            flash.message = "Album not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ albumInstance : albumInstance ]
        }
    }

    def update = {
        def albumInstance = Album.get( params.id )
        if(albumInstance) {
            albumInstance.properties = params
            if(!albumInstance.hasErrors() && albumInstance.save()) {
                flash.message = "Album ${albumInstance.title} updated"
                redirect(action:show, params:[artistName: albumInstance.artist.name.encodeAsArtistName(),
                                              albumTitle: albumInstance.title.encodeAsAlbumTitle()])
            }
            else {
                render(view:'edit',model:[albumInstance:albumInstance])
            }
        }
        else {
            flash.message = "Album not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def albumInstance = new Album()
        albumInstance.properties = params
        return ['albumInstance':albumInstance]
    }

    def save = {
        def albumInstance = new Album(params)
        if(!albumInstance.hasErrors() && albumInstance.save()) {
            flash.message = "Album ${albumInstance.id} created"
            redirect(action:show, params:[artistName: albumInstance.artist.name.encodeAsArtistName(), 
                                          albumTitle: albumInstance.title.encodeAsAlbumTitle()])
        }
        else {
            render(view:'create',model:[albumInstance:albumInstance])
        }
    }
}
