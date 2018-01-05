<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student - Spring Hibernate Project</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css"
	type="text/css" />
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<hr>
	
		<div class="row">
			<div class="col-md-6 push-md-3">

				<h3>Edit Post</h3>
				<div class="form-group row">
					<label class="col-md-3">Name</label>${post.title}
				</div>
				<div class="form-group row">
					<label class="col-md-3">Description</label>${post.description}
				</div>
				<div class="form-group row">
				<label class="col-md-3"> Price</label>
					${post.price}
				</div>
				<div class="form-group row">
					<label class="col-md-3"> Category : </label>
					${categoryName}
				
				</div>
			</div>

			<div class="col-md-3 mx-auto">
				<img style="margin-top: 5%;"
					src="<c:url value="/static/images/${post.photo.name}"/>"
					class="img-fluid img-thumbnail h-25">
			</div>
		</div>
		
</body>
</html>