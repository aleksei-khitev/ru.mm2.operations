<%@ page import="ru.mm2.operations.OperationRecord" %>
<script>
    function hide_show_patology(){
        if(isPatology.checked==true) {
            patology.style.visibility= 'visible';
        }
        else {
            patology.style.visibility= 'hidden';
        }
    }
    function hide_show_disp(){
        if(isDisp.checked==true) {
            disp.style.visibility= 'visible';
        }
        else {
            disp.style.visibility= 'hidden';
        }
    }
</script>
<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'fio', 'error')} ">
    <label for="fio">
        <g:message code="operationRecord.fio.label" default="ФИО пациента" />

    </label>
    <g:if test="${fio}!=''">
        <g:textField name="fio" value="${fio}"/>
    </g:if>
    <g:else>
        <g:textField name="fio" value="${operationRecordInstance?.fio}"/>
    </g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'birthday', 'error')} required">
    <label for="birthday">
        <g:message code="operationRecord.birthday.label" default="Дата рождения пациента" />
        <span class="required-indicator">*</span>
    </label>

    <g:datePicker name="birthday" precision="day"  value="${birthday}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'diagnoz', 'error')} ">
    <label for="diagnoz">
        <g:message code="operationRecord.diagnoz.label" default="Диагноз" />

    </label>

    <g:if test="${diagnoz}!=''">
        <g:textField name="diagnoz" value="${diagnoz}"/>
    </g:if>
    <g:else>
        <g:textField name="diagnoz" value="${operationRecordInstance?.diagnoz}"/>
    </g:else>

</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'isPatology', 'error')} ">
    <gui:toolTip text="Страдает ли ребёнок какими-то хроническими заболевами?">
        <label for="isPatology">
            <g:message code="operationRecord.isPatology.label" default="Хроническая патология" />

        </label>
        <g:checkBox name="isPatology" value="${operationRecordInstance?.isPatology}" onclick="hide_show_patology()"/>
        <g:textField name="patology" value="${operationRecordInstance?.patology}" style="visibility: hidden"/>
    </gui:toolTip>
</div>


<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'isDisp', 'error')} ">
    <gui:toolTip text="Состоит ли ребёнок на учёте у какого-нибудь специалиста?">
        <label for="isDisp">
            <g:message code="operationRecord.isDisp.label" default="Диспансерное наблюдение" />
        </label>
        <g:checkBox name="isDisp" value="${operationRecordInstance?.isDisp}" onclick="hide_show_disp()"/>
        <g:textField name="disp" value="${operationRecordInstance?.disp}" style="visibility: hidden"/>
    </gui:toolTip>
</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'lastill', 'error')} ">
    <label for="lastill">
        <g:message code="operationRecord.lastill.label" default="Последнее простудное заболевание" />

    </label>
    <g:textField name="lastill" value="${operationRecordInstance?.lastill}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'parentfio', 'error')} ">
    <label for="parentfio">
        <g:message code="operationRecord.parentfio.label" default="ФИО родителей" />

    </label>
    <g:textField name="parentfio" value="${operationRecordInstance?.parentfio}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'client_contact', 'error')} ">
    <gui:toolTip text="7 цифр - городской телефон; 10 цифр - мобильный телефон">
        <label for="client_contact">
            <g:message code="operationRecord.client_contact.label" default="Контакт для связи" />

        </label>
        <g:if test="${client_contact}!=''">
            <g:textField name="client_contact" value="${client_contact}"  pattern="[0-9]{7,10}"/>
        </g:if>
        <g:else>
            <g:textField name="client_contact" value="${operationRecordInstance?.client_contact}"  pattern="[0-9]{7,10}"/>
        </g:else>
    </gui:toolTip>

</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'oms', 'error')} ">
    <label for="oms">
        <g:message code="operationRecord.oms.label" default="Полис ОМС" />

    </label>
    <g:if test="${oms}!=''">
        <g:textField name="oms" value="${oms}"/>
    </g:if>
    <g:else>
        <g:textField name="oms" value="${operationRecordInstance?.oms}"/>
    </g:else>

</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'operation', 'error')} required">
    <label for="operation">
        <g:message code="operationRecord.operation.label" default="Операция" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="operation" name="operation.id" from="${ru.mm2.operations.Operations.list()}" optionKey="id" required="" value="${operationRecordInstance?.operation?.id}" optionValue="name" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'doctor', 'error')} required">
    <label for="doctor">
        <g:message code="operationRecord.doctor.label" default="Врач" />
        <span class="required-indicator">*</span>
    </label>

    <g:if test="${doctor_id}!=''">
        <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${doctor_id}" class="many-to-one"/>
    </g:if>
    <g:else>
        <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${operationRecordInstance?.doctor?.id}" class="many-to-one"/>
    </g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'date_time', 'error')} required">
    <label for="date_time">
        <g:message code="operationRecord.date_time.label" default="Дата госпитализации" />
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="date_time" precision="day"  value="${date}"  />
</div>
<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'isConfirm', 'error')} ">
    <gui:toolTip text="Если визит подтвержден, отметьте поле галочкой">
        <label for="isConfirm">
            <g:message code="operationRecord.isConfirm.label" default="Контрольный обзвон" />
        </label>
        <g:checkBox name="isConfirm" value="${operationRecordInstance?.isConfirm}" />
    </gui:toolTip>
</div>
<div class="fieldcontain ${hasErrors(bean: operationRecordInstance, field: 'prim', 'error')} ">
    <label for="prim">
        <g:message code="operationRecord.prim.label" default="Примечание" />

    </label>
    <g:textField name="prim" value="${operationRecordInstance?.prim}"/>
</div>

