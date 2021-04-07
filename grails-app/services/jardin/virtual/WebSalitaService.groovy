package jardin.virtual

import grails.gorm.transactions.Transactional

@Transactional
class WebSalitaService {
    NotificacionService notificacionService

    def serviceMethod() {

    }

    boolean inscribirse(long idSalita, long idNino, Familiar familiar) {
        Salita salita = Salita.get(idSalita)
        Nino nino = Nino.get(idNino)
        if(!familiar.esPermanenteDeNino(nino))
            return false
        if(salita.cupo() <= 0)
            return false
        if(salita.edadMaxima < nino.edad || salita.edadMinima > nino.edad)
            return false

        new Inscripcion(nino:nino,salita:salita,estado: Estado.PENDIENTE).save()


        nino.refresh()
        salita.refresh()
        familiar.refresh()
        return true
    }

    Map getSalita(long id,Maestro maestro) {
        Map map = [:]
        if(maestro.misSalitas.any{it.id == id}){
            Salita salita = Salita.get(id)
            map.salita = salita
            map.inscripcionesPendientes = salita.inscripciones.findAll{it.estado == Estado.PENDIENTE}
            map.ninos = salita.inscripciones.findAll{it.estado == Estado.ACEPTADA}.collect{it.nino}
            map.actividadesAbiertas = salita.actividades.findAll{it.tipo == Tipo.ABIERTA}
        }
        return map
    }

    long aceptar(long idInscripcion, Maestro maestro) {
        Inscripcion inscripcion = Inscripcion.get(idInscripcion)
        if(maestro.misSalitas.any{it.id == inscripcion.salita.id}){
            inscripcion.setEstado(Estado.ACEPTADA)
            inscripcion.save()
            maestro.refresh()
            inscripcion.salita.refresh()

            for (vinculo in inscripcion.nino.familia.vinculos){
                notificacionService.notificar(vinculo.familiar,"Su niño " + inscripcion.nino + " fue aceptado en la salita")
            }

            inscripcion.salita.id
        } else{
            -1
        }
    }
}
