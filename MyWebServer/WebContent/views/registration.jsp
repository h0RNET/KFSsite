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

		<div id="reg-content">
			<div id="registration">
				<form id="form-reg" action="Registration" method="post">
					<input class="registration" type="text" name="login" placeholder="Введите логин"><br> 
					<input class="registration" type="text" name="password" placeholder="Введите пароль"><br> 
					<input class="registration" type="text" name="lastname" placeholder="Введите фамилию"><br> 
					<input class="registration" type="text" name="firstname" placeholder="Введите имя">
					<input class="submit" type="submit" value="Зарегистрироваться" style="margin-left: -10px"><br>
				</form>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>


</html>
