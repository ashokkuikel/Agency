<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css"
	type="text/css" />
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-4 push-md-4">
			<h3 class="text-center">List of Category</h3>
			<table style="margin-top: 25px;"
				class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<c:forEach items="${categories}" var="categories">
							<td>${categories.id}</td>
							<td>${categories.name}</td>
							<td><a
								href="${pageContext.request.contextPath}/editCategory-${categories.id}">Edit</a>
								/ <a
								href="${pageContext.request.contextPath}/deleteCategory-${categories.id}">Delete</a></td>
							<td><a href="<c:url value='/view-${categories.id}' />">View</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>

</body>
</html>