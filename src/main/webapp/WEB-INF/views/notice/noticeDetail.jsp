<%@page import="kr.or.ddit.notice.model.NoticeVO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	.hiddenFile{
	visibility: hidden;
	}
</style>
<script>
$("#content").val();
$(document).ready(function (){
	$("#commentBtn").on("click", function (){
		alert("commentBtn");
		$("#commentForm").submit();
		
	})
	
	$(".fileLabel").on("click", function(){
		alert("fileLable");
		$("#fileId").val($(this).next().next().val())
		$("#frm").submit();
	});
	
	$("#plus").on("click", function () {
		$("#file").click();
	});
	
});
</script>
<title>게시글 조회</title>
<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시글 조회</h2>
							
						<form id="frm" class="form-horizontal" action="${pageContext.request.contextPath}/notice/fileDownload" 
						method="post" role="form"
						>
							<input type="hidden" class="hiddenFile" name="fileId" id="fileId" >

							<div class="form-group">
								<label for="userId" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<label class="control-label">${notiDeatilMap.noticeVo.title}</label>
								</div>
							</div>
							
							<div class="form-group">
							<label for="userId" class="col-sm-2 control-label">내용</label>		
								<div class="col-sm-10">
									${notiDeatilMap.noticeVo.content }
								</div>
							</div>
							<div class="form-group">
							<label for="userId" class="col-sm-2 control-label">첨부파일</label>		
								<div class="col-sm-8">
								<c:forEach items="${notiDeatilMap.uploadFileList}" var="file">
									<label class="fileLabel">${file.fileName }</label><br>
									<input type="hidden" class="hiddenFile" name="files" value="${file.fileId}">
								</c:forEach>
								</div>
							</div>
							<div class="form-group">
								<label for="userId" class="col-sm-2 control-label">댓글</label>
								<div class="col-sm-6">
								<c:forEach items="${notiDeatilMap.ntcList }" var="comment">
									<label class="control-label">${comment.content} [${comment.userId }/ <fmt:formatDate value="${comment.reg_dt }" pattern="yyyy-MM-dd"/> ]</label>
										
										<c:if test="${comment.del_yn eq true && comment.userId eq USER_INFO.userId}">
										<a href="${pageContext.request.contextPath }/noti_commnet/deleteComment?notiId=${notiDeatilMap.noticeVo.notiId}&userId=${USER_INFO.userId}&id=${comment.id}">
										<button  type="button" class="btn btn-default">댓글 삭제</button> </a>
										</c:if>
										<br>
									</c:forEach>
								</div>
							</div>
							</form>
							<form id="commentForm"  class="form-horizontal" action="${pageContext.request.contextPath }/noti_commnet/createComment" method="post">
								<div class="form-group">
									<label for="userId" class="col-sm-2 control-label"></label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="comment"
											name="comment" placeholder="댓글">
										<input type="hidden" name="cntNotiId" value="${notiDeatilMap.noticeVo.notiId}">
									</div>
										<input id="commentBtn" type="button" class="btn btn-default" value="댓글저장">
								</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<c:if test="${notiDeatilMap.noticeVo.userId eq USER_INFO.userId }">
										<a href="${pageContext.request.contextPath }/notice/updateNotice?notiId=${notiDeatilMap.noticeVo.notiId}"><button  type="button" class="btn btn-default">수정하기</button> </a>
										<a href="${pageContext.request.contextPath }/notice/deleteNotice?notiId=${notiDeatilMap.noticeVo.notiId}"><button  type="button" class="btn btn-default">삭제하기</button> </a>
									</c:if>
										<a href="${pageContext.request.contextPath }/notice/replyNotice?notiId=${notiDeatilMap.noticeVo.notiId}"><button type="button" id="replyBtn" class="btn btn-default">답글</button> </a>
								</div>
							</div>
							<input type="hidden" id="userId" value="${USER_INFO.userId }"> 
						</form>
					</div>
				</div>
