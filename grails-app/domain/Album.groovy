class Album {
    String title
    static belongsTo = [artist: Artist]
    static hasMany = [tracks: Track]
    
    String toString() {
        title
    }
    
    static constraints = {
        title matches: /[^_]*/, unique: 'artist'
    }
}