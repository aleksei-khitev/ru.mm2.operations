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

import java.text.SimpleDateFormat

class OperationsTagLib {
    //static encodeAsForTags = [tagName: 'raw']
    def phoneWithPattern = {
        attrs ->
            if(attrs.value==null){
                out << g.textField (name:"${attrs.name}", value:"",  pattern:"[0-9]{7,10}")
            }else{
                out << g.textField (name:"${attrs.name}", value:"${attrs.value}",  pattern:"[0-9]{7,10}")
            }
    }

    def infoAboutRecord = {
        attrs ->
            if(attrs.lastUpdated){
                out << '<li class="fieldcontain">'
                out << '<span id="lastUpdated-label" class="property-label">Дата изменения записи</span>'
                out << '<span class="property-value" aria-labelledby="lastUpdated-label">'
                out << g.formatDate(formatName: "datetime.date.format", date: attrs.lastUpdated)
                out << '</span>'
                out << '</li>'
            }
            if(attrs.updatedUser){
                out << '<li class="fieldcontain">'
                out << '<span id="updatedUser-label" class="property-label">Последний оператор</span>'
                out << '<span class="property-value" aria-labelledby="updatedUser-label">'
                out << attrs.updatedUser
                out << '</span>'
                out << '</li>'
            }
    }

    def patologyRecordImages = {
        attrs ->
            if(attrs.domain!=null){
                def domain = grailsApplication.getDomainClass("ru.mm2.operations.${attrs.domain}").clazz
                Date date = attrs.date
                List list = (domain.findAllByDate_timeBetween((date-1),date))
                List result = new ArrayList()
                for(def records : list){
                    if(records.isPatology){
                        result.add(records)
                    }
                }
                for(int i=0; i<result.size(); i++){
                    result.any(){
                        out << '<img src="/ru.mm2.operations/static/images/type2.png" alt="Патология"/><br>'
                    }
                }

            }
    }

    def LessTreeYearsImages = {
        attrs ->
            if(attrs.domain!=null){
                def domain = grailsApplication.getDomainClass("ru.mm2.operations.${attrs.domain}").clazz
                Date date = attrs.date

                List list = (domain.findAllByDate_timeBetween((date-1),date))
                List result = new ArrayList()
                for(def records : list){
                    if(((new Date()-records.birthday)/365)<3){
                        result.add(records)
                    }
                }
                if(result.size()>0){
                    for(int i=0; i<result.size(); i++){
                        out << '<img src="/ru.mm2.operations/static/images/type1.png" alt="Патология"/><br>'
                    }
                }

            }
    }

    def NotLessImages = {
        attrs ->
            if(attrs.domain!=null){
                def domain = grailsApplication.getDomainClass("ru.mm2.operations.${attrs.domain}").clazz
                Date date = attrs.date

                List list = (domain.findAllByDate_timeBetween((date-1),date))
                List result = new ArrayList()
                for(def records : list){
                    if(((new Date()-records.birthday)/365)>=3){
                        result.add(records)
                    }
                }
                for(int i=0; i<result.size(); i++){
                    result.any(){
                        out << '<img src="/ru.mm2.operations/static/images/type3.png" alt="Патология"/><br>'
                    }
                }

            }
    }

    def NotLessNotPatologyImages = {
        attrs ->
            if(attrs.domain!=null){
                def domain = grailsApplication.getDomainClass("ru.mm2.operations.${attrs.domain}").clazz
                Date date = attrs.date

                List list = (domain.findAllByDate_timeBetween((date-1),date))
                List result = new ArrayList()
                for(def records : list){
                    if(!records.isPatology){
                        if(((new Date()-records.birthday)/365)>=3){
                            result.add(records)
                        }
                    }
                }
                for(int i=0; i<result.size(); i++){
                    result.any(){
                        out << '<img src="/ru.mm2.operations/static/images/type3.png" alt="Патология"/><br>'
                    }
                }

            }
    }

    def AllImages = {
        attrs ->
            if(attrs.domain!=null){
                def domain = grailsApplication.getDomainClass("ru.mm2.operations.${attrs.domain}").clazz
                Date date = attrs.date

                List list = (domain.findAllByDate_timeBetween((date-1),date))
                List result = new ArrayList()
                for(def records : list){
                        result.add(records)
                }
                for(int i=0; i<result.size(); i++){
                    result.any(){
                        out << '<img src="/ru.mm2.operations/static/images/type3.png" alt="Патология"/><br>'
                    }
                }

            }
    }

    def WorkOrSunday = {
        attrs ->
            SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yy" );
            df.applyPattern( "EEE" );
            String dayOfWeek = df.format( attrs.date )
            if(dayOfWeek=="Вс"){
                if(attrs.tabindex!=null){
                    out << '<td id="dest" tabindex="1" style="color: red">'
                }else{
                    out << '<td style="color: red">'
                }
                out << g.formatDate (formatName:"custom.date.format", date:attrs.date)
                out << '</td>'
            }else{
                if(attrs.tabindex!=null){
                    out << '<td id="dest" tabindex="1">'
                }else{
                    out << '<td>'
                }
                out << g.link( class:"create", action:"create", params:[date_time: "${attrs.date}"]){ g.formatDate (formatName:"custom.date.format", date:attrs.date)}
                out << '</td>'
            }
    }

    def WorkOrWeekend = {
        attrs ->
            SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yy" );
            df.applyPattern( "EEE" );
            String dayOfWeek = df.format( attrs.date )
            if(dayOfWeek=="Вс"||dayOfWeek=="Сб"){
                if(attrs.tabindex!=null){
                    out << '<td id="dest" tabindex="1" style="color: red">'
                }else{
                    out << '<td style="color: red">'
                }
                out << g.formatDate (formatName:"custom.date.format", date:attrs.date)
                out << '</td>'
            }else{
                if(attrs.tabindex!=null){
                    out << '<td id="dest" tabindex="1">'
                }else{
                    out << '<td>'
                }
                out << g.link( class:"create", action:"create", params:[date_time: "${attrs.date}"]){ g.formatDate (formatName:"custom.date.format", date:attrs.date)}
                out << '</td>'
            }
    }
}
