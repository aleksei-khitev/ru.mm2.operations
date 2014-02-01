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
        Date diapStart = new Date()+prolong-1
        diapStart.hours=23
        diapStart.minutes=59
        Date diapFinish = new Date()+prolong+1
        diapFinish.hours=0
        diapFinish.minutes=0
        println "${diapStart}"
        println "${diapFinish}"
        String mailText = "На ${onlyDateFormat.format(new Date()+prolong)}\r\n"
        mailText = "${mailText} Список операций по ОМС:\r\n"
        for (GenOperationRecord currOper : GenOperationRecord.findByDate_timeBetween(diapStart, diapFinish)){
            mailText = "${mailText} ${currOper?.fio}, ${currOper?.operation?.name}, ${currOper?.diagnoz}, ${onlyDateFormat.format(currOper?.birthday)}\r\n"
        }
        mailText = "${mailText} Список операций по ДМС и ХОЗРАСЧЁТУ:\r\n"
        for (ComOperationRecord currComOper : ComOperationRecord.findByDate_timeBetween(diapStart, diapFinish)){
            mailText = "${mailText} ${currComOper?.fio}, ${currComOper?.operation?.name}, ${currComOper?.diagnoz}, ${onlyDateFormat.format(currComOper?.birthday)}\r\n"
        }
        mailText = "${mailText} Список консультаций по ОМС:\r\n"
        for (ConsultationRecord currCons : ConsultationRecord.findByDate_timeBetween(diapStart, diapFinish)){
            mailText = "${mailText} ${currCons?.fio}, ${onlyTimeFormat.format(currCons?.date_time)}, ${currCons?.diagnoz}, ${onlyDateFormat.format(currCons?.birthday)}\r\n"
        }
        mailText = "${mailText} Список консультаций по ДМС и ХОЗРАСЧЁТУ:\r\n"
        for (ComConsultationRecord currComCons : ComConsultationRecord.findByDate_timeBetween(diapStart, diapFinish)){
            mailText = "${mailText} ${currComCons?.fio}, ${onlyTimeFormat.format(currComCons?.date_time)}, ${currComCons?.diagnoz}, ${onlyDateFormat.format(currComCons?.birthday)}\r\n"
        }
        /*mailService.sendMail{
            from "ru.mm2.operations@gmail.com"
            to "art1977.kashin@gmail.com"
            subject "На ${new Date()+prolong}\r\n"
            text mailText
        }*/
        mailService.sendMail{
            from "ru.mm2.operations@gmail.com"
            to "9045531637@mail.ru"
            subject "На ${new Date()+prolong}\r\n"
            text mailText
        }
        mailService.sendMail{
            from "ru.mm2.operations@gmail.com"
            to "alexkhitev@gmail.com"
            subject "На ${new Date()+prolong}\r\n"
            text mailText
        }
        println "!2"
    }
}
