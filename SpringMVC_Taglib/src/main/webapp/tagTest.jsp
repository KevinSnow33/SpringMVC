<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/26
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--导入 Spring MVC表单标签库，与导入 JSTL 标签库的语法非常相似，前缀 prefix 可以自定义，通常定义为 from--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Tag</title>
</head>
<body>
    <h1>用户信息</h1>
<%--    1.原始方式--%>
<%--    <form>--%>
<%--        姓名：<input type="text" value="${user.name}">--%>
<%--        ID:<input type="text" value="${user.id}">--%>
<%--    </form>--%>

<%--    2.通过表单标签库，简化代码--%>
    <form:form modelAttribute="user">
        <%-- 将 form 表单与模型数据通过 modelAttribute 属性完成绑定，将 modelAttribute 的值设置为模型数据对应的 key 值--%>
        姓名：<form:input path="name"/> <br/>
        ID：<form:input path="id"/>
    </form:form>

</body>
</html>
