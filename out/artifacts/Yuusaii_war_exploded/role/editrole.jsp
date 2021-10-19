<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021/8/6
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="css/AddUniversal.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="role.do" method="post">
        <ul class="forminfo">
            <input type="hidden" value="upd" name="method">
            <li><label>角色id</label><input type="text"  name="id" value="${r.id}" class="dfinput" readonly="readonly"></li>
            <li><label>角色名称</label><input name="name" type="text" value="${r.name}" class="dfinput" /></li>
            <li><label>角色描述</label><input name="remark" type="text" value="${r.remark}" class="dfinput" /></li>

            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
                <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
            </li>
        </ul>
    </form>

</div>
</body>
</html>
