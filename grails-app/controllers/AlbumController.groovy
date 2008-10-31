class AlbumController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ albumInstanceList: Album.list( params ) ]
    }

    def show = {
        def albumInstance = Album.get( params.id )

        if(!albumInstance) {
            flash.message = "Album not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ albumInstance : albumInstance ] }
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
                flash.message = "Album ${params.id} updated"
                redirect(action:show,id:albumInstance.id)
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
            redirect(action:show,id:albumInstance.id)
        }
        else {
            render(view:'create',model:[albumInstance:albumInstance])
        }
    }
}
