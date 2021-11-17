<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

#etcButton {
	background-color: #90ABDA;
}

#searchButton {
	width: 100px; 
	height: 47px;
	background-color: #90ABDA;
}

#writeButton {
	width: 400px; 
	height: 50px;	
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
					<li><a href="<c:url value='/diary/my/list' />">MY ���̾</a></li>
					<li><a href="<c:url value='/diary/all/list' />">��ü ���̾</a></li>
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
				<input id="writeButton" type="button" value="���̾ �ۼ�" 
					onclick="location.href='<c:url value='/diary/write' />'">
			</div>
		</div>

		<div style="float: right">
			<!-- �˻�â -->
			<div id="search" style="width: 700px; height: 50px;">
				<form name="searchForm" method="POST" action="<c:url value='/diary/all/list' />">
					<input type="text" name="searchDiary" placeholder="�˻��� ���̾�� ������ �Է��ϼ���."
						style="width: 580px; height: 42px;">
						<input id="searchButton" type="button"value="�˻�" onclick="">
				</form>
			</div>
			<!-- ��ü ���̾ ��� -->
			<div id="list">
				<div style="width: 670px; height: 30px;">
					<table id="listTable">
						<tr id="listItem">
							<th>����</th>
							<th>��¥</th>
							<th>� �ð�</th>
							<th>�ۼ���</th>
							<td><form name="sortForm" method="POST" action="<c:url value='/diary/all/list' />">
								<select name="sortDiary" style="width: 80px; height: 37px;" onchange="this.form.submit()">
									<option value="1" <c:if test="${checkedOne}">selected</c:if>>��¥��</option>
									<option value="2" <c:if test="${checkedTwo}">selected</c:if>>� �ð���</option>
								</select>
							</form></td>
						</tr>
						<c:forEach var="diary" items="${diaryList}">
							<tr id="listTr">
								<td>${diary.title}</td>
								<td><fmt:formatDate value="${diary.date}" pattern="yyyy-MM-dd" /></td>
								<td>${diary.workTime}</td>
								<td>${diary.author}</td>
								<td>
									<input id="etcButton" type="button" value="������">
								</td>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>