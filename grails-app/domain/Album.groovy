class Album {
    String title
    static belongsTo = [artist: Artist]
    static hasMany = [tracks: Track]

    List tracks
    
    String toString() {
        title
    }
    
    static constraints = {
        title matches: /[^_]*/, unique: 'artist'
    }
}