<%@ page import="ru.mm2.operations.Research" %>



<div class="fieldcontain ${hasErrors(bean: researchInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="research.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${researchInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: researchInstance, field: 'price', 'error')} required">
    <label for="price">
        <g:message code="research.price.label" default="Цена" />
    </label>
    <g:textField name="price" required="" value="${researchInstance?.price}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: researchInstance, field: 'updatedUser', 'error')} ">
    <g:hiddenField name="updatedUser" value="${sec.loggedInUserInfo(field:"username")}"/>
</div>
