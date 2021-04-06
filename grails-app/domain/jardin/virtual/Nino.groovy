package jardin.virtual

import groovy.transform.ToString


class Nino {
    String nombre
    String apellido
    Familia familia
    Cuaderno cuaderno
    Inscripcion inscripcion
    int edad

    static belongsTo = [familia:Familia]

    static hasOne = [cuaderno:Cuaderno, inscripcion:Inscripcion]

    static constraints = {
        nombre nullable: false, blank: false
        apellido nullable: false, blank: false
        inscripcion nullable: true
        cuaderno nullable: true //sino no puedo usar el scaffolding para crear
    }                           //No puedo crear cuaderno sin nino y nino sin cuaderno

    @Override
    String toString(){
        nombre + " " + apellido
    }
}
