<!DOCTYPE html>
<%@ page import="ru.mm2.operations.ComConsultationRecord" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'comConsultationRecord.label', default: 'ComConsultationRecord')}" />
    <title><g:message code="default.createrecod.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_2').checked = true;
        }
    </script>
</head>
<body>
<a href="#create-comConsultationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: lightgreen">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
        <h3 style="text-align: center">Запись на консультацию</h3>
    </ul>
</div>
<div id="create-comConsultationRecord" class="content scaffold-create" role="main">
    <h1><g:message code="default.createrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${comConsultationRecordInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${comConsultationRecordInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form url="[resource:comConsultationRecordInstance, action:'save']" >
        <fieldset class="form">
            <%@ page import="ru.mm2.operations.ComConsultationRecord" %>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'fio', 'error')} ">
                <label for="fio">
                    <g:message code="comConsultationRecord.fio.label" default="ФИО пациента" />

                </label>
                <g:textField name="fio" value="${comConsultationRecordInstance?.fio}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'birthday', 'error')} required">
                <label for="birthday">
                    <g:message code="comConsultationRecord.birthday.label" default="Дата рождения пациента" />
                    <span class="required-indicator">*</span>
                </label>
                <g:datePicker name="birthday" precision="day"  value="${comConsultationRecordInstance?.birthday}"  />
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'date_time', 'error')} required">
                <label for="date_time">
                    <g:message code="comConsultationRecord.date_time.label" default="Дата консультации" />
                    <span class="required-indicator">*</span>
                </label>
                <g:datePicker name="date_time" precision="day"  value="${date}"  />
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'diagnoz', 'error')} ">
                <label for="diagnoz">
                    <g:message code="comConsultationRecord.diagnoz.label" default="Диагноз" />

                </label>
                <g:textField name="diagnoz" value="${comConsultationRecordInstance?.diagnoz}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'oms', 'error')} ">
                <label for="oms">
                    <g:message code="comConsultationRecord.oms.label" default="Полис ОМС" />

                </label>
                <g:textField name="oms" value="${comConsultationRecordInstance?.oms}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'doctor', 'error')} required">
                <label for="doctor">
                    <g:message code="comConsultationRecord.doctor.label" default="Врач" />
                    <span class="required-indicator">*</span>
                </label>
                <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${comConsultationRecordInstance?.doctor?.id}" class="many-to-one"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'client_contact', 'error')} ">
                <gui:toolTip text="7 цифр - городской телефон; 10 цифр - мобильный телефон">
                    <label for="client_contact">
                        <g:message code="comConsultationRecord.client_contact.label" default="Контакт для связи" />
                    </label>
                    <g:phoneWithPattern name="client_contact" value="${comConsultationRecordInstance?.client_contact}"/>
                </gui:toolTip>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'parentfio', 'error')} ">
                <label for="parentfio">
                    <g:message code="comConsultationRecord.parentfio.label" default="ФИО родителей" />

                </label>
                <g:textField name="parentfio" value="${comConsultationRecordInstance?.parentfio}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'isNaprav', 'error')} ">
                <gui:toolTip text="Срок действия 1 месяц">
                    <label for="isNaprav">
                        <g:message code="comConsultationRecord.isNaprav.label" default="Наличие направления" />
                    </label>
                    <g:checkBox name="isNaprav" value="${comConsultationRecordInstance?.isNaprav}" />
                </gui:toolTip>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'isPechat', 'error')} ">
                <gui:toolTip text="На направлении должно быть 2 печати: печать для справок и печать ЛПУ ">
                    <label for="isPechat">
                        <g:message code="comConsultationRecord.isPechat.label" default="Наличие печатей на направлении" />
                    </label>
                    <g:checkBox name="isPechat" value="${comConsultationRecordInstance?.isPechat}" />
                </gui:toolTip>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'isConfirm', 'error')} ">
                <gui:toolTip text="Если визит подтвержден, отметьте поле галочкой">
                    <label for="isConfirm">
                        <g:message code="comConsultationRecord.isConfirm.label" default="Контрольный обзвон" />
                    </label>
                    <g:checkBox name="isConfirm" value="${comConsultationRecordInstance?.isConfirm}" />
                </gui:toolTip>
            </div>

            <div class="fieldcontain ${hasErrors(bean: comConsultationRecordInstance, field: 'prim', 'error')} ">
                <gui:toolTip text="Результат обзвона">
                    <label for="prim">
                        <g:message code="comConsultationRecord.prim.label" default="Примечание" />

                    </label>
                    <g:textField name="prim" value="${comConsultationRecordInstance?.prim}"/>
                </gui:toolTip>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
        </fieldset>
    </g:form>
</div>
<div id="list-comConsultationRecord" class="content scaffold-list" role="main">
    <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="fio" title="${message(code: 'comConsultationRecord.fio.label', default: 'ФИО пациента')}" />
            <th><g:message code="comConsultationRecord.doctor.label" default="Врач" /></th>
            <g:sortableColumn property="birthday" title="${message(code: 'comConsultationRecord.birthday.label', default: 'Дата рождения')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${comConsultationRecordInstanceList}" status="i" var="comConsultationRecordInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td><g:link action="show" id="${comConsultationRecordInstance.id}">${fieldValue(bean: comConsultationRecordInstance, field: "fio")}</g:link></td>
                <td>"${comConsultationRecordInstance?.doctor?.fio }"</td>
                <td><g:formatDate date="${comConsultationRecordInstance?.birthday}" /></td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${comConsultationRecordInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>
