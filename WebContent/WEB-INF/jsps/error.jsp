<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Occurred!!!</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css"
	type="text/css" />
</head>

<body>

	<div class="container">
		<div style="margin-top: 15%;" class="error">
			<h1>Error OCCURED.</h1>
			<h2>Dn't Know what Error!!! -_-+</h2>
			<h2 style="margin-left: 5%;">Damn........</h2>
		</div>

		<c:if test="${not empty exception}">
			<h3 style="color: red;">${exception.}</h3>
		</c:if>

	</div>

</body>
</html>