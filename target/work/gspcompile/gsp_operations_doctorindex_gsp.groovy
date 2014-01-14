import ru.mm2.operations.Doctor
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_doctorindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/doctor/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'doctor.label', default: 'Doctor'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',20,['code':("default.newdoctor.label"),'args':("Ad")],-1)
})
invokeTag('link','g',20,['class':("create"),'action':("create"),'style':("color: black")],2)
printHtmlPart(9)
invokeTag('message','g',24,['code':("default.listdoctor.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('sortableColumn','g',32,['property':("fio"),'title':(message(code: 'doctor.fio.label', default: 'ФИО'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',33,['property':("rang"),'title':(message(code: 'doctor.rang.label', default: 'Должность'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',34,['property':("rang"),'title':(message(code: 'doctor.email.label', default: 'Почта'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',35,['property':("prim"),'title':(message(code: 'doctor.prim.label', default: 'Примечание'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( doctorInstance in (doctorInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: doctorInstance, field: "fio"))
})
invokeTag('link','g',45,['action':("show"),'id':(doctorInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: doctorInstance, field: "rang"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: doctorInstance, field: "email"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: doctorInstance, field: "prim"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',57,['total':(doctorInstanceCount ?: 0)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',60,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389544546000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
