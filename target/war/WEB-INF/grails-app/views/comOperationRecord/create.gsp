<!DOCTYPE html>
<%@ page import="ru.mm2.operations.ComOperationRecord" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'comOperationRecord.label', default: 'ComOperationRecord')}" />
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
            document.getElementById('tab_2').checked = true;
        }
    </script>
</head>
<body>
<a href="#create-comOperationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: yellowgreen">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecod.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="create-comOperationRecord" class="content scaffold-create" role="main">
    <h1><g:message code="default.createrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${comOperationRecordInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${comOperationRecordInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form url="[resource:comOperationRecordInstance, action:'save']" >
        <fieldset class="form">
            <%@ page import="ru.mm2.operations.ComOperationRecord" %>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'fio', 'error')} ">
                <label for="fio">
                    <g:message code="comOperationRecord.fio.label" default="ФИО пациента" />

                </label>
                <g:if test="${fio}!=''">
                    <g:textField name="fio" value="${fio}"/>
                </g:if>
                <g:else>
                    <g:textField name="fio" value="${comOperationRecordInstance?.fio}"/>
                </g:else>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'birthday', 'error')} required">
                <label for="birthday">
                    <g:message code="comOperationRecord.birthday.label" default="Дата рождения пациента" />
                    <span class="required-indicator">*</span>
                </label>

                <g:datePicker name="birthday" precision="day"  value="${birthday}"  />

            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'diagnoz', 'error')} ">
                <label for="diagnoz">
                    <g:message code="comOperationRecord.diagnoz.label" default="Диагноз" />

                </label>

                <g:if test="${diagnoz}!=''">
                    <g:textField name="diagnoz" value="${diagnoz}"/>
                </g:if>
                <g:else>
                    <g:textField name="diagnoz" value="${comOperationRecordInstance?.diagnoz}"/>
                </g:else>

            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'isPatology', 'error')} ">
                <gui:toolTip text="Страдает ли ребёнок какими-то хроническими заболевами?">
                    <label for="isPatology">
                        <g:message code="comOperationRecord.isPatology.label" default="Хроническая патология" />

                    </label>
                    <g:checkBox name="isPatology" value="${comOperationRecordInstance?.isPatology}" onclick="hide_show_patology()"/>
                    <g:textField name="patology" value="${comOperationRecordInstance?.patology}" style="visibility: hidden"/>
                </gui:toolTip>
            </div>


            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'isDisp', 'error')} ">
                <gui:toolTip text="Состоит ли ребёнок на учёте у какого-нибудь специалиста?">
                    <label for="isDisp">
                        <g:message code="comOperationRecord.isDisp.label" default="Диспансерное наблюдение" />
                    </label>
                    <g:checkBox name="isDisp" value="${comOperationRecordInstance?.isDisp}" onclick="hide_show_disp()"/>
                    <g:textField name="disp" value="${comOperationRecordInstance?.disp}" style="visibility: hidden"/>
                </gui:toolTip>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'lastill', 'error')} ">
                <label for="lastill">
                    <g:message code="comOperationRecord.lastill.label" default="Последнее простудное заболевание" />

                </label>
                <g:textField name="lastill" value="${comOperationRecordInstance?.lastill}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'parentfio', 'error')} ">
                <label for="parentfio">
                    <g:message code="comOperationRecord.parentfio.label" default="ФИО родителей" />

                </label>
                <g:textField name="parentfio" value="${comOperationRecordInstance?.parentfio}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'client_contact', 'error')} ">
                <gui:toolTip text="7 цифр - городской телефон; 10 цифр - мобильный телефон">
                    <label for="client_contact">
                        <g:message code="comOperationRecord.client_contact.label" default="Контакт для связи" />

                    </label>
                    <g:if test="${client_contact}!=''">
                        <g:textField name="client_contact" value="${client_contact}"  pattern="[0-9]{7,10}"/>
                    </g:if>
                    <g:else>
                        <g:textField name="client_contact" value="${comOperationRecordInstance?.client_contact}"  pattern="[0-9]{7,10}"/>
                    </g:else>
                </gui:toolTip>

            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'oms', 'error')} ">
                <label for="oms">
                    <g:message code="comOperationRecord.oms.label" default="Полис ОМС" />

                </label>
                <g:if test="${oms}!=''">
                    <g:textField name="oms" value="${oms}"/>
                </g:if>
                <g:else>
                    <g:textField name="oms" value="${comOperationRecordInstance?.oms}"/>
                </g:else>

            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'operation', 'error')} required">
                <label for="operation">
                    <g:message code="comOperationRecord.operation.label" default="Операция" />
                    <span class="required-indicator">*</span>
                </label>
                <g:select id="operation" name="operation.id" from="${ru.mm2.operations.Operations.list()}" optionKey="id" required="" value="${comOperationRecordInstance?.operation?.id}" optionValue="name" class="many-to-one"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'doctor', 'error')} required">
                <label for="doctor">
                    <g:message code="comOperationRecord.doctor.label" default="Врач" />
                    <span class="required-indicator">*</span>
                </label>

                <g:if test="${doctor_id}!=''">
                    <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${doctor_id}" class="many-to-one"/>
                </g:if>
                <g:else>
                    <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${comOperationRecordInstance?.doctor?.id}" class="many-to-one"/>
                </g:else>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'date_time', 'error')} required">
                <label for="date_time">
                    <g:message code="comOperationRecord.date_time.label" default="Дата госпитализации" />
                    <span class="required-indicator">*</span>
                </label>
                <g:datePicker name="date_time" precision="day"  value="${date}"  />
            </div>
            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'isConfirm', 'error')} ">
                <gui:toolTip text="Если визит подтвержден, отметьте поле галочкой">
                    <label for="isConfirm">
                        <g:message code="comOperationRecord.isConfirm.label" default="Контрольный обзвон" />
                    </label>
                    <g:checkBox name="isConfirm" value="${comOperationRecordInstance?.isConfirm}" />
                </gui:toolTip>
            </div>
            <div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'prim', 'error')} ">
                <label for="prim">
                    <g:message code="comOperationRecord.prim.label" default="Примечание" />

                </label>
                <g:textField name="prim" value="${comOperationRecordInstance?.prim}"/>
            </div>

        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
        </fieldset>
    </g:form>
</div>
<div id="list-comOperationRecord" class="content scaffold-list" role="main">
    <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="fio" title="${message(code: 'comOperationRecord.fio.label', default: 'ФИО пациента')}" />
            <g:sortableColumn property="fio" title="${message(code: 'comOperationRecord.operation.label', default: 'Операция')}" />
            <th><g:message code="comOperationRecord.doctor.label" default="Врач" /></th>
            <g:sortableColumn property="birthday" title="${message(code: 'comOperationRecord.birthday.label', default: 'Дата рождения')}" />
            <g:sortableColumn property="diagnoz" title="${message(code: 'comOperationRecord.isConfirm.label', default: 'Обзвон')}" />
            <g:sortableColumn property="prim" title="${message(code: 'comOperationRecord.prim.label', default: 'Примечание')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${comOperationRecordInstanceList}" status="i" var="comOperationRecordInstance">
            <g:if test="${comOperationRecordInstance?.isConfirm}">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}"  style="background-color:#32CD32">
                    <td><g:link action="show" id="${comOperationRecordInstance.id}">${fieldValue(bean: comOperationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${comOperationRecordInstance?.operation?.name }"</td>
                    <td>"${comOperationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate format="dd.MM.yyyy" date="${comOperationRecordInstance?.birthday}" /></td>
                    <td><g:checkBox name="isConfirm " value="${comOperationRecordInstance?.isConfirm }" /></td>
                    <td>"${comOperationRecordInstance?.prim }"</td>
                </tr>
            </g:if>
            <g:else>
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link action="show" id="${comOperationRecordInstance.id}">${fieldValue(bean: comOperationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${comOperationRecordInstance?.operation?.name }"</td>
                    <td>"${comOperationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate format="dd.MM.yyyy" date="${comOperationRecordInstance?.birthday}" /></td>
                    <td><g:checkBox name="isConfirm " value="${comOperationRecordInstance?.isConfirm }" /></td>
                    <td>"${comOperationRecordInstance?.prim }"</td>
                </tr>
            </g:else>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${comOperationRecordInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>
