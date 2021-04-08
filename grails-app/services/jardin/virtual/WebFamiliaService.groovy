package jardin.virtual

import grails.gorm.transactions.Transactional

import java.time.ZoneId
import java.time.ZonedDateTime

@Transactional
class WebFamiliaService {
    NotificacionService notificacionService
    def serviceMethod() {

    }

    List getFamilia(long idFamilia,Familiar familiar) {
        def miFamilia = Familia.get(idFamilia)
        miFamilia.attach()

        def vinculosTemporales = miFamilia.getVinculosTemporales()
        def vinculosPermanentes = miFamilia.getVinculosPermanentes()
        def soyPermanente = vinculosPermanentes.any { it.familiar == familiar }

        def solicitudes = miFamilia.solicitudes.findAll { it.estado == Estado.PENDIENTE }
        def ninos = miFamilia.ninos
        [miFamilia, ninos, solicitudes, vinculosPermanentes, vinculosTemporales, soyPermanente]
    }

    void crear(String nombre, String vinculo, Familiar familiar) {
        def familia = new Familia(nombre: nombre).save()
        new VinculoPermanente(descripcion: vinculo, familia: familia, familiar: familiar).save()
        familiar.refresh()
        familia.refresh()
    }

    void solicitarFamilia(long id, Familiar familiar, String vinculoSolicitud) {
        def familia = Familia.get(id)
        new SolicitudVinculoFamiliar(familiar: familiar, familia: familia, fecha: new Date(), estado: Estado.PENDIENTE, vinculo: vinculoSolicitud).save()

        familiar.refresh()
        familia.refresh()

        for (vinculo in familia.vinculos) {
            notificacionService.notificar(vinculo.familiar, "Solicitud de " + familiar + " para unirse a " + familia)
        }
    }

    SolicitudVinculoFamiliar aceptarSolicitudPermanente(long idSolicitud) {
        def solicitud = SolicitudVinculoFamiliar.get(idSolicitud)
        solicitud.estado = Estado.ACEPTADA

        def familiar = solicitud.familiar
        def familia = solicitud.familia
        new VinculoPermanente(descripcion: solicitud.vinculo, familia: familia, familiar: familiar).save()

        familiar.refresh()
        familia.refresh()
        notificacionService.notificar(solicitud.familiar, "Su solicitud para unirse a la familia " + solicitud.familia + " ha sido aprobada permanentemente")
        solicitud
    }

    SolicitudVinculoFamiliar aceptarSolicitudTemporal(long idSolicitud, long dias) {
        def solicitud = SolicitudVinculoFamiliar.get(idSolicitud)
        solicitud.estado = Estado.ACEPTADA

        ZonedDateTime desde = ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires"));
        ZonedDateTime hasta = desde.plusDays(dias)

        def familiar = solicitud.familiar
        def familia = solicitud.familia
        new VinculoTemporal(descripcion: solicitud.vinculo, familia: familia, familiar: familiar, desde: desde, hasta: hasta).save()

        familiar.refresh()
        familia.refresh()
        notificacionService.notificar(solicitud.familiar, "Su solicitud para unirse a la familia " + solicitud.familia + " ha sido aprobada temporalmente hasta " + hasta)
        solicitud
    }

    SolicitudVinculoFamiliar rechazarSolicitud(long idSolicitud) {
        def solicitud = SolicitudVinculoFamiliar.get(idSolicitud)
        //este cambio de estado podría hacerse en la clase Solicitud con un metodo rechazar
        solicitud.estado = Estado.RECHAZADA
        solicitud.save()
        solicitud.familiar.refresh()
        notificacionService.notificar(solicitud.familiar, "Su solicitud para unirse a la familia " + solicitud.familia + " ha sido rechazada")
        solicitud
    }

}
