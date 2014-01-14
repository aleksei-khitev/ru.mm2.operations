import ru.mm2.operations.ComResearchRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_comResearchRecord_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/comResearchRecord/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: comResearchRecordInstance, field: 'fio', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("comResearchRecord.fio.label"),'default':("ФИО пациента")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("fio"),'required':(""),'value':(comResearchRecordInstance?.fio)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comResearchRecordInstance, field: 'birthday', 'error'))
printHtmlPart(4)
invokeTag('message','g',13,['code':("comResearchRecord.birthday.label"),'default':("Дата рождения")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',16,['name':("birthday"),'precision':("day"),'value':(comResearchRecordInstance?.birthday)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: comResearchRecordInstance, field: 'date_time', 'error'))
printHtmlPart(7)
invokeTag('message','g',22,['code':("comResearchRecord.date_time.label"),'default':("Дата исследования")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',25,['name':("date_time"),'precision':("day"),'value':(comResearchRecordInstance?.date_time)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: comResearchRecordInstance, field: 'research', 'error'))
printHtmlPart(8)
invokeTag('message','g',30,['code':("comResearchRecord.research.label"),'default':("Исследование")],-1)
printHtmlPart(5)
invokeTag('select','g',33,['id':("research"),'name':("research.id"),'from':(ru.mm2.operations.Research.list(sort:"name")),'optionKey':("id"),'required':(""),'optionValue':("nameAndString"),'value':(comResearchRecordInstance?.research?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389543827000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
