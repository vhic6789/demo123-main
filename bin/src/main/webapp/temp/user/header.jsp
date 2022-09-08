<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/fileinclude/css/responsiveTable.css">
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
					<li class="nav-item"><a class="nav-link" href="/index">Home</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Tạo giao dịch </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="/user/seller">Bán</a> <a
								class="dropdown-item" href="/user/buyer">Mua</a>
						</div></li>


					<li class="nav-item"><a
						class="nav-link btn btn-primary text-white" type="button" href="#"
						data-toggle="modal" data-target="#myModalLogin">Đăng nhập</a></li>
					<li class="nav-item"><a
						class="nav-link btn btn-danger text-white" type="button" href="#"
						data-toggle="modal" data-target="#myModalResigter">Đăng ký</a></li>


				</ul>
			</div>

			<!-- The Modal -->
			<div class="modal" id="myModalLogin">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Thông tin đăng nhập</h4>
							<button type="button" class="close" data-dismiss="modal">×</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<form action="/j_spring_security_check" method="post">
								<label class="sr-only" for="usrname">Username</label>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1"><i
											class="fa fa-user"></i></span>
									</div>
									<input type="text" name="username" class="form-control"
										placeholder="Username" aria-label="Username"
										aria-describedby="basic-addon1">
								</div>


								<label class="sr-only" for="Password">Name</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon2"><i
											class="fa fa-key"></i></span>
									</div>
									<input id="Password" name="password" type="password"
										class="form-control" placeholder="Password"
										aria-label="Password" aria-describedby="basic-addon2">
								</div>

								<div class="input-group mb-2">
									<div class="form-check-inline">
										<label class="form-check-label"> <input
											type="checkbox" name="remember-me" class="form-check-input">Remember
										</label>
									</div>
								</div>

								<div class="modal-footer">
									<a href="#">quen mat khau?</a> <input type="hidden"
										name="${_csrf.parameterName }" value="${_csrf.token }">
									<button type="submit" class="btn btn-primary">Ok</button>
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Đóng</button>
								</div>
							</form>
						</div>

						<!-- Modal footer -->


					</div>
				</div>
			</div>


			<div class="modal" id="myModalResigter">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Thông tin đăng ký</h4>
							<button type="button" class="close" data-dismiss="modal">×</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<form action="/register" method="POST">
								<label class="sr-only" for="usrname">Username</label>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1"><i
											class="fa fa-user"></i></span>
									</div>
									<input name="username" type="text" class="form-control"
										placeholder="Tài khoản" aria-label="Username"
										aria-describedby="basic-addon1">
								</div>


								<label class="sr-only" for="">Password</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon2"><i
											class="fa fa-key"></i></span>
									</div>
									<input name="password" id="Password" type="password"
										class="form-control" placeholder="Mật khẩu"
										aria-label="Password" aria-describedby="basic-addon2">
								</div>

								<label class="sr-only" for="">PasswordAgain</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon2"><i
											class="fa fa-key"></i></span>
									</div>
									<input name="passwordagain" id="PasswordAgain" type="password"
										class="form-control" placeholder="Nhập lại mật khẩu"
										aria-label="Password" aria-describedby="basic-addon2">
								</div>

								<p class="text-danger">* số điện thoại trùng với tài khoản
									momo</p>
								<label class="sr-only" for="">Phonenumber</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon2"><i
											class="fa fa-key"></i></span>
									</div>
									<input name="phonenumber" id="sdt" type="text"
										class="form-control" placeholder="Số điện thoại"
										aria-label="Password" aria-describedby="basic-addon2">
								</div>

								<p class="text-danger">* gmail để lấy lại mật khẩu</p>
								<label class="sr-only" for="">Email</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon2"><i
											class="fa fa-key"></i></span>
									</div>
									<input name="email" id="gmail" type="text" class="form-control"
										placeholder="Gmail" aria-label="Password"
										aria-describedby="basic-addon2">
								</div>
								<div class="modal-footer">
									<input type="hidden" name="${_csrf.parameterName }"
										value="${_csrf.token }">
									<button type="submit" class="btn btn-primary">Ok</button>
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Đóng</button>
								</div>
							</form>
						</div>

						<!-- Modal footer -->


					</div>
				</div>
			</div>

		</nav>

	</div>