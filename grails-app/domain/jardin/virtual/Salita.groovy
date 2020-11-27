package jardin.virtual

class Salita {
    int edadMinima
    int edadMaxima
    int cupo
    Set<Inscripcion> inscripciones
    Set<MaestroSalita> maestroSalitas
    Set<Actividad> actividades

    static hasMany = [inscripciones:Inscripcion,
                      maestroSalitas:MaestroSalita,
                      actividades:Actividad]

    static constraints = {

    }
}
