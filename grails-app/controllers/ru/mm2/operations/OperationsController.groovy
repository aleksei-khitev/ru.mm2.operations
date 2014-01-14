package ru.mm2.operations



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OperationsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Operations.list(params), model: [operationsInstanceCount: Operations.count()]
    }

    def show(Operations operationsInstance) {
        respond operationsInstance
    }

    def create() {
        respond new Operations(params)
    }

    @Transactional
    def save(Operations operationsInstance) {
        if (operationsInstance == null) {
            notFound()
            return
        }

        if (operationsInstance.hasErrors()) {
            respond operationsInstance.errors, view: 'create'
            return
        }

        operationsInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'operationsInstance.label', default: 'Operations'), operationsInstance.id])
                redirect operationsInstance
            }
            '*' { respond operationsInstance, [status: CREATED] }
        }
    }

    def edit(Operations operationsInstance) {
        respond operationsInstance
    }

    @Transactional
    def update(Operations operationsInstance) {
        if (operationsInstance == null) {
            notFound()
            return
        }

        if (operationsInstance.hasErrors()) {
            respond operationsInstance.errors, view: 'edit'
            return
        }

        operationsInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Operations.label', default: 'Operations'), operationsInstance.id])
                redirect operationsInstance
            }
            '*' { respond operationsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Operations operationsInstance) {

        if (operationsInstance == null) {
            notFound()
            return
        }

        operationsInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Operations.label', default: 'Operations'), operationsInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'operationsInstance.label', default: 'Operations'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
