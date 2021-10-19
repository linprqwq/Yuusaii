<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021/8/6
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>授权</title>
    <link href="../css/authc.css" rel="stylesheet" type="text/css" />
</head>

<body>

<script>
    function rolechange() {
        var rid = document.getElementById("rid").value;
        location.href="authc.do?method=showauthc&rid="+rid;
    }
</script>
<div class="formbody">
    <div class="formtitle"><span>基本信息</span></div>
<form action="authc.do">
    <ul class="forminfo">
    <input type="hidden" name="method" value="setauthc">
        <li><label>角色</label>
            <cite><select name="rid" id="rid" onchange="rolechange()" class="dfinput">
        <option value="-1">---请选择---</option>
        <c:forEach items="${roles}" var="role">
            <option value="${role.id}" ${rid == role.id?"selected":""}>${role.name}</option>
        </c:forEach>
    </select></cite></li>
        菜单
    <!-- 先循环一级菜单-->
    <c:forEach items="${menus}" var="menu">
      <h4>  <input name="mid" type="checkbox" ${menu.ischecked?"checked":""} value="${menu.id}" <%--${menu.id == mr.mid  ? "checked='checked'":""}--%>>${menu.name}</h4>
        <!-- 去一级菜单获取二级菜单-->
        <c:forEach items="${menu.childmenus}" var="childmenu">
            <input name="mid" type="checkbox" ${childmenu.ischecked?"checked":""} value="${childmenu.id}" <%--${childmenu.id == mr.mid  ? "checked='checked'":""}--%>>${childmenu.name}
        </c:forEach>
</c:forEach>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="授权" /></li>
    </ul>
</form>
</div>
</body>
</html>
