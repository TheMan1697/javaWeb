<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="../common/head.jsp"/>
</head>
<body>
  <jsp:include page="../common/nav.jsp"/>
  <c:choose>
  <c:when test="${pageContext.request.contextPath}/board/list?category=2">
     <h1 class="board-text">Notice
  </c:when>
  <c:when test="${pageContext.request.contextPath}/board/list">
     <h1 class="board-text">Board
  </c:when>
  </c:choose>
    </h1>
    <table class="board-table-inner">
        <tr class="index">
            <th class="col1">No.</th>
            <th class="col2">Title</th>
            <th class="col2">Writer</th>
            <th class="col2">Views</th>
            <th class="col3">Day</th>
        </tr>
           <c:forEach items="${boards}" var="board">
								<tr>
									<td>${board.bno}</td>
									<td><a href="get${page.criteria.params2}&bno=${board.bno}">${board.title}</a><span class="text-secondary small">[${board.replyCnt}]</span></td>
									<td ${empty board.writer ? 'class="text-muted small"' : ''}>${empty board.writer ? '(?̶?̶?̶)' :board.writer}</td>
									<td>${board.hitcount}</td>
									<td>${board.regDate}</td>
								</tr>
							</c:forEach>
    </table>
     <div class="pagination">
                       	 <ul class="pagination justify-content-center">
                       	 <c:if test="${page.prev}">
                        			<a class="page-link" href="list${page.criteria.params}&pageNum=${page.criteria.pageNum-1}">prev</a>
                       	 </c:if>
                        		<c:forEach begin="${page.start}" end="${page.end}" var="p">
                        			<a class="page-link" href="list${page.criteria.params}&pageNum=${p}">${p}</a>
                        		</c:forEach>
                        		<c:if test="${page.next}"></c:if>
                        			<a class="page-link" href="list${page.criteria.params}&pageNum=${page.criteria.pageNum+1}">next</a>
							</ul>
                        </div>
    <a href="register${page.criteria.params2}" class="last-button"><i class="fas fa-edit"></i>Write</a>
  <jsp:include page="../common/footer.jsp"/>
</body>
<script type="text/javascript">


</script>
</html>