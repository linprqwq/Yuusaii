<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021/8/6
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="css/Universal.css" rel="stylesheet" type="text/css" />
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
    <form action="menu.do" method="post">
    <input type="hidden" value="queryallmenu"  name="method">
    <label>菜单名称:</label><input name="name" type="text" class="scinput" />
    <a style="margin-left:20px;"></a>
    <label>&nbsp;</label><input name="" type="submit" class="btn" value="查询" />
    <a style="margin-left:8px;"></a>
    <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
    </form>
    </div>
    <div class="tools">

    <ul class="toolbar">
        <li class="click"><span></span><a href="menu/addmenu.jsp">添加</a></li>
    </ul>
    </div>



    <table class="tablelist">
    <thead>
    <tr>
    <th>编号<i class="sort"></i></th>
    <th>菜单名称</th>
    <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.rows}" var="s">
        <tr>
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td>
        <a onclick="sc(${s.id })" class="tablelink">删除</a>
        <a onclick="bj(${s.id })" class="tablelink">编辑</a>
        </td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    <div class="pagin">
    <ul class="paginList">
    <a href="menu.do?method=queryallmenu&name=${page.obj.name}&pagenum=1">首页</a>
    <a href="menu.do?method=queryallmenu&name=${page.obj.name}&pagenum=${page.pagenum==1?1:page.pagenum-1}"> 上一页</a>
    <a href="menu.do?method=queryallmenu&name=${page.obj.name}&pagenum=${page.pagenum==page.totalpage?page.pagenum:page.pagenum+1}">下一页</a>
    <a href="menu.do?method=queryallmenu&name=${page.obj.name}&pagenum=${page.totalpage}">尾页</a>
    </ul>
    </div>
    </div>
    <script >
    function sc(id){
    if(confirm("您确认要删除吗?")){
    location.href="menu.do?method=del&id="+id;
        }
    }

    function bj(id){
    location.href="menu.do?method=selById&id="+id;
    }
    </script>
</body>
</html>
