<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>修改信息</title>
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
			<h3>修改员工信息</h3>
			<form action="${pageContext.request.contextPath }/ModifyInfo2" method="post">
					<input type="hidden" name="id" value="${user.id }"/>
				<table border="1">
			
					<tr>
						<th>姓名</th>
						<td><input type="text" name="name" value="${user.name }"/></td>
					</tr>
					<tr>
						<th>性别</th>
						<td>
							<input type="radio" name="sex" value="男" <c:if test="${user.sex == '男'}"> checked="checked" </c:if>/>男
							<input type="radio" name="sex" value="女" <c:if test="${user.sex == '女'}"> checked="checked" </c:if> />女
						</td>
					</tr>
					<tr>
						<th>年龄</th>
						<td><input type="text" name="age" value="${user.age }" /></td>
					</tr>
					<tr>
						<th>手机</th>
						<td><input type="text" name="tel" value="${user.tel }" /></td>
					</tr>
					<tr>
						<th>邮箱</th>
						<td><input type="text" name="email" value="${user.email }" /></td>
					</tr>
					<tr>
						<th>QQ</th>
						<td><input type="text" name="qq" value="${user.qq }" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" />&nbsp;
							<input type="reset" value="重置" /></td>
					</tr>
				</table>
			</form>
		</div>
	</body>

</html>