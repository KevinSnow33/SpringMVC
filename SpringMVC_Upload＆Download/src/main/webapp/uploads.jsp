<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/25
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Uploads</title>
</head>
<body>
    <form action="/uploads" method="post" enctype="multipart/form-data">
        <%--   3个上传项的name可以不同，最终都会封装到一个MultipartFile[]文件对象数组中      --%>
        <input type="file" name="imgs1"> <br/>
        <input type="file" name="imgs2"> <br/>
        <input type="file" name="imgs3"> <br/>
        <input type="submit" value="多个上传">
    </form>

<%--    用jstl和el表达式，遍历图片文件路径，并通过路径拿到图片显示--%>
    <c:forEach items="${paths}" var="path">
        <img src="${path}">
    </c:forEach>
</body>
</html>
