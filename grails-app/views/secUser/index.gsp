
<%@ page import="ru.mm2.operations.SecUser" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'secUser.label', default: 'SecUser')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_4').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#list-secUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: darkred">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: white"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create" style="color: white"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-secUser" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'secUser.username.label', default: 'Username')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${secUserInstanceList}" status="i" var="secUserInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${secUserInstance.id}" style="font-size: 30px">${fieldValue(bean: secUserInstance, field: "fullName")}</g:link><br>
                        Имя для входа в систему: <b style="color: purple">${secUserInstance.username}</b><br>
                        <g:if test="${secUserInstance.accountExpired}">
                            Срок действия аккаунта <b style="color: darkred">истек</b>
                        </g:if>
                        <g:if test="${secUserInstance.passwordExpired}">
                            Срок действия пароля <b style="color: darkred">истек</b>
                        </g:if>
                        <g:if test="${secUserInstance.accountLocked}">
                            Аккаунт <b style="color: darkred">заблокирован</b>
                        </g:if>
                        <g:if test="${secUserInstance.passwordExpired}">
                            Пароль <b style="color: darkred">истек</b>
                        </g:if>
                        <g:if test="${secUserInstance.enabled}">
                            Аккаунт <b style="color: darkgreen">активен</b>
                        </g:if>
                        <g:else>
                            Аккаунт <b style="color: darkred">дизактиван</b>
                        </g:else>
                        <br/>Член групп:<br/>
                        <g:each in="${secUserInstance.getAuthorities()}">
                              <b>${it.authority}</b><br/>
                        </g:each>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${secUserInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
