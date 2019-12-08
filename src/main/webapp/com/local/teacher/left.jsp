<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/10/22
  Time: 下午7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script language="JavaScript">
        function showmenu(id){
            var list = document.getElementById("list" + id);
            var menu = document.getElementById("menu" + id);
            if(list.style.display == "none"){
                document.getElementById("list" + id).style.display="block";
                menu.className = "title1";
            }else{
                document.getElementById("list" + id).style.display="none";
                menu.className = "title";
            }
        }
    </script>
    <style type="text/css">
        <!--
        *{margin:0;padding:0;list-style:none;font-size:14px}
        #nav{margin:10px;text-align:center;line-height:25px;width:200px;}
        .title{background:#336699;color:#000;border-bottom:1px solid #fff;cursor:pointer;}
        .title1{background:#888;color:#000;border-bottom:1px solid #666;cursor:pointer;}
        content li{color:#336699;background:#ddd;border-bottom:1px solid #fff;}
        -->
    </style>
</head>
<body>
<div id="nav">
    <div class="title" id="menu1" onclick="showmenu('1')">问题池</div>
    <div id="list1" class="content" style="display:none"><%--none 此元素不会被显示--%>
        <ul>
            <li><a href="questionPool.jsp" target="iframe_a">综合问题</a></li>
        </ul>
    </div>
    <div class="title" id="menu2" onclick="showmenu('2')">我的消息</div>
    <div id="list2" class="content" style="display:none">
        <ul>
            <li><a href="problemslist.jsp" target="iframe_a">学生问题表（指名发送）</a></li>
            <li><a href="HistoryCommunication.jsp" target="iframe_a">历史消息</a></li>
        </ul>
    </div>
    <div class="title" id="menu3" onclick="showmenu('3')">个人信息</div>
    <div id="list3" class="content" style="display:none"><%--none 此元素不会被显示--%>
        <ul>
            <li><a href="myInformation.jsp" target="iframe_a">我的信息</a></li>
        </ul>
    </div>
    <div class="title" id="menu4" onclick="showmenu('4')">文章</div>
    <div id="list4" class="content" style="display:none"><%--none 此元素不会被显示--%>
        <ul>
            <li><a href="writeMassage.jsp" target="iframe_a">写文章</a></li>
            <li><a href="myMassage.jsp" target="iframe_a">我的文章</a></li>
            <li><a href="cheakMassage.jsp" target="iframe_a">文章审阅</a></li>
        </ul>
    </div>
</div>
</body>
</html>
