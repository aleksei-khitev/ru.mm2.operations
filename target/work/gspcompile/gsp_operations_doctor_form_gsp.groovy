import ru.mm2.operations.Doctor
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_doctor_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/doctor/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('resources','gui',2,['components':(['toolTip'])],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: doctorInstance, field: 'fio', 'error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("doctor.fio.label"),'default':("ФИО")],-1)
printHtmlPart(3)
invokeTag('textField','g',9,['name':("fio"),'value':(doctorInstance?.fio)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: doctorInstance, field: 'rang', 'error'))
printHtmlPart(5)
invokeTag('message','g',14,['code':("doctor.rang.label"),'default':("Должность")],-1)
printHtmlPart(6)
invokeTag('textField','g',17,['name':("rang"),'value':(doctorInstance?.rang)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: doctorInstance, field: 'email', 'error'))
printHtmlPart(7)
invokeTag('message','g',22,['code':("doctor.email.label"),'default':("Электронная почта")],-1)
printHtmlPart(6)
invokeTag('textField','g',25,['name':("email"),'value':(doctorInstance?.email)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: doctorInstance, field: 'localphone', 'error'))
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
invokeTag('message','g',31,['code':("doctor.localphone.label"),'default':("Местный телефон")],-1)
printHtmlPart(10)
})
invokeTag('toolTip','gui',34,['text':("This text shows in a tool tip.")],1)
printHtmlPart(11)
invokeTag('textField','g',35,['name':("localphone"),'value':(doctorInstance?.localphone)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: doctorInstance, field: 'workphone', 'error'))
printHtmlPart(12)
invokeTag('message','g',40,['code':("doctor.workphone.label"),'default':("Рабочий телефон")],-1)
printHtmlPart(6)
invokeTag('textField','g',43,['name':("workphone"),'value':(doctorInstance?.workphone)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: doctorInstance, field: 'prim', 'error'))
printHtmlPart(13)
invokeTag('message','g',48,['code':("doctor.prim.label"),'default':("Примечание")],-1)
printHtmlPart(3)
invokeTag('textField','g',51,['name':("prim"),'value':(doctorInstance?.prim)],-1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389171697000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
