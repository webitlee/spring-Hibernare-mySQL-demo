<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<script src="/gitRepository/html/jquery/jquery-3.0.0.min.js"></script>
</head>
<body>
	<form id="from" method="post" action="/gitRepository/login">
		<div>
			<span>账号：</span>
			<input name="account"/>
		</div>
		<br/>
		<div>
			<span>密码：</span>
			<input type="password" name="password"/>
		</div>
		<br/>
		<div>
			<span>验证码：</span>
			<input id="auth-code" name="authCode"/>
			<img id="img" src="" title="验证码"/>
			<span id="hint" style="color:red;display:none;"></span>
		</div>
		<button id="btn-submit">登录</button>
	</form>
</body>
<script>
	$('#auth-code').focus(function(){
		$('#img').attr('src', "/gitRepository/image?" + Math.random());
	})
	
</script>
</html>