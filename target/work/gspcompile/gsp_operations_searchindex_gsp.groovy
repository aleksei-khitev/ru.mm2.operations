import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_searchindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',11,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (operSearchResult?.results)) {
printHtmlPart(5)
for( result in (operSearchResult.results) ) {
printHtmlPart(6)
createTagBody(4, {->
printHtmlPart(7)
expressionOut.print(result.fio)
printHtmlPart(8)
})
invokeTag('link','g',36,['controller':("operationRecord"),'action':("show"),'id':(result.id)],4)
printHtmlPart(9)
expressionOut.print(result.diagnoz)
printHtmlPart(10)
expressionOut.print(result.doctor?.fio)
printHtmlPart(10)
expressionOut.print(result.date_time)
printHtmlPart(10)
expressionOut.print(result.client_contact)
printHtmlPart(10)
expressionOut.print(result.prim)
printHtmlPart(11)
}
printHtmlPart(12)
}
printHtmlPart(3)
if(true && (comOperSearchResult?.results)) {
printHtmlPart(13)
for( result in (comOperSearchResult.results) ) {
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
expressionOut.print(result.fio)
printHtmlPart(16)
})
invokeTag('link','g',68,['controller':("comOperationRecord"),'action':("show"),'id':(result.id)],4)
printHtmlPart(17)
expressionOut.print(result.diagnoz)
printHtmlPart(18)
expressionOut.print(result.doctor?.fio)
printHtmlPart(18)
expressionOut.print(result.date_time)
printHtmlPart(18)
expressionOut.print(result.client_contact)
printHtmlPart(18)
expressionOut.print(result.prim)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(3)
if(true && (consSearchResult?.results)) {
printHtmlPart(21)
for( result in (consSearchResult.results) ) {
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
expressionOut.print(result.fio)
printHtmlPart(16)
})
invokeTag('link','g',101,['controller':("consultationRecord"),'action':("show"),'id':(result.id)],4)
printHtmlPart(17)
expressionOut.print(result.diagnoz)
printHtmlPart(18)
expressionOut.print(result.doctor?.fio)
printHtmlPart(18)
invokeTag('formatDate','g',106,['format':("dd.MM.yyyy"),'date':(result?.date_time)],-1)
printHtmlPart(18)
expressionOut.print(result.client_contact)
printHtmlPart(18)
expressionOut.print(result.prim)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(2)
if(true && (comConsSearchResult?.results)) {
printHtmlPart(22)
for( result in (comConsSearchResult.results) ) {
printHtmlPart(23)
createTagBody(4, {->
printHtmlPart(24)
expressionOut.print(result.fio)
printHtmlPart(15)
})
invokeTag('link','g',134,['controller':("comConsultationRecord"),'action':("show"),'id':(result.id)],4)
printHtmlPart(25)
expressionOut.print(result.diagnoz)
printHtmlPart(26)
expressionOut.print(result.doctor?.fio)
printHtmlPart(26)
invokeTag('formatDate','g',139,['format':("dd.MM.yyyy"),'date':(result?.date_time)],-1)
printHtmlPart(26)
expressionOut.print(result.client_contact)
printHtmlPart(26)
expressionOut.print(result.prim)
printHtmlPart(27)
}
printHtmlPart(12)
}
printHtmlPart(3)
if(true && (comResearchSearchResult?.results)) {
printHtmlPart(28)
for( result in (comResearchSearchResult.results) ) {
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
expressionOut.print(result?.fio)
printHtmlPart(16)
})
invokeTag('link','g',165,['controller':("comResearchRecord"),'action':("show"),'id':(result.id)],4)
printHtmlPart(17)
expressionOut.print(result?.research?.name)
printHtmlPart(18)
expressionOut.print(result?.date_time)
printHtmlPart(18)
invokeTag('formatDate','g',170,['format':("dd.MM.yyyy"),'date':(result?.birthday)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(3)
if(true && (doctorSearchResult?.results)) {
printHtmlPart(29)
for( result in (doctorSearchResult.results) ) {
printHtmlPart(30)
createTagBody(4, {->
printHtmlPart(15)
expressionOut.print(result?.fio)
printHtmlPart(16)
})
invokeTag('link','g',193,['controller':("doctor"),'action':("show"),'id':(result.id)],4)
printHtmlPart(17)
expressionOut.print(result?.rang)
printHtmlPart(18)
expressionOut.print(result?.localphone)
printHtmlPart(18)
expressionOut.print(result?.email)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',200,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389543951000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
