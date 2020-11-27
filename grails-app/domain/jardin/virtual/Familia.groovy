package jardin.virtual

class Familia {
    Set<Vinculo> vinculos
    Set<Nino> ninos
    static hasMany = [vinculos:Vinculo,ninos:Nino]

    static constraints = {
    }
}
