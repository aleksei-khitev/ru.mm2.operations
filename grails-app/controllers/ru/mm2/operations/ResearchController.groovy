package ru.mm2.operations



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ResearchController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Research.list(params), model: [researchInstanceCount: Research.count()]
    }

    def show(Research researchInstance) {
        respond researchInstance
    }

    def create() {
        respond new Research(params)
    }

    @Transactional
    def save(Research researchInstance) {
        if (researchInstance == null) {
            notFound()
            return
        }

        if (researchInstance.hasErrors()) {
            respond researchInstance.errors, view: 'create'
            return
        }

        researchInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'researchInstance.label', default: 'Research'), researchInstance.id])
                redirect researchInstance
            }
            '*' { respond researchInstance, [status: CREATED] }
        }
    }

    def edit(Research researchInstance) {
        respond researchInstance
    }

    @Transactional
    def update(Research researchInstance) {
        if (researchInstance == null) {
            notFound()
            return
        }

        if (researchInstance.hasErrors()) {
            respond researchInstance.errors, view: 'edit'
            return
        }

        researchInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Research.label', default: 'Research'), researchInstance.id])
                redirect researchInstance
            }
            '*' { respond researchInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Research researchInstance) {

        if (researchInstance == null) {
            notFound()
            return
        }

        researchInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Research.label', default: 'Research'), researchInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'researchInstance.label', default: 'Research'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
