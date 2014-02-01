
<%@ page import="ru.mm2.operations.ConsultationRecord" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'consultationRecord.label', default: 'ConsultationRecord')}" />
    <title><g:message code="default.showrecod.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_1').checked = true;
        }
    </script>
</head>
<body>
<a href="#show-consultationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: #DDA0DD">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
        <h3 style="text-align: center">Запись на консультацию</h3>
    </ul>
</div>
<div id="show-consultationRecord" class="content scaffold-show" role="main">
    <h1><g:message code="default.showrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list consultationRecord">

        <g:if test="${consultationRecordInstance?.fio}">
            <li class="fieldcontain">
                <span id="fio-label" class="property-label"><g:message code="consultationRecord.fio.label" default="ФИО пациента" /></span>

                <span class="property-value" aria-labelledby="fio-label"><g:fieldValue bean="${consultationRecordInstance}" field="fio"/></span>

            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.birthday}">
            <li class="fieldcontain">
                <span id="birthday-label" class="property-label"><g:message code="consultationRecord.birthday.label" default="Дата рождения пациента" /></span>

                <span class="property-value" aria-labelledby="birthday-label"><g:formatDate date="${consultationRecordInstance?.birthday}" /></span>

            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.date_time}">
            <li class="fieldcontain">
                <span id="date_time-label" class="property-label"><g:message code="consultationRecord.date_time.label" default="Дата консультации" /></span>

                <span class="property-value" aria-labelledby="date_time-label"><g:formatDate date="${consultationRecordInstance?.date_time}" /></span>

            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.diagnoz}">
            <li class="fieldcontain">
                <span id="diagnoz-label" class="property-label"><g:message code="consultationRecord.diagnoz.label" default="Диагноз" /></span>

                <span class="property-value" aria-labelledby="diagnoz-label"><g:fieldValue bean="${consultationRecordInstance}" field="diagnoz"/></span>

            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.oms}">
            <li class="fieldcontain">
                <span id="oms-label" class="property-label"><g:message code="consultationRecord.oms.label" default="Полис ОМС" /></span>

                <span class="property-value" aria-labelledby="oms-label"><g:fieldValue bean="${consultationRecordInstance}" field="oms"/></span>

            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.doctor}">
            <li class="fieldcontain">
                <span id="doctor-label" class="property-label"><g:message code="consultationRecord.doctor.label" default="Врач" /></span>

                <span class="property-value" aria-labelledby="doctor-label"><g:link controller="doctor" action="show" id="${consultationRecordInstance?.doctor?.id}">${consultationRecordInstance?.doctor?.fio}</g:link></span>

            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.client_contact}">
            <li class="fieldcontain">
                <span id="client_contact-label" class="property-label"><g:message code="consultationRecord.client_contact.label" default="Контакт для связи" /></span>

                <span class="property-value" aria-labelledby="client_contact-label"><g:fieldValue bean="${consultationRecordInstance}" field="formattedPhone"/></span>

            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.parentfio}">
            <li class="fieldcontain">
                <span id="parentfio-label" class="property-label"><g:message code="consultationRecord.parentfio.label" default="ФИО родителей" /></span>

                <span class="property-value" aria-labelledby="parentfio-label"><g:fieldValue bean="${consultationRecordInstance}" field="parentfio"/></span>

            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.isNaprav}">
            <li class="fieldcontain">
                <span id="isNaprav-label" class="property-label"><g:message code="consultationRecord.isNaprav.label" default="Наличие направления" /></span>
                <span class="property-value" aria-labelledby="isNaprav-label"><g:formatBoolean boolean="${consultationRecordInstance?.isNaprav}" /></span>
            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.isPechat}">
            <li class="fieldcontain">
                <span id="isPechat-label" class="property-label"><g:message code="consultationRecord.isPechat.label" default="Наличие печатей на направлении" /></span>
                <span class="property-value" aria-labelledby="isPechat-label"><g:formatBoolean boolean="${consultationRecordInstance?.isPechat}" /></span>
            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.isConfirm}">
            <li class="fieldcontain">
                <span id="isConfirm-label" class="property-label"><g:message code="consultationRecord.isConfirm.label" default="Контрольный обзвон" /></span>
                <span class="property-value" aria-labelledby="isConfirm-label"><g:formatBoolean boolean="${consultationRecordInstance?.isConfirm}" /></span>
            </li>
        </g:if>

        <g:if test="${consultationRecordInstance?.prim}">
            <li class="fieldcontain">
                <span id="prim-label" class="property-label"><g:message code="consultationRecord.prim.label" default="Примечание" /></span>

                <span class="property-value" aria-labelledby="prim-label"><g:fieldValue bean="${consultationRecordInstance}" field="prim"/></span>

            </li>
        </g:if>

        <g:infoAboutRecord lastUpdated="${consultationRecordInstance?.lastUpdated}" updatedUser="${consultationRecordInstance?.updatedUser}"/>
    </ol>
    <g:form url="[resource:consultationRecordInstance, action:'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${consultationRecordInstance}"><g:message code="default.button.edit.label" default="Редактировать" /></g:link>
            <g:link class="edit" controller="genOperationRecord" action="create" params='[parentfio:"${consultationRecordInstance?.parentfio}",doctor_id:"${consultationRecordInstance?.doctor?.id}",oms:"${consultationRecordInstance?.oms}",birthday:"${consultationRecordInstance?.birthday}",client_contact:"${consultationRecordInstance?.client_contact}",diagnoz:"${consultationRecordInstance?.diagnoz}",fio:"${consultationRecordInstance?.fio}",from_consult:"true",date_time: "${consultationRecordInstance?.date_time}"]' style="color: maroon; font-weight: bold;"><g:message code="default.consulttooper.label" default="Направить на операцию"/></g:link>
            <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />

        </fieldset>
    </g:form>
</div>
</body>
</html>
