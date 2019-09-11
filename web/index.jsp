<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/5
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="#" method="post" onsubmit="return true">
    用户名：<input type="text" name="username" placeholder="请输入用户名"/><br>
    密码：<input type="password" name="password" placeholder="请输入密码"/><br>
    验证码：<input type="text" placeholder="请输入验证码">
    <img src="/checkCode" width="150" height="50" onclick="changeImg()" id="myImg">
    <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
    <br>
    <input type="submit" value="登陆">
  </form>
  <script>
    function changeImg() {
        //注意默认会读缓存
      document.getElementById("myImg").src="/checkCode?url="+new Date().getTime();
    }
  </script>
  </body>
</html>
