package jardin.virtual

import grails.gorm.services.Service

@Service(VinculoPermanente)
interface VinculoPermanenteService {

    VinculoPermanente get(Serializable id)

    List<VinculoPermanente> list(Map args)

    Long count()

    void delete(Serializable id)

    VinculoPermanente save(VinculoPermanente vinculoPermanente)

}