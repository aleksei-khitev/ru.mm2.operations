
<%@ page import="ru.mm2.operations.OperationRecord" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'operationRecord.label', default: 'OperationRecord')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_1').checked = true;
            }
        </script>
	</head>
	<body>
		<a href="#list-operationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: #FA8072">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: white"><g:message code="default.home.label"/></a></li>
                <h3 style="color: white; text-align: center">Запись на госпитализацию</h3>
			</ul>
		</div>
    <div style="width: 950px; height: 300px; overflow-y: scroll;">
        <table>
            <thead>
            <tr>
                <g:each var="i" in="${ (0..<120) }">
                    <g:form>
                        <g:workOrSunday date="${new Date()+i}"/>
                    </g:form>
                </g:each>
            </tr>
            </thead>
            <tbody>
            <tr>
                <g:each var="i" in="${ (0..<120) }">
                    <td>
                        <g:patologyRecordImages domain="OperationRecord" date="${new Date()+i}"/>
                        <g:lessTreeYearsImages domain="OperationRecord" date="${new Date()+i}"/>
                        <g:notLessNotPatologyImages domain="OperationRecord" date="${new Date()+i}"/>
                    </td>
                </g:each>
            </tr>
            </tbody>
        </table>
    </div>

	</body>
</html>
