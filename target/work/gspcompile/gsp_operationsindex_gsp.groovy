import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operationsindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',81,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',83,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(controller: 'doctor', action: 'index'))
printHtmlPart(7)
expressionOut.print(createLink(controller: 'operations', action: 'index'))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'research', action: 'index'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'consultationRecord', action: 'index'))
printHtmlPart(10)
expressionOut.print(createLink(controller: 'operationRecord', action: 'index'))
printHtmlPart(11)
expressionOut.print(createLink(controller: 'comConsultationRecord', action: 'index'))
printHtmlPart(12)
expressionOut.print(createLink(controller: 'comOperationRecord', action: 'index'))
printHtmlPart(13)
expressionOut.print(createLink(controller: 'comResearchRecord', action: 'index'))
printHtmlPart(14)
expressionOut.print(resource(dir: 'images', file: 'unnamed.jpg'))
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',111,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389195457000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
