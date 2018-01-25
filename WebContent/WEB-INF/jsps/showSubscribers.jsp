<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Subscriber</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css"
	type="text/css" />
</head>
<body>

	<div class="container">
		<div style="margin-top: 5%;">
			<center>
				<h2>List Subscriber</h2>
			</center>
		</div>

		<div>
			<table style="margin-top: 25px;" class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Fullname</th>
						<th>Email address</th>
						<th>Contact</th>
						<th>Category</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${subscribers}" var="data">
						<tr>
							<td>${data.id}</td>
							<td>${data.fullname}</td>
							<td>${data.email}</td>
							<td>${data.contact}</td>
							<td>${data.categories}</td>
							<td><a
								href="${pageContext.request.contextPath}/subscribe/editSubscriber-${data.id}">Edit</a>
								/ <a
								href="${pageContext.request.contextPath}/subscribe/deleteSubscriber-${data.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<h3>
			<center>
				<a href="${pageContext.request.contextPath}/"><b>Home</b></a>
			</center>
		</h3>
	</div>

</body>
</html>