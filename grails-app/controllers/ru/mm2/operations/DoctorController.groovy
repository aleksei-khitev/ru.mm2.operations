package ru.mm2.operations

import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional


@Transactional(readOnly = true)
class DoctorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Doctor.list(params), model: [doctorInstanceCount: Doctor.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(Doctor doctorInstance) {
        respond doctorInstance
    }

    @Secured(['ROLE_ROOT'])
    def create() {
        respond new Doctor(params)
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def save(Doctor doctorInstance) {
        if (doctorInstance == null) {
            notFound()
            return
        }

        if (doctorInstance.hasErrors()) {
            respond doctorInstance.errors, view: 'create'
            return
        }

        doctorInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'doctorInstance.label', default: 'Doctor'), doctorInstance.id])
                redirect doctorInstance
            }
            '*' { respond doctorInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ROOT'])
    def edit(Doctor doctorInstance) {
        respond doctorInstance
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def update(Doctor doctorInstance) {
        if (doctorInstance == null) {
            notFound()
            return
        }

        if (doctorInstance.hasErrors()) {
            respond doctorInstance.errors, view: 'edit'
            return
        }

        doctorInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Doctor.label', default: 'Doctor'), doctorInstance.id])
                redirect doctorInstance
            }
            '*' { respond doctorInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def delete(Doctor doctorInstance) {

        if (doctorInstance == null) {
            notFound()
            return
        }

        doctorInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Doctor.label', default: 'Doctor'), doctorInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctorInstance.label', default: 'Doctor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
