
<%@ page import="ru.mm2.operations.ComResearchRecord" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'comResearchRecord.label', default: 'ComResearchRecord')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <script>
            window.onload = function(){
                document.getElementById('tab_2').checked = true;
            }
        </script>
    </head>
	<body>
		<a href="#list-comResearchRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation" style="background-color: springgreen">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
                <h3 style="text-align: center" style="color: black">Запись на исследования</h3>
			</ul>
		</div>
    <div style="width: 950px; height: 300px; overflow-y: scroll;">
        <table>
            <thead>
            <tr>
                <g:each var="i" in="${ (0..<120) }">
                    <g:workOrWeekend date="${new Date()-120+i}"/>
                </g:each>
                <g:each var="i" in="${ (0..<120) }">

                    <g:if test="${i==0}">
                        <g:workOrSunday date="${new Date()+i}" tabindex="1"/>
                    </g:if>
                    <g:else>
                        <g:workOrSunday date="${new Date()+i}"/>
                    </g:else>

                </g:each>
            </tr>
            </thead>
            <tbody>
            <tr>
                <g:each var="i" in="${ (0..<120) }">
                    <td>
                        <g:allImages domain="ComResearchRecord" date="${new Date()-120+i}"/>
                    </td>
                </g:each>
                <g:each var="i" in="${ (0..<120) }">
                    <td>
                        <g:allImages domain="ComResearchRecord" date="${new Date()+i}"/>
                    </td>
                </g:each>
            </tr>
            </tbody>
        </table>
        <script>
            document.getElementById('dest').focus();
        </script>
    </div>
	</body>
</html>
