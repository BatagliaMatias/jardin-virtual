package jardin.virtual

class Nino {
    String nombre
    String apellido
    Familia familia
    Cuaderno cuaderno

    static belongsTo = [familia:Familia]

    static hasOne = [cuaderno:Cuaderno]

    static constraints = {
        nombre nullable: false, blank: false
        apellido nullable: false, blank: false
        cuaderno nullable: true //sino no puedo usar el scaffolding para crear
    }                           //No puedo crear cuaderno sin nino y nino sin cuaderno
}
