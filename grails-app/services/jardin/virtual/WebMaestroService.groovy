package jardin.virtual

import grails.gorm.transactions.Transactional

@Transactional
class WebMaestroService {

    Maestro validarSesionMaestro(def session) {
        if(session.user == null || !(session.user instanceof Maestro)){
            //Ver si se puede mejorar, un redirect en un service no es la mejor idea. Evita copiar y pegar código
            new FamiliarController().redirect (uri:"/login")
            return null
        }
        if(!session.user.isAttached()){
            session.user.attach();
        }

        return session.user

    }

    Map getMaestro(long id) {
        def map = [:]
        def maestro = Maestro.get(id)
        map.maestro = maestro
        map.salitas = maestro.getMisSalitas()
        return map
    }
}
