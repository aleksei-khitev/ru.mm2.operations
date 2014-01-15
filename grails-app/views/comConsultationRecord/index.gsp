<%@ page import="ru.mm2.operations.ComConsultationRecord" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'comConsultationRecord.label', default: 'ComConsultationRecord')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <script>
        window.onload = function(){
            document.getElementById('tab_2').checked = true;
        }
    </script>
</head>
<body>
<a href="#list-comConsultationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: lightgreen">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <h3 style="text-align: center">Запись на консультацию</h3>
    </ul>
</div>
<div style="width: 950px; height: 300px; overflow-y: scroll;">
    <table>
        <thead>
        <tr>
            <g:each var="i" in="${ (0..<120) }">
                <g:workOrSunday date="${new Date()+i}"/>
            </g:each>
        </tr>
        </thead>
        <tbody>
        <tr>
            <g:each var="i" in="${ (0..<120) }">
                <td>
                    <g:lessTreeYearsImages domain="ComConsultationRecord" date="${new Date()+i}"/>
                    <g:notLessImages domain="ComConsultationRecord" date="${new Date()+i}"/>
                </td>
            </g:each>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>