import ru.mm2.operations.ComOperationRecord
import ru.mm2.operations.ComOperationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_comOperationRecordcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/comOperationRecord/create.gsp" }
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
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'comOperationRecord.label', default: 'ComOperationRecord'))],-1)
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
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',34,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',37,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',38,['code':("default.listrecodheader.label"),'args':([entityName])],-1)
})
invokeTag('link','g',38,['class':("list"),'action':("index"),'style':("color: black")],2)
printHtmlPart(9)
invokeTag('message','g',43,['code':("default.createrecod.label"),'args':([entityName])],-1)
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
invokeTag('message','g',50,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',51,['bean':(comOperationRecordInstance),'var':("error")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',53,['bean':(comOperationRecordInstance)],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(20)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'fio', 'error'))
printHtmlPart(22)
invokeTag('message','g',60,['code':("comOperationRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(23)
if(true && ("${fio}!=''")) {
printHtmlPart(24)
invokeTag('textField','g',64,['name':("fio"),'value':(fio)],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('textField','g',67,['name':("fio"),'value':(comOperationRecordInstance?.fio)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'birthday', 'error'))
printHtmlPart(27)
invokeTag('message','g',73,['code':("comOperationRecord.birthday.label"),'default':("Дата рождения пациента")],-1)
printHtmlPart(28)
invokeTag('datePicker','g',77,['name':("birthday"),'precision':("day"),'value':(birthday)],-1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'diagnoz', 'error'))
printHtmlPart(30)
invokeTag('message','g',83,['code':("comOperationRecord.diagnoz.label"),'default':("Диагноз")],-1)
printHtmlPart(31)
if(true && ("${diagnoz}!=''")) {
printHtmlPart(24)
invokeTag('textField','g',88,['name':("diagnoz"),'value':(diagnoz)],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('textField','g',91,['name':("diagnoz"),'value':(comOperationRecordInstance?.diagnoz)],-1)
printHtmlPart(25)
}
printHtmlPart(29)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'isPatology', 'error'))
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(33)
invokeTag('message','g',99,['code':("comOperationRecord.isPatology.label"),'default':("Хроническая патология")],-1)
printHtmlPart(34)
invokeTag('checkBox','g',102,['name':("isPatology"),'value':(comOperationRecordInstance?.isPatology),'onclick':("hide_show_patology()")],-1)
printHtmlPart(24)
invokeTag('textField','g',103,['name':("patology"),'value':(comOperationRecordInstance?.patology),'style':("visibility: hidden")],-1)
printHtmlPart(25)
})
invokeTag('toolTip','gui',104,['text':("Страдает ли ребёнок какими-то хроническими заболевами?")],3)
printHtmlPart(35)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'isDisp', 'error'))
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(36)
invokeTag('message','g',111,['code':("comOperationRecord.isDisp.label"),'default':("Диспансерное наблюдение")],-1)
printHtmlPart(37)
invokeTag('checkBox','g',113,['name':("isDisp"),'value':(comOperationRecordInstance?.isDisp),'onclick':("hide_show_disp()")],-1)
printHtmlPart(24)
invokeTag('textField','g',114,['name':("disp"),'value':(comOperationRecordInstance?.disp),'style':("visibility: hidden")],-1)
printHtmlPart(25)
})
invokeTag('toolTip','gui',115,['text':("Состоит ли ребёнок на учёте у какого-нибудь специалиста?")],3)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'lastill', 'error'))
printHtmlPart(38)
invokeTag('message','g',120,['code':("comOperationRecord.lastill.label"),'default':("Последнее простудное заболевание")],-1)
printHtmlPart(23)
invokeTag('textField','g',123,['name':("lastill"),'value':(comOperationRecordInstance?.lastill)],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'parentfio', 'error'))
printHtmlPart(39)
invokeTag('message','g',128,['code':("comOperationRecord.parentfio.label"),'default':("ФИО родителей")],-1)
printHtmlPart(23)
if(true && ("${parentfio}!=''")) {
printHtmlPart(24)
invokeTag('textField','g',132,['name':("parentfio"),'value':(parentfio)],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('textField','g',135,['name':("parentfio"),'value':(comOperationRecordInstance?.parentfio)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'client_contact', 'error'))
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(40)
invokeTag('message','g',142,['code':("comOperationRecord.client_contact.label"),'default':("Контакт для связи")],-1)
printHtmlPart(34)
if(true && ("${client_contact}!=''")) {
printHtmlPart(41)
invokeTag('textField','g',146,['name':("client_contact"),'value':(client_contact),'pattern':("[0-9]{7,10}")],-1)
printHtmlPart(24)
}
else {
printHtmlPart(41)
invokeTag('textField','g',149,['name':("client_contact"),'value':(comOperationRecordInstance?.client_contact),'pattern':("[0-9]{7,10}")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
})
invokeTag('toolTip','gui',151,['text':("7 цифр - городской телефон; 10 цифр - мобильный телефон")],3)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'oms', 'error'))
printHtmlPart(42)
invokeTag('message','g',157,['code':("comOperationRecord.oms.label"),'default':("Полис ОМС")],-1)
printHtmlPart(23)
if(true && ("${oms}!=''")) {
printHtmlPart(24)
invokeTag('textField','g',161,['name':("oms"),'value':(oms)],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('textField','g',164,['name':("oms"),'value':(comOperationRecordInstance?.oms)],-1)
printHtmlPart(25)
}
printHtmlPart(29)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'operation', 'error'))
printHtmlPart(43)
invokeTag('message','g',171,['code':("comOperationRecord.operation.label"),'default':("Операция")],-1)
printHtmlPart(44)
invokeTag('select','g',174,['id':("operation"),'name':("operation.id"),'from':(ru.mm2.operations.Operations.list()),'optionKey':("id"),'required':(""),'value':(comOperationRecordInstance?.operation?.id),'optionValue':("name"),'class':("many-to-one")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'doctor', 'error'))
printHtmlPart(45)
invokeTag('message','g',179,['code':("comOperationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(28)
if(true && ("${doctor_id}!=''")) {
printHtmlPart(24)
invokeTag('select','g',184,['id':("doctor"),'name':("doctor.id"),'from':(ru.mm2.operations.Doctor.list()),'optionKey':("id"),'required':(""),'optionValue':("fio"),'value':(doctor_id),'class':("many-to-one")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('select','g',187,['id':("doctor"),'name':("doctor.id"),'from':(ru.mm2.operations.Doctor.list()),'optionKey':("id"),'required':(""),'optionValue':("fio"),'value':(comOperationRecordInstance?.doctor?.id),'class':("many-to-one")],-1)
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'date_time', 'error'))
printHtmlPart(46)
invokeTag('message','g',193,['code':("comOperationRecord.date_time.label"),'default':("Дата госпитализации")],-1)
printHtmlPart(44)
invokeTag('datePicker','g',196,['name':("date_time"),'precision':("day"),'value':(date)],-1)
printHtmlPart(47)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'isConfirm', 'error'))
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(48)
invokeTag('message','g',201,['code':("comOperationRecord.isConfirm.label"),'default':("Контрольный обзвон")],-1)
printHtmlPart(37)
invokeTag('checkBox','g',203,['name':("isConfirm"),'value':(comOperationRecordInstance?.isConfirm)],-1)
printHtmlPart(25)
})
invokeTag('toolTip','gui',204,['text':("Если визит подтвержден, отметьте поле галочкой")],3)
printHtmlPart(47)
expressionOut.print(hasErrors(bean: comOperationRecordInstance, field: 'prim', 'error'))
printHtmlPart(49)
invokeTag('message','g',208,['code':("comOperationRecord.prim.label"),'default':("Примечание")],-1)
printHtmlPart(23)
invokeTag('textField','g',211,['name':("prim"),'value':(comOperationRecordInstance?.prim)],-1)
printHtmlPart(50)
invokeTag('submitButton','g',216,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(51)
})
invokeTag('form','g',218,['url':([resource:comOperationRecordInstance, action:'save'])],2)
printHtmlPart(52)
invokeTag('message','g',221,['code':("default.listrecod.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(53)
invokeTag('sortableColumn','g',228,['property':("fio"),'title':(message(code: 'comOperationRecord.fio.label', default: 'ФИО пациента'))],-1)
printHtmlPart(54)
invokeTag('sortableColumn','g',229,['property':("fio"),'title':(message(code: 'comOperationRecord.operation.label', default: 'Операция'))],-1)
printHtmlPart(55)
invokeTag('message','g',230,['code':("comOperationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(56)
invokeTag('sortableColumn','g',231,['property':("birthday"),'title':(message(code: 'comOperationRecord.birthday.label', default: 'Дата рождения'))],-1)
printHtmlPart(54)
invokeTag('sortableColumn','g',232,['property':("diagnoz"),'title':(message(code: 'comOperationRecord.isConfirm.label', default: 'Обзвон'))],-1)
printHtmlPart(54)
invokeTag('sortableColumn','g',233,['property':("prim"),'title':(message(code: 'comOperationRecord.prim.label', default: 'Примечание'))],-1)
printHtmlPart(57)
loop:{
int i = 0
for( comOperationRecordInstance in (comOperationRecordInstanceList) ) {
printHtmlPart(54)
if(true && (comOperationRecordInstance?.isConfirm)) {
printHtmlPart(58)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(59)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: comOperationRecordInstance, field: "fio"))
})
invokeTag('link','g',240,['action':("show"),'id':(comOperationRecordInstance.id)],4)
printHtmlPart(60)
expressionOut.print(comOperationRecordInstance?.operation?.name)
printHtmlPart(61)
expressionOut.print(comOperationRecordInstance?.doctor?.fio)
printHtmlPart(62)
invokeTag('formatDate','g',243,['format':("dd.MM.yyyy"),'date':(comOperationRecordInstance?.birthday)],-1)
printHtmlPart(63)
invokeTag('checkBox','g',244,['name':("isConfirm "),'value':(comOperationRecordInstance?.isConfirm)],-1)
printHtmlPart(60)
expressionOut.print(comOperationRecordInstance?.prim)
printHtmlPart(64)
}
else {
printHtmlPart(58)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(65)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: comOperationRecordInstance, field: "fio"))
})
invokeTag('link','g',250,['action':("show"),'id':(comOperationRecordInstance.id)],4)
printHtmlPart(60)
expressionOut.print(comOperationRecordInstance?.operation?.name)
printHtmlPart(61)
expressionOut.print(comOperationRecordInstance?.doctor?.fio)
printHtmlPart(62)
invokeTag('formatDate','g',253,['format':("dd.MM.yyyy"),'date':(comOperationRecordInstance?.birthday)],-1)
printHtmlPart(63)
invokeTag('checkBox','g',254,['name':("isConfirm "),'value':(comOperationRecordInstance?.isConfirm)],-1)
printHtmlPart(60)
expressionOut.print(comOperationRecordInstance?.prim)
printHtmlPart(64)
}
printHtmlPart(66)
i++
}
}
printHtmlPart(67)
invokeTag('paginate','g',262,['total':(comOperationRecordInstanceCount ?: 0)],-1)
printHtmlPart(68)
})
invokeTag('captureBody','sitemesh',265,[:],1)
printHtmlPart(69)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389540006000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
