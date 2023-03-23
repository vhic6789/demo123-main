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
								<td>Người thuê</td>
								<td>${mytrade.getNguoimua() }</td>
							</tr>
							<tr>
								<td>Người làm</td>
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

		<table class="table">
				<tbody>
					<tr>
						<td>${mytrade.getNguoimua() }(Người thuê)</td>
						<td>${mytrade.getTrangthaimua()} </td>
					</tr>
					<tr>
						<td>Thời gian</td>
						<td>${mytrade.getSophutconlai() } phút</td>
					</tr>
					<tr>
						<td>${mytrade.getNguoiban() }(Người làm)</td>
						<td>${mytrade.getTrangthaiban() }</td>
					</tr>
					<tr>
						<td>ADMIN</td>
						<td>
							<c:if test="${empty message }">
								<div class="msg to">
									Giao dịch bắt đầu
								</div>
							</c:if>
							
						</td>
					</tr>
					<tr>
						<td>Chuyển khoản</td>
						<td style='color: red;'>Số tiền: ${mytrade.getTongtien() }<br> Nội dung: ${mytrade.getMagiaodich() }<br>
							${chuyenkhoan }</td>
					</tr>
				</tbody>
			</table>
			<img src="/images/nganhang.jpg" height="350" width="300" alt="">
						<section>
				<button class="chat-btn">
					<i class="material-icons"> comment </i>
				</button>
				<div class="chat-popup">
					<div class="chat-area">
						<c:forEach var="cmt" items="${cmts }">
								<c:if test="${cmt.getCreateby() == mytrade.getNguoimua() }">
									<div class="income-msg">
										<img src="/images/avata.jpg" class="avatar" alt="">
										<span class="msg">${cmt.getContents() }</span>
									</div>
								</c:if>
								<c:if test="${cmt.getCreateby() == mytrade.getNguoiban() }">
									<div class="out-msg">
											<span class="my-msg">${cmt.getContents() }</span>
											<img src="/images/avata.jpg" class="avatar" alt="">
									</div>
								</c:if>
	
						</c:forEach>
					</div>
					<form id="formcmt" action="/user/mytrade" method="POST">
						<div class="input-area">
							<input name="id" value="${mytrade.getId() }" type="hidden">
							<input name="contents" type="text" placeholder="...message" />
							<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
							<button class="submit"> <i class="material-icons">send</i></button>
						</div>
						<br>
						<div class="btn-group" style="width: 100%">

							<button name="khieunai" value="-3" type="submit" class="btn btn-sm btn-danger">Khiếu
								nại</button>
							<button name="huygiaodich" value="-2" type="submit" class="btn btn-sm btn-warning">Hủy giao
								dịch</button>
							<button name="xacnhan" value="1" type="submit" class="btn btn-sm btn-success">Xác
								nhận</button>
						</div>
					</form>
				</div>
			</section>
			
	</c:if>

</div>

<%@ include file="/temp/user/footer.jsp"%>
