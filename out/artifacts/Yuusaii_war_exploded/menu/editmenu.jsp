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

    <form action="menu.do" method="post">
    <ul class="forminfo">
    <input type="hidden" value="upd"  name="method">
    <li><label>菜单id</label><input name="id" type="text" readonly="readonly" value="${m.id}" class="dfinput"/></li>
    <li><label>菜单名称</label><input name="name" type="text" value="${m.name}" class="dfinput"/></li>
    <li><label>菜单</label>
    <cite><select name="parentid" class="dfinput">
    <option>--请选择--</option>
    <option value="0" ${m.parentid==0  ? "selected='selected'":""}>父菜单</option>
    <c:forEach items="${listadup}" var="s">
        <option value="${s.id}"  ${m.parentid==s.id  ? "selected='selected'":""}>${s.name}</option>
    </c:forEach>
    </select>
    </cite></li>

    <li><label>节点类型</label>
    <cite><select name="nodetype" class="dfinput">
    <option>--请选择--</option>
    <option value="1" ${m.nodetype==1  ? "selected='selected'":""}>父节点</option>
    <option value="2" ${m.nodetype==2  ? "selected='selected'":""}>子节点</option>
    </select>
    </cite></li>

    <li><label>路径</label><input type="text"  name="linkurl" value="${m.linkurl}" class="dfinput"/></li>

    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
    <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
    </li>
    </ul>
    </form>
    </div>
</body>
</html>
