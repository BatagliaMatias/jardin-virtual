package jardin.virtual

class PedidoLectura {
    Entrada entrada
    Date fecha

    static belongsTo = [entrada:Entrada]

    static constraints = {
        entrada nullable: false
        fecha nullable: false
    }
}
