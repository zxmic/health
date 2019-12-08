<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/10/22
  Time: 下午8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        .main_container{
            width: 760px;
            height: auto;
            margin: auto;
            padding-top: 10%;
        }


        table {margin: auto;height: auto}
        body{
            text-align: center;
            background-size: 100% 100%;
            background-attachment: fixed;
            background-repeat: no-repeat;
        }


    </style>
    <script>
        function jump(){
            window.location.href="regist.jsp";
        }
    </script>

</head>
<body>
<div class="main_container" >
    <div >
        <h3>欢迎登录</h3>
    </div>

    </div>
    <div>
        <form action="/login_teacherLogin.action" method="post">
            用户名:<input name="username" type="text" placeholder="请输入用户名" style="width: 200px;height:25px;border-radius: 10px;color: black;"  maxlength="20" minlength="1"/><br>
            密&nbsp&nbsp码:<input name="password" type="password" placeholder=">请输入用户密码" style="width: 200px;height:25px;border-radius: 10px;color: black"  maxlength="20" minlength="1"> <br>

            <input type="submit" value="登录">
            <input type="button" value="注册" onclick=javascript:jump()>
        </form>
    </div>
</div>
</body>
</html>
