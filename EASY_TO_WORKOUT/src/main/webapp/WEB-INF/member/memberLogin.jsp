<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ETW MemberLoginPage</title>
<script>
function login() {
	if (form.loginId.value == "") {
		alert("ID�� �Է��ϼ���.");
		form.loginId.focus();
		return false;
	}
	if (form.loginPw.value == "") {
		alert("��й�ȣ�� �Է��ϼ���.");
		form.loginPw.focus();
		return false;
	}
	form.submit();
}
</script>
</head>

<body>
<form name="form" method="POST" action="<c:url value='/member/login' />">
	<!-- ��ϱ� ���ϱ�&�ΰ� -->
	<div style="text-align: center; margin: 80px 0 20px 0">
		<a href=""><img src="<c:url value='/images/logo.PNG' />"
			width=500px height=130px /></a>
	</div>
	<div style="text-align: center">
		<input type="text" name="loginId" placeholder="���̵�" style="width: 400px; height: 50px; margin: 10px">
	</div>
	<div style="text-align: center">
		<input type="password" name="loginPw" placeholder="��й�ȣ" style="width: 400px; height: 50px; margin: 10px">
	</div>
	<div style="text-align: center">
		<input type="button" onclick="login()" value="�α���" style="width: 190px; height: 50px; margin: 10px">
		<input type="button" onclick="" value="ȸ�� ����" style="width: 190px; height: 50px; margin: 10px">
	</div>
	<div style="text-align: center">
		<c:if test="${loginFailed}">
		  <br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
		</c:if>
	</div>
</form>
</body>
</html>