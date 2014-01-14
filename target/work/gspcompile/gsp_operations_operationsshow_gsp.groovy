import ru.mm2.operations.Operations
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_operationsshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/operations/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'operations.label', default: 'Operations'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.showoperation.label"),'args':([entityName])],-1)
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
invokeTag('message','g',20,['code':("default.listoperation.label"),'args':([entityName])],-1)
})
invokeTag('link','g',20,['class':("list"),'action':("index"),'style':("color: black")],2)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',21,['code':("default.newoperation.label"),'args':([entityName])],-1)
})
invokeTag('link','g',21,['class':("create"),'action':("create"),'style':("color: black")],2)
printHtmlPart(10)
invokeTag('message','g',25,['code':("default.showoperation.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (operationsInstance?.name)) {
printHtmlPart(15)
invokeTag('message','g',33,['code':("operations.name.label"),'default':("Название операции")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',35,['bean':(operationsInstance),'field':("name")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',43,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',43,['class':("edit"),'action':("edit"),'resource':(operationsInstance)],3)
printHtmlPart(20)
invokeTag('actionSubmit','g',44,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(21)
})
invokeTag('form','g',46,['url':([resource:operationsInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',48,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389544566000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
