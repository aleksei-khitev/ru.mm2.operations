
<%@ page import="ru.mm2.operations.OperationRecord" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'operationRecord.label', default: 'OperationRecord')}" />
    <title><g:message code="default.showrecod.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_1').checked = true;
        }
    </script>
</head>
<body>
<a href="#show-operationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: yellowgreen">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
        <h3 style="text-align: center" style="color: black">Запись на госпитализацию</h3>
    </ul>
</div>
<div id="show-operationRecord" class="content scaffold-show" role="main">
    <h1><g:message code="default.showrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list operationRecord">

        <g:if test="${operationRecordInstance?.fio}">
            <li class="fieldcontain">
                <span id="fio-label" class="property-label"><g:message code="operationRecord.fio.label" default="ФИО пациента" /></span>

                <span class="property-value" aria-labelledby="fio-label"><g:fieldValue bean="${operationRecordInstance}" field="fio"/></span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.birthday}">
            <li class="fieldcontain">
                <span id="birthday-label" class="property-label"><g:message code="operationRecord.birthday.label" default="Дата рождения пациента" /></span>

                <span class="property-value" aria-labelledby="birthday-label"><g:formatDate date="${operationRecordInstance?.birthday}" /></span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.diagnoz}">
            <li class="fieldcontain">
                <span id="diagnoz-label" class="property-label"><g:message code="operationRecord.diagnoz.label" default="Диагноз" /></span>

                <span class="property-value" aria-labelledby="diagnoz-label"><g:fieldValue bean="${operationRecordInstance}" field="diagnoz"/></span>

            </li>
        </g:if>


        <li class="fieldcontain">
            <span id="isPatology-label" class="property-label"><g:message code="operationRecord.isPatology.label" default="Хроническая патология" /></span>

            <span class="property-value" aria-labelledby="isPatology-label">
                <g:if test="${operationRecordInstance?.isPatology}">
                    <input type="text" value="Есть" style="border: none" size="5"/>
                    <g:fieldValue bean="${operationRecordInstance}" field="patology"/>
                </g:if>
                <g:else>
                    <input type="text" value="Нет" style="border: none"/>
                </g:else>
            </span>

        </li>



        <li class="fieldcontain">
            <span id="isDisp-label" class="property-label"><g:message code="operationRecord.isDisp.label" default="Диспансерное наблюдение" /></span>
            <span class="property-value" aria-labelledby="isDisp-label">
                <g:if test="${operationRecordInstance?.isDisp}">
                    <input type="text" value="Есть" style="border: none" size="5"/>
                    <g:fieldValue bean="${operationRecordInstance}" field="disp"/>
                </g:if><g:else>
                <input type="text" value="Нет" style="border: none"/>
            </g:else>
            </span>

        </li>


        <g:if test="${operationRecordInstance?.lastill}">
            <li class="fieldcontain">
                <span id="lastill-label" class="property-label"><g:message code="operationRecord.lastill.label" default="Последнее простудное заболевание" /></span>

                <span class="property-value" aria-labelledby="lastill-label"><g:fieldValue bean="${operationRecordInstance}" field="lastill"/></span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.parentfio}">
            <li class="fieldcontain">
                <span id="parentfio-label" class="property-label"><g:message code="operationRecord.parentfio.label" default="ФИО родителей" /></span>

                <span class="property-value" aria-labelledby="parentfio-label"><g:fieldValue bean="${operationRecordInstance}" field="parentfio"/></span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.client_contact}">
            <li class="fieldcontain">
                <span id="client_contact-label" class="property-label"><g:message code="operationRecord.client_contact.label" default="Контакт для связи" /></span>

                <span class="property-value" aria-labelledby="client_contact-label"><g:fieldValue bean="${operationRecordInstance}" field="formattedPhone"/>
                </span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.oms}">
            <li class="fieldcontain">
                <span id="oms-label" class="property-label"><g:message code="operationRecord.oms.label" default="Полис ОМС" /></span>

                <span class="property-value" aria-labelledby="oms-label"><g:fieldValue bean="${operationRecordInstance}" field="oms"/></span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.operation}">
            <li class="fieldcontain">
                <span id="operation-label" class="property-label"><g:message code="operationRecord.operation.label" default="Операция" /></span>

                <span class="property-value" aria-labelledby="operation-label"><g:link controller="operations" action="show" id="${operationRecordInstance?.operation?.id}">${operationRecordInstance?.operation?.name}</g:link></span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.doctor}">
            <li class="fieldcontain">
                <span id="doctor-label" class="property-label"><g:message code="operationRecord.doctor.label" default="Врач" /></span>

                <span class="property-value" aria-labelledby="doctor-label"><g:link controller="doctor" action="show" id="${operationRecordInstance?.doctor?.id}">${operationRecordInstance?.doctor?.fio}</g:link></span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.date_time}">
            <li class="fieldcontain">
                <span id="date_time-label" class="property-label"><g:message code="operationRecord.date_time.label" default="Дата госпитализации" /></span>

                <span class="property-value" aria-labelledby="date_time-label"><g:formatDate date="${operationRecordInstance?.date_time}" /></span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.prim}">
            <li class="fieldcontain">
                <span id="prim-label" class="property-label"><g:message code="operationRecord.prim.label" default="Примечание" /></span>

                <span class="property-value" aria-labelledby="prim-label"><g:fieldValue bean="${operationRecordInstance}" field="prim"/></span>

            </li>
        </g:if>

        <g:if test="${operationRecordInstance?.isConfirm}">
            <li class="fieldcontain">
                <span id="isConfirm-label" class="property-label"><g:message code="operationRecord.isConfirm.label" default="Контрольный обзвоне" /></span>

                <span class="property-value" aria-labelledby="isConfirm-label"><g:formatBoolean boolean="${operationRecordInstance?.isConfirm}" /></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource:operationRecordInstance, action:'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${operationRecordInstance}"><g:message code="default.button.edit.label" default="Редактировать" /></g:link>
            <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
