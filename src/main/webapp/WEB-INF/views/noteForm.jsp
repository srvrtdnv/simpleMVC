<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new note</title>
</head>
<body>
	<form:form method="post" modelAttribute="note" action="/simpleMVC/list">
	  <form:hidden value="${note.id}" path="id"/>
	  <form:input value="${note.note}" path="note"/>
	  <input type="submit" value="Confirm" onClick='location.href="/simpleMVC/list"'/>
	</form:form>
</body>
</html>