package jardin.virtual



class Inscripcion {
    Nino nino
    Estado estado
    Salita salita

    static belongsTo = [nino:Nino,salita:Salita]
    static constraints = {
        nino nullable: false
        estado nullable: false
        salita nullable: false
    }
}
