
<%@ page import="ru.mm2.operations.ComConsultationRecord" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'comConsultationRecord.label', default: 'ComConsultationRecord')}" />
    <title><g:message code="default.showrecod.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_2').checked = true;
        }
    </script>
</head>
<body>
<a href="#show-comConsultationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: lightgreen">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
        <h3 style="text-align: center">Запись на консультацию</h3>
    </ul>
</div>
<div id="show-comConsultationRecord" class="content scaffold-show" role="main">
    <h1><g:message code="default.showrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list comConsultationRecord">

        <g:if test="${comConsultationRecordInstance?.fio}">
            <li class="fieldcontain">
                <span id="fio-label" class="property-label"><g:message code="comConsultationRecord.fio.label" default="ФИО пациента" /></span>

                <span class="property-value" aria-labelledby="fio-label"><g:fieldValue bean="${comConsultationRecordInstance}" field="fio"/></span>

            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.birthday}">
            <li class="fieldcontain">
                <span id="birthday-label" class="property-label"><g:message code="comConsultationRecord.birthday.label" default="Дата рождения пациента" /></span>

                <span class="property-value" aria-labelledby="birthday-label"><g:formatDate date="${comConsultationRecordInstance?.birthday}" /></span>

            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.date_time}">
            <li class="fieldcontain">
                <span id="date_time-label" class="property-label"><g:message code="comConsultationRecord.date_time.label" default="Дата консультации" /></span>

                <span class="property-value" aria-labelledby="date_time-label"><g:formatDate date="${comConsultationRecordInstance?.date_time}" /></span>

            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.diagnoz}">
            <li class="fieldcontain">
                <span id="diagnoz-label" class="property-label"><g:message code="comConsultationRecord.diagnoz.label" default="Диагноз" /></span>

                <span class="property-value" aria-labelledby="diagnoz-label"><g:fieldValue bean="${comConsultationRecordInstance}" field="diagnoz"/></span>

            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.oms}">
            <li class="fieldcontain">
                <span id="oms-label" class="property-label"><g:message code="comConsultationRecord.oms.label" default="Полис ОМС" /></span>

                <span class="property-value" aria-labelledby="oms-label"><g:fieldValue bean="${comConsultationRecordInstance}" field="oms"/></span>

            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.doctor}">
            <li class="fieldcontain">
                <span id="doctor-label" class="property-label"><g:message code="comConsultationRecord.doctor.label" default="Врач" /></span>

                <span class="property-value" aria-labelledby="doctor-label"><g:link controller="doctor" action="show" id="${comConsultationRecordInstance?.doctor?.id}">${comConsultationRecordInstance?.doctor?.fio}</g:link></span>

            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.client_contact}">
            <li class="fieldcontain">
                <span id="client_contact-label" class="property-label"><g:message code="comConsultationRecord.client_contact.label" default="Контакт для связи" /></span>

                <span class="property-value" aria-labelledby="client_contact-label"><g:fieldValue bean="${comConsultationRecordInstance}" field="formattedPhone"/></span>

            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.parentfio}">
            <li class="fieldcontain">
                <span id="parentfio-label" class="property-label"><g:message code="comConsultationRecord.parentfio.label" default="ФИО родителей" /></span>

                <span class="property-value" aria-labelledby="parentfio-label"><g:fieldValue bean="${comConsultationRecordInstance}" field="parentfio"/></span>

            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.isNaprav}">
            <li class="fieldcontain">
                <span id="isNaprav-label" class="property-label"><g:message code="comConsultationRecord.isNaprav.label" default="Наличие направления" /></span>
                <span class="property-value" aria-labelledby="isNaprav-label"><g:formatBoolean boolean="${comConsultationRecordInstance?.isNaprav}" /></span>
            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.isPechat}">
            <li class="fieldcontain">
                <span id="isPechat-label" class="property-label"><g:message code="comConsultationRecord.isPechat.label" default="Наличие печатей на направлении" /></span>
                <span class="property-value" aria-labelledby="isPechat-label"><g:formatBoolean boolean="${comConsultationRecordInstance?.isPechat}" /></span>
            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.isConfirm}">
            <li class="fieldcontain">
                <span id="isConfirm-label" class="property-label"><g:message code="comConsultationRecord.isConfirm.label" default="Контрольный обзвон" /></span>
                <span class="property-value" aria-labelledby="isConfirm-label"><g:formatBoolean boolean="${comConsultationRecordInstance?.isConfirm}" /></span>
            </li>
        </g:if>

        <g:if test="${comConsultationRecordInstance?.prim}">
            <li class="fieldcontain">
                <span id="prim-label" class="property-label"><g:message code="comConsultationRecord.prim.label" default="Примечание" /></span>

                <span class="property-value" aria-labelledby="prim-label"><g:fieldValue bean="${comConsultationRecordInstance}" field="prim"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource:comConsultationRecordInstance, action:'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${comConsultationRecordInstance}"><g:message code="default.button.edit.label" default="Редактировать" /></g:link>
            <g:link class="edit" controller="comOperationRecord" action="create" params='[parentfio:"${consultationRecordInstance?.parentfio}",doctor_id:"${comConsultationRecordInstance?.doctor?.id}",oms:"${comConsultationRecordInstance?.oms}",birthday:"${comConsultationRecordInstance?.birthday}",client_contact:"${comConsultationRecordInstance?.client_contact}",diagnoz:"${comConsultationRecordInstance?.diagnoz}",fio:"${comConsultationRecordInstance?.fio}",from_consult:"true",date_time: "${comConsultationRecordInstance?.date_time}"]' style="color: maroon; font-weight: bold;"><g:message code="default.consulttooper.label" default="Направить на операцию"/></g:link>
            <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />

        </fieldset>
    </g:form>
</div>
</body>
</html>
