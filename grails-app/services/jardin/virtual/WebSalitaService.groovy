package jardin.virtual

import grails.gorm.transactions.Transactional

@Transactional
class WebSalitaService {

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
}
