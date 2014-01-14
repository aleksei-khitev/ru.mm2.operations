<%--
  Created by IntelliJ IDEA.
  User: akhitev
  Date: 18.12.13
  Time: 23:43
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'operationRecord.label', default: 'OperationRecord')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-operationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.newrecod.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="list-operationRecord" class="content scaffold-list" role="main">
    <h1><g:message code="default.listrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="birthday" title="${message(code: 'operationRecord.birthday.label', default: 'Birthday')}" />

            <g:sortableColumn property="client_contact" title="${message(code: 'operationRecord.client_contact.label', default: 'Clientcontact')}" />

            <g:sortableColumn property="date_time" title="${message(code: 'operationRecord.date_time.label', default: 'Datetime')}" />

            <g:sortableColumn property="diagnoz" title="${message(code: 'operationRecord.diagnoz.label', default: 'Diagnoz')}" />

            <th><g:message code="operationRecord.doctor.label" default="Doctor" /></th>

            <g:sortableColumn property="fio" title="${message(code: 'operationRecord.fio.label', default: 'Fio')}" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${operationRecordInstanceList}" status="i" var="operationRecordInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show" id="${operationRecordInstance.id}">${fieldValue(bean: operationRecordInstance, field: "birthday")}</g:link></td>

                <td>${fieldValue(bean: operationRecordInstance, field: "client_contact")}</td>

                <td><g:formatDate date="${operationRecordInstance.date_time}" /></td>

                <td>${fieldValue(bean: operationRecordInstance, field: "diagnoz")}</td>

                <td>${fieldValue(bean: operationRecordInstance, field: "doctor")}</td>

                <td>${fieldValue(bean: operationRecordInstance, field: "fio")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${operationRecordInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>