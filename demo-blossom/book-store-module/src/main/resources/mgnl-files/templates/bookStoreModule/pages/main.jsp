<%--@elvariable id="content" type="info.magnolia.jcr.util.ContentMap"--%>
<%--@elvariable id="navigation" type="java.util.Map<java.lang.String, java.lang.String>"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://magnolia-cms.com/taglib/templating-components/cms" prefix="cms" %>
<%@ taglib uri="http://magnolia-cms.com/taglib/templating-components/cmsfn" prefix="cmsfn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <style type="text/css">
    .btn {
      background: #3498db;
      background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
      background-image: -moz-linear-gradient(top, #3498db, #2980b9);
      background-image: -ms-linear-gradient(top, #3498db, #2980b9);
      background-image: -o-linear-gradient(top, #3498db, #2980b9);
      background-image: linear-gradient(top, #3498db, #2980b9);
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      font-family: Arial;
      color: #ffffff;
      font-size: 20px;
      padding: 10px 20px 10px 20px;
      text-decoration: none; }

    .btn:hover {
      background: #3cb0fd;
      background: #3498db;
      background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
      background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
      background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
      background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
      background-image: linear-gradient(top, #3cb0fd, #3498db);
      text-decoration: none; }

    input {
      min-width: 400px;
      min-height: 30px; }
      input label {
        font-weight: bold; }

    .page, .header, .footer, .content {
      width: 100%; }

    .header {
      height: 100px;
      background: #000066;
      color: white;
      padding: 24px; }

    .footer {
      margin-top: 100px;
      background: #000066;
      color: white;
      padding: 24px;
      text-align: center; }

    .content {
      padding: 24px; }

    .comment_border {
      margin: 24px;
      border-radius: 10px;
      border: 1px solid #0099FF;
      padding: 5px;
      width: 80%;
      height: auto; }
      .comment_border .comment_detail {
        display: table; }
        .comment_border .comment_detail span {
          padding: 8px;
          display: table-cell;
          vertical-align: middle; }

    table {
      border: 1px solid black;
      border-collapse: collapse; }
      table th, table td {
        padding: 5px;
        text-align: left; }

    table#table01 {
      width: 100%; }
      table#table01 tr:nth-child(even) {
        background-color: #eee; }
      table#table01 tr:nth-child(odd) {
        background-color: #fff; }
      table#table01 th {
        background-color: black;
        color: white; }

    .form-group {
      padding: 8px;
      font-weight: bold; }

    </style>
    <title>Book Store - Detail</title>
</head>
<body>
    <div class="page">
        <div class="header">
            <h1>Book Store</h1>
             <div id="menu">
                 <ul>
                 <c:forEach items="${navigation}" var="navigationEntry">
                     <li><a href="${pageContext.request.contextPath}${navigationEntry.key}.html">${navigationEntry.value}</a></li>
                 </c:forEach>
                 </ul>
             </div>
        </div>
        <div class="content">
            <cms:area name="main" />
            <cms:area name="promos" />
        </div>
        <div class="footer">
            This page is created by trieudoan
        </div>
    </div>
</body>
</html>
