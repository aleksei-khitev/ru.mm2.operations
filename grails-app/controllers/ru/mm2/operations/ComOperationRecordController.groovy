package ru.mm2.operations

import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.text.DateFormat
import java.text.SimpleDateFormat


@Transactional(readOnly = true)
class ComOperationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ComOperationRecord.list(params), model: [comOperationRecordInstanceCount: ComOperationRecord.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(ComOperationRecord comOperationRecordInstance) {
        respond comOperationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def detailed() {
        respond ComOperationRecord.list(params)
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def create() {
        DateFormat dateFormat
        def map = [:]
        if(params.from_consult){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("en","EN"))
            map.fio=params.fio
            map.diagnoz=params.diagnoz
            map.oms=params.oms
            map.birthday=dateFormat.parse(params.birthday)
            map.client_contact=params.client_contact
            map.doctor_id=params.doctor_id
            map.parentfio=params.parentfio
        }else{
            dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("en","EN"))
        }
        Date date = dateFormat.parse(params.date_time);
        List<ComOperationRecord> comOperationRecord = ComOperationRecord.findAllByDate_timeBetween((date-1),date)
        map.comOperationRecordInstanceCount=ComOperationRecord.count()
        respond comOperationRecord, model: map
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def save(ComOperationRecord comOperationRecordInstance) {
        if (comOperationRecordInstance == null) {
            notFound()
            return
        }

        if (comOperationRecordInstance.hasErrors()) {
            respond comOperationRecordInstance.errors, view: 'create'
            return
        }

        comOperationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'comOperationRecordInstance.label', default: 'ComOperationRecord'), comOperationRecordInstance.id])
                redirect comOperationRecordInstance
            }
            '*' { respond comOperationRecordInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def edit(ComOperationRecord comOperationRecordInstance) {
        respond comOperationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def update(ComOperationRecord comOperationRecordInstance) {
        if (comOperationRecordInstance == null) {
            notFound()
            return
        }

        if (comOperationRecordInstance.hasErrors()) {
            respond comOperationRecordInstance.errors, view: 'edit'
            return
        }

        comOperationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ComOperationRecord.label', default: 'ComOperationRecord'), comOperationRecordInstance.id])
                redirect comOperationRecordInstance
            }
            '*' { respond comOperationRecordInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def delete(ComOperationRecord comOperationRecordInstance) {

        if (comOperationRecordInstance == null) {
            notFound()
            return
        }

        comOperationRecordInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ComOperationRecord.label', default: 'ComOperationRecord'), comOperationRecordInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'comOperationRecordInstance.label', default: 'ComOperationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}

