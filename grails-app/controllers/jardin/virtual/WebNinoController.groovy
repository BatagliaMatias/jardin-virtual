package jardin.virtual

class WebNinoController {
    WebFamiliarService webFamiliarService
    WebNinoService webNinoService
    def nino(long id) {
        def familiar = webFamiliarService.validarSesionFamiliar(session)
        respond webNinoService.mostrarNino(id)
    }
}
