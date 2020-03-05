<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/29
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <%--使用表单标签库，先在浏览器用get请求访问“/login”，将模型数据返回到本jsp中
    （否则modelAttribute是空的。）然后再在本jsp中正常提交用户输入数据，进行校验。
      必须使用表单标签库的目的是为了能将errors信息返回到jsp中显示出来--%>
    <form:form modelAttribute="user" action="/login" method="post">
        姓名：<form:input path="name"/><form:errors path="name"></form:errors><br/>
        密码：<form:input path="password"/><form:errors path="password"></form:errors><br/>
        <input type="submit" value="登录"/>
    </form:form>


<%--&lt;%&ndash;下面的方式不用表单标签库，不需要先拿到模型数据（modelAttribute），而是直接提交输入的内容，--%>
<%--    然后进行校验，也可以。但是error属于【表单标签库】的内容，没法把error的信息返回回来&ndash;%&gt;--%>
<%--    <form action="/login" method="post">--%>
<%--        姓名：<input type="text" name="name"/>--%>
<%--        密码：<input type="text" name="password"/>--%>
<%--        <input type="submit" value="登录"/>--%>
<%--    </form>--%>


</body>
</html>
