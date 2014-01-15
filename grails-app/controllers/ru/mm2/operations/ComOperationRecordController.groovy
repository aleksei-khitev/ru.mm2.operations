package ru.mm2.operations



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.text.DateFormat
import java.text.SimpleDateFormat


@Transactional(readOnly = true)
class ComOperationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ComOperationRecord.list(params), model: [comOperationRecordInstanceCount: ComOperationRecord.count()]
    }

    def show(ComOperationRecord comOperationRecordInstance) {
        respond comOperationRecordInstance
    }

    def detailed() {
        respond ComOperationRecord.list(params)
    }

    def create() {
        DateFormat dateFormat
        String fio=""
        String diagnoz=""
        Date birthday = new Date()
        String oms
        String client_contact
        String doctor_id
        String parentfio
        if(params.from_consult){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("en","EN"))
            fio=params.fio
            diagnoz=params.diagnoz
            oms=params.oms
            birthday=dateFormat.parse(params.birthday)
            client_contact=params.client_contact
            doctor_id=params.doctor_id
            parentfio=params.parentfio
        }else{
            dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("en","EN"))
        }
        Date date = dateFormat.parse(params.date_time);
        List<ComOperationRecord> comOperationRecord = ComOperationRecord.findAllByDate_timeBetween((date-1),date)
        respond comOperationRecord, model: [comOperationRecordInstanceCount: ComOperationRecord.count(), date:date, fio:fio, diagnoz:diagnoz, birthday:birthday, oms:oms, client_contact:client_contact, doctor_id:doctor_id, parentfio:parentfio]
    }

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

    def edit(ComOperationRecord comOperationRecordInstance) {
        respond comOperationRecordInstance
    }

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

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'comOperationRecordInstance.label', default: 'ComOperationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def static collectPatologies(Date date){
        List<ComOperationRecord> list = (ComOperationRecord.findAllByDate_timeBetween((date-1),date))
        List<ComOperationRecord> result = new ArrayList<ComOperationRecord>()
        for(ComOperationRecord comOperationRecords : list){
            if(comOperationRecords.isPatology){
                result.add(comOperationRecords)
            }
        }
        return result
    }
}

