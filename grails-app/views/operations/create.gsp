<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'operations.label', default: 'Operations')}" />
		<title><g:message code="default.createoperation.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_3').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#create-operations" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: sandybrown">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index" style="color: black"><g:message code="default.listoperation.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-operations" class="content scaffold-create" role="main">
			<h1><g:message code="default.createoperation.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${operationsInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${operationsInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:operationsInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
