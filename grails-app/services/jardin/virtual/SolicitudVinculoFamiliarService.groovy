package jardin.virtual

import grails.gorm.services.Service

@Service(SolicitudVinculoFamiliar)
interface SolicitudVinculoFamiliarService {

    SolicitudVinculoFamiliar get(Serializable id)

    List<SolicitudVinculoFamiliar> list(Map args)

    Long count()

    void delete(Serializable id)

    SolicitudVinculoFamiliar save(SolicitudVinculoFamiliar solicitudVinculoFamiliar)

}