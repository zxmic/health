<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/10/22
  Time: 下午11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>historyFeeling</title>
</head>
<body><!--补充日历，选择哪天，出现哪天明细-->
    <s:iterator value="#session.mypointEntities">
        <div>
            ************************************<br>
            <s:property value="whichday"/>&nbsp&nbsp:&nbsp&nbsp
            <s:property value="moodpoint"/><br>

        </div>

    </s:iterator>


</body>
</html>
