
<%@ page import="ru.mm2.operations.Research" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'research.label', default: 'Research')}" />
		<title><g:message code="default.showresearch.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_3').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#show-research" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: sandybrown">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index" style="color: black"><g:message code="default.listresearch.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create" style="color: black"><g:message code="default.newresearch.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-research" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list research">
			
				<g:if test="${researchInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="research.name.label" default="Название" /></span>
                    <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${researchInstance}" field="name"/></span>
                    <span id="price-label" class="property-label"><g:message code="research.price.label" default="Цена" /></span>

                        <span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${researchInstance}" field="price"/></span>
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:researchInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${researchInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
