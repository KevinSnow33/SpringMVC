<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/21
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MapSubmit</title>
</head>
<body>
    <form action="/map" method="post">
        <table>
            <tr>
                <td>A姓名</td>
                <%-- ['A']代表key是'A', 取得Map集合map中key为'A'对应value（user对象） --%>
                <td><input type="text" name="map['A'].name"></td>
            </tr>
            <tr>
                <td>Aid</td>
                <td><input type="text" name="map['A'].id"></td>
            </tr>
            <tr>
                <td>B姓名</td>
                <td><input type="text" name="map['B'].name"></td>
            </tr>
            <tr>
                <td>Bid</td>
                <td><input type="text" name="map['B'].id"></td>
            </tr>
            <tr>
                <td>C姓名</td>
                <td><input type="text" name="map['C'].name"></td>
            </tr>
            <tr>
                <td>Cid</td>
                <td><input type="text" name="map['C'].id"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
