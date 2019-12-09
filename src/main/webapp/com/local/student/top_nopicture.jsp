<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/10/22
  Time: 下午8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <s:label label="姓名" />
        ${sessionScope.studentloginEntity.getRealname()}
        &nbsp&nbsp&nbsp
        <s:label label="班级" />
        ${sessionScope.studentloginEntity.getClazz()}
    </div>


    <form name="form" action="uptate_todaymood.action">
    今日心情指数：${sessionScope.mypointEntity.getMoodpoint()}
        <select name="moodpoint">
            <option >极差</option>
            <option>郁闷</option>
            <option>一般</option>
            <option selected="selected">嗨皮</option>
            <option>人生巅峰</option>
        </select>
    <input type="submit" name="submit"  value="确认提交">

</form>
</center>
</body>
</html>
