<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/demo-mongodb/css/style.css" />
    <title>Book Store - Detail</title>
</head>
<body>
    <input id="book_id" type="hidden" value="${book.id}"/>
    <h1>Book Store - Detail</h1>
    <h3>${book.name}</h3>
    <p>Author: ${book.author}</p>
    <p>Price: <fmt:formatNumber value="${book.price}" type="currency"/></p>
    <div>Tags:
        <ul>
            <c:forEach var="tag" items="${book.tags}">
                <li>"${tag}"</li>
            </c:forEach>
        </ul>
    </div>
    <div id="comment_container"></div>

    <script id="comment_template" type="text/template">
        <p><strong>Comment</strong></p>
        <textarea id="inputComment" rows="4" cols="50" placeholder="Enter your comment."></textarea>
        <div><button id="buttonComment">Submit</button></div>
        <div id="list_comment"></div>
    </script>

     <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
     <script src="/demo-mongodb/script/underscore-min.js"></script>
     <script src="/demo-mongodb/script/backbone-min.js"></script>
     <script src="/demo-mongodb/script/comment.js"></script>
     <script src="/demo-mongodb/script/app.js"></script>
</body>
</html>