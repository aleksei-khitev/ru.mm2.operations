<%@ page import="ru.mm2.operations.ConsultationRecord" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'consultationRecord.label', default: 'ConsultationRecord')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_1').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#edit-consultationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: #DDA0DD">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
                <h3 style="text-align: center">Запись на консультацию</h3>
			</ul>
		</div>
		<div id="edit-consultationRecord" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${consultationRecordInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${consultationRecordInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:consultationRecordInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${consultationRecordInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
