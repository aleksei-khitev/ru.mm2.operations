<!DOCTYPE html>
<%@ page import="ru.mm2.operations.GenOperationRecord" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'genOperationRecord.label', default: 'GenOperationRecord')}" />
    <title><g:message code="default.createrecod.label" args="[entityName]" /></title>
    <script>
        function hide_show_patology(){
            if(isPatology.checked==true) {
                patology.style.visibility= 'visible';
            }
            else {
                patology.style.visibility= 'hidden';
            }
        }
        function hide_show_disp(){
            if(isDisp.checked==true) {
                disp.style.visibility= 'visible';
            }
            else {
                disp.style.visibility= 'hidden';
            }
        }

    </script>
    <script>
        window.onload = function(){
            document.getElementById('tab_1').checked = true;
        }
    </script>
</head>
<body>
<a href="#create-genOperationRecord" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation" style="background-color: #DDA0DD">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}" style="color: black"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index" style="color: black"><g:message code="default.listrecodheader.label" args="[entityName]" /></g:link></li>
        <h3 style="text-align: center" style="color: black">Запись на госпитализацию</h3>
    </ul>
</div>
<div id="create-genOperationRecord" class="content scaffold-create" role="main">
    <h1><g:message code="default.createrecod.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${genOperationRecordInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${genOperationRecordInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form url="[resource:genOperationRecordInstance, action:'save']" >
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
        </fieldset>
    </g:form>
</div>
<g:render template="list-for-day"/>
</body>
</html>
