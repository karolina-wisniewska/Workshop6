<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit book</title>
</head>
<body>

<h3>Edit book</h3>

<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <div>Title: <form:input path="title"/></div>
    <div>Author: <form:input path="author"/></div>
    <div>Isbn: <form:input path="isbn"/></div>
    <div>Publisher: <form:input path="publisher"/></div>
    <div>Type: <form:input path="type"/></div>
    <input type="submit" value="Edit book">
</form:form>

</body>
</html>
