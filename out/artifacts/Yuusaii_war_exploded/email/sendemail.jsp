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
</head>
<link rel="stylesheet" href="css/AddUniversal.css">
<body>
<div class="formbody">
    <div class="formtitle"><span>基本信息</span></div>
    <form action="ema.do" method="post">
        <ul class="forminfo">
            <input type="hidden" name="method" value="xj">
            <li><label>发件人</label>
                <cite><select name="fromuid" class="dfinput">
                        <option value="${user.id}">${user.realname}</option>
                </select>
                </cite></li>
            <li><label>收件人</label>
                <cite><select name="touid" class="dfinput">
                    <option>--请选择--</option>
                    <c:forEach items="${listuser}" var="l">
                        <option value="${l.id}">${l.realname}</option>
                    </c:forEach>
                </select>
                </cite></li>
            <li><label>标题</label><input type="text"  name="title" class="dfinput"/></li>
            <li><label>内容</label><input type="text"  name="content" class="dfinput"/></li>

            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="发送" />
                <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
            </li>
        </ul>
    </form>
</div>

</body>
</html>
