package ru.mm2.operations

import java.text.DateFormat
import java.text.SimpleDateFormat


class MailSenderJob {
    static triggers = {
        cron name: 'myTrigger', cronExpression: "0 0 9 * * ?"
    }

    def mailService

    def execute() {
        println "!1"
        DateFormat onlyDateFormat = new SimpleDateFormat("dd.MM.yyyy", new Locale("en","EN"))
        DateFormat onlyTimeFormat = new SimpleDateFormat("HH:mm", new Locale("en","EN"))
        //Date date = dateFormat.parse(params.date_time);
        int prolong = 2
        Date diapStart = new Date()+prolong
        diapStart.hours=0
        diapStart.minutes=0
        Date diapFinish = new Date()+prolong
        diapFinish.hours=23
        diapFinish.minutes=59
        println "${diapStart}"
        println "${diapFinish}"
        String mailText = "На ${onlyDateFormat.format(new Date()+prolong)}\r\n"
        mailText = "<html><head><meta http-equiv='Content-type' content='text/html; charset=utf-8' /><title></title></head><body><h3>На ${onlyDateFormat.format(new Date()+prolong)}</h3><br/><table border='1'>"
        List<GenOperationRecord> genOperationRecordList = GenOperationRecord.findAllByDate_timeBetween(diapStart, diapFinish);
        List<ComOperationRecord> comOperationRecordList = ComOperationRecord.findAllByDate_timeBetween(diapStart, diapFinish);
        List<ConsultationRecord> consultationRecordList = ConsultationRecord.findAllByDate_timeBetween(diapStart, diapFinish);
        List<ComConsultationRecord> comConsultationRecordList = ComConsultationRecord.findAllByDate_timeBetween(diapStart, diapFinish);
        mailText = "${mailText} <tr style='background-color: #1E90FF; color: white'><td colspan='4'>Госпитализации по ОМС</td></tr><tr style='background-color: mediumpurple; color: white'><td colspan='2'>ФИО</td><td>Диагноз</td><td>Дата рождения</td></tr>"
        if(genOperationRecordList.size()>0){
            for (GenOperationRecord currOper : genOperationRecordList){
                mailText = "${mailText}<tr><td colspan='2'>${currOper?.fio}</td><td>${currOper?.operation?.name}</td><td>${onlyDateFormat.format(currOper?.birthday)}</td></tr>"
            }
        }else{
            mailText = "${mailText}<tr><td colspan='4'>Нет</td></tr>"
        }
        mailText = "${mailText} <tr style='background-color: #1E90FF; color: white'><td colspan='4'>Госпитализации по ДМС и ХозРасчету</td></tr><tr style='background-color: forestgreen; color: white'><td colspan='2'>ФИО</td><td>Диагноз</td><td>Дата рождения</td></tr>"
        if(comOperationRecordList.size()>0){
            for (ComOperationRecord currComOper : comOperationRecordList){
                mailText = "${mailText}<tr><td colspan='2'>${currComOper?.fio}</td><td>${currComOper?.operation?.name}</td><td>${onlyDateFormat.format(currComOper?.birthday)}</td></tr>"
            }
        }else{
            mailText = "${mailText}<tr><td colspan='4'>Нет</td></tr>"
        }
        mailText = "${mailText} <tr style='background-color: #1E90FF; color: white'><td colspan='4'>Консультации по ОМС</td></tr><tr style='background-color: mediumpurple; color: white'><td>Время</td><td>ФИО</td><td>Диагноз</td><td>Дата рождения</td></tr>"
        if(consultationRecordList.size()>0){
            for (ConsultationRecord currCons : consultationRecordList){
                mailText = "${mailText}<tr><td>${currCons?.fio}</td><td>${onlyTimeFormat.format(currCons?.date_time)}</td><td>${currCons?.diagnoz}</td><td>${onlyDateFormat.format(currCons?.birthday)}</td></tr>"
            }
        }else{
            mailText = "${mailText}<tr><td colspan='4'>Нет</td></tr>"
        }
        mailText = "${mailText} <tr style='background-color: #1E90FF; color: white'><td colspan='4'>Консультации по ДМС и ХозРасчету</td></tr><tr style='background-color: forestgreen; color: white'><td>Время</td><td>ФИО</td><td>Диагноз</td><td>Дата рождения</td></tr>"
        if(comConsultationRecordList.size()>0){
            for (ComConsultationRecord currComCons : comConsultationRecordList){
                mailText = "${mailText}<tr><td>${currComCons?.fio}</td><td>${onlyTimeFormat.format(currComCons?.date_time)}</td><td>${currComCons?.diagnoz}</td><td>${onlyDateFormat.format(currComCons?.birthday)}</td></tr>"
            }
        }else{
            mailText = "${mailText}<tr><td colspan='4'>Нет</td></tr>"
        }
        mailText = "${mailText}</table></body></html>"
        mailService.sendMail{
            from "ru.mm2.operations@gmail.com"
            to "art1977.kashin@gmail.com"
            subject "На ${new Date()+prolong}\r\n"
            text mailText
        }
        mailService.sendMail{
            from "ru.mm2.operations@gmail.com"
            to "9045531637@mail.ru"
            subject "На ${new Date()+prolong}\r\n"
            html mailText
        }
        mailService.sendMail{
            from "ru.mm2.operations@gmail.com"
            to "alexkhitev@gmail.com"
            subject "На ${new Date()+prolong}\r\n"
            html mailText
        }
        println "!2"
    }
}
