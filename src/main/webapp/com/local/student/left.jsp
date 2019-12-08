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
    <div class="title" id="menu1" onclick="showmenu('1')">个人信息</div>
    <div id="list1" class="content" style="display:none"><%--none 此元素不会被显示--%>
        <ul>
            <li><a href="myPersonalInformation.jsp" target="iframe_a">我的个人信息</a></li>
        </ul>
    </div>
    <div class="title" id="menu2" onclick="showmenu('2')">心灵导师</div>
    <div id="list2" class="content" style="display:none">
        <ul>
            <li><a href="myproblem.jsp" target="iframe_a">我的问题</a></li>
            <li><a href="HistoryCommunication.jsp" target="iframe_a">历史记录</a></li>
        </ul>
    </div>
    <div class="title" id="menu3" onclick="showmenu('3')">世界鸡汤</div>
    <div id="list3" class="content" style="display:none"><%--none 此元素不会被显示--%>
        <ul>
            <li><a href="forMeMassages.jsp" target="iframe_a">鸡汤一览</a></li>
            <li><a href="writeMassage.jsp" target="iframe_a">写文章</a></li>
            <li><a href="myMassages.jsp" target="iframe_a">我的文章</a></li>
        </ul>
    </div>
    <div class="title" id="menu4" onclick="showmenu('4')">我的心情</div>
    <div id="list4" class="content" style="display:none"><%--none 此元素不会被显示--%>
        <ul>
            <li><a href="todayFeeling.jsp" target="iframe_a">今日心情</a></li>
            <li><a href="historyFeeling.jsp" target="iframe_a">历史心情</a></li>
        </ul>
    </div>
</div>
</body>
</html>
