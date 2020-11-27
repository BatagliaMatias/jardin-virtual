package jardin.virtual

class Foto {
    String uri
    static constraints = {
        uri nullable: false, blank: false, url: true
    }
}
