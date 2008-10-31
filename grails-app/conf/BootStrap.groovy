class BootStrap {

    def init = { servletContext ->
        def jeffBeck = new Artist(name: 'Jeff Beck')
        jeffBeck.save()
        
        def blowByBlow = new Album(title: 'Blow By Blow')
        def wired = new Album(title: 'Wired')

        def blowByBlowTracks = ['You Know What I Mean',
        "She's A Woman",
        'Constipated Duck',
        'Air Blower',
        'Scatterbrain',
        "Cause We've Ended As Lovers",
        'Thelonius',
        'Freeway Jam',
        'Diamond Dust']

        def wiredTracks = ['Led Boots',
        'Come Dancing',
        'Goodbye Pork Pie Hat',
        'Head For Backstage Pass',
        'Blue Wind',
        'Sophie',
        'Play With Me',
        'Love Is Green']

        def addTrack = { album, trackName ->
            album.addToTracks name: trackName
        }

        blowByBlowTracks.each addTrack.curry(blowByBlow)
        wiredTracks.each addTrack.curry(wired)

        jeffBeck.addToAlbums blowByBlow
        jeffBeck.addToAlbums wired

        jeffBeck.save()
    }
    def destroy = {
    }
} 