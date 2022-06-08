<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/css/bootstrap.min.css" integrity="sha512-Ez0cGzNzHR1tYAv56860NLspgUGuQw16GiOOp/I2LuTmpSK9xDXlgJz3XN4cnpXWDmkNBKXR/VDMTCnAaEooxA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/js/bootstrap.min.js" integrity="sha512-EKWWs1ZcA2ZY9lbLISPz8aGR2+L7JVYqBAYTq5AXgBkSjRSuQEGqWx8R1zAX16KdXPaCjOCaKE8MCpU0wcHlHA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	window.onload=function(){
	    document.frm.onsubmit=function(){
	        var id = document.frm.id;
	        var pwd = document.frm.pwd;
	        if(!document.frm.id.value){
	            alert("아이디를 입력하세요")
	            id.focus();
	            return false;
	        }
	        if(!document.frm.pwd.value){
	            alert("비밀번호를 입력하세요")
	            pwd.focus();
	            return false;
	        }
	    }
	}
</script>
<style>
.container{margin: 0 auto; text-align: left; max-width: 250px;}
        .form{height: 300px;}
        .form-label{position: absolute; font-size: 12px;}
        .form-control{height: 50px; width: 239px; padding-top: 13px; padding-bottom: 6px; margin-bottom: 15px; border-style: solid; border-color: gray;}
        .sign-button { text-decoration: none; display: block; background: #000; padding: 18px;text-align: center;color: #fff; width: 240px}
</style>
</head>
<body>
	<div class="container">
	<div class="col-6 mx-auto">
		<h3>Sign up</h3>
		<div class="box-inner">
		<form class="form" method="post" name="frm">
			<div>
			<label for="userId" class="form-label">&nbsp; ID</label>
			<input type="text" name="id" id="userId" class="form-control">
			</div>
			<div>
			<label for="password" class="form-label">&nbsp; Password</label>
			<input type="password" name="pwd" id="password" class="form-control">
			</div>
				<button class="sign-button">Login</button>
			</div>
			</div>
		</form>
	</div>
</body>
</html>