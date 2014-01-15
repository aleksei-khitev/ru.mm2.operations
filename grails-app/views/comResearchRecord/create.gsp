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
                    <%@ page import="ru.mm2.operations.ComResearchRecord" %>

                    <div class="fieldcontain ${hasErrors(bean: comResearchRecordInstance, field: 'fio', 'error')} required">
                        <label for="fio">
                            <g:message code="comResearchRecord.fio.label" default="ФИО пациента" />
                            <span class="required-indicator">*</span>
                        </label>
                        <g:textField name="fio" required="" value="${comResearchRecordInstance?.fio}"/>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: comResearchRecordInstance, field: 'birthday', 'error')} required">
                        <label for="birthday">
                            <g:message code="comResearchRecord.birthday.label" default="Дата рождения" />
                            <span class="required-indicator">*</span>
                        </label>
                        <g:datePicker name="birthday" precision="day"  value="${comResearchRecordInstance?.birthday}"  />
                    </div>



                    <div class="fieldcontain ${hasErrors(bean: comResearchRecordInstance, field: 'date_time', 'error')} required">
                        <label for="date_time">
                            <g:message code="comResearchRecord.date_time.label" default="Дата исследования" />
                            <span class="required-indicator">*</span>
                        </label>
                        <g:datePicker name="date_time" precision="day"  value="${date}"  />
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: comResearchRecordInstance, field: 'research', 'error')} required">
                        <label for="research">
                            <g:message code="comResearchRecord.research.label" default="Исследование" />
                            <span class="required-indicator">*</span>
                        </label>
                        <g:select id="research" name="research.id" from="${ru.mm2.operations.Research.list(sort:"name")}" optionValue="nameAndString" optionKey="id" required="" value="${comResearchRecordInstance?.research?.id}" class="many-to-one"/>
                    </div>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Создать')}" />
				</fieldset>
			</g:form>
		</div>
    <div id="list-comResearchRecord" class="content scaffold-list" role="main">
        <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <table>
            <thead>
            <tr>
                <g:sortableColumn property="fio" title="${message(code: 'comResearchRecord.fio.label', default: 'ФИО пациента')}" />
                <g:sortableColumn property="fio" title="${message(code: 'comResearchRecord.research.label', default: 'Операция')}" />
                <g:sortableColumn property="birthday" title="${message(code: 'comResearchRecord.birthday.label', default: 'Дата рождения')}" />
            </tr>
            </thead>
            <tbody>
            <g:each in="${comResearchRecordInstanceList}" status="i" var="comResearchRecordInstance">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td><g:link action="show" id="${comResearchRecordInstance.id}">${fieldValue(bean: comResearchRecordInstance, field: "fio")}</g:link></td>
                        <td>"${comResearchRecordInstance?.research?.nameAndString }"</td>
                        <td><g:formatDate date="${comResearchRecordInstance?.birthday}" /></td>
                    </tr>
            </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${comResearchRecordInstanceCount ?: 0}" />
        </div>
    </div>
	</body>
</html>
