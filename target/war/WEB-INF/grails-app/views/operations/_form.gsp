<%@ page import="ru.mm2.operations.Operations" %>

<div class="fieldcontain ${hasErrors(bean: operationsInstance, field: 'name', 'error')} ">
    <label for="name">
        <g:message code="operations.name.label" default="Название" />

    </label>
    <g:textField name="name" value="${operationsInstance?.name}"/>
</div>




