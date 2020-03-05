<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/21
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON</title>
</head>
<body>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">

        //把JSON对象通过AJAX传到后台，通过处理后后台又返回一个修改过JSON对象回来

        $(function () {
            //创建JSON对象
            var user = {
                "id":3,
                "name":"张三"
            }

            $.ajax({
                url:"/json",
                data:JSON.stringify(user),  //把上面的user对象转成JSON格式
                type:"POST",
                contentType:"application/json;charset=UTF-8", //处理中文乱码
                dataType:"JSON", //返回数据类型
                success:function (data) {
                    alert(data.id + "---" + data.name)
                }
             }
            )

        })
    </script>
</body>
</html>
