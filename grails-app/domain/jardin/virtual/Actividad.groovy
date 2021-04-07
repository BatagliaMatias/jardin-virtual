package jardin.virtual
enum Tipo{ABIERTA,CERRADA}
class Actividad {
    Date inicio
    Date fin
    Tipo tipo
    Set<Foto> fotos
    Set<Video> videos
    Set<Descargable> descargables
    String consigna
    Salita salita


    static belongsTo = [salita:Salita]

    static constraints = {
    }
}
