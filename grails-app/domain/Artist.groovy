class Artist {
    String name
    static hasMany = [albums: Album]
    
    String toString() {
        name
    }

	def getTracks() {
		albums.tracks.flatten()
	}
	
	static transients = ["tracks"]
	
    static constraints = {
        name matches: /[^_]*/, unique: true
    }
    static mapping = {
        albums sort: 'title'
    }
}
