package jardin.virtual

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MaestroController {

    MaestroService maestroService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond maestroService.list(params), model:[maestroCount: maestroService.count()]
    }

    def show(Long id) {
        respond maestroService.get(id)
    }

    def create() {
        respond new Maestro(params)
    }

    def save(Maestro maestro) {
        if (maestro == null) {
            notFound()
            return
        }

        try {
            maestroService.save(maestro)
        } catch (ValidationException e) {
            respond maestro.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'maestro.label', default: 'Maestro'), maestro.id])
                redirect maestro
            }
            '*' { respond maestro, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond maestroService.get(id)
    }

    def update(Maestro maestro) {
        if (maestro == null) {
            notFound()
            return
        }

        try {
            maestroService.save(maestro)
        } catch (ValidationException e) {
            respond maestro.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'maestro.label', default: 'Maestro'), maestro.id])
                redirect maestro
            }
            '*'{ respond maestro, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        maestroService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'maestro.label', default: 'Maestro'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'maestro.label', default: 'Maestro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
