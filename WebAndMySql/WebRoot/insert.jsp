<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>添加信息</title>
		<style type="text/css">
			table {
				width: 300px;
				border-collapse: collapse;
			}
			
			h3 {
				text-align: center;
			}
			
			div {
				margin: 0 auto;
				width: 300px;
			}
		</style>
	</head>

	<body>
		<div>
			<h3>添加员工信息</h3>
			<form action="${pageContext.request.contextPath }/InsertInfo" method="post">
				<table border="1"> 
					<tr>
						<th>姓名</th>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<th>性别</th>
						<td>
							<input type="radio" name="sex" value="男" />男
							<input type="radio" name="sex" value="女"  />女
						</td>
					</tr>
					<tr>
						<th>年龄</th>
						<td><input type="text" name="age" /></td>
					</tr>
					<tr>
						<th>手机</th>
						<td><input type="text" name="tel" /></td>
					</tr>
					<tr>
						<th>邮箱</th>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<th>QQ</th>
						<td><input type="text" name="qq" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="添加" />&nbsp;
							<input type="reset" value="重置" /></td>
					</tr>
				</table>
			</form>
		</div>
	</body>

</html>