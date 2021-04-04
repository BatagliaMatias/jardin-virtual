package jardin.virtual

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SolicitudVinculoFamiliarController {

    SolicitudVinculoFamiliarService solicitudVinculoFamiliarService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond solicitudVinculoFamiliarService.list(params), model:[solicitudVinculoFamiliarCount: solicitudVinculoFamiliarService.count()]
    }

    def show(Long id) {
        respond solicitudVinculoFamiliarService.get(id)
    }

    def create() {
        respond new SolicitudVinculoFamiliar(params)
    }

    def save(SolicitudVinculoFamiliar solicitudVinculoFamiliar) {
        if (solicitudVinculoFamiliar == null) {
            notFound()
            return
        }

        try {
            solicitudVinculoFamiliarService.save(solicitudVinculoFamiliar)
        } catch (ValidationException e) {
            respond solicitudVinculoFamiliar.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'solicitudVinculoFamiliar.label', default: 'SolicitudVinculoFamiliar'), solicitudVinculoFamiliar.id])
                redirect solicitudVinculoFamiliar
            }
            '*' { respond solicitudVinculoFamiliar, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond solicitudVinculoFamiliarService.get(id)
    }

    def update(SolicitudVinculoFamiliar solicitudVinculoFamiliar) {
        if (solicitudVinculoFamiliar == null) {
            notFound()
            return
        }

        try {
            solicitudVinculoFamiliarService.save(solicitudVinculoFamiliar)
        } catch (ValidationException e) {
            respond solicitudVinculoFamiliar.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'solicitudVinculoFamiliar.label', default: 'SolicitudVinculoFamiliar'), solicitudVinculoFamiliar.id])
                redirect solicitudVinculoFamiliar
            }
            '*'{ respond solicitudVinculoFamiliar, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        solicitudVinculoFamiliarService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'solicitudVinculoFamiliar.label', default: 'SolicitudVinculoFamiliar'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'solicitudVinculoFamiliar.label', default: 'SolicitudVinculoFamiliar'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
