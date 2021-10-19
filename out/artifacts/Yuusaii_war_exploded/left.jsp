<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧</title>
    <link rel="stylesheet" href="css/left.css">
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">

$(function(){
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})

</script>
</head>
<body>
	<div class="lefttop"></div>
    <dl class="leftmenu">
    <dd>
<c:forEach items="${menus}" var="menu">
    <div class="title">
    <span></span>${menu.name}
    </div>
    	<ul class="menuson" style="display: none">
    <c:forEach items="${menu.childmenus}" var="childmenu">
        <li class="active"><cite></cite><a href="${childmenu.linkurl}" target="rightFrame">${childmenu.name}</a><i></i></li>
    </c:forEach>
        </ul>
</c:forEach>
    </dd>
    </dl>
</body>
</html>
