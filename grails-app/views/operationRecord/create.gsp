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
                    <%@ page import="ru.mm2.operations.OperationRecord" %>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'fio', 'error')} ">
                        <label for="fio">
                            <g:message code="operationRecord.fio.label" default="ФИО пациента" />

                        </label>
                         <g:if test="${fio}!=''">
                             <g:textField name="fio" value="${fio}"/>
                         </g:if>
                        <g:else>
                            <g:textField name="fio" value="${operationRecordInstance?.fio}"/>
                        </g:else>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'birthday', 'error')} required">
                        <label for="birthday">
                            <g:message code="operationRecord.birthday.label" default="Дата рождения пациента" />
                            <span class="required-indicator">*</span>
                        </label>

                    <g:datePicker name="birthday" precision="day"  value="${birthday}"  />

                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'diagnoz', 'error')} ">
                        <label for="diagnoz">
                            <g:message code="operationRecord.diagnoz.label" default="Диагноз" />

                        </label>

                        <g:if test="${diagnoz}!=''">
                            <g:textField name="diagnoz" value="${diagnoz}"/>
                        </g:if>
                        <g:else>
                            <g:textField name="diagnoz" value="${operationRecordInstance?.diagnoz}"/>
                        </g:else>

                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'isPatology', 'error')} ">
                        <gui:toolTip text="Страдает ли ребёнок какими-то хроническими заболевами?">
                            <label for="isPatology">
                                <g:message code="operationRecord.isPatology.label" default="Хроническая патология" />

                            </label>
                            <g:checkBox name="isPatology" value="${operationRecordInstance?.isPatology}" onclick="hide_show_patology()"/>
                            <g:textField name="patology" value="${operationRecordInstance?.patology}" style="visibility: hidden"/>
                        </gui:toolTip>
                    </div>


                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'isDisp', 'error')} ">
                         <gui:toolTip text="Состоит ли ребёнок на учёте у какого-нибудь специалиста?">
                            <label for="isDisp">
                                <g:message code="operationRecord.isDisp.label" default="Диспансерное наблюдение" />
                            </label>
                            <g:checkBox name="isDisp" value="${operationRecordInstance?.isDisp}" onclick="hide_show_disp()"/>
                             <g:textField name="disp" value="${operationRecordInstance?.disp}" style="visibility: hidden"/>
                         </gui:toolTip>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'lastill', 'error')} ">
                        <label for="lastill">
                            <g:message code="operationRecord.lastill.label" default="Последнее простудное заболевание" />

                        </label>
                        <g:textField name="lastill" value="${operationRecordInstance?.lastill}"/>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'parentfio', 'error')} ">
                        <label for="parentfio">
                            <g:message code="operationRecord.parentfio.label" default="ФИО родителей" />

                        </label>
                        <g:textField name="parentfio" value="${operationRecordInstance?.parentfio}"/>
                        <g:if test="${parentfio}!=''">
                            <g:textField name="parentfio" value="${parentfio}"/>
                        </g:if>
                        <g:else>
                            <g:textField name="parentfio" value="${operationRecordInstance?.parentfio}"/>
                        </g:else>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'client_contact', 'error')} ">
                        <gui:toolTip text="7 цифр - городской телефон; 10 цифр - мобильный телефон">
                                    <label for="client_contact">
                                        <g:message code="operationRecord.client_contact.label" default="Контакт для связи" />

                                    </label>
                                    <g:if test="${client_contact}!=''">
                                        <g:textField name="client_contact" value="${client_contact}"  pattern="[0-9]{7,10}"/>
                                    </g:if>
                                    <g:else>
                                        <g:textField name="client_contact" value="${operationRecordInstance?.client_contact}"  pattern="[0-9]{7,10}"/>
                                    </g:else>
                        </gui:toolTip>

                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'oms', 'error')} ">
                        <label for="oms">
                            <g:message code="operationRecord.oms.label" default="Полис ОМС" />

                        </label>
                        <g:if test="${oms}!=''">
                            <g:textField name="oms" value="${oms}"/>
                        </g:if>
                        <g:else>
                            <g:textField name="oms" value="${operationRecordInstance?.oms}"/>
                        </g:else>

                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'operation', 'error')} required">
                        <label for="operation">
                            <g:message code="operationRecord.operation.label" default="Операция" />
                            <span class="required-indicator">*</span>
                        </label>
                        <g:select id="operation" name="operation.id" from="${ru.mm2.operations.Operations.list()}" optionKey="id" required="" value="${operationRecordInstance?.operation?.id}" optionValue="name" class="many-to-one"/>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'doctor', 'error')} required">
                        <label for="doctor">
                            <g:message code="operationRecord.doctor.label" default="Врач" />
                            <span class="required-indicator">*</span>
                        </label>

                        <g:if test="${doctor_id}!=''">
                            <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${doctor_id}" class="many-to-one"/>
                        </g:if>
                        <g:else>
                            <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${operationRecordInstance?.doctor?.id}" class="many-to-one"/>
                        </g:else>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'date_time', 'error')} required">
                        <label for="date_time">
                            <g:message code="operationRecord.date_time.label" default="Дата госпитализации" />
                            <span class="required-indicator">*</span>
                        </label>
                        <g:datePicker name="date_time" precision="day"  value="${date}"  />
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'isConfirm', 'error')} ">
                        <gui:toolTip text="Если визит подтвержден, отметьте поле галочкой">
                            <label for="isConfirm">
                                <g:message code="operationRecord.isConfirm.label" default="Контрольный обзвон" />
                            </label>
                            <g:checkBox name="isConfirm" value="${operationRecordInstance?.isConfirm}" />
                        </gui:toolTip>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'prim', 'error')} ">
                        <label for="prim">
                            <g:message code="operationRecord.prim.label" default="Примечание" />

                        </label>
                        <g:textField name="prim" value="${operationRecordInstance?.prim}"/>
                    </div>

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
                        <td><g:formatDate format="dd.MM.yyyy" date="${operationRecordInstance?.birthday}" /></td>
                        <td><g:checkBox name="isConfirm " value="${operationRecordInstance?.isConfirm }" /></td>
                        <td>"${operationRecordInstance?.prim }"</td>
                    </tr>
                </g:if>
                <g:else>
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td><g:link action="show" id="${operationRecordInstance.id}">${fieldValue(bean: operationRecordInstance, field: "fio")}</g:link></td>
                        <td>"${operationRecordInstance?.operation?.name }"</td>
                        <td>"${operationRecordInstance?.doctor?.fio }"</td>
                        <td><g:formatDate format="dd.MM.yyyy" date="${operationRecordInstance?.birthday}" /></td>
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
