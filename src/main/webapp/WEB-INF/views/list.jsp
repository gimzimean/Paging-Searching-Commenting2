<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
	<table>
		<tr>
			<td colspan="5" align="right"><a href="input">글쓰기</a></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.bno }</td>
				<td><a class="read1" href="${board.bno}">${board.title}(${board.replycount})</a></td>
				<td>${board.writer }</td>
				<td><fmt:formatDate value="${board.regdate }" /></td>
				<td>${board.readcount }</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="5" align="center">
				<form id='searchForm' action="/list" method='get'>
					<select name='type'>
						<option value=""
							<c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
						<option value="T"
							<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
						<option value="C"
							<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
						<option value="W"
							<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
						<option value="TC"
							<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목
							or 내용</option>
						<option value="TW"
							<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목
							or 작성자</option>
						<option value="TWC"
							<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}"/>>제목
							or 내용 or 작성자</option>
					</select> 
					<input type='text' name='keyword' value="${pageMaker.cri.keyword}">
					<input type='hidden' name='page' value="${pageMaker.cri.page}" > 
					<input type='hidden' name='perPageNum' value="${pageMaker.cri.perPageNum}">
					<button class='btn btn-default'>Search</button>
				</form>
			</td>
		</tr>

		<tr>
			<td id="pagenate" colspan="5" align="center"><c:if
					test="${pageMaker.prev }">
					<a href="${pageMaker.startPage-1}">이전</a>
				</c:if> <c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage}" var="i">
					<c:choose>
						<c:when test="${pageMaker.cri.page==i}">${i }</c:when>
						<c:otherwise>
							<a href="${i }">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> <c:if test="${pageMaker.next }">
					<a href="${pageMaker.endPage+1 }">다음</a>
				</c:if></td>
		</tr>
	</table>

	<form id="jobForm">
		<input type="hidden" name="page" value="${pageMaker.cri.page}">
		<input type="hidden" name="perPageNum" value="${pageMaker.cri.perPageNum}">
		<input type='hidden' name='type' value="${pageMaker.cri.type}">
		<input type='hidden' name='keyword' value="${pageMaker.cri.keyword}">
	</form>

	<script type="text/javascript">
		var jobForm = $("#jobForm");
		var searchForm = $("#searchForm")

		$("#pagenate a").on("click", function(event) {
			event.preventDefault();

			var targetPage = $(this).attr("href");

			jobForm.find("[name='page']").val(targetPage);
			jobForm.attr("action", "/list").attr("method", "get");
			jobForm.submit();
		});

		$(".read1").on(
				"click",
				function(event) {
					event.preventDefault();

					jobForm.append("<input type='hidden' name='bno' value='"
							+ $(this).attr("href") + "'>");
					jobForm.attr("action", "/update").attr("method", "get");
					jobForm.submit();
		});
		
		$("#searchForm button").on("click",function(event){
			event.preventDefault();
			
			if(!searchForm.find("option:selected").val()){
				alert("검색종류를 선택하세요");
				return false;
			}
			
			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}
			searchForm.find("input[name='page']").val(1);
			searchForm.submit();
		});
	</script>

</body>
</html>