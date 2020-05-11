<%@page import="java.io.PrintWriter"%>
<%@page import="models.Customers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<link rel="stylesheet" href="views/style.css">
</head>

<%
	Customers customer = (Customers) session.getAttribute("customer"); //с помощью объекта сессии получили объект customer от пользователя через заданный атрибут
%>

<c:if test="${customer!= null}">
	<!-- если объект customer есть то выводим на сайт один вид блока #user-inf -->
	<li id="FIO" style="margin-bottom: 10px">Здравствуйте, <%=customer.getLastName()%>
		<%=customer.getFirstName()%></li>
	<!--получили ФИО из класса Customer-->
	<a class="linkStyle" href="ShowBasket">Корзина</a>
	<%-- <c:out value="${count}"></c:out> --%>
	<form action="Logout" method="post">
		<input class="submit" style="margin-top: 10px" name="Выйти" type="submit" value="Выйти">
	</form>
</c:if>

<c:if test="${customer == null}">

	<form action="Login" method="post">
		<input class="login" type="text" name="login"
			placeholder="Введите логин"> <input id="password" type="text"
			name="password" placeholder="Введите пароль"> <input
			class="submit " type="submit" value="Войти">
	</form>
	<a class="linkStyle" href="Registration">Регистрация</a>
</c:if>


