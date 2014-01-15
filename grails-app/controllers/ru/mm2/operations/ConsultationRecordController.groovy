package ru.mm2.operations

import java.text.DateFormat
import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConsultationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ConsultationRecord.list(params), model: [consultationRecordInstanceCount: ConsultationRecord.count()]
    }

    def show(ConsultationRecord operationRecordInstance) {
        respond operationRecordInstance
    }

    def create() {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("en","EN"))
        Date date = dateFormat.parse(params.date_time);
        List<ConsultationRecord> consultationRecord = ConsultationRecord.findAllByDate_timeBetween((date-1),date)
        respond consultationRecord, model: [consultationRecordInstanceCount: ConsultationRecord.count(), date:date]
    }

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

    def edit(ConsultationRecord consultationRecordInstance) {
        respond consultationRecordInstance
    }

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

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultationRecordInstance.label', default: 'ConsultationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def static collectLessTreeYears(Date date){
        List<ConsultationRecord> list = (ConsultationRecord.findAllByDate_timeBetween((date-1),date))
        List<ConsultationRecord> result = new ArrayList<ConsultationRecord>()

        for(ConsultationRecord consultationRecord : list){
                if(((new Date()-consultationRecord.birthday)/365)<3){
                    result.add(consultationRecord)
                }
        }
        return result
    }

    def static collectOthers(Date date){
        List<ConsultationRecord> list = (ConsultationRecord.findAllByDate_timeBetween((date-1),date))
        List<ConsultationRecord> result = new ArrayList<ConsultationRecord>()
        for(ConsultationRecord consultationRecord : list){
                if(((new Date()-consultationRecord.birthday)/365)>=3){
                    result.add(consultationRecord)
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
