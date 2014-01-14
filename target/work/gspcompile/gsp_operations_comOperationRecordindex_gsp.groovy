import ru.mm2.operations.ComOperationRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_operations_comOperationRecordindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/comOperationRecord/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'comOperationRecord.label', default: 'ComOperationRecord'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',16,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',19,['code':("default.home.label")],-1)
printHtmlPart(7)
for( i in ((0..<120)) ) {
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
if(true && (ru.mm2.operations.ComOperationRecordController.isSanday(new Date()+i))) {
printHtmlPart(10)
invokeTag('formatDate','g',30,['format':("EEE dd.MM.yy"),'date':(new Date()+i)],-1)
printHtmlPart(11)
}
else {
printHtmlPart(12)
createTagBody(5, {->
invokeTag('formatDate','g',33,['format':("EEE dd.MM.yy"),'date':(new Date()+i)],-1)
})
invokeTag('link','g',33,['class':("create"),'action':("create"),'params':([date_time: "${new Date()+i}"])],5)
printHtmlPart(11)
}
printHtmlPart(8)
})
invokeTag('form','g',35,[:],3)
printHtmlPart(13)
}
printHtmlPart(14)
for( i in ((0..<120)) ) {
printHtmlPart(15)
for( v in (ru.mm2.operations.ComOperationRecordController.collectPatologies(new Date()+i)) ) {
printHtmlPart(16)
expressionOut.print(resource(dir: 'images', file: 'type2.png'))
printHtmlPart(17)
}
printHtmlPart(9)
for( v in (ru.mm2.operations.ComOperationRecordController.collectLessTreeYears(new Date()+i)) ) {
printHtmlPart(16)
expressionOut.print(resource(dir: 'images', file: 'type1.png'))
printHtmlPart(18)
}
printHtmlPart(9)
for( v in (ru.mm2.operations.ComOperationRecordController.collectOthers(new Date()+i)) ) {
printHtmlPart(16)
expressionOut.print(resource(dir: 'images', file: 'type3.png'))
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',59,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1389197349000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
