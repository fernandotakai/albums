class ArtistTests extends GroovyTestCase {

    void testUnderscoreInName() {
        def artist = new Artist(name:'Jeff_Beck')
        assertFalse 'validation should have failed because of underscore in name', artist.validate()
        
        def nameError = artist.errors?.getFieldError('name')
        assertNotNull 'name error should not have been null', nameError
        
        assertTrue 'expected message not found', 'artist.name.matches.error' in nameError.codes
    }
    
    void testArtistsWithSameName() {
        def artist1 = new Artist(name:'Johnny Winter')
        artist1.save(flush: true)
        
        def artist2 = new Artist(name:'Johnny Winter')
        assertFalse 'validation should have failed for dup artist', artist2.validate()

        def nameError = artist2.errors?.getFieldError('name')
        assertNotNull 'name error should not have been null', nameError

        assertTrue 'expected message not found', 'artist.name.unique.error' in nameError.codes
    }
}
