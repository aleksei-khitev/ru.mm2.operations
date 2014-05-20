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

class ComConsultationRecord {
    Integer id
    Date date_time
    String client_contact
    String prim
    String fio
    String diagnoz
    String oms
    Date birthday
    Doctor doctor
    String parentfio
    Boolean isNaprav
    Boolean isPechat
    Boolean isConfirm
    Date lastUpdated
    String updatedUser
    static transients = ['formattedPhone','formattedConfirm']
    String getFormattedPhone(){
        if(client_contact.size()==7){
            "(812) ${client_contact.substring(0,3)} - ${client_contact.substring(3,5)} - ${client_contact.substring(5,7)}"
        }else if(client_contact.size()<10){
            "Неправильно набран номер. длинна может быть либо 7, либо 10 цифр"
        }else{
            "+7 (${client_contact.substring(0,3)}) ${client_contact.substring(3,6)} - ${client_contact.substring(6,8)} - ${client_contact.substring(8,10)}"
        }
    }
    String getFormattedConfirm(){
        if(isConfirm){
            "Да"
        }else{
            "нет"
        }
    }
    static belongsTo = [doctor:Doctor]
    static searchable = true
    static constraints = {
        birthday nullable: false, blank: false
        oms nullable: false, blank: false
        diagnoz nullable: false, blank: false
        fio nullable: false, blank: false
        prim nullable: true
        client_contact nullable: false, blank: false
        date_time nullable: false, blank: false
    }
    static mapping = {
        table 'com_consultation_records'
    }
}
