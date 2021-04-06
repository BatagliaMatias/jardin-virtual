package jardin.virtual

import grails.gorm.transactions.Transactional

@Transactional
class WebFamiliarService {
    Familiar validarSesionFamiliar(def session) {
        if(session.user == null){
            //Ver si se puede mejorar, un redirect en un service no es la mejor idea. Evita copiar y pegar código
            new FamiliarController().redirect (uri:"/login")
            return null
        }
        if(!session.user.isAttached()){
            session.user.attach();
        }

        if(session.user instanceof Familiar)
            session.user
        else
            null
    }
}
