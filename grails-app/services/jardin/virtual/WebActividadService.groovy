package jardin.virtual

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class WebActividadService {
    NotificacionService notificacionService
    def serviceMethod() {

    }

    Map getActividad(long id){
        Map map = [:]
        Actividad actividad = Actividad.get(id)
        map.actividad = actividad
        map
    }

    void crear(Maestro maestro,GrailsParameterMap params) {
        Salita salita = Salita.get(params.salita)

        if(params.inicio > params.fin){
            throw new IllegalArgumentException("Fecha inicio no puede ser posterior al fin")
        }

        if(maestro.misSalitas.any{it.id == salita.id}) {
            List fotos = []
            if(params.fotos != null && params.fotos.contains('\r\n')) {
                String[] fotosParse = params.fotos.split('\r\n')
                if (fotosParse != null && fotosParse.size() > 0)
                    for (String uri : fotosParse) {
                        fotos.add(new Foto(uri: uri))
                    }
            }

            List videos = []
            if(params.videos != null && params.videos.contains('\r\n')) {
                String[] videosParse = params.videos.split('\r\n')
                if (videosParse != null && videosParse.size() > 0)
                    for (String uri : videosParse) {
                        videos.add(new Video(uri: uri))
                    }
            }

            List descargables = []
            if(params.descargables != null && params.descargables.contains('\r\n')) {
                String[] descargablesParse = params.descargables.split('\r\n')
                if (descargablesParse != null && descargablesParse.size() > 0)
                    for (String uri : descargablesParse) {
                        descargables.add(new Descargable(uri: uri))
                    }
            }

            new Actividad(inicio:params.inicio,
                    fin:params.fin,
                    tipo:Tipo.ABIERTA,
                    fotos:fotos,
                    videos:videos,
                    descargables:descargables,
                    consigna:params.consigna,
                    salita:salita
            ).save()

            salita.inscripciones.each {
                for (vinculo in it.nino.familia.vinculos){
                    notificacionService.notificar(vinculo.familiar,"Su niño " + it.nino + " tiene una nueva actividad")
                }
            }



        }


    }
}
