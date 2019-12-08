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

    <el-rate
            v-model="value"
            :icon-classes="iconClasses"
            void-icon-class="icon-rate-face-off"
            :colors="['#99A9BF', '#F7BA2A', '#FF9900']">
    </el-rate>

    <script>
        export default {
            data() {
                return {
                    value: null,
                    iconClasses: ['icon-rate-face-1', 'icon-rate-face-2', 'icon-rate-face-3'] // 等同于 { 2: 'icon-rate-face-1', 4: { value: 'icon-rate-face-2', excluded: true }, 5: 'icon-rate-face-3' }
                }
            }
        }
    </script>

    <form name="form" action="uptate_">
    今日心情指数：<input type="text" name="stars"><br>
    <input type="submit" name="submit"  value="确认提交">

</form>
</center>
</body>
</html>
