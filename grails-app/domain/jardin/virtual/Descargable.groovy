package jardin.virtual

class Descargable {
    String uri
    static constraints = {
        uri nullable: false, blank: false, url: true
    }
}
