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
            <g:sortableColumn property="date_time" title="${message(code: 'consultationRecord.date_time.label', default: 'Время консультации')}" />
            <g:sortableColumn property="isConfirm" title="${message(code: 'consultationRecord.isConfirm.label', default: 'Обзвон')}" />
            <g:sortableColumn property="prim" title="${message(code: 'consultationRecord.prim.label', default: 'Комментарии')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${consultationRecordInstanceList}" status="i" var="consultationRecordInstance">
            <g:if test="${consultationRecordInstance?.isConfirm}">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}"  style="background-color:#32CD32">
                    <td><g:link action="show" id="${consultationRecordInstance.id}">${fieldValue(bean: consultationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${consultationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${consultationRecordInstance?.birthday}" /></td>
                    <td><g:formatDate formatName="onlytime.date.format" date="${consultationRecordInstance?.date_time}" /></td>
                    <td><g:checkBox name="isConfirm " value="${consultationRecordInstance?.isConfirm }" /></td>
                    <td>"${consultationRecordInstance?.prim }"</td>
                </tr>
            </g:if>
            <g:else>
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link action="show" id="${consultationRecordInstance.id}">${fieldValue(bean: consultationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${consultationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${consultationRecordInstance?.birthday}" /></td>
                    <td><g:formatDate formatName="onlytime.date.format" date="${consultationRecordInstance?.date_time}" /></td>
                    <td><g:checkBox name="isConfirm " value="${consultationRecordInstance?.isConfirm }" /></td>
                    <td>"${consultationRecordInstance?.prim }"</td>
                </tr>
            </g:else>

        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${consultationRecordInstanceCount ?: 0}" />
    </div>
</div>