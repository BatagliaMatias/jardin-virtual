package jardin.virtual

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FamiliarController {

    FamiliarService familiarService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond familiarService.list(params), model:[familiarCount: familiarService.count()]
    }

    def show(Long id) {
        respond familiarService.get(id)
    }

    def create() {
        respond new Familiar(params)
    }

    def save(Familiar familiar) {
        if (familiar == null) {
            notFound()
            return
        }

        try {
            familiarService.save(familiar)
        } catch (ValidationException e) {
            respond familiar.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'familiar.label', default: 'Familiar'), familiar.id])
                redirect familiar
            }
            '*' { respond familiar, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond familiarService.get(id)
    }

    def update(Familiar familiar) {
        if (familiar == null) {
            notFound()
            return
        }

        try {
            familiarService.save(familiar)
        } catch (ValidationException e) {
            respond familiar.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'familiar.label', default: 'Familiar'), familiar.id])
                redirect familiar
            }
            '*'{ respond familiar, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        familiarService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'familiar.label', default: 'Familiar'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'familiar.label', default: 'Familiar'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
