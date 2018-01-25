<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Subscriber</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css"
	type="text/css" />
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<hr />

	<form action="${pageContext.request.contextPath}/subscribe/updateSubscriber"
		method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col-md-6 push-md-3">

				<h3>Edit Post</h3>
				<div class="form-group row">
					<label class="col-md-3">ID</label> <input type="text"
						readonly="true" name="id" class="col-md-3" value="${subscriber.id}" />
				</div>
				<div class="form-group row">
					<label class="col-md-3">Name</label> <input type="text"
						name="fullname" class="col-md-3" value="${subscriber.fullname}" />
				</div>
				<div class="form-group row">
					<label class="col-md-3">Email</label> <input type="text"
						name="email" class="col-md-3" value="${subscriber.email}" />
				</div>
				
				<div class="form-group row">
					<label class="col-md-3">Description</label> <input type="text"
						name="contact" class="col-md-3" value="${subscriber.contact}" />
				</div>
				
				<div class="form-group row">
					<label class="col-md-3"> Category : </label>
					<form:select path="categories" name="categories">

						<c:forEach items="${categories}" var="categories">
						<option value="NONE" label="--- Select ---"></option>
							<option
								<c:if test="${post.category.name eq categories.name}">selected="selected"</c:if>
								value="${categories.name}">${categories.name}</option>
						</c:forEach>

					</form:select>
				</div>
			</div>
		</div>
		<div class="row push-md-6 col-md-3">

			<input style="margin-top: -200px; position: absolute;" type="submit"
				class="btn btn-danger mx-auto" value="Update">
		</div>
	</form>



</body>
</html>