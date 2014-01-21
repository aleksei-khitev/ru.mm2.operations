<%@ page import="ru.mm2.operations.ComOperationRecord" %>
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

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'fio', 'error')} ">
    <label for="fio">
        <g:message code="comOperationRecord.fio.label" default="ФИО пациента" />

    </label>
    <g:if test="${fio}">
        <g:textField name="fio" value="${fio}"/>
    </g:if>
    <g:else>
        <g:textField name="fio" value="${comOperationRecordInstance?.fio}"/>
    </g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'birthday', 'error')} required">
    <label for="birthday">
        <g:message code="comOperationRecord.birthday.label" default="Дата рождения пациента" />
        <span class="required-indicator">*</span>
    </label>

    <g:datePicker name="birthday" precision="day"  value="${birthday}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'diagnoz', 'error')} ">
    <label for="diagnoz">
        <g:message code="comOperationRecord.diagnoz.label" default="Диагноз" />

    </label>

    <g:if test="${diagnoz}">
        <g:textField name="diagnoz" value="${diagnoz}"/>
    </g:if>
    <g:else>
        <g:textField name="diagnoz" value="${comOperationRecordInstance?.diagnoz}"/>
    </g:else>

</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'isPatology', 'error')} ">
    <gui:toolTip text="Страдает ли ребёнок какими-то хроническими заболевами?">
        <label for="isPatology">
            <g:message code="comOperationRecord.isPatology.label" default="Хроническая патология" />

        </label>
        <g:checkBox name="isPatology" value="${comOperationRecordInstance?.isPatology}" onclick="hide_show_patology()"/>
        <g:textField name="patology" value="${comOperationRecordInstance?.patology}" style="visibility: hidden"/>
    </gui:toolTip>
</div>


<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'isDisp', 'error')} ">
    <gui:toolTip text="Состоит ли ребёнок на учёте у какого-нибудь специалиста?">
        <label for="isDisp">
            <g:message code="comOperationRecord.isDisp.label" default="Диспансерное наблюдение" />
        </label>
        <g:checkBox name="isDisp" value="${comOperationRecordInstance?.isDisp}" onclick="hide_show_disp()"/>
        <g:textField name="disp" value="${comOperationRecordInstance?.disp}" style="visibility: hidden"/>
    </gui:toolTip>
</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'lastill', 'error')} ">
    <label for="lastill">
        <g:message code="comOperationRecord.lastill.label" default="Последнее простудное заболевание" />

    </label>
    <g:textField name="lastill" value="${comOperationRecordInstance?.lastill}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'parentfio', 'error')} ">
    <label for="parentfio">
        <g:message code="comOperationRecord.parentfio.label" default="ФИО родителей" />

    </label>
    <g:if test="${parentfio}">
        <g:textField name="parentfio" value="${parentfio}"/>
    </g:if>
    <g:else>
        <g:textField name="parentfio" value="${comOperationRecordInstance?.parentfio}"/>
    </g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'client_contact', 'error')} ">
    <gui:toolTip text="7 цифр - городской телефон; 10 цифр - мобильный телефон">
        <label for="client_contact">
            <g:message code="comOperationRecord.client_contact.label" default="Контакт для связи" />

        </label>
        <g:if test="${client_contact}">
            <g:phoneWithPattern name="client_contact" value="${client_contact}"/>
        </g:if>
        <g:else>
            <g:phoneWithPattern name="client_contact" value="${comOperationRecordInstance?.client_contact}"/>
        </g:else>
    </gui:toolTip>

</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'oms', 'error')} ">
    <label for="oms">
        <g:message code="comOperationRecord.oms.label" default="Полис ОМС" />

    </label>
    <g:if test="${oms}">
        <g:textField name="oms" value="${oms}"/>
    </g:if>
    <g:else>
        <g:textField name="oms" value="${comOperationRecordInstance?.oms}"/>
    </g:else>

</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'operation', 'error')} required">
    <label for="operation">
        <g:message code="comOperationRecord.operation.label" default="Операция" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="operation" noSelection="['':'Выберите операцию']" name="operation.id" from="${ru.mm2.operations.Operations.list()}" optionKey="id" required="" value="${comOperationRecordInstance?.operation?.id}" optionValue="name" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'doctor', 'error')} required">
    <label for="doctor">
        <g:message code="comOperationRecord.doctor.label" default="Врач" />
        <span class="required-indicator">*</span>
    </label>

    <g:if test="${doctor_id}">
        <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${doctor_id}" class="many-to-one"/>
    </g:if>
    <g:else>
        <g:select id="doctor" noSelection="['':'Выберите врача']" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${comOperationRecordInstance?.doctor?.id}" class="many-to-one"/>
    </g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'date_time', 'error')} required">
    <label for="date_time">
        <g:message code="comOperationRecord.date_time.label" default="Дата госпитализации" />
        <span class="required-indicator">*</span>
    </label>
    <g:if test="${date}">
        <g:datePicker name="date_time" precision="day"  value="${date}"  />
    </g:if>
    <g:else>
        <g:datePicker name="date_time" precision="day"  value="${comOperationRecordInstance?.date_time}"  />
    </g:else>
</div>
<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'isConfirm', 'error')} ">
    <gui:toolTip text="Если визит подтвержден, отметьте поле галочкой">
        <label for="isConfirm">
            <g:message code="comOperationRecord.isConfirm.label" default="Контрольный обзвон" />
        </label>
        <g:checkBox name="isConfirm" value="${comOperationRecordInstance?.isConfirm}" />
    </gui:toolTip>
</div>
<div class="fieldcontain ${hasErrors(bean: comOperationRecordInstance, field: 'prim', 'error')} ">
    <label for="prim">
        <g:message code="comOperationRecord.prim.label" default="Примечание" />

    </label>
    <g:textField name="prim" value="${comOperationRecordInstance?.prim}"/>
</div>