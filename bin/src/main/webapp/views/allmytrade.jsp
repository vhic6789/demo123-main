<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/temp/user/_menu.jsp"%>

<div class="container">
	<c:if test="${not empty message}">
		<div style="position: fixed; left: 0px; top: 0px; width: 100%;"
			class="alert alert-success" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>success</strong>
		</div>
	</c:if>

	<table class="tablereponsive" style="margin-top: 10px;">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nội dung</th>
				<th scope="col">Giá trị</th>
				<th scope="col">Người tạo</th>
				<th scope="col">Ngày tạo</th>
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
					<td data-label="Ngày tạo">${ttgd.getNgaytao() }</td>
					<td data-label="Trạng thái">${ttgd.getTrangthaichung() }</td>
					<td><a href="/user/mytrade/${ttgd.getId() }/active">Xem</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- <button type="button" class="btn btn-primary" id="btnReloadData">Reload data</button> -->
	<ul class="pagination justify-content-end">
		<li class="page-item"><a class="page-link"
			href="/user/allmytrade?page=${pageNumber - 1 }">Trước</a></li>
		<li class="page-item"><a class="page-link"
			href="/user/allmytrade?page=${pageNumber }">${pageNumber }</a></li>
		<li class="page-item"><a class="page-link"
			href="/user/allmytrade?page=${pageNumber + 1 }">Tiếp</a></li>
	</ul>
	<!--Table-->
</div>

<%@ include file="/temp/user/footer.jsp"%>