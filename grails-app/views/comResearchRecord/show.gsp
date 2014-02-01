
<%@ page import="ru.mm2.operations.ComResearchRecord" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'comResearchRecord.label', default: 'ComResearchRecord')}" />
		<title><g:message code="default.showrecod.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_2').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#show-comResearchRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation"  style="background-color: springgreen">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"  style="color: black"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"  style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
                <h3 style="text-align: center" style="color: black">Запись на исследования</h3>
			</ul>
		</div>
		<div id="show-comResearchRecord" class="content scaffold-show" role="main">
			<h1><g:message code="default.showrecod.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list comResearchRecord">
			
				<g:if test="${comResearchRecordInstance?.birthday}">
				<li class="fieldcontain">
					<span id="birthday-label" class="property-label"><g:message code="comResearchRecord.birthday.label" default="Дата рождения" /></span>
					
						<span class="property-value" aria-labelledby="birthday-label"><g:formatDate date="${comResearchRecordInstance?.birthday}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${comResearchRecordInstance?.fio}">
				<li class="fieldcontain">
					<span id="fio-label" class="property-label"><g:message code="comResearchRecord.fio.label" default="ФИО пациента" /></span>
					
						<span class="property-value" aria-labelledby="fio-label"><g:fieldValue bean="${comResearchRecordInstance}" field="fio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comResearchRecordInstance?.date_time}">
				<li class="fieldcontain">
					<span id="date_time-label" class="property-label"><g:message code="comResearchRecord.date_time.label" default="Дата исследования" /></span>
					
						<span class="property-value" aria-labelledby="date_time-label"><g:formatDate date="${comResearchRecordInstance?.date_time}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${comResearchRecordInstance?.research}">
				<li class="fieldcontain">
					<span id="research-label" class="property-label"><g:message code="comResearchRecord.research.label" default="исследование" /></span>
					
						<span class="property-value" aria-labelledby="research-label"><g:link controller="research" action="show" id="${comResearchRecordInstance?.research?.id}">${comResearchRecordInstance?.research?.nameAndString}</g:link></span>
					
				</li>
				</g:if>

                <g:infoAboutRecord lastUpdated="${comResearchRecordInstance?.lastUpdated}" updatedUser="${comResearchRecordInstance?.updatedUser}"/>
			
			</ol>
			<g:form url="[resource:comResearchRecordInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${comResearchRecordInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
