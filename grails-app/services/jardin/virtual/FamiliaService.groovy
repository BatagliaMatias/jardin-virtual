package jardin.virtual

import grails.gorm.services.Service

@Service(Familia)
interface FamiliaService {

    Familia get(Serializable id)

    List<Familia> list(Map args)

    Long count()

    void delete(Serializable id)

    Familia save(Familia familia)

}