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
                <h2>${board.attachs}</h2>
                <div class="card mb-4">
                    <div class="card-body">
                        <form>
						  <div class="mb-3 mt-3">
						    <label for="bno" class="form-label">bno</label>
						    <input type="text" class="form-control" id="bno" name="bno" value="${board.bno}" disabled>
						  </div>
						  <div class="mb-3">
						    <label for="title" class="form-label">title</label>
						    <input type="text" class="form-control" id="title" name="title" value="${board.title}" disabled>
						  </div>
						  <div class="mb-3">
						    <label for="content" class="form-label">content</label>
						    <c:if test="${cri.category==3 }"></c:if>
						    <div>
						    	<c:forEach items="${board.attachs}" var="attach">
						    		<c:if test="${attach.image}">
						    		<div class="text-center my-3">
			  							<img src="${pageContext.request.contextPath}/display?uuid=${attach.uuid}&path=${attach.path}" alt="${attach.origin}">
						    		</div>
						    		</c:if>
						    	</c:forEach>
						    </div>
						    <textarea class="form-control" id="content" name="content" disabled>${board.content}</textarea>
						  </div>
						  <div class="mb-3">
						    <label for="regDate" class="form-label">regDate</label>
						    <input type="text" class="form-control" id="regDate" name="regDate" value="${board.regDate}" disabled>
						  </div>
						  <div class="mb-3">
						    <label for="writer" class="form-label">writer</label>
						    <input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" disabled>
						  </div>
						  <div class="mb-3">
						    <label for="attach" class="form-label"><i class="fas fa-house-damage"></i> attach</label>
						    <ul class="list-group">
						    <c:forEach items="${board.attachs}" var="attach">
							  <li class="list-group-item"><i class="fas fa-ghost"></i> <a href="${pageContext.request.contextPath}/download${attach.params}">${attach.origin}</a></li>
						    </c:forEach>
							</ul>
						  </div>
							<div class="clearfix">
						    <span class="form-label mb-4"><i class="fas fa-hammer"></i> replies</span> 
							</div>
								<div class="row p-4">
									<div class="col-10 bg">
										<textarea class="w-100" id="replyContent"></textarea>
									</div>
									<div class="col-2">
										<button class="btn btn-primary" id="btnReplyReg" type="button">글 등록</button>
									</div>
								</div>
							<ul class="list-group my-3 small replies" >
								<!-- <li class="list-group-item">
									<div class="list-group-item list-group-item-danger small">
										<span>작성자</span>
										<span class="small float-end"> 작성시간</span></div>
									<div class="list-group-item">
										댓글 내용 <br>
										댓글 내용 <br>
										댓글 내용 <br>
										댓글 내용 <br>
										댓글 내용 <br>
								</div>
								</li> -->
							</ul>
						  <a href="list${cri.params2}" class="btn btn-outline-secondary">list</a>
						  <c:if test="${not empty member && member.id == board.writer}">
						  <a href="modify${cri.params2}&bno=${board.bno}" class="btn btn-outline-warning">modify</a>
						  <a href="remove${cri.params2}&bno=${board.bno}" class="btn btn-outline-danger" onclick="return confirm('삭제하시겠습니까?')">remove</a>
						  </c:if>
						</form>
                    </div>
                </div>
            </div>
        </main>
        <%@ include file="../common/footer.jsp" %>
		<script>
			const cp ="${pageContext.request.contextPath}";
			

			// replyService.get(30, function(data){
			// 	console.log(data);
			// },cp);
			// replyService.add({bno:169, content:'get.jsp 내용', writer:'javaman'}, function(data){
			// 	console.log(data);
			// },cp);
			

			$(function() {
				const bno='${board.bno}';
				showList();
						function showList(){
								replyService.list(bno, function(data){
									console.log(data);
									var str="";
									for(var i in data){
										str+='';
str+='												<li class="list-group-item" data-rno="'+data[i].rno+'">'
str+='						<div class="list-group-item list-group-item-danger small">'
str+='								<span>'+data[i].writer+'</span>'
str+='								<span class="small float-end">' +data[i].regDate+'</span>'
str+='								<span class="small float-end mx-2 btnReplyRemove"><i class="fas fa-dizzy" style="cursor:pointer"></i></span>'
str+='</div>'
str+='						<div class="list-group-item">'	+data[i].content+'</div>'
str+='							</li>'
									}
									$(".replies").html(str);
								},cp);
						}

						//댓글 상세 조회
						$(".replies").on("click", "li",function(){
							replyService.get($(this).data("rno"), function(data){
								console.log(data);
								
								//값 부여
								$("#rno").val(data.rno);
								$("#replyContent").val(data.content);
								$("#replyRegDate").val(data.regDate);
								$("#replyWriter").val(data.writer);
								//버튼
								$("#replyModal .modal-body div").show();
								
								$("#replyModal")
								.data("rno", data.rno)
									.find(".modal-footer button").hide()
										.filter(":gt(0)").show()
										.end()
								.end()
									.find("input,textarea").prop("disabled",false)
								.end().modal("show");
							},cp);
							// $("#reflyModal").modal("show");
						});
						$(".replies").on("click", "li",function(){
							var rno =$(this).closest("li").data("rno");
							var reply={rno:rno};
							replyService.remove(reply,function(data){
								showList();
							},cp);
						});

							//댓글 등록 버튼 클릭 이벤트
							$("#btnReplyReg").click(function(){
								// alert("등록 버튼");
								var reply ={bno:bno, content:$("#replyContent").val(), writer:'bibibik'};
								replyService.add(reply, function(data){
									// console.log(data);
									showList();
									$('#replyContent').val("");
									alert("댓글이 등록되었습니다");
								},cp);
							});
							//댓글 수정 버튼 클릭 이벤트
							$("#replyModal .modal-footer button:eq(1)").click(function(){
								// alert("등록 버튼");
								var reply ={rno:$("#replyModal").data("rno"), content:$("#replyContent").val()};
								replyService.modify(reply, function(data){
									// console.log(data);
									showList();
									$("#replyModal").modal("hide")
								},cp);
							});
							$("#replyModal .modal-footer button:eq(2)").click(function(){
								// alert("등록 버튼");
								var reply ={rno:$("#replyModal").data("rno"), content:$("#replyContent").val()};
								replyService.remove(reply, function(data){
									// console.log(data);
									showList();
									$("#replyModal").modal("hide")
								},cp);
							});
			});
		</script>
    </body>
</html>
