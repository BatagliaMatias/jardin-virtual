package jardin.virtual

enum Urgencia {
    BAJA,MEDIA,ALTA
}

class Entrada {
    Cuaderno cuaderno
    Urgencia urgencia
    Date fecha
    Date fechaLectura
    Maestro autor
    Set<PedidoLectura> pedidosLectura

    static belongsTo = [cuaderno:Cuaderno]
    static hasOne = [autor:Maestro]
    static hasMany = [pedidosLectura:PedidoLectura]

    static constraints = {
        urgencia nullable: false
        fecha nullable:false
        autor nullable:false
        cuaderno nullable: false
    }
}
