import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_operationRecorddetailed_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/operationRecord/detailed.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("entityName"),'value':(message(code: 'operationRecord.label', default: 'OperationRecord'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',13,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',17,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',20,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',21,['code':("default.newrecod.label"),'args':([entityName])],-1)
})
invokeTag('link','g',21,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',24,['code':("default.listrecod.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',33,['property':("birthday"),'title':(message(code: 'operationRecord.birthday.label', default: 'Birthday'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',35,['property':("client_contact"),'title':(message(code: 'operationRecord.client_contact.label', default: 'Clientcontact'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',37,['property':("date_time"),'title':(message(code: 'operationRecord.date_time.label', default: 'Datetime'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',39,['property':("diagnoz"),'title':(message(code: 'operationRecord.diagnoz.label', default: 'Diagnoz'))],-1)
printHtmlPart(14)
invokeTag('message','g',39,['code':("operationRecord.doctor.label"),'default':("Doctor")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',43,['property':("fio"),'title':(message(code: 'operationRecord.fio.label', default: 'Fio'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( operationRecordInstance in (operationRecordInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: operationRecordInstance, field: "birthday"))
})
invokeTag('link','g',51,['action':("show"),'id':(operationRecordInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: operationRecordInstance, field: "client_contact"))
printHtmlPart(19)
invokeTag('formatDate','g',53,['date':(operationRecordInstance.date_time)],-1)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: operationRecordInstance, field: "diagnoz"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: operationRecordInstance, field: "doctor"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: operationRecordInstance, field: "fio"))
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',67,['total':(operationRecordInstanceCount ?: 0)],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1387395867000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
