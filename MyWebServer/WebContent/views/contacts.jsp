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
			<jsp:include page="map.jsp"></jsp:include>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>


</html>