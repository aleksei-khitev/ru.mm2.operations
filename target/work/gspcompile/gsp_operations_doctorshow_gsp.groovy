import ru.mm2.operations.Doctor
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_doctorshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/doctor/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'doctor.label', default: 'Врач'))],-1)
printHtmlPart(3)
invokeTag('javascript','g',8,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(3)
invokeTag('javascript','g',9,['library':("jquery"),'plugin':("jquery-ui")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',10,['code':("default.showdoctor.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('message','g',18,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(7)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(8)
invokeTag('message','g',21,['code':("default.home.label")],-1)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',22,['code':("default.listdoctor.label"),'args':([entityName])],-1)
})
invokeTag('link','g',22,['class':("list"),'action':("index"),'style':("color: black")],2)
printHtmlPart(10)
createTagBody(2, {->
invokeTag('message','g',23,['code':("default.newdoctor.label"),'args':([entityName])],-1)
})
invokeTag('link','g',23,['class':("create"),'action':("create"),'style':("color: black")],2)
printHtmlPart(11)
invokeTag('message','g',27,['code':("default.showdoctor.label"),'args':([entityName])],-1)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (doctorInstance?.fio)) {
printHtmlPart(16)
invokeTag('message','g',35,['code':("doctor.fio.label"),'default':("ФИО")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',37,['bean':(doctorInstance),'field':("fio")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (doctorInstance?.rang)) {
printHtmlPart(20)
invokeTag('message','g',44,['code':("doctor.rang.label"),'default':("Должность")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',46,['bean':(doctorInstance),'field':("rang")],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (doctorInstance?.email)) {
printHtmlPart(23)
invokeTag('message','g',53,['code':("doctor.email.label"),'default':("Электронная почта")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',55,['bean':(doctorInstance),'field':("email")],-1)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (doctorInstance?.localphone)) {
printHtmlPart(26)
invokeTag('message','g',62,['code':("doctor.workphone.label"),'default':("Местный телефон")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',64,['bean':(doctorInstance),'field':("localphone")],-1)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (doctorInstance?.workphone)) {
printHtmlPart(28)
invokeTag('message','g',71,['code':("doctor.workphone.label"),'default':("Рабочий телефон")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',73,['bean':(doctorInstance),'field':("workphone")],-1)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (doctorInstance?.prim)) {
printHtmlPart(30)
invokeTag('message','g',80,['code':("doctor.prim.label"),'default':("Примечание")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',82,['bean':(doctorInstance),'field':("prim")],-1)
printHtmlPart(25)
}
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createTagBody(3, {->
invokeTag('message','g',89,['code':("default.button.edit.label"),'default':("Изменить")],-1)
})
invokeTag('link','g',89,['class':("edit"),'action':("edit"),'resource':(doctorInstance)],3)
printHtmlPart(34)
invokeTag('actionSubmit','g',90,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(35)
})
invokeTag('form','g',92,['url':([resource:doctorInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(36)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389544539000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
