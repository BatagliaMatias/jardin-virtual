package jardin.virtual

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(excludes = 'ninos,vinculos,solicitudes')
class Familia {
    String nombre
    Set<Vinculo> vinculos
    Set<Nino> ninos
    Set<SolicitudVinculoFamiliar> solicitudes
    static hasMany = [vinculos:Vinculo,ninos:Nino,solicitudes:SolicitudVinculoFamiliar]

    static constraints = {
    }

    @Override
    String toString() {
        nombre + " #" + id
    }
}
