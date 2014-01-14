import ru.mm2.operations.OperationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_operationRecordedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/operationRecord/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'operationRecord.label', default: 'OperationRecord'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.editrecod.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',15,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',18,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',19,['code':("default.listrecodheader.label"),'args':([entityName])],-1)
})
invokeTag('link','g',19,['class':("list"),'action':("index"),'style':("color: white")],2)
printHtmlPart(8)
invokeTag('message','g',24,['code':("default.editrecod.label"),'args':([entityName])],-1)
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
invokeTag('message','g',31,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',32,['bean':(operationRecordInstance),'var':("error")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',34,['bean':(operationRecordInstance)],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('hiddenField','g',36,['name':("version"),'value':(operationRecordInstance?.version)],-1)
printHtmlPart(21)
invokeTag('render','g',38,['template':("form")],-1)
printHtmlPart(22)
invokeTag('actionSubmit','g',41,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(23)
})
invokeTag('form','g',43,['url':([resource:operationRecordInstance, action:'update']),'method':("PUT")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',45,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389540185000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
