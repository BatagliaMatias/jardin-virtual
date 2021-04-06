package jardin.virtual

class WebNinoController {
    WebFamiliarService webFamiliarService
    def nino(long id) {
        def familiar = webFamiliarService.validarSesionFamiliar(session)
        respond model:[familiar:familiar]
    }
}
