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
            <g:sortableColumn property="date_time" title="${message(code: 'comConsultationRecord.date_time.label', default: 'Время консультации')}" />
            <g:sortableColumn property="isConfirm" title="${message(code: 'comConsultationRecord.isConfirm.label', default: 'Обзвон')}" />
            <g:sortableColumn property="prim" title="${message(code: 'comConsultationRecord.prim.label', default: 'Комментарии')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${comConsultationRecordInstanceList}" status="i" var="comConsultationRecordInstance">
            <g:if test="${comConsultationRecordInstance?.isConfirm}">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}"  style="background-color:#32CD32">
                    <td><g:link action="show" id="${comConsultationRecordInstance.id}">${fieldValue(bean: comConsultationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${comConsultationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${comConsultationRecordInstance?.birthday}" /></td>
                    <td><g:formatDate formatName="onlytime.date.format" date="${comConsultationRecordInstance?.date_time}" /></td>
                    <td><g:checkBox name="isConfirm " value="${comConsultationRecordInstance?.isConfirm }" /></td>
                    <td>"${comConsultationRecordInstance?.prim }"</td>
                </tr>
            </g:if>
            <g:else>
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link action="show" id="${comConsultationRecordInstance.id}">${fieldValue(bean: comConsultationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${comConsultationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${comConsultationRecordInstance?.birthday}" /></td>
                    <td><g:formatDate formatName="onlytime.date.format" date="${comConsultationRecordInstance?.date_time}" /></td>
                    <td><g:checkBox name="isConfirm " value="${comConsultationRecordInstance?.isConfirm }" /></td>
                    <td>"${comConsultationRecordInstance?.prim }"</td>
                </tr>
            </g:else>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${comConsultationRecordInstanceCount ?: 0}" />
    </div>
</div>