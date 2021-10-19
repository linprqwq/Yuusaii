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
    <link href="../css/AddUniversal.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="qj.do" method="post">
        <ul class="forminfo">
            <input type="hidden" value="yy"  name="method">
            <li><label>请假人</label>
                <cite><select name="uid" class="dfinput">
                    <option value="${user.id}">${user.realname}</option>
                </select>
                </cite></li>
            <li><label>请假理由</label><input type="text"  name="ly" class="dfinput"/></li>
            <li><label>开始时间</label><input type="date"  name="btime" class="dfinput"/></li>
            <li><label>结束时间</label><input type="date"  name="stime" class="dfinput"/></li>

            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认" />
            </li>
        </ul>
    </form>
</div>
</body>
</html>
