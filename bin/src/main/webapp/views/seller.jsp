<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/temp/user/_menu.jsp"%>

<div class="container">

	<c:if test="${not empty message }">
		<div style="position: fixed; left: 0px; top: 0px; width: 100%;"
			class="alert alert-danger" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>error!</strong> ${message }
		</div>
	</c:if>

	<form action="/user/seller" method="POST">

		<div class="border-right">
			<div class="p-3 py-5">
				<div class="d-flex justify-content-between align-items-center mb-3">
					<h4 class="text-right">Chủ đề bán</h4>
				</div>

				<div class="">
					<input name="title" type="text" class="form-control"
						placeholder="tiêu đề" value="">
				</div>

				<br>
				<div class="">
					<input name="buyname" type="text" class="form-control"
						placeholder="User đối tác" value="">
				</div>

				<br>
				<div class="">
					<input name="price" type="text" class="form-control"
						placeholder="Giá trị 400000đ" value="">
				</div>

				<br>
				<div>Phí: 1000đ</div>
				<br>

				<div class="d-inline-flex">
					<div class="">Thời lượng giao dịch:</div>
					<div class="">
						<select name="hour" id="hour">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select> giờ
					</div>
					<div class="">
						<select name="minutes" id="minutes">
							<option value="0">0</option>
							<option value="15">15</option>
							<option value="30">30</option>
							<option value="45">45</option>
						</select> phút
					</div>
				</div>
				<!-- </div> -->
				<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }">
				<div class="mt-5 text-center">
					<button class="btn btn-primary profile-button" type="submit">Bán</button>
				</div>
			</div>
		</div>
	</form>

</div>

<%@ include file="/temp/user/footer.jsp"%>
