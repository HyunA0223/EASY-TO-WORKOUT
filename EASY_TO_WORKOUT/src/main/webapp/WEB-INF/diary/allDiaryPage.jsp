<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ETW AllDiaryPage</title>
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

#list {
	width: 700px;
	height: 540px;
	border: 1px solid;
	margin-top: 10px;
	overflow: scroll;
}

#listTable {
	border-collapse: collapse;
	width: 700px;
	table-layout: fixed;
}

#listItem {
	border-bottom: 1px solid;
	height: 50px;
}

#listTr {
	width: 700px;
	height: 40px;
	table-layout: fixed;
}

th, td {
	text-align: center;
}
</style>
</head>

<body>
	<!-- ��ϱ� ���ϱ�&�ΰ� -->
	<div style="text-align: center">
		<a href="<c:url value='/main' />"><img src="<c:url value='/images/logo.PNG' />"
			width=500px height=130px /></a>
	</div>

	<hr>
	<!-- �޴��� -->
	<nav class="menu">
		<ul class="mainMenu">
			<li><a href="<c:url value='/club' />">����</a></li>
			<li><a href="<c:url value='/routine' />">��ƾ</a></li>
			<li><a href='#'>���̾</a>
				<ul class="subMenu">
					<li><a href="<c:url value='/diary/my' />">MY ���̾</a></li>
					<li><a href="<c:url value='/diary/all' />">��ü ���̾</a></li>
				</ul></li>
		</ul>
	</nav>

	<hr>
	<div class="container">
		<!-- ȸ������ Ʋ -->
		<div style="width: 400px; height: 600px; border: 1px solid; float: left; margin-right: 10px;">
			<div style="height: 530px;">
				<h3 style="margin: 20px;">ȸ������</h3>
				<table id="memberDataTable">
					<tr>
						<td><img src="<c:url value='/images/somsom.jpg' />" width=150px height=230px />
						</td>
						<td>�̸� : �赿��
							<p /> ��� : ����
							<p /> <br> <a href='#'>ȸ������ ����</a>
							<p>
								<a href='../user/member_login.jsp'>�α׾ƿ�</a>
						</td>
					</tr>
				</table>
				<br><hr>
				<article>
					<h4 style="margin: 20px;">�� ���� ���</h4>
					<ul>
						<li><a href='#'>������</a></li>
						<li><a href='#'>ETW</a></li>
					</ul>
				</article>
			</div>
			<div style="height: 50px;">
				<!-- ���̾ �ۼ� ��ư -->
				<input type="button" value="���̾ �ۼ�" onclick=""
					style="width: 400px; height: 50px;">
			</div>
		</div>

		<div style="float: right">
			<!-- �˻�â -->
			<div id="search" style="width: 700px; height: 50px;">
				<form action="" method="get">
					<input type="text" name="diary"
						style="width: 480px; height: 42px;"> <input type="button"
						value="�˻�" onclick="" style="width: 100px; height: 47px;">
					<select name="sort" style="width: 100px; height: 47px;">
						<option value="1" selected>��ü</option>
						<option value="2">��¥��</option>
						<option value="3">� �ð���</option>
					</select>
				</form>
			</div>
			<!-- ��ü ���̾ ��� -->
			<div id="list">
				<div style="width: 670px; height: 30px;">
					<table id="listTable">
						<tr id="listItem">
							<th>����</th>
							<th>�ۼ���</th>
							<th>��¥</th>
							<th>� �ð�</th>
						</tr>
						<tr id="listTr">
							<td>���� �ѵ��ϱ���</td>
							<td>�赿��</td>
							<td>2021.10.05</td>
							<td>1�ð�</td>
						</tr>
						<tr id="listTr">
							<td>����� �����</td>
							<td>�ȳ���</td>
							<td>2021.10.05</td>
							<td>2�ð�</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>