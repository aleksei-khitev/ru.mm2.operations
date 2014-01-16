package ru.mm2.operations

import org.springframework.security.access.annotation.Secured

import java.text.DateFormat
import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConsultationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ConsultationRecord.list(params), model: [consultationRecordInstanceCount: ConsultationRecord.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(ConsultationRecord operationRecordInstance) {
        respond operationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def create() {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("en","EN"))
        Date date = dateFormat.parse(params.date_time);
        List<ConsultationRecord> consultationRecord = ConsultationRecord.findAllByDate_timeBetween((date-1),date)
        respond consultationRecord, model: [consultationRecordInstanceCount: ConsultationRecord.count(), date:date]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def save(ConsultationRecord consultationRecordInstance) {
        if (consultationRecordInstance == null) {
            notFound()
            return
        }

        if (consultationRecordInstance.hasErrors()) {
            respond consultationRecordInstance.errors, view: 'create'
            return
        }

        consultationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'consultationRecordInstance.label', default: 'ConsultationRecord'), consultationRecordInstance.id])
                redirect consultationRecordInstance
            }
            '*' { respond consultationRecordInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def edit(ConsultationRecord consultationRecordInstance) {
        respond consultationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def update(ConsultationRecord consultationRecordInstance) {
        if (consultationRecordInstance == null) {
            notFound()
            return
        }

        if (consultationRecordInstance.hasErrors()) {
            respond consultationRecordInstance.errors, view: 'edit'
            return
        }

        consultationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ConsultationRecord.label', default: 'ConsultationRecord'), consultationRecordInstance.id])
                redirect consultationRecordInstance
            }
            '*' { respond consultationRecordInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def delete(ConsultationRecord consultationRecordInstance) {

        if (consultationRecordInstance == null) {
            notFound()
            return
        }

        consultationRecordInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ConsultationRecord.label', default: 'ConsultationRecord'), consultationRecordInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultationRecordInstance.label', default: 'ConsultationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
