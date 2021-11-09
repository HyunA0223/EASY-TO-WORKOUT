<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ETW club_detials</title>
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

#clubInfoOutput {
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
	height: 30px;
	width: 700px;
	table-layout: fixed;
}

#backButton {
	width: 150px;
	height: 45px;
	text-align: center;
	margin: 10px;
	background-color: #90ABDA;
}

#scheduleDetailButton {
	width: 100px; 
	height: 35px;
	background-color: #90ABDA;
}

th, td {
	text-align: center;
}
</style>
</head>

<body>
	<!-- ��ϱ� ���ϱ�&�ΰ� -->
	<div style="text-align: center">
		<a href="../../mainPage.jsp"><img src="../images/logo.PNG"
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
			<div style="height: 530px;">
				<h3 style="margin: 20px;">ȸ������</h3>
				<table id="memberDataTable">
					<tr>
						<td><img src="../../images/somsom.jpg" width=150px height=230px />
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
		</div>

		<div style="float: right">
			<!-- ���� �� ���� ��� �κ�  -->
			<div id="clubInfoOutput">
				<h3 style="margin: 20px;">���� �� ����</h3>
				<hr>
				<table id="clubTable">
					<tr id="clubTableTr">
						<td style="width: 130px;">���� �̸� :</td>
						<td style="text-align:left;">
							<p>���� �̸� ���
						</td>
						<td >
						<input id="scheduleDetailButton" type="button" value="���� ����"
							onclick="location.href='./schedule_list.jsp'">
					</td>
					</tr>
					<tr id="clubTableTr">
						<td style="width: 130px;">���� ���� :</td>
						<td colspan=2 style="text-align:left;">
							<p>������ or �Ͻ���
						</td>
					</tr>
					<tr id="clubTableTr">
						<td style="width: 130px;">�ʴ� ���� :</td>
						<td colspan=2 style="text-align:left;">
							<p>�ʴ� or ����
						</td>
					</tr>
					<tr id="clubTableTr">
						<td style="width: 130px;">���� �Ұ� :</td>
						<td colspan=2 style="text-align:left;">
							<textarea rows=13 cols=60
								style="resize: none; font-size: 14px;" readonly="readonly" disabled>
								������ �Ұ� �� ���� ���� ���, ��������, ��Ģ ��
							</textarea></td>
					</tr>
				</table>
				<div style="text-align: center;">
					<input id="backButton" type="button" value="���ư���"
						onclick="location.href='./clubPage.jsp'">
				</div>
			</div>
		</div>
	</div>
</body>
</html>