package jardin.virtual

import grails.gorm.transactions.Transactional

@Transactional
class WebNinoService {

    def mostrarNino(long id) {
        def model = [:]
        def nino = Nino.get(id)
        model.nino = nino
        def estaInscripto = nino.inscripcion != null
        model.estaInscripto = estaInscripto

        if(estaInscripto){
            model.salita = nino.inscripcion.salita
            model.estaEsperandoAceptacion = nino.inscripcion.estado == Estado.PENDIENTE
        } else {
            def criteria = Salita.createCriteria()
            model.salitas = criteria.list{
                le("edadMinima",nino.edad)
                ge('edadMaxima',nino.edad)
                gt('cupo',0)
                order("cupo","desc")
            }
        }

        return model
    }
}
