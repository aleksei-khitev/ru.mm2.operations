import ru.mm2.operations.OperationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_operationRecordshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/operationRecord/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'operationRecord.label', default: 'OperationRecord'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.showrecod.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',16,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',19,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',20,['code':("default.listrecodheader.label"),'args':([entityName])],-1)
})
invokeTag('link','g',20,['class':("list"),'action':("index"),'style':("color: white")],2)
printHtmlPart(9)
invokeTag('message','g',25,['code':("default.showrecod.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (operationRecordInstance?.fio)) {
printHtmlPart(14)
invokeTag('message','g',33,['code':("operationRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',35,['bean':(operationRecordInstance),'field':("fio")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (operationRecordInstance?.birthday)) {
printHtmlPart(18)
invokeTag('message','g',42,['code':("operationRecord.birthday.label"),'default':("Дата рождения пациента")],-1)
printHtmlPart(19)
invokeTag('formatDate','g',44,['format':("dd.MM.yyyy"),'date':(operationRecordInstance?.birthday)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (operationRecordInstance?.diagnoz)) {
printHtmlPart(22)
invokeTag('message','g',51,['code':("operationRecord.diagnoz.label"),'default':("Диагноз")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',53,['bean':(operationRecordInstance),'field':("diagnoz")],-1)
printHtmlPart(16)
}
printHtmlPart(24)
invokeTag('message','g',60,['code':("operationRecord.isPatology.label"),'default':("Хроническая патология")],-1)
printHtmlPart(25)
if(true && (operationRecordInstance?.isPatology)) {
printHtmlPart(26)
invokeTag('fieldValue','g',65,['bean':(operationRecordInstance),'field':("patology")],-1)
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
invokeTag('message','g',77,['code':("operationRecord.isDisp.label"),'default':("Диспансерное наблюдение")],-1)
printHtmlPart(30)
if(true && (operationRecordInstance?.isDisp)) {
printHtmlPart(26)
invokeTag('fieldValue','g',81,['bean':(operationRecordInstance),'field':("disp")],-1)
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(31)
if(true && (operationRecordInstance?.lastill)) {
printHtmlPart(32)
invokeTag('message','g',92,['code':("operationRecord.lastill.label"),'default':("Последнее простудное заболевание")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',94,['bean':(operationRecordInstance),'field':("lastill")],-1)
printHtmlPart(16)
}
printHtmlPart(34)
if(true && (operationRecordInstance?.parentfio)) {
printHtmlPart(35)
invokeTag('message','g',101,['code':("operationRecord.parentfio.label"),'default':("ФИО родителей")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',103,['bean':(operationRecordInstance),'field':("parentfio")],-1)
printHtmlPart(16)
}
printHtmlPart(34)
if(true && (operationRecordInstance?.client_contact)) {
printHtmlPart(37)
invokeTag('message','g',110,['code':("operationRecord.client_contact.label"),'default':("Контакт для связи")],-1)
printHtmlPart(38)
expressionOut.print(formatted_phone)
printHtmlPart(39)
}
printHtmlPart(34)
if(true && (operationRecordInstance?.oms)) {
printHtmlPart(40)
invokeTag('message','g',120,['code':("operationRecord.oms.label"),'default':("Полис ОМС")],-1)
printHtmlPart(41)
invokeTag('fieldValue','g',122,['bean':(operationRecordInstance),'field':("oms")],-1)
printHtmlPart(16)
}
printHtmlPart(34)
if(true && (operationRecordInstance?.operation)) {
printHtmlPart(42)
invokeTag('message','g',129,['code':("operationRecord.operation.label"),'default':("Операция")],-1)
printHtmlPart(43)
createTagBody(3, {->
expressionOut.print(operationRecordInstance?.operation?.name)
})
invokeTag('link','g',131,['controller':("operations"),'action':("show"),'id':(operationRecordInstance?.operation?.id)],3)
printHtmlPart(16)
}
printHtmlPart(34)
if(true && (operationRecordInstance?.doctor)) {
printHtmlPart(44)
invokeTag('message','g',138,['code':("operationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(45)
createTagBody(3, {->
expressionOut.print(operationRecordInstance?.doctor?.fio)
})
invokeTag('link','g',140,['controller':("doctor"),'action':("show"),'id':(operationRecordInstance?.doctor?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (operationRecordInstance?.date_time)) {
printHtmlPart(46)
invokeTag('message','g',147,['code':("operationRecord.date_time.label"),'default':("Дата госпитализации")],-1)
printHtmlPart(47)
invokeTag('formatDate','g',149,['format':("dd.MM.yyyy"),'date':(operationRecordInstance?.date_time)],-1)
printHtmlPart(20)
}
printHtmlPart(17)
if(true && (operationRecordInstance?.prim)) {
printHtmlPart(48)
invokeTag('message','g',156,['code':("operationRecord.prim.label"),'default':("Примечание")],-1)
printHtmlPart(49)
invokeTag('fieldValue','g',158,['bean':(operationRecordInstance),'field':("prim")],-1)
printHtmlPart(20)
}
printHtmlPart(34)
if(true && (operationRecordInstance?.isConfirm)) {
printHtmlPart(50)
invokeTag('message','g',165,['code':("operationRecord.isConfirm.label"),'default':("Контрольный обзвоне")],-1)
printHtmlPart(51)
invokeTag('formatBoolean','g',167,['boolean':(operationRecordInstance?.isConfirm)],-1)
printHtmlPart(16)
}
printHtmlPart(52)
createTagBody(2, {->
printHtmlPart(53)
createTagBody(3, {->
invokeTag('message','g',175,['code':("default.button.edit.label"),'default':("Редактировать")],-1)
})
invokeTag('link','g',175,['class':("edit"),'action':("edit"),'resource':(operationRecordInstance)],3)
printHtmlPart(54)
invokeTag('actionSubmit','g',176,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(55)
})
invokeTag('form','g',178,['url':([resource:operationRecordInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(56)
})
invokeTag('captureBody','sitemesh',180,[:],1)
printHtmlPart(57)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389540192000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
