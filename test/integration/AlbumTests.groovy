class AlbumTests extends GroovyTestCase {

    void testUnderscoreInTitle() {
        def album = new Album(title:'Some_Title')
        assertFalse 'validation should have failed', album.validate()

        def titleError = album.errors?.getFieldError('title')
        assertNotNull 'title error should not have been null', titleError
        
        assertTrue 'expected message not found', 'album.title.matches.error' in titleError.codes
    }
    
    void testAlbumsWithSameArtistAndSameTitle() {
        def artist = new Artist(name: 'Some Artist')
        artist.save(flush: true)
        def album1 = new Album(title: 'Some Album Title')
        def album2 = new Album(title: 'Some Album Title')

        artist.addToAlbums album1
        artist.save(flush: true)
        artist.addToAlbums album2
        
        assertFalse 'validation should have failed', artist.validate()

        def albumTitleError = artist.errors.getFieldError('albums.title')
        assertNotNull 'album title error should not have been null'
        assertTrue 'expected message not found', 'album.title.unique.error' in albumTitleError.codes
    }
}
