<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시글 수정</h2>
						<form id="frm" class="form-horizontal" action="${pageContext.request.contextPath}/notice/updateNotice" 
						method="post" role="form"
						enctype="multipart/form-data"
						>
							<div class="form-group">
							<label for="userId" class="col-sm-2 control-label"></label>		
								<div class="col-sm-10">
									<%@include file="/SE2/updateIndex.jsp" %>
								</div>
							</div>
						</form>
					</div>
				</div>