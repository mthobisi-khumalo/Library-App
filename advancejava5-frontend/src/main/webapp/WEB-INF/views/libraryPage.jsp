<%@page import="edu.nagarro.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
table {
	width: 100%;
	border: 1px solid black;
}

table td {
	border: 1.5px solid black;
	text-align: center;
}
</style>
<!-- Main css -->
<link type="text/css" rel="stylesheet" href="../resources/css/style.css">
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

	<div class="mb-4" style="position: relative">

		<div class="row">

			<div class="col-md-8 offset-sm-2">

				<div class="card auth">

					<div class="row">
						<div class="col-sm-6 pt-2">
							<h6 class="text-left">Books Listing</h6>
						</div>
						<div class="col-sm-2 offset-sm-4">
							<a href="addBook"><button type="submit"
									class="btn btn-primary btn-md ">Add a Book</button></a>
						</div>
					</div>

					<div class="card-body auth-card2">
						<div class="table-responsive text-center">
							<table class="table">
								<thead style="background-color: #000; color: #aaa;">
									<tr>
										<td>Book Code</td>
										<td>Book Name</td>
										<td>Author</td>
										<td>Date Added</td>
										<td>Actions</td>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="p" items="${bookArray}" varStatus="status">
										<tr>
											<td>${p.getBookId() }</td>
											<td>${p.getBookName()}</td>
											<td>${p.getAuthorName()}</td>
											<td>${p.getCurrentDate()}</td>

											<td><a
												href="editBook?bookId=${p.getBookId()}&bookName=${p.getBookName()}&currentDate=${p.getCurrentDate()}"
												style="cursor: pointer;"><svg
														xmlns="http://www.w3.org/2000/svg" width="1.5em"
														height="1.5em" fill="currentColor" viewBox="0 0 16 16"
														class="bi bi-pencil-square mr-3">
                                                    <path
															d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z">
                                                    </path>
                                                    <path
															fill-rule="evenodd"
															d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z">
                                                    </path>
                                                </svg></a> <a
												href="deleteBook?bookId=${p.getBookId()}"
												style="cursor: pointer;"><svg
														xmlns="http://www.w3.org/2000/svg" width="1.5em"
														height="1.5em" fill="currentColor" viewBox="0 0 16 16"
														class="bi bi-trash">
                                                    <path
															d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z">
                                                    </path>
                                                    <path
															fill-rule="evenodd"
															d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z">
                                                    </path>
                                                </svg></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>