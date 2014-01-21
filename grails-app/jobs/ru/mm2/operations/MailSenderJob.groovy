package ru.mm2.operations



class MailSenderJob {
    static triggers = {
        cron name: 'myTrigger', cronExpression: "0 45 22 * * ?"
    }

    def mailService

    def execute() {
        println "!1"
        int prolong = 3
        Date diapStart = new Date()+prolong-1
        diapStart.hours=23
        diapStart.minutes=59
        Date diapFinish = new Date()+prolong+1
        diapFinish.hours=0
        diapFinish.minutes=0
        println "${diapStart}"
        println "${diapFinish}"
        for (GenOperationRecord currOper : GenOperationRecord.findByDate_timeBetween(diapStart, diapFinish)){
            String subjectText = currOper?.doctor?.email
            String toText = currOper?.doctor?.email
            String textText = "Операция ${currOper?.operation?.name} у ${currOper?.fio}"
            println currOper?.doctor?.email
            println "Операция на "+currOper.date_time
            mailService.sendMail{
                from "ru.mm2.operations@gmail.com"
                to toText
                subject subjectText
                text textText
            }
        }
        for (ComOperationRecord currComOper : ComOperationRecord.findByDate_timeBetween(diapStart, diapFinish)){
            String subjectText = currComOper?.doctor?.email
            String toText = currComOper?.doctor?.email
            String textText = "Операция ${currComOper?.operation?.name} у ${currComOper?.fio}"
            println toText
            println subjectText
            println textText
            mailService.sendMail{
                from "ru.mm2.operations@gmail.com"
                to toText
                subject subjectText
                text textText
            }
        }
        println "!2"
    }
}
