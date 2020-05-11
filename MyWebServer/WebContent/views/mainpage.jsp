<%@page import="models.UseModel"%>
<%@page import="models.CreateJSON"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>KFC SO GOOD</title>
<link rel="stylesheet" href="views/style.css"> <!-- подключаем css файл -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> <!-- Подключаем библиотеку jquery -->
<script src="https://maps.api.2gis.ru/2.0/loader.js?pkg=full"></script> <!-- Подключаем скрипт с картой 2gis-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- Подключаем библиотеку jquery -->

<script type="text/javascript">
	
<%@include file = "tab.js"%>
	
</script>

</head>

<body onload="swap(1,0)">
	<div id="site">
		<jsp:include page="head.jsp"></jsp:include>
		<jsp:include page="menubar.jsp"></jsp:include>
		<div id="content">
			<table id="foodsTable">
			</table>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>

</html>
