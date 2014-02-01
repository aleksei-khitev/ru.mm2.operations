<%@ page import="ru.mm2.operations.SecRole" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'secRole.label', default: 'SecRole')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_4').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#edit-secRole" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: darkred">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: white"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index" style="color: white"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create" style="color: white"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-secRole" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${secRoleInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${secRoleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:secRoleInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${secRoleInstance?.version}" />
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
