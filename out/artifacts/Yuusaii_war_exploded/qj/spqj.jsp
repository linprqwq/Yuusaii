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
        <form action="qj.do" method="post">
            <input type="hidden" value="spqj"  name="method">
            <label>员工名称</label>
            <cite><select name="uid" class="scinput">
                <option>--请选择--</option>
                <c:forEach items="${listuser}" var="l">
                    <option value="${l.id}">${l.realname}</option>
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
            <th>请假理由</th>
            <th>员工名称</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.rows}" var="s">
            <tr ${user.zid>=s.zid ? "style='display:none'":""} ${s.jg=='no' ? "style='display:none'":""} ${s.jg=='ok' ? "style='display:none'":""}>
                <td>${s.qid}</td>
                <td>${s.ly}</td>
                <c:forEach items="${listuser}" var="l">
                    <c:if test="${s.uid==l.id }">
                        <td>${l.realname}</td>
                    </c:if>
                </c:forEach>
                <td>${s.btime}</td>
                <td>${s.stime}</td>
                <td ${s.jg=='jlsp' ? "style='display:none'":""} ${user.zid==1 ? "style='display:none'":""}><a href="qj.do?method=tg&spid=${user.id}&qid=${s.qid}&btime=${s.btime}&stime=${s.stime}&jg=${s.jg}" class="tablelink">通过</a>
                    <a href="qj.do?method=btg&spid=${user.id}&qid=${s.qid}" class="tablelink">不通过</a>
                </td>

                <c:if test="${user.zid==1}">
                    <td ${s.jg==null ? "style='display:none'":""}><a href="qj.do?method=tg&spid=${user.id}&qid=${s.qid}&btime=${s.btime}&stime=${s.stime}&jg=${s.jg}" class="tablelink">通过</a>
                        <a href="qj.do?method=btg&spid=${user.id}&qid=${s.qid}" class="tablelink">不通过</a>
                    </td>
                </c:if>

                <c:if test="${user.zid==1}">
                    <td ${s.zid==2 ? "style='display:none'":""} ${s.jg=='jlsp' ? "style='display:none'":""}>等待下属审批</td>
                </c:if>

               <%-- 总经理为副经理专属审批--%>
                <c:if test="${s.zid==2}">
                    <td><a href="qj.do?method=tg&spid=${user.id}&qid=${s.qid}&btime=${s.btime}&stime=${s.stime}&jg=${s.jg}&zid=${s.zid}" class="tablelink">通过</a>
                        <a href="qj.do?method=btg&spid=${user.id}&qid=${s.qid}" class="tablelink">不通过</a>
                    </td>
                </c:if>

                <c:if test="${s.jg=='jlsp'}">
                    <td ${user.zid==1 ? "style='display:none'":""}>待总经理审批(>=3天)</td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">
        <ul class="paginList">
            <a href="qj.do?method=spqj&uid=${page.obj.uid}&pagenum=1">首页</a>
            <a href="qj.do?method=spqj&uid=${page.obj.uid}&pagenum=${page.pagenum==1?1:page.pagenum-1}"> 上一页</a>
            <a href="qj.do?method=spqj&uid=${page.obj.uid}&pagenum=${page.pagenum==page.totalpage?page.pagenum:page.pagenum+1}">下一页</a>
            <a href="qj.do?method=spqj&uid=${page.obj.uid}&pagenum=${page.totalpage}">尾页</a>
        </ul>
    </div>
</div>
<script>

    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
