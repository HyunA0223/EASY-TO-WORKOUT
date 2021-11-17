<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ETW MainPage</title>
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

#clubTable {
	border-collapse: collapse;
	width: 700px;
	table-layout: fixed;
}

#clubScedule {
	height: 250px;
}

#clubDate {
	border-bottom: 1px solid;
	height: 50px;
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

th, td {
	text-align: center;
}
</style>
<!-- � ��� ���� ���� -->
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
		data.addRows([ [ '2020.03.02', 51 ], [ '2020.03.03', 0 ],
				[ '2020.03.04', 140 ], [ '2020.03.05', 110 ],
				[ '2020.03.06', 0 ], [ '2020.03.07', 15 ],
				[ '2020.03.08', 45 ], [ '2020.03.09', 123 ], ]);

		var opt = {
			'title' : '� ��� ',
			'width' : 700,
			'height' : 250,
		};

		var chart = new google.visualization.BarChart(document
				.getElementById('record_ex'));
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
			<br><hr>
			<article>
				<h4 style="margin: 20px;">�� ���� ���</h4>
				<ul>
					<li><a href='#'>������</a></li>
					<li><a href='#'>ETW</a></li>
				</ul>
			</article>
		</div>

		<div style="float: right">
			<!-- � ��� ���� �׷��� -->
			<div id="record_ex"
				style="width: 700px; height: 250px; border: 1px solid;"></div>
			<!-- ���� ���� ���� -->
			<div
				style="width: 700px; height: 340px; border: 1px solid; margin-top: 10px;">
				<p>
				<table id="clubTable">
					<caption>���� ����</caption>
					<tr id="clubDate">
						<th>09</th>
						<th>10</th>
						<th>11</th>
						<th>12</th>
						<th>13</th>
						<th>14</th>
						<th>15</th>
					</tr>
					<tr id="clubScedule">
						<td>
							<p style="font-style: italic;">PM 06:00</p>
							<p style="color: #006CD4;">ETW
						</td>
						<td></td>
						<td>
							<p style="font-style: italic;">AM 10:00</p>
							<p style="color: #7F00D4;">������
						</td>
						<td></td>
						<td></td>
						<td>
							<p style="font-style: italic;">AM 10:00</p>
							<p style="color: #7F00D4;">������
							<p style="font-style: italic;">PM 08:00</p>
							<p style="color: #006CD4;">ETW
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>