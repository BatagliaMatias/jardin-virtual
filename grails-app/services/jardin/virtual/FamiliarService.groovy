package jardin.virtual

import grails.gorm.services.Service

@Service(Familiar)
interface FamiliarService {

    Familiar get(Serializable id)

    List<Familiar> list(Map args)

    Long count()

    void delete(Serializable id)

    Familiar save(Familiar familiar)

}