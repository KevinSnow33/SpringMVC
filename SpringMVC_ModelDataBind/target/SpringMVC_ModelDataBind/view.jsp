<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/22
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--启用EL表达式--%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>ModelDataBind</title>
</head>
<body>
    requestScope:${requestScope.user}    <hr>
    sessionScope:${sessionScope.user}    <hr>
    applicationScope:${applicationScope.user}    <hr>
</body>
</html>
