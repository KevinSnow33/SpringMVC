<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/21
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListSubmit</title>
</head>
<body>
    <form action="/list" method="post">
        ⽤户1编号： <input type="text" name="users[0].id"/><br/>
        ⽤户1名称： <input type="text" name="users[0].name"/><br/>
        ⽤户2编号： <input type="text" name="users[1].id"/><br/>
        ⽤户2名称： <input type="text" name="users[1].name"/><br/>
        ⽤户3编号： <input type="text" name="users[2].id"/><br/>
        ⽤户3名称： <input type="text" name="users[2].name"/><br/>
        <input type="submit" value="提交"/>
    </form>

</body>
</html>
