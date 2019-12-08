<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/10/22
  Time: 下午8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>top</title>
    <style type="text/css">
        .con4 {
            width: 300px;
            height: auto;
            overflow: hidden;
            margin: 20px auto;
            color: #FFFFFF;
        }

        .con4 .btn {
            width: 100%;
            height: 40px;
            line-height: 40px;
            text-align: center;
            background: #d8b49c;
            display: block;
            font-size: 16px;
            border-radius: 5px;
        }

        .upload {
            float: left;
            position: relative;
        }

        .upload_pic {
            display: block;
            width: 100%;
            height: 40px;
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
            border-radius: 5px;
        }

        #cvs {
            border: 1px solid #000;
            margin: 20px 0 20px 50px;
        }
    </style>
</head>
<body>
<div>
    <div class="con4">
        <canvas id="cvs" width="200" height="250"></canvas>
        <span class="btn upload">上传头像<input type="file" class="upload_pic" id="upload" /></span>
    </div>
    <script>
        //获取上传按钮
        var input1 = document.getElementById("upload");
        if(typeof FileReader === 'undefined') {
            //result.innerHTML = "抱歉，你的浏览器不支持 FileReader";
            input1.setAttribute('disabled', 'disabled');
        } else {
            input1.addEventListener('change', readFile, false);

        }

        function readFile() {
            var file = this.files[0]; //获取上传文件列表中第一个文件
            if(!/image\/\w+/.test(file.type)) {
                //图片文件的type值为image/png或image/jpg
                alert("文件必须为图片！");
                return false;
            }
            // console.log(file);
            var reader = new FileReader(); //实例一个文件对象
            reader.readAsDataURL(file); //把上传的文件转换成url
            //当文件读取成功便可以调取上传的接口
            reader.onload = function(e) {

                var image = new Image();
                // 设置src属性
                image.src = e.target.result;
                var max = 200;
                // 绑定load事件处理器，加载完成后执行，避免同步问题
                image.onload = function() {
                    // 获取 canvas DOM 对象
                    var canvas = document.getElementById("cvs");
                    // 获取 canvas的 2d 环境对象,
                    var ctx = canvas.getContext("2d");
                    // canvas清屏
                    ctx.clearRect(0, 0, canvas.width, canvas.height);

                    ctx.drawImage(image, 0, 0, 200, 250);

                };
            }
        };
    </script>
</div>
</body>
</html>
