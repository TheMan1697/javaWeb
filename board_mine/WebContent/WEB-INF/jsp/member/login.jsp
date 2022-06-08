<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="../common/head.jsp"/>
</head>
<body>
  <jsp:include page="../common/nav.jsp"/>
     <div class="box">
        <h3>Login</h3>
        <form method="post">
	        <div class="box-inner">
	            <div class="input" label="아이디">
	                <div class="input_title">&nbsp; ID</div>
	                <input class="input-expand" type="text" name="id" placeholder="  ID">
	            </div>
	            <div class="input" label="비밀번호">
	                <div class="input_title">&nbsp; Password</div>
	                <input class="input-expand" type="pw" name="pw" placeholder="  **********">
	            </div>
	                  <button class="btn btn-primary" >Login</button>
	          </div>
        </form>
        </div>
  <jsp:include page="../common/footer.jsp"/>
</body>
</html>