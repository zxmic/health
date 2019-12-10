<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/10/22
  Time: 下午9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mypersonal</title>
</head>
<body>
<div>
    <table>
        <tr>
            <td>
                姓名：${sessionScope.studentloginEntity.getRealname()}
            </td>
            <td>
                班级：${sessionScope.studentloginEntity.getClazz()}
            </td>
        </tr>
        <tr>
            <td>
                学号：${sessionScope.studentloginEntity.getStudentid()}
            </td>
            <td>
                联系方式：${sessionScope.studentloginEntity.getTel()}
            </td>
        </tr>
        <tr>
            <td>
                班主任：${sessionScope.studentloginEntity.getClassmaster()}
            </td>
            <td>
                班主任联系方式：${sessionScope.studentloginEntity.getMastertel()}
            </td>
        </tr>
        <tr>
            <td>
                学院：${sessionScope.studentloginEntity.getCollege()}
            </td>
            <td>
                专业：${sessionScope.studentloginEntity.getMajor()}
            </td>
        </tr>
        <tr>
            <td>
                宿舍：${sessionScope.studentloginEntity.getDorm()}
            </td>
            <td>

            </td>
        </tr>


    </table>

</div>
<div>
    <form>
        个性签名：<br>
        <input type="text" name="text"><br>
        <input type="submit" name="submit" value="提交">
    </form>
</div>

</body>
</html>
