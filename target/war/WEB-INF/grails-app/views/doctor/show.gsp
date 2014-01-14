
<%@ page import="ru.mm2.operations.Doctor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'doctor.label', default: 'Врач')}" />
        <g:javascript library="jquery" plugin="jquery"/>
        <g:javascript library="jquery" plugin="jquery-ui"/>
		<title><g:message code="default.showdoctor.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_3').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#show-doctor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.listdoctor.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.newdoctor.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-doctor" class="content scaffold-show" role="main">
			<h1><g:message code="default.showdoctor.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list doctor">

				<g:if test="${doctorInstance?.fio}">
				<li class="fieldcontain">
                    <span id="fio-label" class="property-label"><g:message code="doctor.fio.label" default="ФИО" /></span>

                        <span class="property-value" aria-labelledby="fio-label"><g:fieldValue bean="${doctorInstance}" field="fio"/></span>
					
				</li>
				</g:if>

				<g:if test="${doctorInstance?.rang}">
				<li class="fieldcontain">
					<span id="rang-label" class="property-label"><g:message code="doctor.rang.label" default="Должность" /></span>

                        <span class="property-value" aria-labelledby="rang-label"><g:fieldValue bean="${doctorInstance}" field="rang"/></span>
					
				</li>
				</g:if>

                <g:if test="${doctorInstance?.email}">
                    <li class="fieldcontain">
                        <span id="email-label" class="property-label"><g:message code="doctor.email.label" default="Электронная почта" /></span>

                        <span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${doctorInstance}" field="email"/></span>

                    </li>
                </g:if>

                <g:if test="${doctorInstance?.localphone}">
                    <li class="fieldcontain">
                        <span id="localphone-label" class="property-label"><g:message code="doctor.workphone.label" default="Местный телефон" /></span>

                        <span class="property-value" aria-labelledby="localphone-label"><g:fieldValue bean="${doctorInstance}" field="localphone"/></span>

                    </li>
                </g:if>

                <g:if test="${doctorInstance?.workphone}">
                    <li class="fieldcontain">
                        <span id="workphone-label" class="property-label"><g:message code="doctor.workphone.label" default="Рабочий телефон" /></span>

                        <span class="property-value" aria-labelledby="workphone-label"><g:fieldValue bean="${doctorInstance}" field="workphone"/></span>

                    </li>
                </g:if>

                <g:if test="${doctorInstance?.prim}">
                    <li class="fieldcontain">
                        <span id="prim-label" class="property-label"><g:message code="doctor.prim.label" default="Примечание" /></span>

                            <span class="property-value" aria-labelledby="prim-label"><g:fieldValue bean="${doctorInstance}" field="prim"/></span>

                    </li>
                </g:if>
			</ol>
			<g:form url="[resource:doctorInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${doctorInstance}"><g:message code="default.button.edit.label" default="Изменить" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
