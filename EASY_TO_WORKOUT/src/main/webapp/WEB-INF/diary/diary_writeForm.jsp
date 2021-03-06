<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EASY TO WORK OUT</title>
<style>
@import url(//font.elice.io/EliceDigitalBaeum.css);
body {
    font-family: "Elice Digital Baeum",sans-serif;
}
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

#diaryTable {
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
		alert("제목을 입력하세요.");
		writeForm.diaryTitle.focus();
		return false;
	}
	if (writeForm.workTime.value == "") {
		alert("운동시간을 입력하세요.");
		writeForm.workTime.focus();
		return false;
	}
	if (writeForm.diaryContents.value == "") {
		alert("내용을 입력하세요.");
		writeForm.diaryContents.focus();
		return false;
	}
	writeForm.submit();
}
</script>

</head>

<body>
	<!-- 운동하기 편하군&로고 -->
	<div style="text-align: center">
		<a href="<c:url value='/main' />"><img src="<c:url value='/images/logo.PNG' />"
			width=500px height=130px /></a>
	</div>
	<!-- 돌아가기 버튼 -->

	<hr>
	<!-- 메뉴바 -->
	<nav class="menu">
		<ul class="mainMenu">
			<li><a href="<c:url value='/club/list' />">모임</a></li>
			<li><a href="<c:url value='/routine/list' />">루틴</a></li>
			<li><a href='#'>다이어리</a>
				<ul class="subMenu">
					<li><a href="<c:url value='/diary/my/list' />">MY 다이어리</a></li>
					<li><a href="<c:url value='/diary/all/list' />">전체 다이어리</a></li>
				</ul></li>
		</ul>
	</nav>

	<hr>
	<div class="container">
		<!-- 회원정보 -->
		<jsp:include page="/WEB-INF/member/memberInfo.jsp"/>

		<div style="float: right">
			<!-- 다이어리 작성 부분  -->
			<div id="diaryInput">
				<h3 style="margin: 20px;">다이어리 작성</h3>
				<hr>
				<form name="writeForm" method="POST" action="<c:url value='/diary/create' />">
				<table id="diaryTable">
					<tr id="diaryTableTr">
						<td style="width: 130px;">제목 :</td>
						<td><input type="text" name="diaryTitle" autocomplete="off"
							style="width: 450px; height: 20px; font-size: 15px;"></td>
					</tr>
					<tr id="diaryTableTr">
						<td style="width: 130px;">공개 여부 :</td>
						<td>
							<input type="checkbox" name="isPrivate" />비공개
						</td>
					</tr>
					<tr id="diaryTableTr">
						<td style="width: 130px;">운동 시간 :</td>
						<td>
							<input type="number" name="workTime" min="1" max="999" /> 분
						</td>
					</tr>
					<tr id="diaryTableTr">
						<td style="width: 130px;">내용 :</td>
						<td><textarea name="diaryContents" rows=15 cols=45  
							style="width: 450px; resize: none;"></textarea></td>
					</tr>
				</table>
				<div style="text-align: center; margin-left: 130px;">
					<input id="diaryWriteButton" type="button" value="다이어리 작성"
						onclick="diaryWriteBtn_click()"> 
					<input id="backButton" type="button" value="돌아가기" 
						onclick="history.back()">
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>