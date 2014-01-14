import ru.mm2.operations.ComResearchRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_comResearchRecordshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/comResearchRecord/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'comResearchRecord.label', default: 'ComResearchRecord'))],-1)
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
invokeTag('link','g',20,['class':("list"),'action':("index"),'style':("color: black")],2)
printHtmlPart(9)
invokeTag('message','g',25,['code':("default.showrecod.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (comResearchRecordInstance?.birthday)) {
printHtmlPart(14)
invokeTag('message','g',33,['code':("comResearchRecord.birthday.label"),'default':("Дата рождения")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',35,['format':("dd.MM.yyyy"),'date':(comResearchRecordInstance?.birthday)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (comResearchRecordInstance?.fio)) {
printHtmlPart(18)
invokeTag('message','g',42,['code':("comResearchRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',44,['bean':(comResearchRecordInstance),'field':("fio")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (comResearchRecordInstance?.date_time)) {
printHtmlPart(20)
invokeTag('message','g',51,['code':("comResearchRecord.date_time.label"),'default':("Дата исследования")],-1)
printHtmlPart(21)
invokeTag('formatDate','g',53,['format':("dd.MM.yyyy"),'date':(comResearchRecordInstance?.date_time)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (comResearchRecordInstance?.research)) {
printHtmlPart(22)
invokeTag('message','g',60,['code':("comResearchRecord.research.label"),'default':("исследование")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(comResearchRecordInstance?.research?.nameAndString)
})
invokeTag('link','g',62,['controller':("research"),'action':("show"),'id':(comResearchRecordInstance?.research?.id)],3)
printHtmlPart(16)
}
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',70,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',70,['class':("edit"),'action':("edit"),'resource':(comResearchRecordInstance)],3)
printHtmlPart(26)
invokeTag('actionSubmit','g',71,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(27)
})
invokeTag('form','g',73,['url':([resource:comResearchRecordInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',75,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389544129000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
