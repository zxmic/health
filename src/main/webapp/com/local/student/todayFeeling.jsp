<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/10/22
  Time: 下午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>todayFeeling</title>
</head>
<body>
<form action="save_todaymyword.action" method="post">
    <div>
        今日心情指数：${sessionScope.mypointEntity.getMoodpoint()}
    </div>
    <div>
        我的小心事：<br>
        <textarea name="todaymyword" cols="25" rows="15">${sessionScope.mywordEntity.getTodaymyword()}</textarea>
    </div>
    <div>
        <input type="submit" name="submit" value="保存">
    </div>
</form>
<div>

</div>
</body>
</html>
