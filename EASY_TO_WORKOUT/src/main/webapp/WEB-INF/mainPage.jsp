<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

#clubTable {
	border-collapse: collapse;
	width: 700px;
	table-layout: fixed;
}

#clubScedule {
	height: 250px;
}

#clubCaption {
	height: 40px;
	border-bottom: 1px solid;
}
#clubDate {
	height: 35px;	
}

#memberDataTable {
	border-collapse: collapse;
	width: 400px;
	height: 230px;
	table-layout: fixed;
}

#myClubScheduleTable {
	border-collapse: collapse;
	width: 400px;
	height: 100px;
	table-layout: fixed;
}

#etcButton {
	background-color: #90ABDA;
}

th, td {
	text-align: center;
}
</style>
<!-- � ��� ���� -->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	google.setOnLoadCallback(drawChart);

	function drawChart() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', '��¥ ');
		data.addColumn('number', ' � �ð� ');
		
		var records = [];
		for (var index in ${recordList}) {
			records[index] = [
				Math.floor(${recordList}[index][0] / 10000).toString() + "�� "
				+ Math.floor(${recordList}[index][0] % 10000 / 100).toString() + "�� "
				+ (${recordList}[index][0] % 100).toString() + "��",
				${recordList}[index][1]
			];
		}
		data.addRows(records);
		
		var opt = {
			'title' : '� ��� ',
			'width' : 700,
			'height' : 250,
			'fontSize' : 10,
		};

		var chart = new google.visualization.BarChart(document
				.getElementById('record'));
		chart.draw(data, opt);
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
			<li><a href='<c:url value='/club/list' />'>����</a></li>
			<li><a href='<c:url value='/routine/list' />'>��ƾ</a></li>
			<li><a href='#'>���̾</a>
				<ul class="subMenu">
					<li><a href='<c:url value='/diary/my/list' />'>MY ���̾</a></li>
					<li><a href='<c:url value='/diary/all/list' />'>��ü ���̾</a></li>
				</ul></li>
		</ul>
	</nav>

	<hr>
	<div class="container">
		<!-- ȸ������ -->
		<jsp:include page="/WEB-INF/member/memberInfo.jsp"/>

		<div style="float: right">
			<!-- � ��� �׷��� -->
			<c:set var="recordList" value="${recordList}" />
			<div id="record"
				style="width: 700px; height: 250px; border: 1px solid;"></div>
			<!-- ���� ���� -->
			<div
				style="width: 700px; height: 340px; border: 1px solid; margin-top: 10px;">
				<p>
				<table id="clubTable">
					<tr id="clubCaption">
						<th>���� �̸�</th>
						<th>��¥</th>
						<th colspan="2">���� �ּ�</th>
						<th></th>
					</tr>
					<c:forEach var="i" begin="0" end="7">
						<c:if test="${clubList[i].clubName ne null }">
							<tr id="clubDate">
								<td>${clubList[i].clubName}</td>
								<td>${scheduleList[i].creationDate}</td>
								<td colspan="2">${scheduleList[i].contactAddress}</td>
								<td>
									<a href="<c:url value='/club/schedule/view'>
											<c:param name='clubId' value='${scheduleList[i].clubId}'/>
											<c:param name='scheduleId' value='${scheduleList[i].scheduleId}'/>
											<c:param name='clubName' value='${clubList[i].clubName}' />
										</c:url>">
										<input id="etcButton" type="button" value="������">
									</a>
								</td>
							</tr>
						</c:if>
						<c:if test="${clubList[i].clubName eq null }">
							<tr></tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>