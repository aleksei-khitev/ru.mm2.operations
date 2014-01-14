
<%@ page import="ru.mm2.operations.Doctor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'doctor.label', default: 'Doctor')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_3').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#list-doctor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: sandybrown">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create" style="color: black"><g:message code="default.newdoctor.label" args='Ad' /></g:link></li>
			</ul>
		</div>
		<div id="list-doctor" class="content scaffold-list" role="main">
			<h1><g:message code="default.listdoctor.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="fio" title="${message(code: 'doctor.fio.label', default: 'ФИО')}" />
                        <g:sortableColumn property="rang" title="${message(code: 'doctor.rang.label', default: 'Должность')}" />
                        <g:sortableColumn property="rang" title="${message(code: 'doctor.email.label', default: 'Почта')}" />
						<g:sortableColumn property="prim" title="${message(code: 'doctor.prim.label', default: 'Примечание')}" />
					

					
					</tr>
				</thead>
				<tbody>
				<g:each in="${doctorInstanceList}" status="i" var="doctorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${doctorInstance.id}">${fieldValue(bean: doctorInstance, field: "fio")}</g:link></td>
                        <td>${fieldValue(bean: doctorInstance, field: "rang")}</td>
                        <td>${fieldValue(bean: doctorInstance, field: "email")}</td>
						<td>${fieldValue(bean: doctorInstance, field: "prim")}</td>
					

					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${doctorInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
