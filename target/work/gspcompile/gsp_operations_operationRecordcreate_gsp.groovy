import ru.mm2.operations.OperationRecord
import ru.mm2.operations.OperationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_operationRecordcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/operationRecord/create.gsp" }
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
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'operationRecord.label', default: 'OperationRecord'))],-1)
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
invokeTag('captureHead','sitemesh',31,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',33,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',36,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',37,['code':("default.listrecodheader.label"),'args':([entityName])],-1)
})
invokeTag('link','g',37,['class':("list"),'action':("index"),'style':("color: white")],2)
printHtmlPart(9)
invokeTag('message','g',42,['code':("default.createrecod.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(16)
expressionOut.print(error.field)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('message','g',49,['error':(error)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',50,['bean':(operationRecordInstance),'var':("error")],3)
printHtmlPart(20)
})
invokeTag('hasErrors','g',52,['bean':(operationRecordInstance)],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(21)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'fio', 'error'))
printHtmlPart(23)
invokeTag('message','g',59,['code':("operationRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(24)
if(true && ("${fio}!=''")) {
printHtmlPart(25)
invokeTag('textField','g',63,['name':("fio"),'value':(fio)],-1)
printHtmlPart(26)
}
else {
printHtmlPart(27)
invokeTag('textField','g',66,['name':("fio"),'value':(operationRecordInstance?.fio)],-1)
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'birthday', 'error'))
printHtmlPart(30)
invokeTag('message','g',72,['code':("operationRecord.birthday.label"),'default':("Дата рождения пациента")],-1)
printHtmlPart(31)
invokeTag('datePicker','g',76,['name':("birthday"),'precision':("day"),'value':(birthday)],-1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'diagnoz', 'error'))
printHtmlPart(33)
invokeTag('message','g',82,['code':("operationRecord.diagnoz.label"),'default':("Диагноз")],-1)
printHtmlPart(34)
if(true && ("${diagnoz}!=''")) {
printHtmlPart(27)
invokeTag('textField','g',87,['name':("diagnoz"),'value':(diagnoz)],-1)
printHtmlPart(28)
}
else {
printHtmlPart(27)
invokeTag('textField','g',90,['name':("diagnoz"),'value':(operationRecordInstance?.diagnoz)],-1)
printHtmlPart(28)
}
printHtmlPart(32)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'isPatology', 'error'))
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(36)
invokeTag('message','g',98,['code':("operationRecord.isPatology.label"),'default':("Хроническая патология")],-1)
printHtmlPart(37)
invokeTag('checkBox','g',101,['name':("isPatology"),'value':(operationRecordInstance?.isPatology),'onclick':("hide_show_patology()")],-1)
printHtmlPart(27)
invokeTag('textField','g',102,['name':("patology"),'value':(operationRecordInstance?.patology),'style':("visibility: hidden")],-1)
printHtmlPart(28)
})
invokeTag('toolTip','gui',103,['text':("Страдает ли ребёнок какими-то хроническими заболевами?")],3)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'isDisp', 'error'))
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
invokeTag('message','g',110,['code':("operationRecord.isDisp.label"),'default':("Диспансерное наблюдение")],-1)
printHtmlPart(41)
invokeTag('checkBox','g',112,['name':("isDisp"),'value':(operationRecordInstance?.isDisp),'onclick':("hide_show_disp()")],-1)
printHtmlPart(25)
invokeTag('textField','g',113,['name':("disp"),'value':(operationRecordInstance?.disp),'style':("visibility: hidden")],-1)
printHtmlPart(26)
})
invokeTag('toolTip','gui',114,['text':("Состоит ли ребёнок на учёте у какого-нибудь специалиста?")],3)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'lastill', 'error'))
printHtmlPart(42)
invokeTag('message','g',119,['code':("operationRecord.lastill.label"),'default':("Последнее простудное заболевание")],-1)
printHtmlPart(43)
invokeTag('textField','g',122,['name':("lastill"),'value':(operationRecordInstance?.lastill)],-1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'parentfio', 'error'))
printHtmlPart(44)
invokeTag('message','g',127,['code':("operationRecord.parentfio.label"),'default':("ФИО родителей")],-1)
printHtmlPart(43)
invokeTag('textField','g',130,['name':("parentfio"),'value':(operationRecordInstance?.parentfio)],-1)
printHtmlPart(28)
if(true && ("${parentfio}!=''")) {
printHtmlPart(27)
invokeTag('textField','g',132,['name':("parentfio"),'value':(parentfio)],-1)
printHtmlPart(28)
}
else {
printHtmlPart(27)
invokeTag('textField','g',135,['name':("parentfio"),'value':(operationRecordInstance?.parentfio)],-1)
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'client_contact', 'error'))
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(45)
invokeTag('message','g',142,['code':("operationRecord.client_contact.label"),'default':("Контакт для связи")],-1)
printHtmlPart(46)
if(true && ("${client_contact}!=''")) {
printHtmlPart(47)
invokeTag('textField','g',146,['name':("client_contact"),'value':(client_contact),'pattern':("[0-9]{7,10}")],-1)
printHtmlPart(48)
}
else {
printHtmlPart(47)
invokeTag('textField','g',149,['name':("client_contact"),'value':(operationRecordInstance?.client_contact),'pattern':("[0-9]{7,10}")],-1)
printHtmlPart(48)
}
printHtmlPart(28)
})
invokeTag('toolTip','gui',151,['text':("7 цифр - городской телефон; 10 цифр - мобильный телефон")],3)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'oms', 'error'))
printHtmlPart(49)
invokeTag('message','g',157,['code':("operationRecord.oms.label"),'default':("Полис ОМС")],-1)
printHtmlPart(43)
if(true && ("${oms}!=''")) {
printHtmlPart(27)
invokeTag('textField','g',161,['name':("oms"),'value':(oms)],-1)
printHtmlPart(28)
}
else {
printHtmlPart(27)
invokeTag('textField','g',164,['name':("oms"),'value':(operationRecordInstance?.oms)],-1)
printHtmlPart(28)
}
printHtmlPart(32)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'operation', 'error'))
printHtmlPart(50)
invokeTag('message','g',171,['code':("operationRecord.operation.label"),'default':("Операция")],-1)
printHtmlPart(51)
invokeTag('select','g',174,['id':("operation"),'name':("operation.id"),'from':(ru.mm2.operations.Operations.list()),'optionKey':("id"),'required':(""),'value':(operationRecordInstance?.operation?.id),'optionValue':("name"),'class':("many-to-one")],-1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'doctor', 'error'))
printHtmlPart(52)
invokeTag('message','g',179,['code':("operationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(53)
if(true && ("${doctor_id}!=''")) {
printHtmlPart(27)
invokeTag('select','g',184,['id':("doctor"),'name':("doctor.id"),'from':(ru.mm2.operations.Doctor.list()),'optionKey':("id"),'required':(""),'optionValue':("fio"),'value':(doctor_id),'class':("many-to-one")],-1)
printHtmlPart(28)
}
else {
printHtmlPart(27)
invokeTag('select','g',187,['id':("doctor"),'name':("doctor.id"),'from':(ru.mm2.operations.Doctor.list()),'optionKey':("id"),'required':(""),'optionValue':("fio"),'value':(operationRecordInstance?.doctor?.id),'class':("many-to-one")],-1)
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'date_time', 'error'))
printHtmlPart(54)
invokeTag('message','g',193,['code':("operationRecord.date_time.label"),'default':("Дата госпитализации")],-1)
printHtmlPart(51)
invokeTag('datePicker','g',196,['name':("date_time"),'precision':("day"),'value':(date)],-1)
printHtmlPart(55)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'isConfirm', 'error'))
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(56)
invokeTag('message','g',201,['code':("operationRecord.isConfirm.label"),'default':("Контрольный обзвон")],-1)
printHtmlPart(41)
invokeTag('checkBox','g',203,['name':("isConfirm"),'value':(operationRecordInstance?.isConfirm)],-1)
printHtmlPart(28)
})
invokeTag('toolTip','gui',204,['text':("Если визит подтвержден, отметьте поле галочкой")],3)
printHtmlPart(55)
expressionOut.print(hasErrors(bean: operationRecordInstance, field: 'prim', 'error'))
printHtmlPart(57)
invokeTag('message','g',208,['code':("operationRecord.prim.label"),'default':("Примечание")],-1)
printHtmlPart(43)
invokeTag('textField','g',211,['name':("prim"),'value':(operationRecordInstance?.prim)],-1)
printHtmlPart(58)
invokeTag('submitButton','g',216,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(59)
})
invokeTag('form','g',218,['url':([resource:operationRecordInstance, action:'save'])],2)
printHtmlPart(60)
invokeTag('message','g',221,['code':("default.listrecod.label"),'args':([entityName])],-1)
printHtmlPart(61)
if(true && (flash.message)) {
printHtmlPart(62)
expressionOut.print(flash.message)
printHtmlPart(63)
}
printHtmlPart(64)
invokeTag('sortableColumn','g',228,['property':("fio"),'title':(message(code: 'operationRecord.fio.label', default: 'ФИО пациента'))],-1)
printHtmlPart(65)
invokeTag('sortableColumn','g',229,['property':("fio"),'title':(message(code: 'operationRecord.operation.label', default: 'Операция'))],-1)
printHtmlPart(66)
invokeTag('message','g',230,['code':("operationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(67)
invokeTag('sortableColumn','g',231,['property':("birthday"),'title':(message(code: 'operationRecord.birthday.label', default: 'Дата рождения'))],-1)
printHtmlPart(65)
invokeTag('sortableColumn','g',232,['property':("diagnoz"),'title':(message(code: 'operationRecord.isConfirm.label', default: 'Обзвон'))],-1)
printHtmlPart(65)
invokeTag('sortableColumn','g',233,['property':("prim"),'title':(message(code: 'operationRecord.prim.label', default: 'Примечание'))],-1)
printHtmlPart(68)
loop:{
int i = 0
for( operationRecordInstance in (operationRecordInstanceList) ) {
printHtmlPart(65)
if(true && (operationRecordInstance?.isConfirm)) {
printHtmlPart(69)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(70)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: operationRecordInstance, field: "fio"))
})
invokeTag('link','g',240,['action':("show"),'id':(operationRecordInstance.id)],4)
printHtmlPart(71)
expressionOut.print(operationRecordInstance?.operation?.name)
printHtmlPart(72)
expressionOut.print(operationRecordInstance?.doctor?.fio)
printHtmlPart(73)
invokeTag('formatDate','g',243,['format':("dd.MM.yyyy"),'date':(operationRecordInstance?.birthday)],-1)
printHtmlPart(74)
invokeTag('checkBox','g',244,['name':("isConfirm "),'value':(operationRecordInstance?.isConfirm)],-1)
printHtmlPart(71)
expressionOut.print(operationRecordInstance?.prim)
printHtmlPart(75)
}
else {
printHtmlPart(69)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(76)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: operationRecordInstance, field: "fio"))
})
invokeTag('link','g',250,['action':("show"),'id':(operationRecordInstance.id)],4)
printHtmlPart(71)
expressionOut.print(operationRecordInstance?.operation?.name)
printHtmlPart(72)
expressionOut.print(operationRecordInstance?.doctor?.fio)
printHtmlPart(73)
invokeTag('formatDate','g',253,['format':("dd.MM.yyyy"),'date':(operationRecordInstance?.birthday)],-1)
printHtmlPart(74)
invokeTag('checkBox','g',254,['name':("isConfirm "),'value':(operationRecordInstance?.isConfirm)],-1)
printHtmlPart(71)
expressionOut.print(operationRecordInstance?.prim)
printHtmlPart(75)
}
printHtmlPart(77)
i++
}
}
printHtmlPart(78)
invokeTag('paginate','g',262,['total':(operationRecordInstanceCount ?: 0)],-1)
printHtmlPart(79)
})
invokeTag('captureBody','sitemesh',265,[:],1)
printHtmlPart(80)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389540179000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
