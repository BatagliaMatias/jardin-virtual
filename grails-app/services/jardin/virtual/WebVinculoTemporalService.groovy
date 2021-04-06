package jardin.virtual

import grails.gorm.transactions.Transactional

@Transactional
class WebVinculoTemporalService {
    NotificacionService notificacionService

    def extender(Familiar solicitante, long id, long dias) {
        def vinculo = Vinculo.get(id)
        boolean vinculoSolicitanteEsPermanente = solicitante.getVinculosPermanentes().any({it.familia == vinculo.familia})

        if(vinculoSolicitanteEsPermanente){
            vinculo.extender(dias)
            vinculo.save()
            vinculo.familiar.refresh()
            vinculo.familia.refresh()
            solicitante.refresh()
            notificacionService.notificar(vinculo.familiar, "Su tiempo en "+vinculo.familia+ " fue extendido gracias a "+solicitante)
        }
    }
}
