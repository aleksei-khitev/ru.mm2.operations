<%@ page import="ru.mm2.operations.Doctor" %>
<gui:resources components="['toolTip']"/>

<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'fio', 'error')} ">
	<label for="fio">
		<g:message code="doctor.fio.label" default="ФИО" />

	</label>
	<g:textField name="fio" value="${doctorInstance?.fio}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'rang', 'error')} ">
    <label for="rang">
        <g:message code="doctor.rang.label" default="Должность" />

    </label>
    <g:textField name="rang" value="${doctorInstance?.rang}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'email', 'error')} ">
    <label for="email">
        <g:message code="doctor.email.label" default="Электронная почта" />

    </label>
    <g:textField name="email" value="${doctorInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'localphone', 'error')} ">
    <gui:toolTip text="This text shows in a tool tip.">
        <label for="localphone">
            <g:message code="doctor.localphone.label" default="Местный телефон" />

        </label>
    </gui:toolTip>
    <g:textField name="localphone" value="${doctorInstance?.localphone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'workphone', 'error')} ">
    <label for="workphone">
        <g:message code="doctor.workphone.label" default="Рабочий телефон" />

    </label>
    <g:textField name="workphone" value="${doctorInstance?.workphone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'prim', 'error')} ">
	<label for="prim">
		<g:message code="doctor.prim.label" default="Примечание" />

	</label>
	<g:textField name="prim" value="${doctorInstance?.prim}"/>
</div>



