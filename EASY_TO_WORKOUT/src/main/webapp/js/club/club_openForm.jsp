<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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

#clubInfoInput {
	width: 700px;
	height: 600px;
	border: 1px solid;
}

#clubTable {
	border-collapse: collapse;
	width: 700px;
	height: 450px;
	float: center;
}

#clubTableTr {
	height: 45px;
	width: 700px;
	table-layout: fixed;
}

#clubAccpetButton {
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
function acceptRequestBtn_click() {
	theForm = document.openForm;
	
	if(theForm.clubName.value == "") alert("���� �̸��� �Է����ּ���.");
	else {
		alert("������ �����Ǿ����ϴ�.");
		location.href= "./club_detail.jsp"
	}
	
}
</script>

</head>

<body>
	<!-- ��ϱ� ���ϱ�&�ΰ� -->
	<div style="text-align: center">
		<a href="../mainPage.jsp"><img src="../images/logo.PNG"
			width=500px height=130px /></a>
	</div>
	<!-- ���ư��� ��ư -->

	<hr>
	<!-- �޴��� -->
	<nav class="menu">
		<ul class="mainMenu">
			<li><a href='../club/clubPage.jsp'>����</a></li>
			<li><a href='../routine/routinePage.jsp'>��ƾ</a></li>
			<li><a href='#'>���̾</a>
				<ul class="subMenu">
					<li><a href='#'>MY ���̾</a></li>
					<li><a href='#'>��ü ���̾</a></li>
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
					<td><img src="../images/somsom.jpg" width=150px height=230px />
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
			<!-- ���� ���� �׸� �Է� �κ�  -->
			<div id="clubInfoInput">
				<h3 style="margin: 20px;">���� ���� �Է�</h3>
				<hr>
				<form name="openForm">
				<table id="clubTable">
					<tr id="clubTableTr">
						<td style="width: 130px;">���� �̸� :</td>
						<td><input type="text" name="clubName"
							style="width: 300px; height: 20px; font-size: 15px;"></td>
					</tr>
					<tr id="clubTableTr">
						<td style="width: 130px;">���� ���� :</td>
						<td>
							<input type="radio" name="clubOpenCycle" value="������" checked />������
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<input type="radio" name="clubOpenCycle" value="�Ͻ���" />�Ͻ���
						</td>
					</tr>
					<tr id="clubTableTr">
						<td style="width: 130px;">�ʴ� ���� :</td>
						<td>
							<input type="radio" name="clubSignUp" value="���� ����" checked />���� ���� 
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<input type="radio" name="clubSignUp" value="�ʴ� ����" />�ʴ� ����
						</td>
					</tr>
					<tr id="clubTableTr">
						<td style="width: 130px;">���� �Ұ� :</td>
						<td><textarea name="clubIntro" rows=15 cols=60 style="resize: none;"></textarea></td>
					</tr>
				</table>
				<div style="text-align: center;">
					<input id="clubAccpetButton" type="button" value="���� ���� ��û"
						onclick="acceptRequestBtn_click()"> 
					<input id="backButton" type="button" value="���ư���" 
						onclick="location.href='./clubPage.jsp'">
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>