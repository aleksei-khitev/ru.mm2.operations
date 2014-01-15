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
