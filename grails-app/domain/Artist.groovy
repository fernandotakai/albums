class Artist {
    String name
    
    String toString() {
        name
    }
    static constraints = {
        name matches: /[_^]*/
    }
}
