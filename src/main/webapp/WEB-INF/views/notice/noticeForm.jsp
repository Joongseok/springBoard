<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function() {
		$("#plus").on("click", function() {
			$("#file").click();
		});
	});
</script>
<title>게시글 등록</title>
<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시글 등록</h2>

						<form id="frm" class="form-horizontal"
							action="${pageContext.request.contextPath}/notice/noticeForm"
							method="post" role="form" enctype="multipart/form-data">
							<div class="form-group">
								<label for="userId" class="col-sm-2 control-label"></label>
								<div class="col-sm-10">
									<%@include file="/SE2/index.jsp"%>
								</div>
							</div>
						</form>
					</div>
				</div>