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
	<table class="table table-striped table-responsive-sm" style="width: 100%;">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nội dung</th>
				<th scope="col">Giá trị</th>
				<th scope="col">Người tạo</th>
				<th scope="col">Trạng thái</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody id="myTable">
			<c:forEach items="${ttgds }" var="ttgd">
				<tr>
					<td>${ttgd.getCode() }</td>
					<td>${ttgd.getTitle() }</td>
					<td>${ttgd.getPrice() }</td>
					<td>${ttgd.getCreateby() }</td>
					<c:if test="${ttgd.getStatusbuy() < 1}">
						<td>chưa duyệt</td>
					</c:if>
					<c:if test="${ttgd.getStatusbuy() > 0}">
						<td>đã duyệt</td>
					</c:if>
					<td>
						<form action="/admin/confirm" method="POST">
							<input type="hidden"
									name="${_csrf.parameterName }" value="${_csrf.token }">
							<c:if test="${ttgd.getStatusbuy() < 1}">
								<button name="id" value="${ttgd.getId() }" type="submit"
									class="btn btn-sm btn-success">Duyệt</button>
							</c:if>
							<c:if test="${ttgd.getStatusbuy() > 0}">
								<button name="id" value="${ttgd.getId() }" type="submit"
									class="btn btn-sm btn-danger">Hủy</button>
							</c:if>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<ul class="pagination justify-content-end">
		<li class="page-item"><a class="page-link"
			href="/admin/home?page=${pageNumber - 1 }">Trước</a></li>
		<li class="page-item"><a class="page-link"
			href="/admin/home?page=${pageNumber }">${pageNumber }</a></li>
		<li class="page-item"><a class="page-link"
			href="/admin/home?page=${pageNumber + 1 }">Tiếp</a></li>
	</ul>
</body>

</html>