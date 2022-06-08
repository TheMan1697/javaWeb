<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/js/bootstrap.min.js" integrity="sha512-EKWWs1ZcA2ZY9lbLISPz8aGR2+L7JVYqBAYTq5AXgBkSjRSuQEGqWx8R1zAX16KdXPaCjOCaKE8MCpU0wcHlHA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	window.onload=function(){
	    document.frm.onsubmit=function(){
	        var id = document.frm.id;
	        var pwd = document.frm.pwd;
	        var name = document.frm.name;
	        var email = document.frm.email;
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
	        if(!document.frm.name.value){
	            alert("이름을 입력하세요")
	            name.focus();
	            return false;
	        }
	        if(!document.frm.email.value){
	            alert("이메일을 입력하세요")
	            email.focus();
	            return false;
	        }
	    }
	}
	
</script>
<style>
.container{margin: 0 auto; text-align: left; max-width: 250px;}
        .form{height: 300px;}
        .form-label{position: absolute; font-size: 12px;}
        .form-control{height: 22px; width: 239px; padding-top: 13px; padding-bottom: 6px; margin-bottom: 15px; border-style: solid; border-color: gray;}
        .sign-button { text-decoration: none; display: block; background: #000; padding: 18px;text-align: center;color: #fff; width: 248px}
</style>
</head>
<body>
	<div class="container">
	<div class="col-6 mx-auto">
		<h3>Sign up</h3>
		<div class="box-inner">
		<form class="form" method="post" name="frm">
			<div>
			<label for="userId" class="form-label">ID</label>
			<input type="text" name="id" id="userId" class="form-control">
			</div>
			<div>
			<label for="password" class="form-label">Password</label>
			<input type="password" name="pwd" id="password" class="form-control">
			</div>
			<div>
			<label for="password" class="form-label">Password Confirmation</label>
			<input type="password" name="pwd" id="password" class="form-control">
			</div>
			<label for="name" class="form-label">Name</label>
			<input type="text" name="name" id="name" class="form-control">
			<label for="email" class="form-label">Email</label>
			<input type="email" name="email" id="email" class="form-control">
			<div class="d-grid">
				<button class="sign-button">Register Now!</button>
			</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>