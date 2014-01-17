package ru.mm2.operations



class MailSenderJob {
    static triggers = {
        //cron name: 'myTrigger', cronExpression: "0 55 17 * * ?"
    }

    def mailService

    def execute() {
        println "!1"
        List<OperationRecord> operations = OperationRecord.findByDate_timeBetween(new Date()+1, new Date()+2)
        List<ComOperationRecord> comOperations = ComOperationRecord.findByDate_time(new Date()+1, new Date()+2)
        for (OperationRecord currOper : operations){
            println currOper?.doctor?.email
        }
        for (ComOperationRecord currComOper : comOperations){
            println currComOper?.doctor?.email
        }
        mailService.sendMail{
            from "alexkhitev@gmail.com"
            to "alpha_7@mail.ru"
            subject "Test"
            text "Text"
        }
        println "!2"
    }
}
