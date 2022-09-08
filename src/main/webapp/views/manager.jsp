<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

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



</head>

<body>
	<table>
		<tr>
			<td>sdt</td>
			<td>${getSdt }</td>
		</tr>
	</table>
	<br>
	<form action="/admin/updatemomo" method="POST">
		<input type="hidden" name="${_csrf.parameterName }"
			value="${_csrf.token }"> <input type="text" name="sdt"
			placeholder="số điện thoại">
		<button type="submit" class="btn btn-sm btn-success">Lưu</button>
	</form>
	<br>
	<p>tìm kiếm phương thức thanh toán</p>
	<form action="/admin/manager" method="GET">
		<input type="text" name="username">
		<button type="submit" class="btn btn-sm btn-success">Tìm kiếm</button>
	</form>
	<c:if test="${ttcn != null }"></c:if>
	<table>
		<tr>
			<td>id</td>
			<td>${ttcn.getId() }</td>
		</tr>
		<tr>
			<td>username</td>
			<td>${ttcn.getUsername() }</td>
		</tr>
		<tr>
			<td>sdt</td>
			<td>${ttcn.getSodienthoai() }</td>
		</tr>
		<tr>
			<td>email</td>
			<td>${ttcn.getEmail() }</td>
		</tr>
		<tr>
			<td>Ngân Hàng</td>
			<td>${stk }</td>
		</tr>
	</table>
</body>

</html>