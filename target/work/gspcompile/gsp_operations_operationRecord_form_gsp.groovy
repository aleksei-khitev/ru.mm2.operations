import ru.mm2.operations.OperationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_operationRecord_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/operationRecord/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'fio', 'error'))
printHtmlPart(1)
invokeTag('message','g',22,['code':("operationRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(2)
if(true && ("${fio}!=''")) {
printHtmlPart(3)
invokeTag('textField','g',26,['name':("fio"),'value':(fio)],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('textField','g',29,['name':("fio"),'value':(operationRecordInstance?.fio)],-1)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'birthday', 'error'))
printHtmlPart(6)
invokeTag('message','g',35,['code':("operationRecord.birthday.label"),'default':("Дата рождения пациента")],-1)
printHtmlPart(7)
invokeTag('datePicker','g',39,['name':("birthday"),'precision':("day"),'value':(birthday)],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'diagnoz', 'error'))
printHtmlPart(9)
invokeTag('message','g',45,['code':("operationRecord.diagnoz.label"),'default':("Диагноз")],-1)
printHtmlPart(10)
if(true && ("${diagnoz}!=''")) {
printHtmlPart(3)
invokeTag('textField','g',50,['name':("diagnoz"),'value':(diagnoz)],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('textField','g',53,['name':("diagnoz"),'value':(operationRecordInstance?.diagnoz)],-1)
printHtmlPart(4)
}
printHtmlPart(8)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'isPatology', 'error'))
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
invokeTag('message','g',61,['code':("operationRecord.isPatology.label"),'default':("Хроническая патология")],-1)
printHtmlPart(13)
invokeTag('checkBox','g',64,['name':("isPatology"),'value':(operationRecordInstance?.isPatology),'onclick':("hide_show_patology()")],-1)
printHtmlPart(3)
invokeTag('textField','g',65,['name':("patology"),'value':(operationRecordInstance?.patology),'style':("visibility: hidden")],-1)
printHtmlPart(4)
})
invokeTag('toolTip','gui',66,['text':("Страдает ли ребёнок какими-то хроническими заболевами?")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'isDisp', 'error'))
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(15)
invokeTag('message','g',73,['code':("operationRecord.isDisp.label"),'default':("Диспансерное наблюдение")],-1)
printHtmlPart(16)
invokeTag('checkBox','g',75,['name':("isDisp"),'value':(operationRecordInstance?.isDisp),'onclick':("hide_show_disp()")],-1)
printHtmlPart(3)
invokeTag('textField','g',76,['name':("disp"),'value':(operationRecordInstance?.disp),'style':("visibility: hidden")],-1)
printHtmlPart(4)
})
invokeTag('toolTip','gui',77,['text':("Состоит ли ребёнок на учёте у какого-нибудь специалиста?")],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'lastill', 'error'))
printHtmlPart(17)
invokeTag('message','g',82,['code':("operationRecord.lastill.label"),'default':("Последнее простудное заболевание")],-1)
printHtmlPart(2)
invokeTag('textField','g',85,['name':("lastill"),'value':(operationRecordInstance?.lastill)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'parentfio', 'error'))
printHtmlPart(18)
invokeTag('message','g',90,['code':("operationRecord.parentfio.label"),'default':("ФИО родителей")],-1)
printHtmlPart(2)
invokeTag('textField','g',93,['name':("parentfio"),'value':(operationRecordInstance?.parentfio)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'client_contact', 'error'))
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(19)
invokeTag('message','g',99,['code':("operationRecord.client_contact.label"),'default':("Контакт для связи")],-1)
printHtmlPart(13)
if(true && ("${client_contact}!=''")) {
printHtmlPart(20)
invokeTag('textField','g',103,['name':("client_contact"),'value':(client_contact),'pattern':("[0-9]{7,10}")],-1)
printHtmlPart(3)
}
else {
printHtmlPart(20)
invokeTag('textField','g',106,['name':("client_contact"),'value':(operationRecordInstance?.client_contact),'pattern':("[0-9]{7,10}")],-1)
printHtmlPart(3)
}
printHtmlPart(4)
})
invokeTag('toolTip','gui',108,['text':("7 цифр - городской телефон; 10 цифр - мобильный телефон")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'oms', 'error'))
printHtmlPart(21)
invokeTag('message','g',114,['code':("operationRecord.oms.label"),'default':("Полис ОМС")],-1)
printHtmlPart(2)
if(true && ("${oms}!=''")) {
printHtmlPart(3)
invokeTag('textField','g',118,['name':("oms"),'value':(oms)],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('textField','g',121,['name':("oms"),'value':(operationRecordInstance?.oms)],-1)
printHtmlPart(4)
}
printHtmlPart(8)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'operation', 'error'))
printHtmlPart(22)
invokeTag('message','g',128,['code':("operationRecord.operation.label"),'default':("Операция")],-1)
printHtmlPart(23)
invokeTag('select','g',131,['id':("operation"),'name':("operation.id"),'from':(ru.mm2.operations.Operations.list()),'optionKey':("id"),'required':(""),'value':(operationRecordInstance?.operation?.id),'optionValue':("name"),'class':("many-to-one")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'doctor', 'error'))
printHtmlPart(24)
invokeTag('message','g',136,['code':("operationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(7)
if(true && ("${doctor_id}!=''")) {
printHtmlPart(3)
invokeTag('select','g',141,['id':("doctor"),'name':("doctor.id"),'from':(ru.mm2.operations.Doctor.list()),'optionKey':("id"),'required':(""),'optionValue':("fio"),'value':(doctor_id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('select','g',144,['id':("doctor"),'name':("doctor.id"),'from':(ru.mm2.operations.Doctor.list()),'optionKey':("id"),'required':(""),'optionValue':("fio"),'value':(operationRecordInstance?.doctor?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'date_time', 'error'))
printHtmlPart(25)
invokeTag('message','g',150,['code':("operationRecord.date_time.label"),'default':("Дата госпитализации")],-1)
printHtmlPart(23)
invokeTag('datePicker','g',153,['name':("date_time"),'precision':("day"),'value':(date)],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'isConfirm', 'error'))
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(27)
invokeTag('message','g',158,['code':("operationRecord.isConfirm.label"),'default':("Контрольный обзвон")],-1)
printHtmlPart(16)
invokeTag('checkBox','g',160,['name':("isConfirm"),'value':(operationRecordInstance?.isConfirm)],-1)
printHtmlPart(4)
})
invokeTag('toolTip','gui',161,['text':("Если визит подтвержден, отметьте поле галочкой")],1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'prim', 'error'))
printHtmlPart(28)
invokeTag('message','g',165,['code':("operationRecord.prim.label"),'default':("Примечание")],-1)
printHtmlPart(2)
invokeTag('textField','g',168,['name':("prim"),'value':(operationRecordInstance?.prim)],-1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389172281000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
