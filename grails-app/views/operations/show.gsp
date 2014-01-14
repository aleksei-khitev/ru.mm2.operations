
<%@ page import="ru.mm2.operations.Operations" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'operations.label', default: 'Operations')}" />
		<title><g:message code="default.showoperation.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_3').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#show-operations" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: sandybrown">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index" style="color: black"><g:message code="default.listoperation.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create" style="color: black"><g:message code="default.newoperation.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-operations" class="content scaffold-show" role="main">
			<h1><g:message code="default.showoperation.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list operations">

				<g:if test="${operationsInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="operations.name.label" default="Название операции" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${operationsInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:operationsInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${operationsInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
