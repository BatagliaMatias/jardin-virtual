package jardin.virtual

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(excludes = 'ninos,vinculos')
class Familia {
    String nombre
    Set<Vinculo> vinculos
    Set<Nino> ninos
    static hasMany = [vinculos:Vinculo,ninos:Nino]

    static constraints = {
    }

    @Override
    String toString() {
        nombre + " #" + id
    }
}
