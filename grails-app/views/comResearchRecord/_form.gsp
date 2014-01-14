<%@ page import="ru.mm2.operations.ComResearchRecord" %>

<div class="fieldcontain ${hasErrors(bean: comResearchRecordInstance, field: 'fio', 'error')} required">
    <label for="fio">
        <g:message code="comResearchRecord.fio.label" default="ФИО пациента" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="fio" required="" value="${comResearchRecordInstance?.fio}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comResearchRecordInstance, field: 'birthday', 'error')} required">
	<label for="birthday">
		<g:message code="comResearchRecord.birthday.label" default="Дата рождения" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthday" precision="day"  value="${comResearchRecordInstance?.birthday}"  />
</div>


<div class="fieldcontain ${hasErrors(bean: comResearchRecordInstance, field: 'date_time', 'error')} required">
	<label for="date_time">
		<g:message code="comResearchRecord.date_time.label" default="Дата исследования" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date_time" precision="day"  value="${comResearchRecordInstance?.date_time}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: comResearchRecordInstance, field: 'research', 'error')} required">
	<label for="research">
		<g:message code="comResearchRecord.research.label" default="Исследование" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="research" name="research.id" from="${ru.mm2.operations.Research.list(sort:"name")}" optionKey="id" required="" optionValue="nameAndString" value="${comResearchRecordInstance?.research?.id}" class="many-to-one"/>
</div>

