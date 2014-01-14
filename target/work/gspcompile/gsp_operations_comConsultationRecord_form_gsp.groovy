import ru.mm2.operations.ComConsultationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_comConsultationRecord_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/comConsultationRecord/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'fio', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("comConsultationRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("fio"),'value':(comConsultationRecordInstance?.fio)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'birthday', 'error'))
printHtmlPart(4)
invokeTag('message','g',13,['code':("comConsultationRecord.birthday.label"),'default':("Дата рождения пациента")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',16,['name':("birthday"),'precision':("day"),'value':(comConsultationRecordInstance?.birthday)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'date_time', 'error'))
printHtmlPart(6)
invokeTag('message','g',21,['code':("comConsultationRecord.date_time.label"),'default':("Дата консультации")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',24,['name':("date_time"),'precision':("day"),'value':(date)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'diagnoz', 'error'))
printHtmlPart(7)
invokeTag('message','g',29,['code':("comConsultationRecord.diagnoz.label"),'default':("Диагноз")],-1)
printHtmlPart(2)
invokeTag('textField','g',32,['name':("diagnoz"),'value':(comConsultationRecordInstance?.diagnoz)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'oms', 'error'))
printHtmlPart(8)
invokeTag('message','g',37,['code':("comConsultationRecord.oms.label"),'default':("Полис ОМС")],-1)
printHtmlPart(2)
invokeTag('textField','g',40,['name':("oms"),'value':(comConsultationRecordInstance?.oms)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'doctor', 'error'))
printHtmlPart(9)
invokeTag('message','g',45,['code':("comConsultationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(5)
invokeTag('select','g',48,['id':("doctor"),'name':("doctor.id"),'from':(ru.mm2.operations.Doctor.list()),'optionKey':("id"),'required':(""),'optionValue':("fio"),'value':(comConsultationRecordInstance?.doctor?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'client_contact', 'error'))
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
invokeTag('message','g',54,['code':("comConsultationRecord.client_contact.label"),'default':("Контакт для связи")],-1)
printHtmlPart(12)
invokeTag('textField','g',56,['name':("client_contact"),'value':(comConsultationRecordInstance?.client_contact),'pattern':("[0-9]{7,10}")],-1)
printHtmlPart(13)
})
invokeTag('toolTip','gui',57,['text':("7 цифр - городской телефон; 10 цифр - мобильный телефон")],1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'parentfio', 'error'))
printHtmlPart(14)
invokeTag('message','g',62,['code':("comConsultationRecord.parentfio.label"),'default':("ФИО родителей")],-1)
printHtmlPart(2)
invokeTag('textField','g',65,['name':("parentfio"),'value':(comConsultationRecordInstance?.parentfio)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'isNaprav', 'error'))
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(15)
invokeTag('message','g',71,['code':("comConsultationRecord.isNaprav.label"),'default':("Наличие направления")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',73,['name':("isNaprav"),'value':(comConsultationRecordInstance?.isNaprav)],-1)
printHtmlPart(13)
})
invokeTag('toolTip','gui',74,['text':("Срок действия 1 месяц")],1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'isPechat', 'error'))
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(16)
invokeTag('message','g',80,['code':("comConsultationRecord.isPechat.label"),'default':("Наличие печатей на направлении")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',82,['name':("isPechat"),'value':(comConsultationRecordInstance?.isPechat)],-1)
printHtmlPart(13)
})
invokeTag('toolTip','gui',83,['text':("На направлении должно быть 2 печати: печать для справок и печать ЛПУ ")],1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'isConfirm', 'error'))
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(17)
invokeTag('message','g',89,['code':("comConsultationRecord.isConfirm.label"),'default':("Контрольный обзвон")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',91,['name':("isConfirm"),'value':(comConsultationRecordInstance?.isConfirm)],-1)
printHtmlPart(13)
})
invokeTag('toolTip','gui',92,['text':("Если визит подтвержден, отметьте поле галочкой")],1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'prim', 'error'))
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(18)
invokeTag('message','g',98,['code':("comConsultationRecord.prim.label"),'default':("Примечание")],-1)
printHtmlPart(19)
invokeTag('textField','g',101,['name':("prim"),'value':(comConsultationRecordInstance?.prim)],-1)
printHtmlPart(13)
})
invokeTag('toolTip','gui',102,['text':("Результат обзвона")],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389176832000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
