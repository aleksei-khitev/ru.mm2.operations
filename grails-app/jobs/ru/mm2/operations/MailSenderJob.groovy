/*
 * ru.mm2.operations is an application for consultations and operations managing.
 * Copyright (c) 2014 Aleksei Khitevi (Хитёв Алексей Юрьевич), Guilnara Gamidova (Гюльнара Гамидова Вилаятовна).
 *
 * This file is part of ru.mm2.operations
 *
 * ru.mm2.operations is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * ru.mm2.operations is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
*/

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
        mailText = "<html><head><meta http-equiv='Content-type' content='text/html; charset=utf-8' /><title></title></head><body><h3>Список пациентов на <font color='darkred'>${onlyDateFormat.format(new Date()+prolong)}</font></h3><br/><table border='1'>"
        List<GenOperationRecord> genOperationRecordList = GenOperationRecord.findAllByDate_timeBetween(diapStart, diapFinish);
        List<ComOperationRecord> comOperationRecordList = ComOperationRecord.findAllByDate_timeBetween(diapStart, diapFinish);
        List<ConsultationRecord> consultationRecordList = ConsultationRecord.findAllByDate_timeBetween(diapStart, diapFinish);
        List<ComConsultationRecord> comConsultationRecordList = ComConsultationRecord.findAllByDate_timeBetween(diapStart, diapFinish);
        mailText = "${mailText} <tr style='background-color: mediumpurple; color: white'><td colspan='7'>Госпитализации по ОМС</td></tr><tr style='background-color: #1E90FF; color: white'><td colspan='2'>ФИО</td><td>Диагноз</td><td>Дата рождения</td><td>Обзвон</td><td>Комментарий</td><td>Телефон для связи</td></tr>"
        if(genOperationRecordList.size()>0){
            for (GenOperationRecord currOper : genOperationRecordList){
                mailText = "${mailText}<tr><td colspan='2'>${currOper?.fio}</td><td>${currOper?.operation?.name}</td><td>${onlyDateFormat.format(currOper?.birthday)}</td><td>${currOper?.formattedConfirm}</td><td>${currOper?.prim}</td><td>${currOper?.formattedPhone}</td></tr>"
            }
        }else{
            mailText = "${mailText}<tr><td colspan='7' align='center'>Нет</td></tr>"
        }
        mailText = "${mailText} <tr style='background-color: forestgreen; color: white'><td colspan='7'>Госпитализации по ДМС и ХозРасчету</td></tr><tr style='background-color: #1E90FF; color: white'><td colspan='2'>ФИО</td><td>Диагноз</td><td>Дата рождения</td><td>Обзвон</td><td>Комментарий</td><td>Телефон для связи</td></tr>"
        if(comOperationRecordList.size()>0){
            for (ComOperationRecord currComOper : comOperationRecordList){
                mailText = "${mailText}<tr><td colspan='2'>${currComOper?.fio}</td><td>${currComOper?.operation?.name}</td><td>${onlyDateFormat.format(currComOper?.birthday)}</td><td>${currComOper?.formattedConfirm}</td><td>${currComOper?.prim}</td><td>${currComOper?.formattedPhone}</td></tr>"
            }
        }else{
            mailText = "${mailText}<tr><td colspan='7' align='center'>Нет</td></tr>"
        }
        mailText = "${mailText} <tr style='background-color: mediumpurple; color: white'><td colspan='7'>Консультации по ОМС</td></tr><tr style='background-color: #1E90FF; color: white'><td>Время</td><td>ФИО</td><td>Диагноз</td><td>Дата рождения</td><td>Обзвон</td><td>Комментарий</td><td>Телефон для связи</td></tr>"
        if(consultationRecordList.size()>0){
            for (ConsultationRecord currCons : consultationRecordList){
                mailText = "${mailText}<tr><td>${onlyTimeFormat.format(currCons?.date_time)}</td><td>${currCons?.fio}</td><td>${currCons?.diagnoz}</td><td>${onlyDateFormat.format(currCons?.birthday)}</td><td>${currCons?.formattedConfirm}</td><td>${currCons?.prim}</td><td>${currCons?.formattedPhone}</td></tr>"
            }
        }else{
            mailText = "${mailText}<tr><td colspan='7' align='center'>Нет</td></tr>"
        }
        mailText = "${mailText} <tr style='background-color: forestgreen; color: white'><td colspan='7'>Консультации по ДМС и ХозРасчету</td></tr><tr style='background-color: #1E90FF; color: white'><td>Время</td><td>ФИО</td><td>Диагноз</td><td>Дата рождения</td><td>Обзвон</td><td>Комментарий</td><td>Телефон для связи</td></tr>"
        if(comConsultationRecordList.size()>0){
            for (ComConsultationRecord currComCons : comConsultationRecordList){
                mailText = "${mailText}<tr><td>${onlyTimeFormat.format(currComCons?.date_time)}</td><td>${currComCons?.fio}</td><td>${currComCons?.diagnoz}</td><td>${onlyDateFormat.format(currComCons?.birthday)}</td><td>${currComCons?.formattedConfirm}</td><td>${currComCons?.prim}</td><td>${currComCons?.formattedPhone}</td></tr>"
            }
        }else{
            mailText = "${mailText}<tr><td colspan='7' align='center'>Нет</td></tr>"
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
            to "zautas@gmail.com"
            subject "На ${new Date()+prolong}\r\n"
            html mailText
        }
        mailService.sendMail{
            from "ru.mm2.operations@gmail.com"
            to "mshabluk@mm2.ru"
            subject "На ${new Date()+prolong}\r\n"
            html mailText
        }
        mailService.sendMail{
            from "ru.mm2.operations@gmail.com"
            to "elmikava@ya.ru"
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
