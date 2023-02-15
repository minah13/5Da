<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/home.css">
<script src="/resources/js/home.js" defer></script>
<meta charset="UTF-8">
<title>오늘의 다이어리</title>
</head>
<body>
<div id="homeContext">

	<h1> 오늘의 다이어리 </h1>
	
	<!-- 
	<input type="button" value="카카오톡으로 로그인하기" id="kakaoLoginBtn" class="loginBtn">
	<br>
	<input type="button" value="구글로 로그인하기" id="googleLoginBtn" class="loginBtn">
	<br>
	<input type="button" value="네이버로 로그인하기" id="naverLoginBtn" class="loginBtn">
	<br>
	<input type="button" value="이메일로 로그인하기" id="emailLoginBtn" class="loginBtn"> -->

	<a href="/oauth2/authorization/google">구글 아이디로 로그인</a>
	<a href="/oauth2/authorization/naver">네이버 아이디로 로그인</a>
	<a href="/oauth2/authorization/kakao">카카오 아이디로 로그인</a>

</div>

</body>
</html>