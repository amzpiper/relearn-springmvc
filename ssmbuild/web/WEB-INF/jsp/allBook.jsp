<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 郭宇航
  Date: 2021/10/3
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>书记展示</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>书籍列表</small>
                    </h1>
                </div>
            </div>
        </div>
        <a href="/book/toAddBookPiper" class="btn btn-success">添加数据</a>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <td>书籍ID</td>
                            <td>书籍名称</td>
                            <td>书籍数量</td>
                            <td>书籍详情</td>
                            <td>操作</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${bookList}" var="book">
                            <tr>
                                <td>${book.bookId}</td>
                                <td>${book.bookName}</td>
                                <td>${book.bookCounts}</td>
                                <td>${book.detail}</td>
                                <td>
                                    <a href="/book/toUpdateBookPiper/${book.bookId}" class="btn btn-info">修改</a> | &nbsp;
                                    <a href="/book/deleteBook/${book.bookId}" class="btn btn-danger">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
