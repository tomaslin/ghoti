<%@ page import="com.getghoti.ProjectTemplates" %>



<div class="fieldcontain ${hasErrors(bean: projectTemplatesInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="projectTemplates.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${projectTemplatesInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectTemplatesInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="projectTemplates.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${projectTemplatesInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectTemplatesInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="projectTemplates.url.label" default="Url" />
		
	</label>
	<g:field type="url" name="url" value="${projectTemplatesInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectTemplatesInstance, field: 'approved', 'error')} ">
	<label for="approved">
		<g:message code="projectTemplates.approved.label" default="Approved" />
		
	</label>
	<g:checkBox name="approved" value="${projectTemplatesInstance?.approved}" />
</div>

