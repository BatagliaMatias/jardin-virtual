package jardin.virtual

class Salita {
    int edadMinima
    int edadMaxima
    int cupoMaximo
    String nombre
    Set<Inscripcion> inscripciones
    Set<MaestroSalita> maestroSalitas
    Set<Actividad> actividades

    static hasMany = [inscripciones:Inscripcion,
                      maestroSalitas:MaestroSalita,
                      actividades:Actividad]

    static constraints = {

    }

    int cupo(){
        cupoMaximo - inscripciones.size()
    }

}
