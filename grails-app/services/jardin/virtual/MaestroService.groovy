package jardin.virtual

import grails.gorm.services.Service

@Service(Maestro)
interface MaestroService {

    Maestro get(Serializable id)

    List<Maestro> list(Map args)

    Long count()

    void delete(Serializable id)

    Maestro save(Maestro maestro)

}