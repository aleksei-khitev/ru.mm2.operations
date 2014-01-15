package ru.mm2.operations



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.text.DateFormat
import java.text.SimpleDateFormat


@Transactional(readOnly = true)
class OperationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond OperationRecord.list(params), model: [operationRecordInstanceCount: OperationRecord.count()]
    }

    def show(OperationRecord operationRecordInstance) {
        respond operationRecordInstance
    }

    def detailed() {
        respond OperationRecord.list(params)
    }

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
        List<OperationRecord> operationRecord = OperationRecord.findAllByDate_timeBetween((date-1),date)
        map.comOperationRecordInstanceCount=ComOperationRecord.count()
        respond operationRecord, model: map
    }

    @Transactional
    def save(OperationRecord operationRecordInstance) {
        if (operationRecordInstance == null) {
            notFound()
            return
        }

        if (operationRecordInstance.hasErrors()) {
            respond operationRecordInstance.errors, view: 'create'
            return
        }

        operationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'operationRecordInstance.label', default: 'OperationRecord'), operationRecordInstance.id])
                redirect operationRecordInstance
            }
            '*' { respond operationRecordInstance, [status: CREATED] }
        }
    }

    def edit(OperationRecord operationRecordInstance) {
        respond operationRecordInstance
    }

    @Transactional
    def update(OperationRecord operationRecordInstance) {
        if (operationRecordInstance == null) {
            notFound()
            return
        }

        if (operationRecordInstance.hasErrors()) {
            respond operationRecordInstance.errors, view: 'edit'
            return
        }

        operationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'OperationRecord.label', default: 'OperationRecord'), operationRecordInstance.id])
                redirect operationRecordInstance
            }
            '*' { respond operationRecordInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(OperationRecord operationRecordInstance) {

        if (operationRecordInstance == null) {
            notFound()
            return
        }

        operationRecordInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'OperationRecord.label', default: 'OperationRecord'), operationRecordInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'operationRecordInstance.label', default: 'OperationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

}

