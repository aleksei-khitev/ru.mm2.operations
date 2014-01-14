import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_phone_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_phone.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(i)
printHtmlPart(1)
if(true && (hidden)) {
printHtmlPart(2)
}
printHtmlPart(3)
invokeTag('hiddenField','g',2,['name':("contact[${i}].id"),'value':(contacts?.id)],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',3,['name':("phonesList[${i}].deleted"),'value':("false")],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',4,['name':("phonesList[${i}].new"),'value':("false")],-1)
printHtmlPart(5)
invokeTag('textField','g',6,['name':("phonesList[${i}].number"),'value':(contacts?.value)],-1)
printHtmlPart(4)
invokeTag('select','g',11,['name':("phonesList[${i}].type"),'from':(ru.mm2.operations.ContactTypes.name()),'optionKey':("key"),'optionValue':("value"),'value':(contacts?.type?.key)],-1)
printHtmlPart(6)
expressionOut.print(resource(dir:'images/skin', file:'icon_delete.png'))
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1387124155000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
