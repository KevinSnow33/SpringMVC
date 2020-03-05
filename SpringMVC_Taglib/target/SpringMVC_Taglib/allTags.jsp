<%--
  Created by IntelliJ IDEA.
  User: Kevin.Snow
  Date: 2020/2/26
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AllTags</title>
</head>
<body>
    <%--渲染的是 HTML 中的<form></form>`，通过 modelAttribute 属性绑定具体的模型数据--%>
    <form:form modelAttribute="user">
        <%--渲染的是 HTML 中的 <input type="text"/>,支持级联path="address.name"--%>
        姓名：<form:input path="name"/> <br/>

        <%--渲染的是 HTML 中的 <input type="password"/>，password 标签的值不会在页面显示--%>
        不会显示的密码：<form:password path="password"/><br/>


        <%--渲染的是 HTML 中的 `<input type="checkbox"/>`，通过 path 与模型数据的属性值进行绑定，可以绑定 boolean、数组和集合。--%>
        <%-- 如果绑定 boolean 值，若该变量的值为 true，则表示该复选框(默认值)为选中，否则表示不选中--%>
        checkbox boolean：<form:checkbox path="checkboxFlag"/> <br/> <br/>


        <%-- 如果绑定数组或者集合，数组/集合中含有元素等于 checkbox中的 value 值，则选中 --%>
        checkbox集合-爱好：<br/>
        <form:checkbox path="selectedHobbys" value="摄影"></form:checkbox>摄影<br/>
        <form:checkbox path="selectedHobbys" value="读书"></form:checkbox>读书<br/>
        <form:checkbox path="selectedHobbys" value="听音乐"></form:checkbox>听音乐<br/>
        <form:checkbox path="selectedHobbys" value="看电影"></form:checkbox>看电影<br/>
        <form:checkbox path="selectedHobbys" value="旅游"></form:checkbox>旅游<br/>
        <form:checkbox path="selectedHobbys" value="玩游戏"></form:checkbox>玩游戏<br/> <br/>
        <%--渲染的是 HTML 中的一组 `<input type="checkbox"/>`，是对 `<form:checkbox/>` 的一种简化，
        需要结合 items 和 path 属性来使用，items 绑定被遍历的集合或数组，path 绑定被选中的集合或数组，
        可以这样理解，items 为全部可选集合，path 为默认的选中集合。--%>
        checkbox-checkboxes集合-爱好：<br/>
        <form:checkboxes items="${user.allHobbys}" path="selectedHobbys"/>  <br/>
        <%--需要注意的是 path 可以直接绑定模型数据的属性值，items 则需要通过 EL 表达式的形式从域对象中获取数据，不能直接写属性名。--%>


        <%--  渲染的是 HTML 中的一个 `<input type="radio"/>`，绑定的数据与标签的 value 值相等则为选中，否则不选中 --%>
        radiobutton-一年级： <from:radiobutton path="grade" value="1"></from:radiobutton> <br/><br/>
        <%--    渲染的是 HTML 中的一组 `<input type="radio"/>`，这里需要结合 items 和 path 两个属性来使用，
                items 绑定被遍历的集合或数组，path 绑定被选中的值，items 为全部的可选类型，path 为默认选中的选项，
                用法与 `<form:checkboxes/>` 一致   --%>
        radiobuttons集合-学生年级：<form:radiobuttons items="${user.gradeMap}" path="grade"/><br/><br/>

        <%--  渲染的是 HTML 中的一个 <select/>标签，需要结合 items 和 path 两个属性来使用，
        items 绑定被遍历的集合或数组，path 绑定被选中的值，用法与 `<from:radiobuttons/>`一致。      --%>
        select集合-所在城市：<form:select path="city[0]" items="${user.cityMap}"></form:select> <br/>
        select-option‘s’-所在城市：<form:select path="city[1]">
                                        <form:options items="${user.cityMap}"></form:options>
                                </form:select><br/>
        select-option-所在城市：<form:select path="city[2]">
                                        <form:option value="1">杭州</form:option>
                                        <form:option value="2">成都</form:option>
                                        <form:option value="3">西安</form:option>
                                </form:select><br/><br/>

        <%--  渲染的是 HTML 中的一个<textarea/>，path绑定模型数据的属性值，作为文本输入域的默认值 --%>
        TextareaDefault：<form:textarea path="textareaDefault"/><br/>


    </form:form>
</body>
</html>
