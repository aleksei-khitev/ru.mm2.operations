
<%@ page import="ru.mm2.operations.GenOperationRecord" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'genOperationRecord.label', default: 'GenOperationRecord')}" />
    <title><g:message code="default.showrecod.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_1').checked = true;
        }
    </script>
</head>
<body>
<a href="#show-genOperationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: #DDA0DD">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
        <h3 style="text-align: center" style="color: black">Запись на госпитализацию</h3>
    </ul>
</div>
<div id="show-genOperationRecord" class="content scaffold-show" role="main">
    <h1><g:message code="default.showrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list genOperationRecord">

        <g:if test="${genOperationRecordInstance?.fio}">
            <li class="fieldcontain">
                <span id="fio-label" class="property-label"><g:message code="genOperationRecord.fio.label" default="ФИО пациента" /></span>

                <span class="property-value" aria-labelledby="fio-label"><g:fieldValue bean="${genOperationRecordInstance}" field="fio"/></span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.birthday}">
            <li class="fieldcontain">
                <span id="birthday-label" class="property-label"><g:message code="genOperationRecord.birthday.label" default="Дата рождения пациента" /></span>

                <span class="property-value" aria-labelledby="birthday-label"><g:formatDate date="${genOperationRecordInstance?.birthday}" /></span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.diagnoz}">
            <li class="fieldcontain">
                <span id="diagnoz-label" class="property-label"><g:message code="genOperationRecord.diagnoz.label" default="Диагноз" /></span>

                <span class="property-value" aria-labelledby="diagnoz-label"><g:fieldValue bean="${genOperationRecordInstance}" field="diagnoz"/></span>

            </li>
        </g:if>


        <li class="fieldcontain">
            <span id="isPatology-label" class="property-label"><g:message code="genOperationRecord.isPatology.label" default="Хроническая патология" /></span>

            <span class="property-value" aria-labelledby="isPatology-label">
                <g:if test="${genOperationRecordInstance?.isPatology}">
                    <input type="text" value="Есть" style="border: none" size="5"/>
                    <g:fieldValue bean="${genOperationRecordInstance}" field="patology"/>
                </g:if>
                <g:else>
                    <input type="text" value="Нет" style="border: none"/>
                </g:else>
            </span>

        </li>



        <li class="fieldcontain">
            <span id="isDisp-label" class="property-label"><g:message code="genOperationRecord.isDisp.label" default="Диспансерное наблюдение" /></span>
            <span class="property-value" aria-labelledby="isDisp-label">
                <g:if test="${genOperationRecordInstance?.isDisp}">
                    <input type="text" value="Есть" style="border: none" size="5"/>
                    <g:fieldValue bean="${genOperationRecordInstance}" field="disp"/>
                </g:if><g:else>
                <input type="text" value="Нет" style="border: none"/>
            </g:else>
            </span>

        </li>


        <g:if test="${genOperationRecordInstance?.lastill}">
            <li class="fieldcontain">
                <span id="lastill-label" class="property-label"><g:message code="genOperationRecord.lastill.label" default="Последнее простудное заболевание" /></span>

                <span class="property-value" aria-labelledby="lastill-label"><g:fieldValue bean="${genOperationRecordInstance}" field="lastill"/></span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.parentfio}">
            <li class="fieldcontain">
                <span id="parentfio-label" class="property-label"><g:message code="genOperationRecord.parentfio.label" default="ФИО родителей" /></span>

                <span class="property-value" aria-labelledby="parentfio-label"><g:fieldValue bean="${genOperationRecordInstance}" field="parentfio"/></span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.client_contact}">
            <li class="fieldcontain">
                <span id="client_contact-label" class="property-label"><g:message code="genOperationRecord.client_contact.label" default="Контакт для связи" /></span>

                <span class="property-value" aria-labelledby="client_contact-label"><g:fieldValue bean="${genOperationRecordInstance}" field="formattedPhone"/>
                </span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.oms}">
            <li class="fieldcontain">
                <span id="oms-label" class="property-label"><g:message code="genOperationRecord.oms.label" default="Полис ОМС" /></span>

                <span class="property-value" aria-labelledby="oms-label"><g:fieldValue bean="${genOperationRecordInstance}" field="oms"/></span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.operation}">
            <li class="fieldcontain">
                <span id="operation-label" class="property-label"><g:message code="genOperationRecord.operation.label" default="Операция" /></span>

                <span class="property-value" aria-labelledby="operation-label"><g:link controller="operations" action="show" id="${genOperationRecordInstance?.operation?.id}">${genOperationRecordInstance?.operation?.name}</g:link></span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.doctor}">
            <li class="fieldcontain">
                <span id="doctor-label" class="property-label"><g:message code="genOperationRecord.doctor.label" default="Врач" /></span>

                <span class="property-value" aria-labelledby="doctor-label"><g:link controller="doctor" action="show" id="${genOperationRecordInstance?.doctor?.id}">${genOperationRecordInstance?.doctor?.fio}</g:link></span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.date_time}">
            <li class="fieldcontain">
                <span id="date_time-label" class="property-label"><g:message code="genOperationRecord.date_time.label" default="Дата госпитализации" /></span>

                <span class="property-value" aria-labelledby="date_time-label"><g:formatDate date="${genOperationRecordInstance?.date_time}" /></span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.prim}">
            <li class="fieldcontain">
                <span id="prim-label" class="property-label"><g:message code="genOperationRecord.prim.label" default="Примечание" /></span>

                <span class="property-value" aria-labelledby="prim-label"><g:fieldValue bean="${genOperationRecordInstance}" field="prim"/></span>

            </li>
        </g:if>

        <g:if test="${genOperationRecordInstance?.isConfirm}">
            <li class="fieldcontain">
                <span id="isConfirm-label" class="property-label"><g:message code="genOperationRecord.isConfirm.label" default="Контрольный обзвоне" /></span>

                <span class="property-value" aria-labelledby="isConfirm-label"><g:formatBoolean boolean="${genOperationRecordInstance?.isConfirm}" /></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource:genOperationRecordInstance, action:'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${genOperationRecordInstance}"><g:message code="default.button.edit.label" default="Редактировать" /></g:link>
            <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
