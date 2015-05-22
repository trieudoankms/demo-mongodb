<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/css/style.css">
<title>Insert title here</title>
</head>
<body>
<h1>Book Store</h1>
<table>
  <tr>
    <th>Name</th>
    <th>Author</th>
    <th>Price</th>
    <th>Tags</th>
  </tr>
  <c:forEach var="book" items="${books}">
  <tr>
    <td>${book.name}</td>
    <td>${book.author}</td>
    <td>${book.price}</td>
  </tr>
  </c:forEach>
</table>
</body>
</html>