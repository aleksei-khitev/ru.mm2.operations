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
        String formatted_phone=""
        String temp = comOperationRecordInstance.client_contact
        if(temp.size()==7){
            formatted_phone="(812) "+temp.substring(0,3)+" - "+temp.substring(3,5)+" - "+temp.substring(5,7)
        }else if(temp.size()<10){
            formatted_phone="Неправильно набран номер. длинна может быть либо 7, либо 10 цифр"
        }else{
            formatted_phone="+7 ("+temp.substring(0,3)+") "+temp.substring(3,6)+" - "+temp.substring(6,8)+" - "+temp.substring(8,10)
        }
        respond comOperationRecordInstance, model: [formatted_phone:formatted_phone]
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

    def static collectLessTreeYears(Date date){
        List<ComOperationRecord> list = (ComOperationRecord.findAllByDate_timeBetween((date-1),date))
        List<ComOperationRecord> result = new ArrayList<ComOperationRecord>()

        for(ComOperationRecord comOperationRecords : list){
            if((!comOperationRecords.isPatology)){
                if(((new Date()-comOperationRecords.birthday)/365)<3){
                    result.add(comOperationRecords)
                }
            }
        }
        return result
    }

    def static collectOthers(Date date){
        List<ComOperationRecord> list = (ComOperationRecord.findAllByDate_timeBetween((date-1),date))
        List<ComOperationRecord> result = new ArrayList<ComOperationRecord>()
        for(ComOperationRecord comOperationRecords : list){
            if(!comOperationRecords.isPatology){
                if(((new Date()-comOperationRecords.birthday)/365)>=3){
                    result.add(comOperationRecords)
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
        println query
        if (!query) {
            return [:]
        }
        try {
            def searchResult = ComOperationRecord.search(query, params)
            return [searchResult: searchResult]
        } catch (e) {
            return [searchError: true]
        }
    }
}

