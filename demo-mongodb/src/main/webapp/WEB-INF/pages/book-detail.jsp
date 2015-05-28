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
    <div class="page">
        <div class="header">
            <h1>Book Store - Detail</h1>
        </div>
        <div class="content">
            <input id="book_id" type="hidden" value="${book.id}"/>
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
        </div>
        <div class="footer">
            This page is created by trieudoan
        </div>
    </div>

    <script id="comment_template" type="text/template">
        <p><strong>Comment</strong></p>
        <textarea id="inputComment" rows="4" cols="50" placeholder="Enter your comment."></textarea>
        <div><button id="btnComment" class="btn">Submit</button></div>
        <div id="list_comment"></div>
        <div><button id="btnLoadMore" class="btn">More comments</button></div>
    </script>

     <script data-main="/demo-mongodb/script/comment" src="/demo-mongodb/script/lib/require.js"></script>
</body>
</html>