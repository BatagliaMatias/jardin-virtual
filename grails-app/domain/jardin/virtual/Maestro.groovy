package jardin.virtual

class Maestro {
    String nombre
    String apellido
    Set<MaestroSalita> maestroSalitas
    Set<Entrada> entradasCuaderno

    static hasMany = [maestroSalitas:MaestroSalita,
                      entradasCuaderno:Entrada]

    static constraints = {
        nombre nullable: false, blank: false
        apellido nullable: false, blank: false
        maestroSalitas nullable: true
        entradasCuaderno nullable: true
    }

    @Override
    String toString(){
        nombre + " " + apellido
    }

    def getMisSalitas() {
        if(maestroSalitas != null)
            maestroSalitas.collect {it.salita}
        else
            []
    }
}
