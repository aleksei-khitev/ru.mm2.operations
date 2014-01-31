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
                if(result.size()>0){
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
                    result.any(){
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
                if(result.size()>0){
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
                if(result.size()>0){
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
                if(result.size()>0){
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
                    println attrs.tabindex
                    out << '<td id="dest" tabindex="1" style="color: red">'
                }else{
                    out << '<td style="color: red">'
                }
                out << g.formatDate (formatName:"custom.date.format", date:attrs.date)
                out << '</td>'
            }else{
                if(attrs.tabindex!=null){
                    println attrs.tabindex
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
                    println attrs.tabindex
                    out << '<td id="dest" tabindex="1" style="color: red">'
                }else{
                    out << '<td style="color: red">'
                }
                out << g.formatDate (formatName:"custom.date.format", date:attrs.date)
                out << '</td>'
            }else{
                if(attrs.tabindex!=null){
                    println attrs.tabindex
                    out << '<td id="dest" tabindex="1">'
                }else{
                    out << '<td>'
                }
                out << g.link( class:"create", action:"create", params:[date_time: "${attrs.date}"]){ g.formatDate (formatName:"custom.date.format", date:attrs.date)}
                out << '</td>'
            }
    }
}
