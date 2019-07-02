<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>게시판관리</title>
<style>
.lprodTr:hover {
	cursor: pointer;
}
</style>
<script>
	$(document).ready(function () {
		if ($(".update_use_yn").val() == "true") {
			$(".updateUse_yn").val("true");
		}

		$("#createClick").on("click", function() {
			if ($("#create_use_yn").val() == "true") {

				$("#use_yn").val("true");
			}
			if ($("#createBoardName").val() == "") {
				alert("게시판 이름을 입력해주세요");
				return;
			} else {
				$("#createFrm").submit();
			}
		})
		$('#create_use_yn').change(function() {
			if ($(this).val == "") {
				$(this).val("true");
			}
			var option = $(this).val();
			$("#use_yn").val(option);
		});
		$('.update_use_yn').change(function() {
			if ($(this).val == "") {
				$(this).val("true");
			}
			var option = $(this).val();
			alert($(this).val())
			$(".updateUse_yn").val(option);
		});
	})
</script>
<div class="row">
	<div class="col-sm-8 blog-main">
		<form id="createFrm" class="navbar-form navbar-right" id="createfrm"
			action="/board/createBoard" method="post">
			<input type="text" class="form-control" id="createBoardName"
				name="createBoardName" placeholder="게시판 이름"> <select
				class="form-control" id="create_use_yn">
				<option value="true">사용</option>
				<option value="false">미사용</option>
			</select> <input type="hidden" id="use_yn" name="use_yn"> <input
				type="hidden" id="user_info" name="user_info"
				value="${USER_INFO.userId }"> <input type="button"
				id="createClick" class="form-control" value="게시판 생성">
		</form>
		<h2 class="sub-header">게시판관리</h2>

		<form id="frm"
			action="${pageContext.request.contextPath}/board/boardManager"
			method="post"></form>

		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>게시판 이름</th>
						<th>생성자</th>
						<th>생성일시</th>
						<th>사용여부</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="" class="text-center">
			<table class="table table-striped">
				<c:if test="${boardAllList != null }">
					<c:forEach items="${boardAllList}" var="board">
						<tr class="updateTr">
							<td>${board.name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>${board.userId }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><fmt:formatDate value="${board.reg_dt }"
									pattern="yyyy-MM-dd" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td class="updateTd">
								<form class="navbar-form navbar-right" class="updateBoard"
									action="/board/updateBoard" method="post">
									<select class="update_use_yn">
										<c:choose>
											<c:when test="${board.use_yn == 'true' }">
												<option value="true" selected="selected">사용</option>
												<option value="false">미사용</option>
											</c:when>
											<c:otherwise>
												<option value="true">사용</option>
												<option value="false" selected="selected">미사용</option>
											</c:otherwise>
										</c:choose>
									</select> <input type="hidden" class="updateUse_yn" name="updateUse_yn">
									<input type="hidden" name="id" value="${board.id }"> <input
										type="hidden" id="userId" value="${USER_INFO.userId}">
									<input type="submit" class="form-control" value="게시판 수정">
								</form>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
</div>