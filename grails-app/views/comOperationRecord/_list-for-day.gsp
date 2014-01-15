<div id="list-comOperationRecord" class="content scaffold-list" role="main">
    <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="fio" title="${message(code: 'comOperationRecord.fio.label', default: 'ФИО пациента')}" />
            <g:sortableColumn property="fio" title="${message(code: 'comOperationRecord.operation.label', default: 'Операция')}" />
            <th><g:message code="comOperationRecord.doctor.label" default="Врач" /></th>
            <g:sortableColumn property="birthday" title="${message(code: 'comOperationRecord.birthday.label', default: 'Дата рождения')}" />
            <g:sortableColumn property="diagnoz" title="${message(code: 'comOperationRecord.isConfirm.label', default: 'Обзвон')}" />
            <g:sortableColumn property="prim" title="${message(code: 'comOperationRecord.prim.label', default: 'Примечание')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${comOperationRecordInstanceList}" status="i" var="comOperationRecordInstance">
            <g:if test="${comOperationRecordInstance?.isConfirm}">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}"  style="background-color:#32CD32">
                    <td><g:link action="show" id="${comOperationRecordInstance.id}">${fieldValue(bean: comOperationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${comOperationRecordInstance?.operation?.name }"</td>
                    <td>"${comOperationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${comOperationRecordInstance?.birthday}" /></td>
                    <td><g:checkBox name="isConfirm " value="${comOperationRecordInstance?.isConfirm }" /></td>
                    <td>"${comOperationRecordInstance?.prim }"</td>
                </tr>
            </g:if>
            <g:else>
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link action="show" id="${comOperationRecordInstance.id}">${fieldValue(bean: comOperationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${comOperationRecordInstance?.operation?.name }"</td>
                    <td>"${comOperationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${comOperationRecordInstance?.birthday}" /></td>
                    <td><g:checkBox name="isConfirm " value="${comOperationRecordInstance?.isConfirm }" /></td>
                    <td>"${comOperationRecordInstance?.prim }"</td>
                </tr>
            </g:else>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${comOperationRecordInstanceCount ?: 0}" />
    </div>
</div>