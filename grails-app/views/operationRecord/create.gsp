<!DOCTYPE html>
<%@ page import="ru.mm2.operations.OperationRecord" %>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'operationRecord.label', default: 'OperationRecord')}" />
		<title><g:message code="default.createrecod.label" args="[entityName]" /></title>
        <script>
            function hide_show_patology(){
                if(isPatology.checked==true) {
                    patology.style.visibility= 'visible';
                }
                else {
                    patology.style.visibility= 'hidden';
                }
            }
            function hide_show_disp(){
                if(isDisp.checked==true) {
                    disp.style.visibility= 'visible';
                }
                else {
                    disp.style.visibility= 'hidden';
                }
            }
        </script>
        <script>
            window.onload = function(){
                document.getElementById('tab_1').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#create-operationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: #FA8072">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: white"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index" style="color: white"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
                <h3 style="color: white; text-align: center">Запись на госпитализацию</h3>
			</ul>
		</div>
		<div id="create-operationRecord" class="content scaffold-create" role="main">
			<h1><g:message code="default.createrecod.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${operationRecordInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${operationRecordInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:operationRecordInstance, action:'save']" >
				<fieldset class="form">
                    <g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
    <div id="list-operationRecord" class="content scaffold-list" role="main">
        <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <table>
            <thead>
            <tr>
                <g:sortableColumn property="fio" title="${message(code: 'operationRecord.fio.label', default: 'ФИО пациента')}" />
                <g:sortableColumn property="fio" title="${message(code: 'operationRecord.operation.label', default: 'Операция')}" />
                <th><g:message code="operationRecord.doctor.label" default="Врач" /></th>
                <g:sortableColumn property="birthday" title="${message(code: 'operationRecord.birthday.label', default: 'Дата рождения')}" />
                <g:sortableColumn property="diagnoz" title="${message(code: 'operationRecord.isConfirm.label', default: 'Обзвон')}" />
                <g:sortableColumn property="prim" title="${message(code: 'operationRecord.prim.label', default: 'Примечание')}" />
            </tr>
            </thead>
            <tbody>
            <g:each in="${operationRecordInstanceList}" status="i" var="operationRecordInstance">
                <g:if test="${operationRecordInstance?.isConfirm}">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}"  style="background-color:#32CD32">
                        <td><g:link action="show" id="${operationRecordInstance.id}">${fieldValue(bean: operationRecordInstance, field: "fio")}</g:link></td>
                        <td>"${operationRecordInstance?.operation?.name }"</td>
                        <td>"${operationRecordInstance?.doctor?.fio }"</td>
                        <td><g:formatDate date="${operationRecordInstance?.birthday}" /></td>
                        <td><g:checkBox name="isConfirm " value="${operationRecordInstance?.isConfirm }" /></td>
                        <td>"${operationRecordInstance?.prim }"</td>
                    </tr>
                </g:if>
                <g:else>
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td><g:link action="show" id="${operationRecordInstance.id}">${fieldValue(bean: operationRecordInstance, field: "fio")}</g:link></td>
                        <td>"${operationRecordInstance?.operation?.name }"</td>
                        <td>"${operationRecordInstance?.doctor?.fio }"</td>
                        <td><g:formatDate date="${operationRecordInstance?.birthday}" /></td>
                        <td><g:checkBox name="isConfirm " value="${operationRecordInstance?.isConfirm }" /></td>
                        <td>"${operationRecordInstance?.prim }"</td>
                    </tr>
                </g:else>
            </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${operationRecordInstanceCount ?: 0}" />
        </div>
    </div>
	</body>
</html>
