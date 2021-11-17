<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ETW DIARY WRITE</title>
<style>
.menu {
	height: 50px;
	background-color: #213963;
	text-align: center;
}

.menu ul {
	display: inline-block;
	list-style: none;
	margin: 0;
}

.menu a {
	text-decoration: none;
	color: white;
}

.menu li:hover>a {
	color: #919191;
}

.menu li:hover>.subMenu li {
	display: block;
	background-color: #90ABDA;
}

.mainMenu li {
	float: left;
	width: 400px;
	height: 50px;
	line-height: 50px;
	text-align: center;
}

.subMenu li {
	float: none;
	display: none;
	position: relative;
	width: 300px;
	margin-left: 10px;
	z-index: 1;
}

.container {
	display: flex;
	justify-content: center;
}

#memberDataTable {
	border-collapse: collapse;
	width: 400px;
	height: 230px;
	table-layout: fixed;
}

#diaryInput {
	width: 700px;
	height: 600px;
	border: 1px solid;
}

#dairyTable {
	border-collapse: collapse;
	width: 700px;
	height: 450px;
	float: center;
}

#diaryTableTr {
	height: 45px;
	width: 700px;
	table-layout: fixed;
}

#diaryWriteButton {
	width: 150px;
	height: 45px;
	text-align: center;
	margin: 10px;
	background-color: #90ABDA;
}

#backButton {
	width: 150px;
	height: 45px;
	text-align: center;
	margin: 10px;
	background-color: #90ABDA;
}

th, td {
	text-align: center;
}
</style>

<script>
function diaryWriteBtn_click() {
	if (writeForm.diaryTitle.value == "") {
		alert("������ �Է��ϼ���.");
		writeForm.diaryTitle.focus();
		return false;
	}
	if (writeForm.workTime.value == "") {
		alert("��ð��� �Է��ϼ���.");
		writeForm.workTime.focus();
		return false;
	}
	if (writeForm.diaryContents.value == "") {
		alert("������ �Է��ϼ���.");
		writeForm.diaryContents.focus();
		return false;
	}
	writeForm.submit();
}
</script>

</head>

<body>
	<!-- ��ϱ� ���ϱ�&�ΰ� -->
	<div style="text-align: center">
		<a href="<c:url value='/main' />"><img src="<c:url value='/images/logo.PNG' />"
			width=500px height=130px /></a>
	</div>
	<!-- ���ư��� ��ư -->

	<hr>
	<!-- �޴��� -->
	<nav class="menu">
		<ul class="mainMenu">
			<li><a href="<c:url value='/club/list' />">����</a></li>
			<li><a href="<c:url value='/routine/list' />">��ƾ</a></li>
			<li><a href='#'>���̾</a>
				<ul class="subMenu">
					<li><a href="<c:url value='/diary/my/list' />">MY ���̾</a></li>
					<li><a href="<c:url value='/diary/all/list' />">��ü ���̾</a></li>
				</ul></li>
		</ul>
	</nav>

	<hr>
	<div class="container">
		<!-- ȸ������ Ʋ -->
		<div
			style="width: 400px; height: 600px; border: 1px solid; float: left; margin-right: 10px;">
			<h3 style="margin: 20px;">ȸ������</h3>
			<table id="memberDataTable">
				<tr>
					<td><img src="<c:url value='/images/somsom.jpg' />" width=150px height=230px />
					</td>
					<td>�̸� : �赿��
						<p /> ��� : ����
						<p /> <br> <a href='#'>ȸ������ ����</a>
						<p>
							<a href='#'>�α׾ƿ�</a>
					</td>
				</tr>
			</table>
			<br>
			<hr>
			<article>
				<h4 style="margin: 20px;">�� ���� ���</h4>
				<ul>
					<li><a href='#'>������</a></li>
					<li><a href='#'>ETW</a></li>
				</ul>
			</article>
		</div>

		<div style="float: right">
			<!-- ���̾ �ۼ� �κ�  -->
			<div id="diaryInput">
				<h3 style="margin: 20px;">���̾ �ۼ�</h3>
				<hr>
				<form name="writeForm" method="POST" action="<c:url value='/diary/create' />">
				<table id="dairyTable">
					<tr id="dairyTableTr">
						<td style="width: 130px;">���� :</td>
						<td><input type="text" name="diaryTitle"
							style="width: 500px; height: 20px; font-size: 15px;"></td>
					</tr>
					<tr id="diaryTableTr">
						<td style="width: 130px;">���� ���� :</td>
						<td>
							<input type="checkbox" name="isPrivate" />�����
						</td>
					</tr>
					<tr id="dairyTableTr">
						<td style="width: 130px;">� �ð� :</td>
						<td>
							<input type="number" name="workTime" min="1" max="24" />�ð�
						</td>
					</tr>
					<tr id="diaryTableTr">
						<td style="width: 130px;">���� :</td>
						<td><textarea name="diaryContents" rows=15 cols=60 style="resize: none;"></textarea></td>
					</tr>
				</table>
				<div style="text-align: center; margin-left: 130px;">
					<input id="diaryWriteButton" type="button" value="���̾ �ۼ�"
						onclick="diaryWriteBtn_click()"> 
					<input id="backButton" type="button" value="���ư���" 
						onclick="history.back()">
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>