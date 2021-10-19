<%--
  Created by IntelliJ IDEA.
  User: 林
  Date: 2021-08-16
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/AddUniversal.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="../meet.do" method="post">
        <ul class="forminfo">
            <input type="hidden" value="ad" name="method">
            <li><label>会议室名称</label><input name="name" type="text" class="dfinput" /></li>
            <li><label>地址</label><input name="address" type="text" class="dfinput" /></li>
            <li><label>容量</label><input name="num" type="text" class="dfinput" /></li>
            <li><label>描述</label><input name="remark" type="text" class="dfinput" /></li>

            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" />
                <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置" />
            </li>
        </ul>
    </form>

</div>
</body>
</html>
