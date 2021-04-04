package jardin.virtual



class Inscripcion {
    Nino nino
    Estado estado
    Date fechaInicio
    Date fechaFin
    Salita salita



    static belongsTo = [nino:Nino,salita:Salita]
    static constraints = {
        fechaInicio nullable: false
        nino nullable: false
        estado nullable: false
        salita nullable: false
    }
}
