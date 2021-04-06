package jardin.virtual

class WebSalitaController {
    WebFamiliarService webFamiliarService
    WebSalitaService webSalitaService
    def index() { }

    def errorInscripcion(){
        //se podría mandar parametro de error para dar un mejor mensaje al usuario
    }

    def inscribirse(long idSalita, long idNino){
        def familiar = webFamiliarService.validarSesionFamiliar(session)
        boolean resultadoOk = webSalitaService.inscribirse(idSalita,idNino,familiar)
        if(resultadoOk){
            redirect (uri:"/webNino/nino?id="+idNino)
        } else {
            redirect (uri:"/webNino/errorInscripcion")
        }
    }
}
