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

    <form action="../menu.do" method="post">
    <ul class="forminfo">
    <input type="hidden" value="ad"  name="method">
    <li><label>菜单名称</label><input name="name" type="text" class="dfinput"/></li>
    <li><label>菜单</label>
    <cite><select name="parentid" class="dfinput">
    <option>--请选择--</option>
    <option value="0">父菜单</option>
    <c:forEach items="${listadup}" var="s">
        <option value="${s.id}">${s.name}</option>
    </c:forEach>
    </select>
    </cite></li>

    <li><label>节点类型</label>
    <cite><select name="nodetype" class="dfinput">
    <option>--请选择--</option>
    <option value="1">父节点</option>
    <option value="2">子节点</option>
    </select>
    </cite></li>
    <li><label>路径</label><input type="text"  name="linkurl" class="dfinput"/></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
    <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
    </li>
    </ul>
    </form>
    </div>
</body>
</html>
