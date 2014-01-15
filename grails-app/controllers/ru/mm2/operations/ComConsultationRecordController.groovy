package ru.mm2.operations

import java.text.DateFormat
import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ComConsultationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ComConsultationRecord.list(params), model: [comConsultationRecordInstanceCount: ComConsultationRecord.count()]
    }

    def show(ComConsultationRecord operationRecordInstance) {
        respond operationRecordInstance
    }

    def create() {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("en","EN"))
        Date date = dateFormat.parse(params.date_time);
        List<ComConsultationRecord> comConsultationRecord = ComConsultationRecord.findAllByDate_timeBetween((date-1),date)
        respond comConsultationRecord, model: [comConsultationRecordInstanceCount: ComConsultationRecord.count(), date:date]
    }

    @Transactional
    def save(ComConsultationRecord comConsultationRecordInstance) {
        if (comConsultationRecordInstance == null) {
            notFound()
            return
        }

        if (comConsultationRecordInstance.hasErrors()) {
            respond comConsultationRecordInstance.errors, view: 'create'
            return
        }

        comConsultationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'comConsultationRecordInstance.label', default: 'ComConsultationRecord'), comConsultationRecordInstance.id])
                redirect comConsultationRecordInstance
            }
            '*' { respond comConsultationRecordInstance, [status: CREATED] }
        }
    }

    def edit(ComConsultationRecord comConsultationRecordInstance) {
        respond comConsultationRecordInstance
    }

    @Transactional
    def update(ComConsultationRecord comConsultationRecordInstance) {
        if (comConsultationRecordInstance == null) {
            notFound()
            return
        }

        if (comConsultationRecordInstance.hasErrors()) {
            respond comConsultationRecordInstance.errors, view: 'edit'
            return
        }

        comConsultationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ComConsultationRecord.label', default: 'ComConsultationRecord'), comConsultationRecordInstance.id])
                redirect comConsultationRecordInstance
            }
            '*' { respond comConsultationRecordInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ComConsultationRecord comConsultationRecordInstance) {

        if (comConsultationRecordInstance == null) {
            notFound()
            return
        }

        comConsultationRecordInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ComConsultationRecord.label', default: 'ComConsultationRecord'), comConsultationRecordInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'comConsultationRecordInstance.label', default: 'ComConsultationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def static collectLessTreeYears(Date date){
        List<ComConsultationRecord> list = (ComConsultationRecord.findAllByDate_timeBetween((date-1),date))
        List<ComConsultationRecord> result = new ArrayList<ComConsultationRecord>()

        for(ComConsultationRecord comConsultationRecord : list){
            if(((new Date()-comConsultationRecord.birthday)/365)<3){
                result.add(comConsultationRecord)
            }
        }
        return result
    }

    def static collectOthers(Date date){
        List<ComConsultationRecord> list = (ComConsultationRecord.findAllByDate_timeBetween((date-1),date))
        List<ComConsultationRecord> result = new ArrayList<ComConsultationRecord>()
        for(ComConsultationRecord comConsultationRecord : list){
            if(((new Date()-comConsultationRecord.birthday)/365)>=3){
                result.add(comConsultationRecord)
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
}
