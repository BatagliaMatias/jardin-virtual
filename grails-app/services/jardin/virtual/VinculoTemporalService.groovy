package jardin.virtual

import grails.gorm.services.Service

@Service(VinculoTemporal)
interface VinculoTemporalService {

    VinculoTemporal get(Serializable id)

    List<VinculoTemporal> list(Map args)

    Long count()

    void delete(Serializable id)

    VinculoTemporal save(VinculoTemporal vinculoTemporal)

}