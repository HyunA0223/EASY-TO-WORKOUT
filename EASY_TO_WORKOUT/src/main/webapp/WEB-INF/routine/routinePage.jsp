<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ETW RoutinePage</title>
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

#searchButton {
	width: 100px; 
	height: 47px;
	background-color: #90ABDA;
}

#createButton {
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
	<!-- 운동하기 편하군&로고 -->
	<div style="text-align: center">
		<a href="<c:url value='/main' />"><img src="<c:url value='/images/logo.PNG' />" width=500px
			height=130px /></a> 
	</div>

	<hr>
	<!-- 메뉴바 -->
	<nav class="menu">
		<ul class="mainMenu">
			<li><a href='<c:url value='/club' />'>모임</a></li>
			<li><a href='<c:url value='/routine' />'>루틴</a></li>
			<li><a href='#'>다이어리</a>
				<ul class="subMenu">
					<li><a href='<c:url value='/diary/my' />'>MY 다이어리</a></li>
					<li><a href='<c:url value='/diary/all' />'>전체 다이어리</a></li>
				</ul></li>
		</ul>
	</nav>

	<hr>
	<div class="container">
		<!-- 회원정보 틀 -->
		<div style="width: 400px; height: 600px; border: 1px solid; float: left; margin-right: 10px;">
			<div style="height: 530px;">
				<h3 style="margin: 20px;">회원정보</h3>
				<table id="memberDataTable">
					<tr>
						<td><img src="<c:url value='/images/somsom.jpg' />" width=150px height=230px />
						</td>
						<td>이름 : 김동덕
							<p /> 등급 : 새싹
							<p /> <br> <a href='#'>회원정보 수정</a>
							<p>
								<a href='#'>로그아웃</a>
						</td>
					</tr>
				</table>
				<br><hr>
				<article>
					<h4 style="margin: 20px;">내 모임 목록</h4>
					<ul>
						<li><a href='#'>투현진</a></li>
						<li><a href='#'>ETW</a></li>
					</ul>
				</article>
			</div>
			<div style="height: 50px;">
				<!-- 루틴 등록 버튼 -->
				<input id="createButton" type="button" value="루틴 등록" onclick="location.href='<c:url value='/routine/create/form' />'">
			</div>
		</div>

		<div style="float: right">
			<!-- 검색창 -->
			<div id="search" style="width: 700px; height: 50px;">
				<form action="" method="get">
					<input type="text" name="routine"
						style="width: 480px; height: 42px;"> 
					<input id="searchButton" type="button" value="검색" onclick="">
					<select name="sort" style="width: 100px; height: 47px;">
						<option value="1" selected>전체</option>
						<option value="2">개인</option>
						<option value="3">인기순</option>
					</select>
				</form>
			</div>
			<!-- 전체 루틴 목록 -->
			<div id="list">
				<div style="width: 670px; height: 30px;">
					<table id="listTable">
						<tr id="listItem">
							<th>루틴명</th>
							<th>등록자</th>
							<th>운동부위</th>
						</tr>
						<tr id="listTr">
							<td>11자 복근 만들기</td>
							<td>솜솜</td>
							<td>복부</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>