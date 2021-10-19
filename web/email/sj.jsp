<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021-08-02
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>
</head>
<body>
<div class="rightinfo">
    <table class="tablelist">
        <thead>
        <tr>
            <th>邮箱编号<i class="sort"></i></th>
            <th>发件人</th>
            <th>收件人</th>
            <th>内容</th>
            <th>发送时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list1}" var="s">
            <tr ${s.state==2 ? "style='display:none'":""} ${s.state==1 ? "style='display:none'":""} ${s.touid!=user.id ? "style='display:none'":""}>
                <td>${s.id}</td>
                <c:forEach items="${listuser}" var="l">
                <c:if test="${s.fromuid==l.id }">
                <td>${l.realname}</td>
                </c:if>
                </c:forEach>

                <c:forEach items="${listuser}" var="l">
                <c:if test="${s.touid==l.id }">
                <td>${l.realname}</td>
                </c:if>
                </c:forEach>
                <td>${s.title}</td>
                <td>${s.content}</td>
                <td>${s.sendtime}</td>
                <td>
                    <a onclick="xc(${s.id })" class="tablelink">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    $('.tablelist tbody tr:odd').addClass('odd');

    function xc(id){
        location.href="ema.do?method=sc&id="+id;
    }
</script>

</body>
</html>
