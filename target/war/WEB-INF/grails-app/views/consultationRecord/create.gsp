<!DOCTYPE html>
<%@ page import="ru.mm2.operations.ConsultationRecord" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'consultationRecord.label', default: 'ConsultationRecord')}" />
    <title><g:message code="default.createrecod.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_1').checked = true;
        }
    </script>
</head>
<body>
<a href="#create-consultationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: #DDA0DD">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecod.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="create-consultationRecord" class="content scaffold-create" role="main">
    <h1><g:message code="default.createrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${consultationRecordInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${consultationRecordInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form url="[resource:consultationRecordInstance, action:'save']" >
        <fieldset class="form">
            <%@ page import="ru.mm2.operations.ConsultationRecord" %>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'fio', 'error')} ">
                <label for="fio">
                    <g:message code="consultationRecord.fio.label" default="ФИО пациента" />

                </label>
                <g:textField name="fio" value="${consultationRecordInstance?.fio}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'birthday', 'error')} required">
                <label for="birthday">
                    <g:message code="consultationRecord.birthday.label" default="Дата рождения пациента" />
                    <span class="required-indicator">*</span>
                </label>
                <g:datePicker name="birthday" precision="day"  value="${consultationRecordInstance?.birthday}"  />
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'date_time', 'error')} required">
                <label for="date_time">
                    <g:message code="consultationRecord.date_time.label" default="Дата консультации" />
                    <span class="required-indicator">*</span>
                </label>
                <g:datePicker name="date_time" precision="day"  value="${date}"  />
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'diagnoz', 'error')} ">
                <label for="diagnoz">
                    <g:message code="consultationRecord.diagnoz.label" default="Диагноз" />

                </label>
                <g:textField name="diagnoz" value="${consultationRecordInstance?.diagnoz}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'oms', 'error')} ">
                <label for="oms">
                    <g:message code="consultationRecord.oms.label" default="Полис ОМС" />

                </label>
                <g:textField name="oms" value="${consultationRecordInstance?.oms}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'doctor', 'error')} required">
                <label for="doctor">
                    <g:message code="consultationRecord.doctor.label" default="Врач" />
                    <span class="required-indicator">*</span>
                </label>
                <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${consultationRecordInstance?.doctor?.id}" class="many-to-one"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'client_contact', 'error')} ">
                <gui:toolTip text="7 цифр - городской телефон; 10 цифр - мобильный телефон">
                        <label for="client_contact">
                            <g:message code="consultationRecord.client_contact.label" default="Контакт для связи" />
                        </label>
                        <g:textField name="client_contact" value="${consultationRecordInstance?.client_contact}"  pattern="[0-9]{7,10}"/>
                </gui:toolTip>
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'parentfio', 'error')} ">
                <label for="parentfio">
                    <g:message code="consultationRecord.parentfio.label" default="ФИО родителей" />

                </label>
                <g:textField name="parentfio" value="${consultationRecordInstance?.parentfio}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'isNaprav', 'error')} ">
                <gui:toolTip text="Срок действия 1 месяц">
                    <label for="isNaprav">
                        <g:message code="consultationRecord.isNaprav.label" default="Наличие направления" />
                    </label>
                    <g:checkBox name="isNaprav" value="${consultationRecordInstance?.isNaprav}" />
                </gui:toolTip>
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'isPechat', 'error')} ">
                <gui:toolTip text="На направлении должно быть 2 печати: печать для справок и печать ЛПУ ">
                        <label for="isPechat">
                            <g:message code="consultationRecord.isPechat.label" default="Наличие печатей на направлении" />
                        </label>
                        <g:checkBox name="isPechat" value="${consultationRecordInstance?.isPechat}" />
                </gui:toolTip>
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'isConfirm', 'error')} ">
                <gui:toolTip text="Если визит подтвержден, отметьте поле галочкой">
                        <label for="isConfirm">
                            <g:message code="consultationRecord.isConfirm.label" default="Контрольный обзвон" />
                        </label>
                        <g:checkBox name="isConfirm" value="${consultationRecordInstance?.isConfirm}" />
                </gui:toolTip>
            </div>

            <div class="fieldcontain ${hasErrors(bean: consultationRecordInstance, field: 'prim', 'error')} ">
                <gui:toolTip text="Результат обзвона">
                        <label for="prim">
                            <g:message code="consultationRecord.prim.label" default="Примечание" />

                        </label>
                        <g:textField name="prim" value="${consultationRecordInstance?.prim}"/>
                </gui:toolTip>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
        </fieldset>
    </g:form>
</div>
<div id="list-consultationRecord" class="content scaffold-list" role="main">
    <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="fio" title="${message(code: 'consultationRecord.fio.label', default: 'ФИО пациента')}" />
            <th><g:message code="consultationRecord.doctor.label" default="Врач" /></th>
            <g:sortableColumn property="birthday" title="${message(code: 'consultationRecord.birthday.label', default: 'Дата рождения')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${consultationRecordInstanceList}" status="i" var="consultationRecordInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link action="show" id="${consultationRecordInstance.id}">${fieldValue(bean: consultationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${consultationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate format="dd.MM.yyyy" date="${consultationRecordInstance?.birthday}" /></td>
                </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${consultationRecordInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>
