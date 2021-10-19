<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021-08-07
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>会议室管理系统</title>
  </head>
  <link rel="stylesheet" href="css/login.css" type="text/css">
  <body style="text-align: center;background-image: url(images/DigitalWater.jpg);background-repeat: no-repeat;background-size:cover">
<%--    <img src="images/index1.jpg" id="b1">--%>
<%--    <img src="images/index2.jpg" id="b2">--%>
<%--    <img src="images/index3.jpg" id="b3">--%>
  <div id="denglu">
    <form action="login.do" method="post">
      <span id="bt">登录</span>
      <input type="hidden" name="method" value="login">
      <input type="text" name="loginname" id="loginname" placeholder="账号"><br>
      <input type="password" name="password" id="password" placeholder="密码">
      <input type="submit" value="登录" id="qd">
    </form>
    <span id="ts1">${errmsg}</span>
  </div>
  <span id="by">by Yuusaii</span>
  </body>
</html>
