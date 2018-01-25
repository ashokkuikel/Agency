<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css"
	type="text/css" />
</head>

<body>

	<div class="jumbotron text-center">
		<h2>Spring Hibernate</h2>
	</div>

	<div class="container">

		<div style="margin-top: 5%;" class="row text-center">
			<div class="pull-left col-md-4">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/createPost">Create
					Post </a>
			</div>

			<div class="pull-right col-md-4">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/fileUpload"> Posts
					FileUpload</a>
			</div>
			<div class="pull-right col-md-4">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/viewPosts">View Posts</a>
			</div>

		</div>

		<div style="margin-top: 1%;" class="row text-center">
			<div class="pull-left col-md-4">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/subscribe/addsubscriber">Subscribe</a>
			</div>
			<div class="col-md-4 push-md-4">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/createCategory">Create
					Category</a>
			</div>
		</div>


		<div style="margin-top: 1%;" class="row text-center">
			<div class="col-md-4 push-md-4">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/subscribe/viewSubscribers">View
					Subscriber</a>
			</div>
		</div>
		<div style="margin-top: 1%;" class="row text-center">
			<div class="col-md-4 push-md-4">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/"> Home</a>
			</div>
		</div>
		<hr />
</body>
</html>