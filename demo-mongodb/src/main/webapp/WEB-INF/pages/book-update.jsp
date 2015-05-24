<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Insert title here</title>
</head>
<body>
    <h1>Book Store - Update Existing Book</h1>
    <form:form commandName="book"  action="updateBook.do"  method="post">
        <form:hidden path="id"/>
        <div>
            <label>Name</label>
            <form:input path="name" />
        </div>
         <div>
            <label>Author</label>
            <form:input path="author" />
        </div>
         <div>
            <label>Price</label>
            <form:input path="price" />
        </div>
         <div>
            <label>Tags (separated by commas)</label>
            <form:input path="tags" />
        </div>
        <button type="submit">Add</button>
    </form:form>
</body>
</html>