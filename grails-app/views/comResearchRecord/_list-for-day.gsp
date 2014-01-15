<div id="list-comResearchRecord" class="content scaffold-list" role="main">
    <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="fio" title="${message(code: 'comResearchRecord.fio.label', default: 'ФИО пациента')}" />
            <g:sortableColumn property="fio" title="${message(code: 'comResearchRecord.research.label', default: 'Операция')}" />
            <g:sortableColumn property="birthday" title="${message(code: 'comResearchRecord.birthday.label', default: 'Дата рождения')}" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${comResearchRecordInstanceList}" status="i" var="comResearchRecordInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td><g:link action="show" id="${comResearchRecordInstance.id}">${fieldValue(bean: comResearchRecordInstance, field: "fio")}</g:link></td>
                <td>"${comResearchRecordInstance?.research?.nameAndString }"</td>
                <td><g:formatDate date="${comResearchRecordInstance?.birthday}" /></td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${comResearchRecordInstanceCount ?: 0}" />
    </div>
</div>