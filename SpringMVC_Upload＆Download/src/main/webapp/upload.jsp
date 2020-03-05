<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/25
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--启用EL表达式--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<%--
    1、input 的 type 设置为 file。
    2、form 的 method 设置为 post（get 请求只能将文件名传给服务器）
    3、from 的 enctype 设置为 multipart-form-data（如果不设置只能将文件名传给服务器）
--%>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="img">  <br/>
        <input type="submit" value="上传">
    </form>
<%--把所上传的文件路径加文件名存入request，以便于在jsp中拿到图片（<img src="图片路径">）--%>
    <img src="${path}">

</body>
</html>
