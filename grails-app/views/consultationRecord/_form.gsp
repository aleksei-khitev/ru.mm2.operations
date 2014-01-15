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
    <g:if test="${date}">
        <g:datePicker name="date_time" precision="day"  value="${date}"  />
    </g:if>
    <g:else>
        <g:datePicker name="date_time" precision="day"  value="${consultationRecordInstance?.date_time}"  />
    </g:else>
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
        <g:phoneWithPattern name="client_contact" value="${consultationRecordInstance?.client_contact}"/>
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
