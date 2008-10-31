class Artist {
    String name
    static hasMany = [albums: Album]
    
    String toString() {
        name
    }
    static constraints = {
        name matches: /[^_]*/, unique: true
    }
}
