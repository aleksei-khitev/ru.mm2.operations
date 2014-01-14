<%@ page import="ru.mm2.operations.Research" %>



<div class="fieldcontain ${hasErrors(bean: researchInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="research.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${researchInstance?.name}"/>
</div>

