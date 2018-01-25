<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap-select.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/global.css"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/static/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="fragments/header.jsp"></jsp:include>

	<div class="container">

		<div class="row">
			<h1>Subscriber</h1>
		</div>

		<spring:url value="/subscribe/reviewsubscriber" var="formUrl" />

		<form:form action="${formUrl}" method="POST" modelAttribute="subscriber">

			<div class="row">

				<div class="form-group">
					<label for="resource-fullname">Name</label>
					<form:input path="fullname" cssClass="form-control" id="subscriber-fullname" />
				</div>
				
				
				<div class="form-group">
					<label for="email">Email</label>
					<form:input path="email" cssClass="form-control" name="email"
						id="subscriber-email" />
				</div>
				<div class="form-group">
					<label for="cost">Contact</label>
					<form:input path="contact" cssClass="form-control" name="contact"
						id="subscriber-contact" />
				</div>
				
				<div class="form-group">
					<label for="categories"> Category : </label>
					<form:select path="categories" name="categoryName"  cssClass="col-sm-4 form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${categories}" itemValue="name"
							itemLabel="name" />
					</form:select>
				</div>

				<button type="submit" class="btn btn-default">Submit</button>

			</div>

		</form:form>

	</div>
</body>
</html>