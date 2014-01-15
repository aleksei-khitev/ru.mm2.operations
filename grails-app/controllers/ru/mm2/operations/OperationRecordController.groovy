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
        List<OperationRecord> operationRecord = OperationRecord.findAllByDate_timeBetween((date-1),date)
        respond operationRecord, model: [operationRecordInstanceCount: OperationRecord.count(), date:date, fio:fio, diagnoz:diagnoz, birthday:birthday, oms:oms, client_contact:client_contact, doctor_id:doctor_id, parentfio:parentfio]
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

    def static collectPatologies(Date date){
        List<OperationRecord> list = (OperationRecord.findAllByDate_timeBetween((date-1),date))
        List<OperationRecord> result = new ArrayList<OperationRecord>()
        for(OperationRecord operationRecords : list){
            if(operationRecords.isPatology){
                result.add(operationRecords)
            }
        }
        return result
    }

    def static collectLessTreeYears(Date date){
        List<OperationRecord> list = (OperationRecord.findAllByDate_timeBetween((date-1),date))
        List<OperationRecord> result = new ArrayList<OperationRecord>()

        for(OperationRecord operationRecords : list){
            if((!operationRecords.isPatology)){
                if(((new Date()-operationRecords.birthday)/365)<3){
                    result.add(operationRecords)
                }
            }
        }
        return result
    }

    def static collectOthers(Date date){
        List<OperationRecord> list = (OperationRecord.findAllByDate_timeBetween((date-1),date))
        List<OperationRecord> result = new ArrayList<OperationRecord>()
        for(OperationRecord operationRecords : list){
            if(!operationRecords.isPatology){
                if(((new Date()-operationRecords.birthday)/365)>=3){
                    result.add(operationRecords)
                }
            }
        }
        return result
    }

    def static isSanday(Date date){
        SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yy" );
        df.applyPattern( "EEE" );
        String dayOfWeek = df.format( date )
        if(dayOfWeek=="Вс"){
            return true
        }else{
            return false
        }
    }

    def search = {
        def query = params.q
        if (!query) {
            return [:]
        }
        try {
            def searchResult = OperationRecord.search(query, params)
            return [searchResult: searchResult]
        } catch (e) {
            return [searchError: true]
        }
    }
}

