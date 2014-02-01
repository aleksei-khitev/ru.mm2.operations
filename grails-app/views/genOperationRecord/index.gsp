
<%@ page import="ru.mm2.operations.GenOperationRecord" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'genOperationRecord.label', default: 'GenOperationRecord')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_1').checked = true;
        }
    </script>
</head>
<body>
<a href="#list-genOperationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: #DDA0DD">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <h3 style="text-align: center" style="color: black">Запись на госпитализацию</h3>
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
                    <g:patologyRecordImages domain="GenOperationRecord" date="${new Date()-120+i}"/>
                    <g:lessTreeYearsImages domain="GenOperationRecord" date="${new Date()-120+i}"/>
                    <g:notLessNotPatologyImages domain="GenOperationRecord" date="${new Date()-120+i}"/>
                </td>
            </g:each>
            <g:each var="i" in="${ (0..<120) }">
                <td>
                    <g:patologyRecordImages domain="GenOperationRecord" date="${new Date()+i}"/>
                    <g:lessTreeYearsImages domain="GenOperationRecord" date="${new Date()+i}"/>
                    <g:notLessNotPatologyImages domain="GenOperationRecord" date="${new Date()+i}"/>
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
