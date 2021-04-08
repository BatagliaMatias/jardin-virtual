package jardin.virtual

import grails.gorm.transactions.Transactional

@Transactional
class WebFamiliarService {
    Familiar validarSesionFamiliar(def session) {
        if(session.user == null || !(session.user instanceof Familiar)){
            //Ver si se puede mejorar, un redirect en un service no es la mejor idea. Evita copiar y pegar código
            new FamiliarController().redirect (uri:"/login")
            return null
        }
        if(!session.user.isAttached()){
            session.user.attach();
        }

        return session.user
    }

    List getFamiliar(Familiar familiar) {
        def misVinculos = familiar.vinculos
        def misFamilias = misVinculos.collect { it.familia }
        //ver de resolver con criteria para sacarle más provecho a Hibernate
        //Puede volverse cuello de botella
        def otrasFamilias = Familia.list().findAll { misFamilias.indexOf(it) == -1 }
        def misSolicitudes = familiar.solicitudes
        def misFamiliasSolicitadas = misSolicitudes.collect { it.familia }
        if (!misFamiliasSolicitadas)
            misFamiliasSolicitadas = []
        [misFamiliasSolicitadas, misVinculos, otrasFamilias, misSolicitudes]
    }
}
