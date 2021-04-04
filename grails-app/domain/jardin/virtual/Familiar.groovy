package jardin.virtual

class Familiar {
    String nombre
    String apellido
    int dni
    String mail
    Set<Vinculo> vinculos
    String telegramId

    static hasMany = [vinculos: Vinculo]


    static constraints = {
        mail email:true
        nombre blank:false, nullable:false
        apellido blank:false, nullable:false
        dni nullable:false
    }

    @Override
    String toString() {
        nombre + " " + apellido
    }
}
