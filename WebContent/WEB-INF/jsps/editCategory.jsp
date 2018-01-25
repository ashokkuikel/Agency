<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Category - Spring Hibernate Project</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css"
	type="text/css" />
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<hr />
	<div class="row">
		<div class="col-md-6 push-md-3">
			<form action="${pageContext.request.contextPath}/updateCategory"
				method="post">
				<h3>Registration Form</h3>
				<div class="form-group row">
					<label class="col-md-3">ID</label> <input type="text"
						readonly="true" name="id" class="col-md-3"
						value="${categories.id}" />
				</div>
				<div class="form-group row">
					<label class="col-md-3">Category Name</label> <input type="text"
						name="name" class="col-md-3" value="${categories.name}" />
				</div>
				<input type="submit" class="btn btn-danger" value="Update">
			</form>
		</div>
	</div>

	</div>

</body>
</html>