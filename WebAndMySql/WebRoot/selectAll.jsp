
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>所有员工信息</title>
		<style type="text/css">
			table td {
				text-align: center;
			}
			/*合并表格的边框*/
			
			table {
				width: 700px;
				border-collapse: collapse;
			}
			
			h3 {
				text-align: center;
			}
			
			div {
				margin: 0 auto;
				width: 700px;
			}
		</style>
	</head>

	<body>
		<div>
			<h3>所有员工信息</h3>
			<a href="insert.jsp">添加员工信息</a><br/>
			<table border="1">

				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机</th>
					<th>邮箱</th>
					<th>QQ</th>
					<th>操作</th>
				</tr>
		<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.id }</td>
					<td>${item.name }</td>
					<td>${item.sex }</td>
					<td>${item.age }</td>
					<td>${item.tel }</td>
					<td>${item.email }</td>
					<td>${item.qq }</td>
					<td><a href="ModifyInfo?id=${item.id }">修改</a>&nbsp;
						<a href="DeleteServlet?id=${item.id }">删除</a></td>
				</tr>
		</c:forEach>
			</table>
			<br>
			<c:if test="${pages.selectPage > 1 }">
				<a href = "UserServlet?point=1">首页</a>
				<a href = "UserServlet?point=${pages.selectPage - 1 }">上一页</a>
			</c:if>
			
			<c:if test="${pages.selectPage < pages.pageCount }">
				<a href = "UserServlet?point=${pages.selectPage + 1 }">下一页</a>
				<a href = "UserServlet?point=${pages.pageCount}">末页</a>
			</c:if>
			<form action="${pageContext.request.contextPath }/UserServlet">
				<h4 align="center">共${pages.pageCount}页</h4>
				<input type="text" value="${pages.selectPage}" name="point" size="1">页
				<input type="submit" value="跳转">
			</form>
			
		</div>
	</body>

</html>