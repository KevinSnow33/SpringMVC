<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/19
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save</title>
</head>

<body>
    <form action="/handler/save" method="post">
        用户名：<input type="text" name="name"> </br>
        ID：<input type="text" name="id"> </br>
        <%-- user的address属性是对象，address对象的属性是value，在jsp中通过级联的方式
        把address.value也提交上来，即可将address对象一起封装进user对象中--%>
        地址：<input type="text" name="address.value"> </br>
        成绩:<input type="text" name="score[0]"> </br>
        成绩:<input type="text" name="score[1]"> </br>
        成绩:<input type="text" name="score[2]"> </br>
        <input type="submit" value="注册">
    </form>

</body>
</html>
