package jardin.virtual

class Cuaderno {
    Nino nino
    Set<Entrada> entradas
    static hasMany = [entradas:Entrada]
    static belongsTo = [nino:Nino]

    static constraints = {
    }
}
