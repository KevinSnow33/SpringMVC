<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/29
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <form:form modelAttribute="person" action="register" method="post">
        用户名：<form:input path="username"></form:input><form:errors path="username"/><br/>
        密码：<form:password path="password"></form:password><form:errors path="password"/><br/>
        邮箱：<form:input path="email"></form:input><form:errors path="email"/><br/>
        电话：<form:input path="phone"></form:input><form:errors path="phone"/><br/>
        <input type="submit" value="提交"/>
    </form:form>
    </body>
</html>
