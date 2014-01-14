
<%@ page import="ru.mm2.operations.Research" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'research.label', default: 'Research')}" />
		<title><g:message code="default.listresearch.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_3').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#list-research" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: sandybrown">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create" style="color: black"><g:message code="default.newresearch.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-research" class="content scaffold-list" role="main">
			<h1><g:message code="default.listresearch.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'research.name.label', default: 'Название')}" />
                        <g:sortableColumn property="price" title="${message(code: 'research.price.label', default: 'Цена')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${researchInstanceList}" status="i" var="researchInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${researchInstance.id}">${fieldValue(bean: researchInstance, field: "name")}</g:link></td>
					    <td>${fieldValue(bean: researchInstance, field: "price")}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${researchInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
