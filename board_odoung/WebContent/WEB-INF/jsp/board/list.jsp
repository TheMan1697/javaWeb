<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <%@ include file="../common/head.jsp" %>
    </head>
    <body class="sb-nav-fixed">
        <%@ include file="../common/nav.jsp" %>
        <main class="mt-5 pt-5">
            <div class="container-fluid px-4">
                <h1 class="mt-4">Board</h1>
                <div class="card mb-4">
                    <div class="card-header">
                    	<a class="btn btn-primary float-end" href="register${page.criteria.params2}">
                        <i class="fas fa-edit"></i>
                        Write
                        </a>
                        <div class="col-2">
                       		<select class="form-select form-amount">
							  <option ${page.criteria.amount == 5 ? 'selected' : '' } value="5">5개씩 보기</option>
							  <option ${page.criteria.amount == 10 ? 'selected' : '' } value="10">10개씩 보기</option>
							  <option ${page.criteria.amount == 25 ? 'selected' : '' } value="25">25개씩 보기</option>
							  <option ${page.criteria.amount == 50 ? 'selected' : '' } value="50">50개씩 보기</option>
							</select>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
									<th>글번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>조회수</th>
									<th>등록일</th>
								</tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${boards}" var="board">
								<tr>
									<td>${board.bno}</td>
									<td><a href="get${page.criteria.params2}&bno=${board.bno}">${board.title}</a><span class="text-secondary small">[${board.replyCnt}]</span></td>
									<td ${empty board.writer ? 'class="text-muted small"' : ''}>${empty board.writer ? '(나간 놈)' :board.writer}</td>
									<td>${board.hitcount}</td>
									<td>${board.regDate}</td>
								</tr>
							</c:forEach>
                            </tbody>
                        </table>
                        <div class="">
                       	 <ul class="pagination justify-content-center">
                       	 <c:if test="${page.prev}">
                        			<li class= "page-item"><a class="page-link" href="list${page.criteria.params}&pageNum=${page.criteria.pageNum-1}">prev</a></li>
                       	 </c:if>
                        		<c:forEach begin="${page.start}" end="${page.end}" var="p">
                        			<li class= "page-item ${p== page.criteria.pageNum ? 'active': ''}"><a class="page-link" href="list${page.criteria.params}&pageNum=${p}">${p}</a></li>
                        		</c:forEach>
                        		<c:if test="${page.next}"></c:if>
                        			<li class= "page-item"><a class="page-link" href="list${page.criteria.params}&pageNum=${page.criteria.pageNum+1}">next</a></li>
							</ul>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <%@ include file="../common/footer.jsp" %>
        <script>
        $(function() {
        	// var num = ; 오류 var num = '';은 오류가 아님
	        $(".form-amount").change(function(){
	        	location.href='list?amount='+$(this).val()+"&category=${page.criteria.category}&pageNum=${page.criteria.pageNum}";
	        });
			
		});
        </script>
    </body>
</html>
