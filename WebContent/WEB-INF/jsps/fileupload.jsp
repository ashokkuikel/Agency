<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css"
	type="text/css" />
</head>
<body>

	<div class="jumbotron text-center">
		<h2>Spring Hibernate - File Upload</h2>
	</div>

	<div class="container">
		<div class="row">
			<div class="cards mx-auto">
				<form action="${pageContext.request.contextPath}/uploadFile"
					method="post" enctype="multipart/form-data">

					<div class="form-group">

						<div>
							<label> Categories : </label>
							<form:select path="categories" name="categoryName">
								<form:option value="NONE" label="--- Select ---" />
								<form:options items="${categories}" itemValue="name"
									itemLabel="name" />
							</form:select>
						</div>
						<div>
							<label>Pick file #1 : </label> <input class="btn btn-default"
								type="file" name="fileUpload" size="50" />
						</div>
						<div>
							<input class="btn btn-primary" type="submit" value="Upload" />

						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>