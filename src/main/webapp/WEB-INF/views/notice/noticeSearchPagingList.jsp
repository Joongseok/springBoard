<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>${boardVo.name }</title>


<style>
	.noticeTr:hover{
		cursor: pointer;
	}
</style>

<script>
	$(document).ready(function (){
		//  tr태그 이벤트 등록
		$(".noticeTr").on("click", function(){
			console.log("noticeTr click");
			
			var notiId = $(this).find(".idHidden").val();
			$("#notiId").val(notiId);
			var del_yn = $(this).find(".del_ynHidden").val();
			$("#del_yn").val(del_yn);
			
			//#frm 을 이용하여 submit();
			if( $("#del_yn").val() == "true"){
				$("#frm").submit();
			}
		});
		$("#select").change(function (){
			$("#selected").val($(this).val())
		});
		$("#btnSearch").on("click", function (){
			
// 			$("#search").submit();
		});
		
	});
</script>
<div class="row">
					<div class="col-sm-8 blog-main">
					<form id="search" action="${pageContext.request.contextPath}/notice/search">
						<select id="select">
							<option value="content">게시글</option>
							<option value="title">제목</option>
						</select>
						<div class="col-lg-6">
						    <div class="input-group">
						      <input type="text" class="form-control" name="search" placeholder="Search for...">
						      <input type="hidden" id="selected" name="selected"/>
						      <input type="hidden" name="boardId" value="${boardVo.id}">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="button" id="btnSearch">Search!</button>
						      </span>
						    </div><!-- /input-group -->
						  </div><!-- /.col-lg-6 -->
					  </form>
						<h2 class="sub-header">검색 내용 : ${searchMap.search}</h2>
						<!-- 사용자 상세 조회 : userId가 필요 -->
						<form id="frm" action="${pageContext.request.contextPath}/notice/noticeDetail" method="get">
							<input type="hidden" id="notiId" name="notiId">
							<input type="hidden" id="del_yn" name="del_yn">
						</form>
						
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일시</th>
								</tr>
								<c:forEach items="${noticeList}" var="notice" >
									<tr class="noticeTr">
									
										<td class="notiId"><form>
										<input type="hidden" class="idHidden" value="${notice.notiId}">
										<input type="hidden" class="del_ynHidden" value="${notice.del_yn}">
									</form>${notice.rn}</td>
										<td>
										 	<c:choose>
										 		<c:when test="${notice.lv > 1 }">
										 			<c:forEach begin="1" end="${notice.lv }">
										 				&nbsp;&nbsp;&nbsp;&nbsp;
											 		</c:forEach>
										 		┗▶
											 		${notice.title}
										 		</c:when>
										 		<c:otherwise>
											 		${notice.title}
										 		</c:otherwise>
										 	</c:choose>
										 </td>
										<td>${notice.userId}</td>
										<td><fmt:formatDate value="${notice.reg_dt }" pattern="yyyy-MM-dd a h:mm:ss"/> </td>
									</tr>
								</c:forEach>
							</table>
						</div>

	
					<a class="btn btn-default pull-right" href="${pageContext.request.contextPath }/notice/noticeForm?id=${searchMap.id}">게시글 작성</a>
						<div class="text-center">
								<!--  내가 현재 몇번째 페이지에 있는가? -->
							 <ul class="pager">
								<c:choose> 
									<c:when test="${searchMap.page  == 1}">
										<li class="disabled"><span>«</span></li>
										<li class="disabled"><span>Previous</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/notice/search?page=${1}&pageSize=${searchMap.pageSize}&id=${searchMap.id}">«</a></li>
										<li><a href="${pageContext.request.contextPath}/notice/search?page=${searchMap.page - 1 }&pageSize=${searchMap.pageSize}&id=${searchMap.id}">Previous</a></li>
									</c:otherwise>
								</c:choose>
									
								<c:forEach var="i" begin="1" end="${paginationSize}">
									<li> 
									<c:choose>    
										<c:when test="${searchMap.page == i}">
											<li class="active" ><span>${i }</span> </li>
										</c:when>
										<c:when test="${searchMap.page != i}">
											<a href="${pageContext.request.contextPath}/notice/search?page=${i}&pageSize=${searchMap.pageSize}&id=${searchMap.id}">${i}</a>
										</c:when>
									</c:choose>
									</li>
								</c:forEach>
								
								<c:choose> 
									<c:when test="${searchMap.page  == paginationSize}">
										<li class="disabled"><span>next</span></li>
										<li class="disabled"><span>»</span></li>
									</c:when>
									<c:otherwise>
										<li class="page-item" ><a href="${pageContext.request.contextPath}/notice/search?page=${searchMap.page + 1 }&pageSize=${searchMap.pageSize}&id=${searchMap.id}">next</a></li>
										<li class="page-item" ><a href="${pageContext.request.contextPath}/notice/search?page=${paginationSize}&pageSize=${searchMap.pageSize}&id=${searchMap.id}">»</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						
						</div>
					</div>
				</div>