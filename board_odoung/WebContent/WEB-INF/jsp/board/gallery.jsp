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
                <h1 class="mt-4">Gallery</h1>
                ${boards}
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
                    	<div class="gallery-list row p-5">
                    		<c:forEach items="${boards }" var="board">
                    		<div class="col-3 card p-3 border-0" >
                    			<a href="get${page.criteria.params2}&bno=${board.bno}">${board.title}
                    			<div class="border p-1">
  									<img onerror="this.src='${pageContext.request.contextPath}/images/noimage.png'" class="card-img-top" src="${pageContext.request.contextPath}/display?uuid=s_${board.attachs[0].uuid}&path=${board.attachs[0].path}" alt="${board.attachs[0].origin}">
  									<div class="card-body">
						   			 	<h6 class="card-title text-truncate">${board.title}</h6>
						   				 <p class="card-text small text-truncate">
									   	 <span class="text-truncate">${board.writer}</span>
									   	 <span class="small float-end">${board.regDate}</span>
						   				 </p>
	                    			</div>
						 		 </div>
                    			</a>
							</div>
                    		</c:forEach>
                    	</div>
                    	
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
