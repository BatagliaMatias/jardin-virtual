package jardin.virtual

import javax.transaction.Transactional
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

@Transactional
class WebFamiliaController {
    FamiliaService familiaService
    VinculoPermanenteService vinculoPermanenteService
    VinculoTemporalService vinculoTemporalService
    SolicitudVinculoFamiliarService solicitudVinculoFamiliarService
    NotificacionService notificacionService
    WebFamiliarService webFamiliarService

    def index() {
        def familiar = webFamiliarService.validarSesionFamiliar(session)

        def misVinculos = familiar.vinculos
        def misFamilias = misVinculos.collect {it.familia}
        def otrasFamilias = familiaService.list().findAll {misFamilias.indexOf(it) == -1}
        def misSolicitudes = familiar.solicitudes
        def misFamiliasSolicitadas = misSolicitudes.collect {it.familia}
        if(!misFamiliasSolicitadas)
            misFamiliasSolicitadas = []
        respond model:[misFamiliasSolicitadas: misFamiliasSolicitadas,misVinculos: misVinculos, otrasFamilias:  otrasFamilias, misSolicitudes: misSolicitudes]
    }

    def familia(long idFamilia){
        def familiar = webFamiliarService.validarSesionFamiliar(session)

        def miFamilia = familiaService.get(idFamilia)
        miFamilia.attach()

        def vinculosTemporales = miFamilia.getVinculosTemporales()
        def vinculosPermanentes = miFamilia.getVinculosPermanentes()
        def soyPermanente = vinculosPermanentes.any{it.familiar == familiar}

        def solicitudes = miFamilia.solicitudes.findAll {it.estado == Estado.PENDIENTE}
        def ninos = miFamilia.ninos
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

        def familia = new Familia(nombre: nombre)
        familiaService.save(familia)
        def vinculoPermanente = new VinculoPermanente(descripcion: vinculo, familia: familia, familiar: familiar)
        vinculoPermanenteService.save(vinculoPermanente)
        familiar.refresh()
        familia.refresh()
        redirect (uri:"/webFamilia/")
    }

    def solicitarFamilia(long id, String vinculoSolicitud){
        def familiar = webFamiliarService.validarSesionFamiliar(session)

        def familia = familiaService.get(id)
        def solicitud = new SolicitudVinculoFamiliar(familiar: familiar, familia: familia, fecha: new Date(),estado: Estado.PENDIENTE,vinculo:vinculoSolicitud)
        solicitudVinculoFamiliarService.save(solicitud)
        familiar.refresh()
        familia.refresh()

        for (vinculo in familia.vinculos){
            notificacionService.notificar(vinculo.familiar, "Solicitud de " + familiar + " para unirse a " + familia )
        }
        redirect (uri:"/webFamilia/")
    }

    def aceptarSolicitudPermanente(long idSolicitud){
        webFamiliarService.validarSesionFamiliar(session)

        def solicitud = solicitudVinculoFamiliarService.get(idSolicitud)
        solicitud.estado = Estado.ACEPTADA

        def familiar = solicitud.familiar
        def familia = solicitud.familia
        def vinculoPermanente = new VinculoPermanente(descripcion: solicitud.vinculo, familia: familia, familiar: familiar)
        vinculoPermanenteService.save(vinculoPermanente)
        familiar.refresh()
        familia.refresh()
        notificacionService.notificar(solicitud.familiar,"Su solicitud para unirse a la familia " + solicitud.familia + " ha sido aprobada permanentemente")
        redirect (uri:"/webFamilia/familia?idFamilia="+solicitud.familia.id)
    }

    def aceptarSolicitudTemporal(long idSolicitud, long dias){
        webFamiliarService.validarSesionFamiliar(session)

        def solicitud = solicitudVinculoFamiliarService.get(idSolicitud)
        solicitud.estado = Estado.ACEPTADA

        ZonedDateTime desde = ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires"));
        ZonedDateTime hasta = desde.plusDays(dias)

        def familiar = solicitud.familiar
        def familia = solicitud.familia
        def vinculoTemporal = new VinculoTemporal(descripcion: solicitud.vinculo, familia: familia, familiar: familiar, desde:desde, hasta:hasta)
        vinculoTemporalService.save(vinculoTemporal)
        familiar.refresh()
        familia.refresh()
        notificacionService.notificar(solicitud.familiar,"Su solicitud para unirse a la familia " + solicitud.familia + " ha sido aprobada temporalmente hasta " + hasta)
        redirect (uri:"/webFamilia/familia?idFamilia="+solicitud.familia.id)
    }

    def rechazarSolicitud(long idSolicitud){
        webFamiliarService.validarSesionFamiliar(session)

        def solicitud = solicitudVinculoFamiliarService.get(idSolicitud)
        solicitud.estado = Estado.RECHAZADA
        solicitudVinculoFamiliarService.save(solicitud)
        solicitud.familiar.refresh()


        notificacionService.notificar(solicitud.familiar,"Su solicitud para unirse a la familia " + solicitud.familia + " ha sido rechazada")
        redirect (uri:"/webFamilia/familia?idFamilia="+solicitud.familia.id)
    }
}
