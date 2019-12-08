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
    <title>注册</title>
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
            window.location.href="/com/local/student/login.jsp";
        }
    </script>
</head>
<body>
    <div class="main_container">
        <div>
            <h3>欢迎注册</h3>
        </div>
        <div>
            <form name="form1" action="/regist_studentRegist.action" method="post" >
                学&nbsp&nbsp号:<input name="username" type="text" value="2240170201" placeholder="2240170201" style="width: 200px;height:25px;border-radius: 10px;color: black;"  maxlength="20" minlength="1"/><br>
                密&nbsp&nbsp码:<input name="password" type="password" value="2240170201" placeholder="2240170201" style="width: 200px;height:25px;border-radius: 10px;color: black"  maxlength="20" minlength="1"/> <br>

                <div>
                    <font color="red"><s:property value="exception.message"/></font>
                </div>

                <input type="submit" value="确认注册" >
                <input type="button" value="返回登录" onclick=javascript:jump()>
            </form>
        </div>
    </div>

</body>