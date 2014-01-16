package ru.mm2.operations

import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OperationsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Operations.list(params), model: [operationsInstanceCount: Operations.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(Operations operationsInstance) {
        respond operationsInstance
    }

    @Secured(['ROLE_ROOT'])
    def create() {
        respond new Operations(params)
    }

    @Secured(['ROLE_ROOT'])
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

    @Secured(['ROLE_ROOT'])
    def edit(Operations operationsInstance) {
        respond operationsInstance
    }

    @Secured(['ROLE_ROOT'])
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

    @Secured(['ROLE_ROOT'])
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

    @Secured(['ROLE_OPER','ROLE_ROOT'])
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
