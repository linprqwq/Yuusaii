<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021/8/6
  Time: 16:18
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

    <form action="../user.do" method="post">
        <ul class="forminfo">
            <input type="hidden" value="ad"  name="method">
            <li><label>用户名称</label><input name="realname" type="text" class="dfinput"/></li>
            <li><label>登入名称</label><input name="loginname" type="text" class="dfinput"/></li>
            <li><label>密码</label><input name="password" type="text" class="dfinput"/></li>

            <li><label>角色名称</label>
                <cite><select name="rid" class="dfinput">
                    <option>--请选择--</option>
                    <c:forEach items="${list}" var="l">
                        <option value="${l.id}">${l.name}</option>
                    </c:forEach>
                </select>
                </cite></li>
            <li><label>职位</label>
                <cite><select name="zid" class="dfinput">
                    <option>--请选择--</option>
                    <c:forEach items="${list1}" var="l">
                        <option value="${l.id}">${l.name}</option>
                    </c:forEach>
                </select>
                </cite></li>
            <li><label>电话</label><input type="text"  name="phone" class="dfinput"/></li>
            <li><label>地址</label><input type="text"  name="address" class="dfinput"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
                <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
            </li>
        </ul>
    </form>
</div>
</body>
</html>
