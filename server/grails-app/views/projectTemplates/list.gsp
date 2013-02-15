
<%@ page import="com.getghoti.ProjectTemplates" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'projectTemplates.label', default: 'ProjectTemplates')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-projectTemplates" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-projectTemplates" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'projectTemplates.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'projectTemplates.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="url" title="${message(code: 'projectTemplates.url.label', default: 'Url')}" />
					
						<g:sortableColumn property="approved" title="${message(code: 'projectTemplates.approved.label', default: 'Approved')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'projectTemplates.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'projectTemplates.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${projectTemplatesInstanceList}" status="i" var="projectTemplatesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${projectTemplatesInstance.id}">${fieldValue(bean: projectTemplatesInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: projectTemplatesInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: projectTemplatesInstance, field: "url")}</td>
					
						<td><g:formatBoolean boolean="${projectTemplatesInstance.approved}" /></td>
					
						<td><g:formatDate date="${projectTemplatesInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${projectTemplatesInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${projectTemplatesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
