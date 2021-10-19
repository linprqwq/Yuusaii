<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021-08-20
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
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
            <th>编号<i class="sort"></i></th>
            <th>请假理由</th>
            <th>员工名称</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.rows}" var="s">
            <tr <%--${s.uid!=user.id ? "style='display:none'":""}--%>>
                <td>${s.qid}</td>
                <td>${s.ly}</td>
                <c:forEach items="${listuser}" var="l">
                    <c:if test="${s.uid==l.id }">
                        <td>${l.realname}</td>
                    </c:if>
                </c:forEach>
                <td>${s.btime}</td>
                <td>${s.stime}</td>
                <c:if test="${s.jg==null}">
                    <td>待审批</td>
                </c:if>
                <c:if test="${s.jg=='ok'}">
                    <td>请假成功</td>
                </c:if>
                <c:if test="${s.jg=='jlsp'}">
                    <td>待总经理审批</td>
                </c:if>
                <c:if test="${s.jg=='no'}">
                    <td>请假失败</td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">
        <ul class="paginList">
            <a href="qj.do?method=queryallqj&pagenum=1">首页</a>
            <a href="qj.do?method=queryallqj&pagenum=${page.pagenum==1?1:page.pagenum-1}"> 上一页</a>
            <a href="qj.do?method=queryallqj&pagenum=${page.pagenum==page.totalpage?page.pagenum:page.pagenum+1}">下一页</a>
            <a href="qj.do?method=queryallqj&pagenum=${page.totalpage}">尾页</a>
        </ul>
    </div>
</div>
<script>
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
