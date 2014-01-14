import ru.mm2.operations.ComConsultationRecord
import ru.mm2.operations.ComConsultationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_comConsultationRecordcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/comConsultationRecord/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'comConsultationRecord.label', default: 'ComConsultationRecord'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.createrecod.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',15,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',18,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',19,['code':("default.listrecodheader.label"),'args':([entityName])],-1)
})
invokeTag('link','g',19,['class':("list"),'action':("index"),'style':("color: black")],2)
printHtmlPart(9)
invokeTag('message','g',24,['code':("default.createrecod.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(15)
expressionOut.print(error.field)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('message','g',31,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',32,['bean':(comConsultationRecordInstance),'var':("error")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',34,['bean':(comConsultationRecordInstance)],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(20)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'fio', 'error'))
printHtmlPart(22)
invokeTag('message','g',41,['code':("comConsultationRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(23)
invokeTag('textField','g',44,['name':("fio"),'value':(comConsultationRecordInstance?.fio)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'birthday', 'error'))
printHtmlPart(25)
invokeTag('message','g',49,['code':("comConsultationRecord.birthday.label"),'default':("Дата рождения пациента")],-1)
printHtmlPart(26)
invokeTag('datePicker','g',52,['name':("birthday"),'precision':("day"),'value':(comConsultationRecordInstance?.birthday)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'date_time', 'error'))
printHtmlPart(27)
invokeTag('message','g',57,['code':("comConsultationRecord.date_time.label"),'default':("Дата консультации")],-1)
printHtmlPart(26)
invokeTag('datePicker','g',60,['name':("date_time"),'precision':("day"),'value':(date)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'diagnoz', 'error'))
printHtmlPart(28)
invokeTag('message','g',65,['code':("comConsultationRecord.diagnoz.label"),'default':("Диагноз")],-1)
printHtmlPart(23)
invokeTag('textField','g',68,['name':("diagnoz"),'value':(comConsultationRecordInstance?.diagnoz)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'oms', 'error'))
printHtmlPart(29)
invokeTag('message','g',73,['code':("comConsultationRecord.oms.label"),'default':("Полис ОМС")],-1)
printHtmlPart(23)
invokeTag('textField','g',76,['name':("oms"),'value':(comConsultationRecordInstance?.oms)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'doctor', 'error'))
printHtmlPart(30)
invokeTag('message','g',81,['code':("comConsultationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(26)
invokeTag('select','g',84,['id':("doctor"),'name':("doctor.id"),'from':(ru.mm2.operations.Doctor.list()),'optionKey':("id"),'required':(""),'optionValue':("fio"),'value':(comConsultationRecordInstance?.doctor?.id),'class':("many-to-one")],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'client_contact', 'error'))
printHtmlPart(31)
createTagBody(3, {->
printHtmlPart(32)
invokeTag('message','g',90,['code':("comConsultationRecord.client_contact.label"),'default':("Контакт для связи")],-1)
printHtmlPart(33)
invokeTag('textField','g',92,['name':("client_contact"),'value':(comConsultationRecordInstance?.client_contact),'pattern':("[0-9]{7,10}")],-1)
printHtmlPart(34)
})
invokeTag('toolTip','gui',93,['text':("7 цифр - городской телефон; 10 цифр - мобильный телефон")],3)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'parentfio', 'error'))
printHtmlPart(35)
invokeTag('message','g',98,['code':("comConsultationRecord.parentfio.label"),'default':("ФИО родителей")],-1)
printHtmlPart(23)
invokeTag('textField','g',101,['name':("parentfio"),'value':(comConsultationRecordInstance?.parentfio)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'isNaprav', 'error'))
printHtmlPart(31)
createTagBody(3, {->
printHtmlPart(36)
invokeTag('message','g',107,['code':("comConsultationRecord.isNaprav.label"),'default':("Наличие направления")],-1)
printHtmlPart(33)
invokeTag('checkBox','g',109,['name':("isNaprav"),'value':(comConsultationRecordInstance?.isNaprav)],-1)
printHtmlPart(34)
})
invokeTag('toolTip','gui',110,['text':("Срок действия 1 месяц")],3)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'isPechat', 'error'))
printHtmlPart(31)
createTagBody(3, {->
printHtmlPart(37)
invokeTag('message','g',116,['code':("comConsultationRecord.isPechat.label"),'default':("Наличие печатей на направлении")],-1)
printHtmlPart(33)
invokeTag('checkBox','g',118,['name':("isPechat"),'value':(comConsultationRecordInstance?.isPechat)],-1)
printHtmlPart(34)
})
invokeTag('toolTip','gui',119,['text':("На направлении должно быть 2 печати: печать для справок и печать ЛПУ ")],3)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'isConfirm', 'error'))
printHtmlPart(31)
createTagBody(3, {->
printHtmlPart(38)
invokeTag('message','g',125,['code':("comConsultationRecord.isConfirm.label"),'default':("Контрольный обзвон")],-1)
printHtmlPart(33)
invokeTag('checkBox','g',127,['name':("isConfirm"),'value':(comConsultationRecordInstance?.isConfirm)],-1)
printHtmlPart(34)
})
invokeTag('toolTip','gui',128,['text':("Если визит подтвержден, отметьте поле галочкой")],3)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comConsultationRecordInstance, field: 'prim', 'error'))
printHtmlPart(31)
createTagBody(3, {->
printHtmlPart(39)
invokeTag('message','g',134,['code':("comConsultationRecord.prim.label"),'default':("Примечание")],-1)
printHtmlPart(40)
invokeTag('textField','g',137,['name':("prim"),'value':(comConsultationRecordInstance?.prim)],-1)
printHtmlPart(34)
})
invokeTag('toolTip','gui',138,['text':("Результат обзвона")],3)
printHtmlPart(41)
invokeTag('submitButton','g',142,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(42)
})
invokeTag('form','g',144,['url':([resource:comConsultationRecordInstance, action:'save'])],2)
printHtmlPart(43)
invokeTag('message','g',147,['code':("default.listrecod.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(44)
invokeTag('sortableColumn','g',154,['property':("fio"),'title':(message(code: 'comConsultationRecord.fio.label', default: 'ФИО пациента'))],-1)
printHtmlPart(45)
invokeTag('message','g',155,['code':("comConsultationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(46)
invokeTag('sortableColumn','g',156,['property':("birthday"),'title':(message(code: 'comConsultationRecord.birthday.label', default: 'Дата рождения'))],-1)
printHtmlPart(47)
loop:{
int i = 0
for( comConsultationRecordInstance in (comConsultationRecordInstanceList) ) {
printHtmlPart(48)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(49)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: comConsultationRecordInstance, field: "fio"))
})
invokeTag('link','g',162,['action':("show"),'id':(comConsultationRecordInstance.id)],3)
printHtmlPart(50)
expressionOut.print(comConsultationRecordInstance?.doctor?.fio)
printHtmlPart(51)
invokeTag('formatDate','g',164,['format':("dd.MM.yyyy"),'date':(comConsultationRecordInstance?.birthday)],-1)
printHtmlPart(52)
i++
}
}
printHtmlPart(53)
invokeTag('paginate','g',170,['total':(comConsultationRecordInstanceCount ?: 0)],-1)
printHtmlPart(54)
})
invokeTag('captureBody','sitemesh',173,[:],1)
printHtmlPart(55)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389539987000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
