package jardin.virtual

class Video {
    String uri
    static constraints = {
        uri nullable: false, blank: false, url: true
    }
}
