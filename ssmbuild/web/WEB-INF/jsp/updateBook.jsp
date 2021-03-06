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
    <title>修改书籍</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>修改书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <form action="/book/updateBook" method="post">
            <input type="text" class="form-control hidden" name="bookId" value="${book.bookId}"/>
            <div class="form-group">
                <label>书籍名称：</label>
                <input type="text" class="form-control" name="bookName" value="${book.bookName}" required/>
            </div>
            <div class="form-group">
                <label>书籍数量：</label>
                <input type="text" class="form-control" name="bookCounts" value="${book.bookCounts}" required/>
            </div>
            <div class="form-group">
                <label>书籍描述：</label>
                <input type="text" class="form-control" name="detail" value="${book.detail}" required/>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改"/>
            </div>
        </form>
    </div>

</body>
</html>
