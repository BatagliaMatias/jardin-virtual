package jardin.virtual

class WebSalitaController {
    WebFamiliarService webFamiliarService
    WebSalitaService webSalitaService
    WebMaestroService webMaestroService

    def index() { }

    def errorInscripcion(){
        //se podría mandar parametro de error para dar un mejor mensaje al usuario
    }

    def salita(long id){
        Maestro maestro = webMaestroService.validarSesionMaestro(session)
        respond webSalitaService.getSalita(id,maestro)
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

    def aceptar(long idInscripcion){
        Maestro maestro = webMaestroService.validarSesionMaestro(session)
        long idSalita = webSalitaService.aceptar(idInscripcion,maestro)
        redirect(uri:"/webSalita/salita?id="+idSalita)
    }
}
