package jardin.virtual

class WebFamiliaController {
    WebFamiliarService webFamiliarService
    WebFamiliaService webFamiliaService

    def index() {
        def familiar = webFamiliarService.validarSesionFamiliar(session)
        def (List misFamiliasSolicitadas, Set<Vinculo> misVinculos, List<Familia> otrasFamilias, Set<SolicitudVinculoFamiliar> misSolicitudes) = webFamiliarService.getFamiliar(familiar)
        respond model:[misFamiliasSolicitadas: misFamiliasSolicitadas,misVinculos: misVinculos, otrasFamilias:  otrasFamilias, misSolicitudes: misSolicitudes]
    }

    def familia(long idFamilia){
        def familiar = webFamiliarService.validarSesionFamiliar(session)
        def (Familia miFamilia, Set<Nino> ninos, Set<SolicitudVinculoFamiliar> solicitudes, List<VinculoPermanente> vinculosPermanentes, List<VinculoTemporal> vinculosTemporales, boolean soyPermanente) = webFamiliaService.getFamilia(idFamilia, familiar)
        respond model:[miFamilia: miFamilia,
                       ninos: ninos,
                       solicitudes:solicitudes,
                       vinculosPermanentes: vinculosPermanentes,
                       vinculosTemporales: vinculosTemporales,
                       soyPermanente:soyPermanente
        ]
    }

    def crearFamilia(String nombre, String vinculo){
        def familiar = webFamiliarService.validarSesionFamiliar(session)
        webFamiliaService.crear(nombre, vinculo, familiar)
        redirect (uri:"/webFamilia/")
    }

    def solicitarFamilia(long id, String vinculoSolicitud){
        def familiar = webFamiliarService.validarSesionFamiliar(session)
        webFamiliaService.solicitarFamilia(id, familiar, vinculoSolicitud)
        redirect (uri:"/webFamilia/")
    }

    def aceptarSolicitudPermanente(long idSolicitud){
        webFamiliarService.validarSesionFamiliar(session)
        SolicitudVinculoFamiliar solicitud = webFamiliaService.aceptarSolicitudPermanente(idSolicitud)
        redirect (uri:"/webFamilia/familia?idFamilia="+solicitud.familia.id)
    }

    def aceptarSolicitudTemporal(long idSolicitud, long dias){
        webFamiliarService.validarSesionFamiliar(session)
        SolicitudVinculoFamiliar solicitud = webFamiliaService.aceptarSolicitudTemporal(idSolicitud, dias)
        redirect (uri:"/webFamilia/familia?idFamilia="+solicitud.familia.id)
    }



    def rechazarSolicitud(long idSolicitud){
        webFamiliarService.validarSesionFamiliar(session)
        SolicitudVinculoFamiliar solicitud = webFamiliaService.rechazarSolicitud(idSolicitud)
        redirect (uri:"/webFamilia/familia?idFamilia="+solicitud.familia.id)
    }


}
