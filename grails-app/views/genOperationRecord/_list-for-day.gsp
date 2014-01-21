<div id="list-genOperationRecord" class="content scaffold-list" role="main">
    <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="fio" title="${message(code: 'genOperationRecord.fio.label', default: 'ФИО пациента')}" />
            <g:sortableColumn property="fio" title="${message(code: 'genOperationRecord.operation.label', default: 'Операция')}" />
            <th><g:message code="genOperationRecord.doctor.label" default="Врач" /></th>
            <g:sortableColumn property="birthday" title="${message(code: 'genOperationRecord.birthday.label', default: 'Дата рождения')}" />
            <g:sortableColumn property="diagnoz" title="${message(code: 'genOperationRecord.isConfirm.label', default: 'Обзвон')}" />
            <g:sortableColumn property="prim" title="${message(code: 'genOperationRecord.prim.label', default: 'Примечание')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${genOperationRecordInstanceList}" status="i" var="genOperationRecordInstance">
            <g:if test="${genOperationRecordInstance?.isConfirm}">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}"  style="background-color:#32CD32">
                    <td><g:link action="show" id="${genOperationRecordInstance.id}">${fieldValue(bean: genOperationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${genOperationRecordInstance?.operation?.name }"</td>
                    <td>"${genOperationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${genOperationRecordInstance?.birthday}" /></td>
                    <td><g:checkBox name="isConfirm " value="${genOperationRecordInstance?.isConfirm }" /></td>
                    <td>"${genOperationRecordInstance?.prim }"</td>
                </tr>
            </g:if>
            <g:else>
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link action="show" id="${genOperationRecordInstance.id}">${fieldValue(bean: genOperationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${genOperationRecordInstance?.operation?.name }"</td>
                    <td>"${genOperationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${genOperationRecordInstance?.birthday}" /></td>
                    <td><g:checkBox name="isConfirm " value="${genOperationRecordInstance?.isConfirm }" /></td>
                    <td>"${genOperationRecordInstance?.prim }"</td>
                </tr>
            </g:else>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${genOperationRecordInstanceCount ?: 0}" />
    </div>
</div>