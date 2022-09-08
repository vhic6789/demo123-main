<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/temp/user/_menu.jsp"%>

<div class="container">

	<c:if test="${not empty error}">
		<div style="position: fixed; left: 0px; top: 0px; width: 100%;"
			class="alert alert-danger" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>error!</strong> ${error }
		</div>
	</c:if>

	<div id="accordion">
		<div class="card">
			<div class="card-header">
				<a class="card-link" data-toggle="collapse" href="#collapse">
					Thông tin giao dịch </a>
			</div>
			<div id="collapse" class="collapse" data-parent="#accordion">
				<div class="card-body">
					<table class="table table-striped w-auto" style="margin: auto;">
						<tbody>
							<tr class="table-info">
								<td>#</td>
								<td>${mytrade.getMagiaodich() }</td>
							</tr>
							<tr>
								<td>Ngày tạo</td>
								<td>${mytrade.getNgaytao() }</td>
							</tr>
							<tr>
								<td>Tiêu đề</td>
								<td>${mytrade.getTieude() }</td>
							</tr>
							<tr>
								<td>Người mua</td>
								<td>${mytrade.getNguoimua() }</td>
							</tr>
							<tr>
								<td>Người bán</td>
								<td>${mytrade.getNguoiban() }</td>
							</tr>
							<tr>
								<td>Giá trị</td>
								<td>${mytrade.getGia() }</td>
							</tr>
							<tr>
								<td>Phí</td>
								<td>${mytrade.getPhi() }</td>
							</tr>
							<tr>
								<td>Thời lượng giao dịch</td>
								<td>${mytrade.getSophutgiaodich() } phút</td>
							</tr>
							<tr>
								<td>Trạng thái</td>
								<td><c:if test="${empty message }">
									${mytrade.getTrangthaichung() }
									</c:if> <c:if test="${not empty message }">
										<c:out value="${'Giao dịch chưa bắt đầu '}" />
									</c:if></td>
							</tr>
						</tbody>
						<!--Table body-->


					</table>
				</div>
			</div>
		</div>
	</div>
	<br>

	<c:if test="${mytrade.getStatus() == 1 }">

		<div class="row">
			<div class="col msg-window-container">

				<div class="card" id="msgWindow">
					<div class="d-flex font-weight-bold"
						style="background: Gainsboro; font-size: 12px;">
						<div class="p-2 flex-fill">Người mua:
							${mytrade.getTrangthaimua() }</div>
						<div class="p-2 flex-fill text-center">${mytrade.getSophutconlai() }
							phút</div>
						<div class="p-2 flex-fill text-right">${mytrade.getTrangthaiban() }
							:Người bán</div>
					</div>

					<div class="card-body" id="msgs"
						style="height: 300px; overflow: scroll;">
						<div class="msg to">
							<span class='text-danger font-weight-bold'>admin</span>:Giao dịch
							chưa bắt đầu <br> Người mua chuyển ${mytrade.getTongtien() } kèm nội dung ${mytrade.getMagiaodich() }
							tới tài khoản Momo: ${chuyenkhoan }
							<p>Người mua: <span class='text-success font-weight-bold'>${mytrade.getNguoimua() }</span></p>
							<p>Người bán: <span class='text-success font-weight-bold'>${mytrade.getNguoiban() }</span></p>
							<p>Momo người bán: <span class='font-weight-bold'>**********</span></p>
							<p>Ngân Hàng người bán: <span class='font-weight-bold'>**********</span></p>
						</div>
						<c:if test="${empty message }">
							<div class="msg to">
								<span class='text-danger font-weight-bold'>admin</span>:Giao
								dịch bắt đầu
							</div>
						</c:if>
						<c:forEach var="cmt" items="${cmts }">
							<c:if test="${cmt.getCreateby() == mytrade.getNguoimua() }">
								<div class="msg to">
									<span class='text-success font-weight-bold'>${mytrade.getNguoimua() }</span>:
									${cmt.getContents() }
								</div>
							</c:if>
							<c:if test="${cmt.getCreateby() == mytrade.getNguoiban() }">
								<div class="msg to text-right">${cmt.getContents() }
									:<span class='text-success font-weight-bold'>${mytrade.getNguoiban() }</span>
								</div>
							</c:if>
						</c:forEach>
					</div>
					
						<form id="formcmt" action="/user/mytrade" method="POST">
							<div class="card-footer">
								<div class="input-group" id="msgForm" data-sender="me">
									<input name="id" value="${mytrade.getId() }" type="hidden">
									<input name="contents" class="form-control" type="text"
										placeholder="...message" /> <input type="hidden"
										name="${_csrf.parameterName }" value="${_csrf.token }">
									<div class="input-group-append">
										<button class="btn btn-outline-secondary" type="submit">Gửi</button>
									</div>
								</div>
							</div>
							<br>
							<div class="btn-group" style="width: 100%">
								<button name="huygiaodich" value="-2" type="submit"
									class="btn btn-sm btn-warning">Hủy giao dịch</button>
								<button name="khieunai" value="-3" type="submit"
									class="btn btn-sm btn-danger">Khiếu nại</button>
								<button name="xacnhan" value="1" type="submit"
									class="btn btn-sm btn-success">Xác nhận</button>
							</div>
						</form>
					
				</div>
			</div>
		</div>
	</c:if>

</div>

<%@ include file="/temp/user/footer.jsp"%>
