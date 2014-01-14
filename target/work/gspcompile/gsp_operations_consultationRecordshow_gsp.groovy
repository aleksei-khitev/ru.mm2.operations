import ru.mm2.operations.ConsultationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_consultationRecordshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/consultationRecord/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'consultationRecord.label', default: 'ConsultationRecord'))],-1)
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
if(true && (consultationRecordInstance?.fio)) {
printHtmlPart(13)
invokeTag('message','g',33,['code':("consultationRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',35,['bean':(consultationRecordInstance),'field':("fio")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.birthday)) {
printHtmlPart(17)
invokeTag('message','g',42,['code':("consultationRecord.birthday.label"),'default':("Дата рождения пациента")],-1)
printHtmlPart(18)
invokeTag('formatDate','g',44,['format':("dd.MM.yyyy"),'date':(consultationRecordInstance?.birthday)],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.date_time)) {
printHtmlPart(19)
invokeTag('message','g',51,['code':("consultationRecord.date_time.label"),'default':("Дата консультации")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',53,['format':("dd.MM.yyyy"),'date':(consultationRecordInstance?.date_time)],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.diagnoz)) {
printHtmlPart(21)
invokeTag('message','g',60,['code':("consultationRecord.diagnoz.label"),'default':("Диагноз")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',62,['bean':(consultationRecordInstance),'field':("diagnoz")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.oms)) {
printHtmlPart(23)
invokeTag('message','g',69,['code':("consultationRecord.oms.label"),'default':("Полис ОМС")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',71,['bean':(consultationRecordInstance),'field':("oms")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.doctor)) {
printHtmlPart(25)
invokeTag('message','g',78,['code':("consultationRecord.doctor.label"),'default':("Врач")],-1)
printHtmlPart(26)
createTagBody(3, {->
expressionOut.print(consultationRecordInstance?.doctor?.fio)
})
invokeTag('link','g',80,['controller':("doctor"),'action':("show"),'id':(consultationRecordInstance?.doctor?.id)],3)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.client_contact)) {
printHtmlPart(27)
invokeTag('message','g',87,['code':("consultationRecord.client_contact.label"),'default':("Контакт для связи")],-1)
printHtmlPart(28)
expressionOut.print(formatted_phone)
printHtmlPart(29)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.parentfio)) {
printHtmlPart(30)
invokeTag('message','g',96,['code':("consultationRecord.parentfio.label"),'default':("ФИО родителей")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',98,['bean':(consultationRecordInstance),'field':("parentfio")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.isNaprav)) {
printHtmlPart(32)
invokeTag('message','g',105,['code':("consultationRecord.isNaprav.label"),'default':("Наличие направления")],-1)
printHtmlPart(33)
invokeTag('formatBoolean','g',106,['boolean':(consultationRecordInstance?.isNaprav)],-1)
printHtmlPart(34)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.isPechat)) {
printHtmlPart(35)
invokeTag('message','g',112,['code':("consultationRecord.isPechat.label"),'default':("Наличие печатей на направлении")],-1)
printHtmlPart(36)
invokeTag('formatBoolean','g',113,['boolean':(consultationRecordInstance?.isPechat)],-1)
printHtmlPart(34)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.isConfirm)) {
printHtmlPart(37)
invokeTag('message','g',119,['code':("consultationRecord.isConfirm.label"),'default':("Контрольный обзвон")],-1)
printHtmlPart(38)
invokeTag('formatBoolean','g',120,['boolean':(consultationRecordInstance?.isConfirm)],-1)
printHtmlPart(34)
}
printHtmlPart(16)
if(true && (consultationRecordInstance?.prim)) {
printHtmlPart(39)
invokeTag('message','g',126,['code':("consultationRecord.prim.label"),'default':("Примечание")],-1)
printHtmlPart(40)
invokeTag('fieldValue','g',128,['bean':(consultationRecordInstance),'field':("prim")],-1)
printHtmlPart(15)
}
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(42)
createTagBody(3, {->
invokeTag('message','g',136,['code':("default.button.edit.label"),'default':("Редактировать")],-1)
})
invokeTag('link','g',136,['class':("edit"),'action':("edit"),'resource':(consultationRecordInstance)],3)
printHtmlPart(43)
createTagBody(3, {->
invokeTag('message','g',137,['code':("default.consulttooper.label"),'default':("Направить на операцию")],-1)
})
invokeTag('link','g',137,['class':("edit"),'controller':("operationRecord"),'action':("create"),'params':([parentfio:"${consultationRecordInstance?.parentfio}",doctor_id:"${consultationRecordInstance?.doctor?.id}",oms:"${consultationRecordInstance?.oms}",birthday:"${consultationRecordInstance?.birthday}",client_contact:"${consultationRecordInstance?.client_contact}",diagnoz:"${consultationRecordInstance?.diagnoz}",fio:"${consultationRecordInstance?.fio}",from_consult:"true",date_time: "${consultationRecordInstance?.date_time}"]),'style':("color: maroon; font-weight: bold;")],3)
printHtmlPart(43)
invokeTag('actionSubmit','g',138,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(44)
})
invokeTag('form','g',141,['url':([resource:consultationRecordInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(45)
})
invokeTag('captureBody','sitemesh',143,[:],1)
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389540040000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
