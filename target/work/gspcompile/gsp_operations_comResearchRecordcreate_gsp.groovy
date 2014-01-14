import ru.mm2.operations.ComResearchRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_comResearchRecordcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/comResearchRecord/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'comResearchRecord.label', default: 'ComResearchRecord'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',14,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',17,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',18,['code':("default.listrecodheader.label"),'args':([entityName])],-1)
})
invokeTag('link','g',18,['class':("list"),'action':("index"),'style':("color: black")],2)
printHtmlPart(8)
invokeTag('message','g',23,['code':("default.createrecod.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
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
invokeTag('message','g',30,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',31,['bean':(comResearchRecordInstance),'var':("error")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',33,['bean':(comResearchRecordInstance)],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(20)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: comResearchRecordInstance, field: 'fio', 'error'))
printHtmlPart(22)
invokeTag('message','g',40,['code':("comResearchRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(23)
invokeTag('textField','g',43,['name':("fio"),'required':(""),'value':(comResearchRecordInstance?.fio)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comResearchRecordInstance, field: 'birthday', 'error'))
printHtmlPart(25)
invokeTag('message','g',48,['code':("comResearchRecord.birthday.label"),'default':("Дата рождения")],-1)
printHtmlPart(23)
invokeTag('datePicker','g',51,['name':("birthday"),'precision':("day"),'value':(comResearchRecordInstance?.birthday)],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: comResearchRecordInstance, field: 'date_time', 'error'))
printHtmlPart(27)
invokeTag('message','g',58,['code':("comResearchRecord.date_time.label"),'default':("Дата исследования")],-1)
printHtmlPart(23)
invokeTag('datePicker','g',61,['name':("date_time"),'precision':("day"),'value':(date)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: comResearchRecordInstance, field: 'research', 'error'))
printHtmlPart(28)
invokeTag('message','g',66,['code':("comResearchRecord.research.label"),'default':("Исследование")],-1)
printHtmlPart(23)
invokeTag('select','g',69,['id':("research"),'name':("research.id"),'from':(ru.mm2.operations.Research.list(sort:"name")),'optionValue':("nameAndString"),'optionKey':("id"),'required':(""),'value':(comResearchRecordInstance?.research?.id),'class':("many-to-one")],-1)
printHtmlPart(29)
invokeTag('submitButton','g',73,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Создать'))],-1)
printHtmlPart(30)
})
invokeTag('form','g',75,['url':([resource:comResearchRecordInstance, action:'save'])],2)
printHtmlPart(31)
invokeTag('message','g',78,['code':("default.listrecod.label"),'args':([entityName])],-1)
printHtmlPart(32)
if(true && (flash.message)) {
printHtmlPart(33)
expressionOut.print(flash.message)
printHtmlPart(34)
}
printHtmlPart(35)
invokeTag('sortableColumn','g',85,['property':("fio"),'title':(message(code: 'comResearchRecord.fio.label', default: 'ФИО пациента'))],-1)
printHtmlPart(36)
invokeTag('sortableColumn','g',86,['property':("fio"),'title':(message(code: 'comResearchRecord.research.label', default: 'Операция'))],-1)
printHtmlPart(36)
invokeTag('sortableColumn','g',87,['property':("birthday"),'title':(message(code: 'comResearchRecord.birthday.label', default: 'Дата рождения'))],-1)
printHtmlPart(37)
loop:{
int i = 0
for( comResearchRecordInstance in (comResearchRecordInstanceList) ) {
printHtmlPart(38)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(39)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: comResearchRecordInstance, field: "fio"))
})
invokeTag('link','g',93,['action':("show"),'id':(comResearchRecordInstance.id)],3)
printHtmlPart(40)
expressionOut.print(comResearchRecordInstance?.research?.nameAndString)
printHtmlPart(41)
invokeTag('formatDate','g',95,['format':("dd.MM.yyyy"),'date':(comResearchRecordInstance?.birthday)],-1)
printHtmlPart(42)
i++
}
}
printHtmlPart(43)
invokeTag('paginate','g',101,['total':(comResearchRecordInstanceCount ?: 0)],-1)
printHtmlPart(44)
})
invokeTag('captureBody','sitemesh',104,[:],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389544030000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
