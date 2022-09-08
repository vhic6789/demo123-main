<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/temp/user/_menu.jsp"%>

<div class="container">
	<input class="form-control" id="myInput" type="text"
		placeholder="Search..">

	<table class="tablereponsive" style="margin-top: 10px;">
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
					<td data-label="#">${ttgd.getMagiaodich() }</td>
					<td data-label="Nội dung">${ttgd.getTieude() }</td>
					<td data-label="Giá trị">${ttgd.getGia() }</td>
					<td data-label="Người tạo">${ttgd.getNguoitao() }</td>
					<td data-label="Trạng thái">${ttgd.getTrangthaichung() }</td>
					<td><a href="/user/mytrade/${ttgd.getId() }/active">Chi
							tiết</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- <button type="button" class="btn btn-primary" id="btnReloadData">Reload data</button> -->
	<ul class="pagination justify-content-end">
		<li class="page-item"><a class="page-link"
			href="/user/home?page=${pageNumber - 1 }">Trước</a></li>
		<li class="page-item"><a class="page-link"
			href="/user/home?page=${pageNumber }">${pageNumber }</a></li>
		<li class="page-item"><a class="page-link"
			href="/user/home?page=${pageNumber + 1 }">Tiếp</a></li>
	</ul>
	<!--Table-->
</div>

<%@ include file="/temp/user/footer.jsp"%>
