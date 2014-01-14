import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',10,['default':("Программа регистрации операций")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir: 'images', file: 'favicon.ico'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon.png'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-retina.png'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: 'main.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'css', file: 'mobile.css'))
printHtmlPart(7)
invokeTag('layoutHead','g',17,[:],-1)
printHtmlPart(1)
invokeTag('javascript','g',18,['library':("application")],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',19,[:],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',20,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
expressionOut.print(createLink(url: '/ru.mm2.operations/'))
printHtmlPart(10)
expressionOut.print(resource(dir: 'images', file: 'logo.jpg'))
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'shedulder.png'))
printHtmlPart(13)
})
invokeTag('link','g',43,['controller':("consultationRecord"),'class':("home")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'shedulder.png'))
printHtmlPart(15)
})
invokeTag('link','g',49,['controller':("operationRecord"),'class':("home")],2)
printHtmlPart(16)
expressionOut.print(createLink(url: '/ru.mm2.operations/'))
printHtmlPart(10)
expressionOut.print(resource(dir: 'images', file: 'logo.jpg'))
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'shedulder.png'))
printHtmlPart(13)
})
invokeTag('link','g',68,['controller':("comConsultationRecord"),'class':("home")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'shedulder.png'))
printHtmlPart(15)
})
invokeTag('link','g',74,['controller':("comOperationRecord"),'class':("home")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'shedulder.png'))
printHtmlPart(17)
})
invokeTag('link','g',80,['controller':("comResearchRecord"),'class':("home")],2)
printHtmlPart(18)
expressionOut.print(createLink(url: '/ru.mm2.operations/'))
printHtmlPart(10)
expressionOut.print(resource(dir: 'images', file: 'logo.jpg'))
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'doctor.png'))
printHtmlPart(19)
})
invokeTag('link','g',99,['controller':("doctor"),'class':("home")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'operations.png'))
printHtmlPart(20)
})
invokeTag('link','g',105,['controller':("operations"),'class':("home")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(resource(dir: 'images', file: 'research.jpg'))
printHtmlPart(21)
})
invokeTag('link','g',111,['controller':("research"),'class':("home")],2)
printHtmlPart(22)
invokeTag('layoutBody','g',121,[:],-1)
printHtmlPart(23)
createClosureForHtmlPart(24, 2)
invokeTag('form','g',125,['action':("index"),'controller':("search")],2)
printHtmlPart(25)
invokeTag('message','g',127,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(26)
invokeTag('layoutResources','r',128,[:],-1)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',129,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389195359000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
