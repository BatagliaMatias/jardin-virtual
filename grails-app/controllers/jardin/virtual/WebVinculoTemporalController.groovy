package jardin.virtual

import javax.transaction.Transactional

/**
 * se agrego este controller y service asociado con prefijo Web para no modificar los que groovy grails generan
 * debería ir con el nombre sin Web
 */

class WebVinculoTemporalController {
    WebVinculoTemporalService webVinculoTemporalService

    def index() { }
    /**Asi se tienen que hacer los metodos de un controller
     * Llamar service para que trabaje con el modelo
     * El controller no maneja negocio
    */
    def extender(long id, long dias){
        if(session.user == null){
            return redirect (uri:"/login")
        }
        if(!session.user.isAttached()){
            session.user.attach();
        }

        webVinculoTemporalService.extender(session.user,id,dias)

        def vinculo = Vinculo.get(id)
        redirect (uri:"/webFamilia/familia?idFamilia="+vinculo.familia.id)
    }
}
