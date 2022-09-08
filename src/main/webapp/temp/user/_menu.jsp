<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">

<head>
<title>${titlePage }</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/fileinclude/css/responsiveTable.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!--  -->

<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>

<body>

	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-white">
			<a class="navbar-brand" href="#">CAR DEALER</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto topnav">
					<li class="nav-item"><a class="nav-link" href="/user/home?page=1">Home</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Tạo giao dịch </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="/user/seller">Bán</a> <a
								class="dropdown-item" href="/user/buyer">Mua</a>
						</div></li>

					<li class="nav-item"><a class="nav-link" href="/user/thongbao">Thông
							báo</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/user/allmytrade?page=1">Giao dịch của tôi(<span id="noti"></span>)
					</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">${pageContext.request.remoteUser } </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item"
								href="/user/profile?name=${pageContext.request.remoteUser }&change=0">Thông
								tin cá nhân</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item"
								href="javascript: document.logoutForm.submit()">Đăng xuất</a>
							<form name="logoutForm" action="/logout" method="post"
								hidden="true">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> <input hidden type="submit"
									value="Sign Out" />
							</form>
						</div></li>


				</ul>
			</div>

		</nav>

	</div>