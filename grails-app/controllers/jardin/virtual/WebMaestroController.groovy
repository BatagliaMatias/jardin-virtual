package jardin.virtual

class WebMaestroController {
    WebMaestroService webMaestroService

    def index() { }

    def maestro(){
        def maestro = webMaestroService.validarSesionMaestro(session)
        respond webMaestroService.getMaestro(maestro.id) //quizas no hace falta pero para traer info desde el service y armar el mapa
    }
}
