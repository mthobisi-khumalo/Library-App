<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
<%@page import="edu.nagarro.service.impl.AuthorServiceImpl"%>
<%@page import="edu.nagarro.model.Author"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddProduct</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div style="text-align: center;">
		<nav class="navbar navbar-light navbar-expand-md"
			style="background-color: #000; color: #aaa;">
			<div class="container-fluid">
				<a class="navbar-brand text-light" href="#">LMS</a>
				<button data-bs-toggle="collapse" class="navbar-toggler"
					data-bs-target="#navcol-1">
					<span class="visually-hidden">Toggle navigation</span><span
						class="navbar-toggler-icon"></span>
				</button>

				<div
					class="collapse navbar-collapse d-lg-flex justify-content-lg-center"
					style="padding-left: 30%;">
					<h5 class="text-center">Library Management System</h5>
				</div>
				<div
					class="collapse navbar-collapse d-lg-flex justify-content-lg-end"
					id="navcol-1" style="padding-left: 10%;">
					<form action="logout" method="post">
						<strong>Hi, ${uname}</strong>
						<button type="submit" style="margin-left: 5px;"
							class="btn btn-info btn-sm ">Logout</button>
					</form>
				</div>
			</div>
		</nav>
	</div>
	<hr>
	<div class="row">
		<div class="col-10"
			style="text-align: center; width: 300px; margin: 0 auto;">
			<legend>
				<b><font size="5">Edit Book Details</font></b>
			</legend>
		</div>
		<div class="row container-fluid details" style="margin-top: 20px;">
			<div class="col-md-8 offset-md-4">
				<form action="editBook" method="post"
					enctype="application/x-www-form-urlencoded">
					<div class="form-group row mb-3">
						<label for="inputbookcode" class="col-sm-2 col-form-label">Book
							Code</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="bookId"
								placeholder="<%=request.getParameter("bookId")%>"
								readonly="readonly" value="<%=request.getParameter("bookId")%>">
						</div>
					</div>
					<div class="form-group row mb-3">
						<label for="bookName" class="col-sm-2 col-form-label">Book
							Name</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="bookName"
								value="<%=request.getParameter("bookName")%>" required>
						</div>
					</div>
					<div class="form-group row mb-3">
						<label for="authorName" class="col-sm-2 col-form-label">Author</label>
						<div class="col-sm-4">
							<select class="form-select" name="authorName"
								aria-label="Choose Author">
								<%
								Author[] listAuthor = (Author[]) new AuthorServiceImpl().getAuthor();
								for (Author author : listAuthor) {
								%>
								<option><%=author.getAuthorName()%></option>
								<%
								}
								%>
							</select>
						</div>
					</div>

					<div class="form-group row mb-3">
						<label for="currentDate" class="col-sm-2 col-form-label">Added
							on</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" readonly name="currentDate"
								value="<%=request.getParameter("currentDate")%>">
						</div>
					</div>
					<div>
						<button type="submit" class="btn btn-primary btn-md ">Update
							Book</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

