<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021-08-16
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="../css/AddUniversal.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="promeet.do" method="post">
        <ul class="forminfo">
            <input type="hidden" value="yy"  name="method">
            <li><label>预约人</label>
                <cite><select name="uid" class="dfinput">
                    <option value="${user.id}">${user.realname}</option>
                </select>
                </cite></li>

            <li><label>会议室名称</label>
                <cite><select name="hid" class="dfinput">
                    <option>--请选择--</option>
                    <c:forEach items="${page.rows}" var="l">
                        <option value="${l.id}">${l.name}</option>
                    </c:forEach>
                </select>
                </cite></li>
            <li><label>开始时间</label><input type="datetime-local"  name="btime" class="dfinput"/></li>
            <li><label>结束时间</label><input type="datetime-local"  name="stime" class="dfinput"/></li>

            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="预约" />
            </li>
        </ul>
    </form>
</div>
</body>
</html>
