<div id="list-operationRecord" class="content scaffold-list" role="main">
    <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="fio" title="${message(code: 'operationRecord.fio.label', default: 'ФИО пациента')}" />
            <g:sortableColumn property="fio" title="${message(code: 'operationRecord.operation.label', default: 'Операция')}" />
            <th><g:message code="operationRecord.doctor.label" default="Врач" /></th>
            <g:sortableColumn property="birthday" title="${message(code: 'operationRecord.birthday.label', default: 'Дата рождения')}" />
            <g:sortableColumn property="diagnoz" title="${message(code: 'operationRecord.isConfirm.label', default: 'Обзвон')}" />
            <g:sortableColumn property="prim" title="${message(code: 'operationRecord.prim.label', default: 'Примечание')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${operationRecordInstanceList}" status="i" var="operationRecordInstance">
            <g:if test="${operationRecordInstance?.isConfirm}">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}"  style="background-color:#32CD32">
                    <td><g:link action="show" id="${operationRecordInstance.id}">${fieldValue(bean: operationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${operationRecordInstance?.operation?.name }"</td>
                    <td>"${operationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${operationRecordInstance?.birthday}" /></td>
                    <td><g:checkBox name="isConfirm " value="${operationRecordInstance?.isConfirm }" /></td>
                    <td>"${operationRecordInstance?.prim }"</td>
                </tr>
            </g:if>
            <g:else>
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link action="show" id="${operationRecordInstance.id}">${fieldValue(bean: operationRecordInstance, field: "fio")}</g:link></td>
                    <td>"${operationRecordInstance?.operation?.name }"</td>
                    <td>"${operationRecordInstance?.doctor?.fio }"</td>
                    <td><g:formatDate date="${operationRecordInstance?.birthday}" /></td>
                    <td><g:checkBox name="isConfirm " value="${operationRecordInstance?.isConfirm }" /></td>
                    <td>"${operationRecordInstance?.prim }"</td>
                </tr>
            </g:else>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${operationRecordInstanceCount ?: 0}" />
    </div>
</div>