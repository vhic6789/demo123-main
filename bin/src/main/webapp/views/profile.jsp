<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/temp/user/_menu.jsp"%>

<div class="container" style="margin-top: 30px">

	<form action="/user/profile" method="GET">
		<div class="p-1 bg-light rounded rounded-pill shadow-sm mb-4">
			<div class="input-group">
				<input name="name" type="search"
					placeholder="Nhập username tìm kiếm?"
					aria-describedby="button-addon1"
					class="form-control border-0 bg-light">
				<div class="input-group-append">
					<button id="button-addon1" type="submit" class="btn text-primary">
						<i class="fa fa-search">Tìm kiếm</i>
					</button>
				</div>
			</div>
		</div>
	</form>

	<div class="row">
		<div class="col-md-3 border-right">
			<div
				class="d-flex flex-column align-items-center text-center p-3 py-5">
				<img class="rounded-circle mt-5" src="/images/avata.jpg"
					height="250px" width="100%"><span class="font-weight-bold">${requestname.getUsername() }
					#${requestname.getId() }</span><span class="text-black-50">Uy tín:
					${requestname.getDiemgiaodich() }%</span><span> </span>
			</div>
		</div>

		<div class="col-md-9 border-right">
			<div class="p-3 py-5">
				<div class="d-flex justify-content-between align-items-center mb-3">
					<h4 class="text-right">Cài đặt</h4>
				</div>
				<div class="row mt-2">
					<div class="col-md-6">
						<label class="labels">Username</label><input type="text"
							class="form-control" placeholder=""
							value="${requestname.getUsername() }" disabled>
					</div>
					<div class="col-md-6">
						<label class="labels">Id</label><input type="text"
							class="form-control" value="${requestname.getId() }"
							placeholder="" disabled>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-md-12">
						<label class="labels">Số điện thoại</label><input type="text"
							class="form-control" placeholder=""
							value="<c:if test='${status == 1 }'>${requestname.getSodienthoai() }</c:if>"
							disabled>
					</div>
					<!-- <div class="col-md-12"><label class="labels">Address</label><input type="text"
                                class="form-control" placeholder="enter address" value=""></div> -->
					<div class="col-md-12">
						<label class="labels">Email</label><input type="text"
							class="form-control" placeholder=""
							value="<c:if test='${status == 1 }'>${requestname.getEmail() }</c:if>"
							disabled>
					</div>
					<div class="col-md-12">
						<label class="labels">Ngày tham gia</label><input type="text"
							class="form-control" placeholder=""
							value="${requestname.getNgaythamgia() }" disabled>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-md-6">
						<label class="labels">Giao dịch đã tham gia</label><input
							type="text" class="form-control" placeholder=""
							value="${requestname.getGiaodichdathamgia() }" disabled>
					</div>
					<div class="col-md-6">
						<label class="labels">Giao dịch thành công</label><input
							type="text" class="form-control"
							value="${requestname.getGiaodichthanhcong() }" placeholder=""
							disabled>
					</div>
				</div>
				<!-- <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Save
                            Profile</button></div> -->
			</div>
		</div>

	</div>
</div>

<%@ include file="/temp/user/footer.jsp"%>
