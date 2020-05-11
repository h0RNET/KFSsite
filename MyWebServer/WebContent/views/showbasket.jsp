<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Регистрация на сайте</title>
<link rel="stylesheet" href="views/style.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://maps.api.2gis.ru/2.0/loader.js?pkg=full"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>

<body>
	<div id="site">
		<jsp:include page="head.jsp"></jsp:include>

		<div id="menu-bar">
			<div id="navigation">
				<a href="MainPage" class="nav-button" id="mainpage">На главную</a>
			</div>
		</div>

		<div id="content">
			<table id="goodsInBasket">
				<caption style="font-size: 25px">Выбранные вами товары</caption>
				<tr>
					<th>№</th>
					<th>Изображение</th>
					<th>Наименование</th>
					<th>Стоимость за шт. (руб)</th>
				</tr>
				<c:forEach items="${goods}" varStatus="num" var="good">
				<tr>
					<td>${num.count}</td>
					<td><img width='50' height='50' src='img/${good.image}'></td>
					<td>${good.title}</td>
					<td>${good.price}</td>
				</tr>
			</c:forEach>
			</table>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>


</html>