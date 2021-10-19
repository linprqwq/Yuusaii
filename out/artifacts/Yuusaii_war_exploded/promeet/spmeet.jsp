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
            <input type="hidden" value="spmeet"  name="method">
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
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.rows}" var="s">
            <tr <%--${s.jg=='ok' ? "style='display:none'":""} ${s.jg=='no' ? "style='display:none'":""}--%>>
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
                    <td><a href="promeet.do?method=tg&spid=${user.id}&id=${s.id}&btime=${s.btime}&uid=${s.uid}" class="tablelink" onclick="pd(${s.jg})">通过</a>
                        <a href="promeet.do?method=btg&spid=${user.id}&id=${s.id}" class="tablelink">不通过</a>
                    </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">
        <ul class="paginList">
            <a href="promeet.do?method=spmeet&hid=${page.obj.hid}&pagenum=1">首页</a>
            <a href="promeet.do?method=spmeet&hid=${page.obj.hid}&pagenum=${page.pagenum==1?1:page.pagenum-1}"> 上一页</a>
            <a href="promeet.do?method=spmeet&hid=${page.obj.hid}&pagenum=${page.pagenum==page.totalpage?page.pagenum:page.pagenum+1}">下一页</a>
            <a href="promeet.do?method=spmeet&hid=${page.obj.hid}&pagenum=${page.totalpage}">尾页</a>
        </ul>
    </div>
</div>
<script>

    $('.tablelist tbody tr:odd').addClass('odd');

    function pd(jg){
        if(jg.valueOf('jqsp')){
            alert("错误")
       }
    }


</script>

</body>
</html>
