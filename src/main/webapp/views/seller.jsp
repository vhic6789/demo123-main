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
						placeholder="Username đối tác" value="">
				</div>

				<br>
				<div class="">
					<input name="price" type="text" class="form-control"
						placeholder="Giá trị 400000đ" value="">
				</div>

				<br>
				<div>Phí: 5000đ</div>
				<br>

				<div class="d-inline-flex">
					<div class="">Thời lượng giao dịch:</div>
					<div class="">
						<select name="hour" id="hour">
							
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
<script>
	var elementHour = document.getElementById("hour");
	var elems = "";
	for (let i = 0; i < 72; i++)
		elems += "<option value='"+i+"'>" + i + "</option>";
	elementHour.innerHTML = elems;
</script>
<%@ include file="/temp/user/footer.jsp"%>
