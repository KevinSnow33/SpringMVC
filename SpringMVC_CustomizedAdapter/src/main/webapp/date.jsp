<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/22
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date</title>
</head>
<body>
    <form action="/date" method="post">
        <%--  这里input标签的name的值：必须是模型对象Date的类名的第一个字母变小写：date  --%>
        请输⼊日期:<input type="text" name="date"/>(yyyy-MM-dd)<br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
