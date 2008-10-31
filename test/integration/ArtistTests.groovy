class ArtistTests extends GroovyTestCase {

    void testUnderscoreInName() {
        def artist = new Artist(name:'Jeff_Beck')
        assertFalse 'validation should have failed', artist.validate()
        
        def nameError = artist.errors?.getFieldError('name')
        assertNotNull 'name error should not have been null', nameError
        
        assertTrue 'expected message not found', 'artist.name.matches.error' in nameError.codes
    }
}
