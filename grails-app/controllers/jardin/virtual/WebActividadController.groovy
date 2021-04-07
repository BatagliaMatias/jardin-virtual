package jardin.virtual

import grails.converters.JSON

class WebActividadController {
    WebMaestroService webMaestroService
    WebActividadService webActividadService
   // static allowedMethods = [index: 'GET', crear: 'POST']

    def index() { }

    def actividad(long id){
        respond webActividadService.getActividad(id)
    }

    def crear(){
        Maestro maestro = webMaestroService.validarSesionMaestro(session)
        webActividadService.crear(maestro,params)
        redirect(uri:"/webSalita/salita?id="+params.salita)
        //renderJson()
    }

    private void renderJson() {
        render(params)
    }

}
