<%--
  Created by IntelliJ IDEA.
  User: 郭宇航
  Date: 2021/10/5
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form method="post" action="/upload" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传">
  </form>

  <a href="/download">下载文件</a>

  </body>
</html>
