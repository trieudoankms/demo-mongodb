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
<script src="script/app.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>Book Store</h1>
<a href="./books/add-new.do">Add New Book</a>
<hr/>
<table id="table01">
  <tr>
    <th>Name</th>
    <th>Author</th>
    <th>Price</th>
    <th>Tags</th>
    <th></th>
  </tr>
  <c:forEach var="book" items="${books}">
  <tr>
    <td>${book.name}</td>
    <td>${book.author}</td>
    <td><fmt:formatNumber value="${book.price}" type="currency"></fmt:formatNumber></td>
    <td>
        <ul>
            <c:forEach var="tag" items="${book.tags}">
                <li>"${tag}"</li>
            </c:forEach>
        </ul>
    </td>
    <td>
        <a href="./books/update.do?id=${book.id}">Update</a>
        <form action="./books/deleteBook.do"  method="post">
            <input type="hidden" name="id" value="${book.id}"/>
            <a href="#" onclick="deleteBook(this)">Delete</a>
        </form>

    </td>
  </tr>
  </c:forEach>
</table>
</body>
</html>