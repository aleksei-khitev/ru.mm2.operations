import ru.mm2.operations.ComOperationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_comOperationRecordshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/comOperationRecord/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'comOperationRecord.label', default: 'ComOperationRecord'))],-1)
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
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',16,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',19,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',20,['code':("default.listrecodheader.label"),'args':([entityName])],-1)
})
invokeTag('link','g',20,['class':("list"),'action':("index"),'style':("color: black")],2)
printHtmlPart(8)
invokeTag('message','g',25,['code':("default.showrecod.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (comOperationRecordInstance?.fio)) {
printHtmlPart(13)
invokeTag('message','g',33,['code':("comOperationRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',35,['bean':(comOperationRecordInstance),'field':("fio")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.birthday)) {
printHtmlPart(17)
invokeTag('message','g',42,['code':("comOperationRecord.birthday.label"),'default':("Дата рождения пациента")],-1)
printHtmlPart(18)
invokeTag('formatDate','g',44,['format':("dd.MM.yyyy"),'date':(comOperationRecordInstance?.birthday)],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.diagnoz)) {
printHtmlPart(19)
invokeTag('message','g',51,['code':("comOperationRecord.diagnoz.label"),'default':("Диагноз")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',53,['bean':(comOperationRecordInstance),'field':("diagnoz")],-1)
printHtmlPart(15)
}
printHtmlPart(21)
invokeTag('message','g',60,['code':("comOperationRecord.isPatology.label"),'default':("Хроническая патология")],-1)
printHtmlPart(22)
if(true && (comOperationRecordInstance?.isPatology)) {
printHtmlPart(23)
invokeTag('fieldValue','g',65,['bean':(comOperationRecordInstance),'field':("patology")],-1)
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
invokeTag('message','g',77,['code':("comOperationRecord.isDisp.label"),'default':("Диспансерное наблюдение")],-1)
printHtmlPart(27)
if(true && (comOperationRecordInstance?.isDisp)) {
printHtmlPart(23)
invokeTag('fieldValue','g',81,['bean':(comOperationRecordInstance),'field':("disp")],-1)
printHtmlPart(24)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
if(true && (comOperationRecordInstance?.lastill)) {
printHtmlPart(30)
invokeTag('message','g',92,['code':("comOperationRecord.lastill.label"),'default':("Последнее простудное заболевание")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',94,['bean':(comOperationRecordInstance),'field':("lastill")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.parentfio)) {
printHtmlPart(32)
invokeTag('message','g',101,['code':("comOperationRecord.parentfio.label"),'default':("ФИО родителей")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',103,['bean':(comOperationRecordInstance),'field':("parentfio")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.client_contact)) {
printHtmlPart(34)
invokeTag('message','g',110,['code':("comOperationRecord.client_contact.label"),'default':("Контакт для связи")],-1)
printHtmlPart(35)
expressionOut.print(formatted_phone)
printHtmlPart(36)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.oms)) {
printHtmlPart(37)
invokeTag('message','g',120,['code':("comOperationRecord.oms.label"),'default':("Полис ОМС")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',122,['bean':(comOperationRecordInstance),'field':("oms")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.operation)) {
printHtmlPart(39)
invokeTag('message','g',129,['code':("comOperationRecord.operation.label"),'default':("Операция")],-1)
printHtmlPart(40)
createTagBody(3, {->
expressionOut.print(comOperationRecordInstance?.operation?.name)
})
invokeTag('link','g',131,['controller':("operations"),'action':("show"),'id':(comOperationRecordInstance?.operation?.id)],3)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.doctor)) {
printHtmlPart(41)
invokeTag('message','g',138,['code':("comOperationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(42)
createTagBody(3, {->
expressionOut.print(comOperationRecordInstance?.doctor?.fio)
})
invokeTag('link','g',140,['controller':("doctor"),'action':("show"),'id':(comOperationRecordInstance?.doctor?.id)],3)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.date_time)) {
printHtmlPart(43)
invokeTag('message','g',147,['code':("comOperationRecord.date_time.label"),'default':("Дата госпитализации")],-1)
printHtmlPart(44)
invokeTag('formatDate','g',149,['format':("dd.MM.yyyy"),'date':(comOperationRecordInstance?.date_time)],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.prim)) {
printHtmlPart(45)
invokeTag('message','g',156,['code':("comOperationRecord.prim.label"),'default':("Примечание")],-1)
printHtmlPart(46)
invokeTag('fieldValue','g',158,['bean':(comOperationRecordInstance),'field':("prim")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (comOperationRecordInstance?.isConfirm)) {
printHtmlPart(47)
invokeTag('message','g',165,['code':("comOperationRecord.isConfirm.label"),'default':("Контрольный обзвоне")],-1)
printHtmlPart(48)
invokeTag('formatBoolean','g',167,['boolean':(comOperationRecordInstance?.isConfirm)],-1)
printHtmlPart(15)
}
printHtmlPart(49)
createTagBody(2, {->
printHtmlPart(50)
createTagBody(3, {->
invokeTag('message','g',175,['code':("default.button.edit.label"),'default':("Редактировать")],-1)
})
invokeTag('link','g',175,['class':("edit"),'action':("edit"),'resource':(comOperationRecordInstance)],3)
printHtmlPart(51)
invokeTag('actionSubmit','g',176,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(52)
})
invokeTag('form','g',178,['url':([resource:comOperationRecordInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(53)
})
invokeTag('captureBody','sitemesh',180,[:],1)
printHtmlPart(54)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389540017000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
