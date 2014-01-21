<%@ page import="ru.mm2.operations.GenOperationRecord" %>
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

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'fio', 'error')} ">
    <label for="fio">
        <g:message code="genOperationRecord.fio.label" default="ФИО пациента" />

    </label>
    <g:if test="${fio}">
        <g:textField name="fio" value="${fio}"/>
    </g:if>
    <g:else>
        <g:textField name="fio" value="${genOperationRecordInstance?.fio}"/>
    </g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'birthday', 'error')} required">
    <label for="birthday">
        <g:message code="genOperationRecord.birthday.label" default="Дата рождения пациента" />
        <span class="required-indicator">*</span>
    </label>

    <g:datePicker name="birthday" precision="day"  value="${birthday}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'diagnoz', 'error')} ">
    <label for="diagnoz">
        <g:message code="genOperationRecord.diagnoz.label" default="Диагноз" />

    </label>

    <g:if test="${diagnoz}">
        <g:textField name="diagnoz" value="${diagnoz}"/>
    </g:if>
    <g:else>
        <g:textField name="diagnoz" value="${genOperationRecordInstance?.diagnoz}"/>
    </g:else>

</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'isPatology', 'error')} ">
    <gui:toolTip text="Страдает ли ребёнок какими-то хроническими заболевами?">
        <label for="isPatology">
            <g:message code="genOperationRecord.isPatology.label" default="Хроническая патология" />

        </label>
        <g:checkBox name="isPatology" value="${genOperationRecordInstance?.isPatology}" onclick="hide_show_patology()"/>
        <g:textField name="patology" value="${genOperationRecordInstance?.patology}" style="visibility: hidden"/>
    </gui:toolTip>
</div>


<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'isDisp', 'error')} ">
    <gui:toolTip text="Состоит ли ребёнок на учёте у какого-нибудь специалиста?">
        <label for="isDisp">
            <g:message code="genOperationRecord.isDisp.label" default="Диспансерное наблюдение" />
        </label>
        <g:checkBox name="isDisp" value="${genOperationRecordInstance?.isDisp}" onclick="hide_show_disp()"/>
        <g:textField name="disp" value="${genOperationRecordInstance?.disp}" style="visibility: hidden"/>
    </gui:toolTip>
</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'lastill', 'error')} ">
    <label for="lastill">
        <g:message code="genOperationRecord.lastill.label" default="Последнее простудное заболевание" />

    </label>
    <g:textField name="lastill" value="${genOperationRecordInstance?.lastill}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'parentfio', 'error')} ">
    <label for="parentfio">
        <g:message code="genOperationRecord.parentfio.label" default="ФИО родителей" />

    </label>
    <g:if test="${parentfio}">
        <g:textField name="parentfio" value="${parentfio}"/>
    </g:if>
    <g:else>
        <g:textField name="parentfio" value="${genOperationRecordInstance?.parentfio}"/>
    </g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'client_contact', 'error')} ">
    <gui:toolTip text="7 цифр - городской телефон; 10 цифр - мобильный телефон">
        <label for="client_contact">
            <g:message code="genOperationRecord.client_contact.label" default="Контакт для связи" />

        </label>
        <g:if test="${client_contact}">
            <g:phoneWithPattern name="client_contact" value="${client_contact}"/>
        </g:if>
        <g:else>
            <g:phoneWithPattern name="client_contact" value="${genOperationRecordInstance?.client_contact}"/>
        </g:else>
    </gui:toolTip>

</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'oms', 'error')} ">
    <label for="oms">
        <g:message code="genOperationRecord.oms.label" default="Полис ОМС" />

    </label>
    <g:if test="${oms}">
        <g:textField name="oms" value="${oms}"/>
    </g:if>
    <g:else>
        <g:textField name="oms" value="${genOperationRecordInstance?.oms}"/>
    </g:else>

</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'operation', 'error')} required">
    <label for="operation">
        <g:message code="genOperationRecord.operation.label" default="Операция" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="operation" noSelection="['':'Выберите операцию']" name="operation.id" from="${ru.mm2.operations.Operations.list()}" optionKey="id" required="" value="${genOperationRecordInstance?.operation?.id}" optionValue="name" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'doctor', 'error')} required">
    <label for="doctor">
        <g:message code="genOperationRecord.doctor.label" default="Врач" />
        <span class="required-indicator">*</span>
    </label>

    <g:if test="${doctor_id}">
        <g:select id="doctor" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${doctor_id}" class="many-to-one"/>
    </g:if>
    <g:else>
        <g:select id="doctor" noSelection="['':'Выберите врача']" name="doctor.id" from="${ru.mm2.operations.Doctor.list()}" optionKey="id" required="" optionValue="fio" value="${genOperationRecordInstance?.doctor?.id}" class="many-to-one"/>
    </g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'date_time', 'error')} required">
    <label for="date_time">
        <g:message code="genOperationRecord.date_time.label" default="Дата госпитализации" />
        <span class="required-indicator">*</span>
    </label>
    <g:if test="${date}">
        <g:datePicker name="date_time" precision="day"  value="${date}"  />
    </g:if>
    <g:else>
        <g:datePicker name="date_time" precision="day"  value="${genOperationRecordInstance?.date_time}"  />
    </g:else>
</div>
<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'isConfirm', 'error')} ">
    <gui:toolTip text="Если визит подтвержден, отметьте поле галочкой">
        <label for="isConfirm">
            <g:message code="genOperationRecord.isConfirm.label" default="Контрольный обзвон" />
        </label>
        <g:checkBox name="isConfirm" value="${genOperationRecordInstance?.isConfirm}" />
    </gui:toolTip>
</div>
<div class="fieldcontain ${hasErrors(bean: genOperationRecordInstance, field: 'prim', 'error')} ">
    <label for="prim">
        <g:message code="genOperationRecord.prim.label" default="Примечание" />

    </label>
    <g:textField name="prim" value="${genOperationRecordInstance?.prim}"/>
</div>