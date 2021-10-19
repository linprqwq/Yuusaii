<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021-08-17
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="../css/Universal.css" rel="stylesheet" type="text/css" />
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

    <div class="right_top" style="height:60px;">
        <form action="promeet.do" method="post">
            <input type="hidden" value="queryallspmeet"  name="method">
            <label>会议室名称</label>
                <cite><select name="hid" class="scinput">
                    <option>--请选择--</option>
                    <c:forEach items="${listmeet}" var="l">
                        <option value="${l.id}">${l.name}</option>
                    </c:forEach>
                </select>
                </cite>
            <a style="margin-left:20px;"></a>
            <label>&nbsp;</label><input name="" type="submit" class="btn" value="查询" />
            <a style="margin-left:8px;"></a>
            <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
        </form>
    </div>

    <div class="tools">
        <ul class="toolbar">
        </ul>
    </div>



    <table class="tablelist">
        <thead>
        <tr>
            <th>编号<i class="sort"></i></th>
            <th>会议室名称</th>
            <th>员工名称</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>审批人</th>
            <th>审批时间</th>
            <th>结果</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.rows}" var="s">
            <tr>
                <td>${s.id}</td>
                <c:forEach items="${listmeet}" var="m">
                    <c:if test="${s.hid==m.id }">
                        <td>${m.name}</td>
                    </c:if>
                </c:forEach>

                <c:forEach items="${listuser}" var="l">
                    <c:if test="${s.uid==l.id }">
                        <td>${l.realname}</td>
                    </c:if>
                </c:forEach>
                <td>${s.btime}</td>
                <td>${s.stime}</td>
            <c:forEach items="${listuser}" var="l">
                <c:if test="${s.spid==l.id }">
                <td>${l.realname}</td>
                </c:if>
            </c:forEach>
                <td>${s.sptime}</td>
                <c:if test="${s.jg=='ok'}">
                    <td>通过</td>
                </c:if>
                <c:if test="${s.jg=='no'}">
                    <td>不通过</td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">
        <ul class="paginList">
            <a href="promeet.do?method=queryallspmeet&hid=${page.obj.hid}&pagenum=1">首页</a>
            <a href="promeet.do?method=queryallspmeet&hid=${page.obj.hid}&pagenum=${page.pagenum==1?1:page.pagenum-1}"> 上一页</a>
            <a href="promeet.do?method=queryallspmeet&hid=${page.obj.hid}&pagenum=${page.pagenum==page.totalpage?page.pagenum:page.pagenum+1}">下一页</a>
            <a href="promeet.do?method=queryallspmeet&hid=${page.obj.hid}&pagenum=${page.totalpage}">尾页</a>
        </ul>
    </div>
</div>
<script>
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>
</html>
