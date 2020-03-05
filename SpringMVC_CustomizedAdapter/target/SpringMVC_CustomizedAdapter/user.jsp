<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/23
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <form action="/user" method="post">
        <%--  这里input标签的name的值：必须是模型对象User的类名的第一个字母变小写：user  --%>
        User信息：<input type="text" name="user"> (格式："zhangsan-01") <br/>
        （传中文会乱码）<br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
