<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'comResearchRecord.label', default: 'ComResearchRecord')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_2').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#create-comResearchRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation"  style="background-color: springgreen">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
                <h3 style="text-align: center" style="color: black">Запись на исследования</h3>
			</ul>
		</div>
		<div id="create-comResearchRecord" class="content scaffold-create" role="main">
			<h1><g:message code="default.createrecod.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${comResearchRecordInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${comResearchRecordInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:comResearchRecordInstance, action:'save']" >
				<fieldset class="form">
                    <g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Создать')}" />
				</fieldset>
			</g:form>
		</div>
        <g:render template="list-for-day"/>
	</body>
</html>
