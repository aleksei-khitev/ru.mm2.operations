package ru.mm2.operations

import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.text.DateFormat
import java.text.SimpleDateFormat


@Transactional(readOnly = true)
class GenOperationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond GenOperationRecord.list(params), model: [genOperationRecordInstanceCount: GenOperationRecord.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(GenOperationRecord genOperationRecordInstance) {
        respond genOperationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def detailed() {
        respond GenOperationRecord.list(params)
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
        map.date=date
        List<GenOperationRecord> genOperationRecord = GenOperationRecord.findAllByDate_timeBetween((date-1),date)
        map.genOperationRecordInstanceCount=GenOperationRecord.count()
        respond genOperationRecord, model: map
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def save(GenOperationRecord genOperationRecordInstance) {
        if (genOperationRecordInstance == null) {
            notFound()
            return
        }

        if (genOperationRecordInstance.hasErrors()) {
            respond genOperationRecordInstance.errors, view: 'create'
            return
        }

        genOperationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'genOperationRecordInstance.label', default: 'GenOperationRecord'), genOperationRecordInstance.id])
                redirect genOperationRecordInstance
            }
            '*' { respond genOperationRecordInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def edit(GenOperationRecord genOperationRecordInstance) {
        respond genOperationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def update(GenOperationRecord genOperationRecordInstance) {
        if (genOperationRecordInstance == null) {
            notFound()
            return
        }

        if (genOperationRecordInstance.hasErrors()) {
            respond genOperationRecordInstance.errors, view: 'edit'
            return
        }

        genOperationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'GenOperationRecord.label', default: 'GenOperationRecord'), genOperationRecordInstance.id])
                redirect genOperationRecordInstance
            }
            '*' { respond genOperationRecordInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def delete(GenOperationRecord genOperationRecordInstance) {

        if (genOperationRecordInstance == null) {
            notFound()
            return
        }

        genOperationRecordInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'GenOperationRecord.label', default: 'GenOperationRecord'), genOperationRecordInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'genOperationRecordInstance.label', default: 'GenOperationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}

