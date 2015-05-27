<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/demo-mongodb/css/style.css" />
<title>Insert title here</title>
</head>
<body>
    <h1>Book Store - Update Existing Book</h1>
    <form:form commandName="book"  action="updateBook.do"  method="post">
        <form:hidden path="id"/>
        <div class="form-group">
            <div><label>Name</label></div>
            <div><form:input path="name" /></div>
        </div>
         <div class="form-group">
            <div><label>Author</label></div>
            <div><form:input path="author" /></div>
        </div>
         <div class="form-group">
            <div><label>Price</label></div>
            <div><form:input path="price" /></div>
        </div>
         <div class="form-group">
            <div><label>Tags (separated by commas)</label></div>
            <div><form:input path="tags" /></div>
        </div>
        <button type="submit" class="btn">Update</button>
    </form:form>
</body>
</html>