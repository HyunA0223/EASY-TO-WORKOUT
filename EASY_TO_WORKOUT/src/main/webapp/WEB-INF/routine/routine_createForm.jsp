<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ETW club_openForm</title>
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

#routineInfoInput {
	width: 700px;
	height: 600px;
	border: 1px solid;
}

#routineTable {
	border-collapse: collapse;
	width: 700px;
	height: 450px;
	float: center;
}

#routineTableTr {
	height: 45px;
	width: 700px;
	table-layout: fixed;
}

#routineCreateButton {
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
function createRequestBtn_click() {
	theForm = document.openForm;
	
	if(theForm.routineName.value == "") alert("��ƾ���� �Է����ּ���.");
	else {
		alert("��ƾ�� ��ϵǾ����ϴ�.\n ��ƾ ��Ͽ��� Ȯ���� �����մϴ�.");
	}
	
}
</script>

</head>

<body>
	<!-- ��ϱ� ���ϱ�&�ΰ� -->
	<div style="text-align: center">
		<a href="<c:url value='/main' />"><img src="<c:url value='/images/logo.PNG' />" width=500px
			height=130px /></a> 
	</div>

	<hr>
	<!-- �޴��� -->
	<nav class="menu">
		<ul class="mainMenu">
			<li><a href='<c:url value='/club' />'>����</a></li>
			<li><a href='<c:url value='/routine' />'>��ƾ</a></li>
			<li><a href='#'>���̾</a>
				<ul class="subMenu">
					<li><a href='<c:url value='/diary/my' />'>MY ���̾</a></li>
					<li><a href='<c:url value='/diary/all' />'>��ü ���̾</a></li>
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
			<!-- ��ƾ ��� �׸� �Է� �κ�  -->
			<div id="routineInfoInput">
				<h3 style="margin: 20px;">��ƾ ���� �Է�</h3>
				<hr>
				<form name="openForm">
				<table id="routineTable">
					<tr id="routineTableTr">
						<td style="width: 130px;">��ƾ�� :</td>
						<td><input type="text" name="routineName"
							style="width: 300px; height: 20px; font-size: 15px;"></td>
					</tr>
					<tr id="routineTableTr">
						<td style="width: 130px;">����� :</td>
						<td><input type="text" name="routineCreator"
							style="width: 300px; height: 20px; font-size: 15px;"></td>
					</tr>
					<tr id="routineTableTr">
						<td style="width: 130px;">� ���� :</td>
						<td>
							<input type="checkbox" name="routinePart" value="��ü" />��ü
							&nbsp;&nbsp; 
							<input type="checkbox" name="routinePart" value="��ü" />��ü
							&nbsp;&nbsp; 
							<input type="checkbox" name="routinePart" value="����" />����
							&nbsp;&nbsp; 
							<input type="checkbox" name="routinePart" value="���" />���
							&nbsp;&nbsp; 
							<input type="checkbox" name="routinePart" value="����" />����
						</td>
					</tr>
					<tr id="routineTableTr">
						<td style="width: 130px;">�ҿ�ð� :</td>
						<td><input type="text" name="routineTime"
							style="width: 300px; height: 20px; font-size: 15px;"></td>
					</tr>
					<tr id="routineTableTr">
						<td style="width: 130px;">� ���� :</td>
						<td>
							<input type="radio" name="routineLevel" value="1" checked />1
							&nbsp;&nbsp; 
							<input type="radio" name="routineLevel" value="2" />2
							&nbsp;&nbsp; 
							<input type="radio" name="routineLevel" value="3" />3
							&nbsp;&nbsp; 
							<input type="radio" name="routineLevel" value="4" />4
							&nbsp;&nbsp; 
							<input type="radio" name="routineLevel" value="5" />5
						</td>
					</tr>
					<tr id="routineTableTr">
						<td style="width: 130px;">��ƾ ���� :</td>
						<td>
							<input type="radio" name="routineType" value="0" checked />��ü
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<input type="radio" name="routineType" value="1" />����
						</td>
					</tr>
					<tr id="routineTableTr">
						<td style="width: 130px;">� ��� :</td>
						<td><textarea name="routineMethod" rows=10 cols=60 style="resize: none;"></textarea></td>
					</tr>
				</table>
				<div style="text-align: center; margin-left: 130px;">
					<input id="routineCreateButton" type="button" value="��ƾ ���"
						onclick="createRequestBtn_click()"> 
					<input id="backButton" type="button" value="���ư���" 
						onclick="location.href='<c:url value='/routine' />'">
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>