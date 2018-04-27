<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
</head>
<body>
 <form method="post" action="seveUser">
		用户名：<input type="text" name="userCode" value="${user.userCode}"><br> 
		密码：<input type="text" name="password" value="${user.password}"><br>
		<input type="submit" value="保存">
</form>
<div>用户：
   <div>
   <table>
	<c:if test="${!empty userDTOList}">
		<c:forEach items="${userDTOList}" var="userDTO" varStatus="index">
		<tr><td>  ${userDTO.userCode} , ${userDTO.password};<a href="deleteUser?userCode=${userDTO.userCode}"> 删除</a></td></tr>
		</c:forEach>
	</c:if>
	</table>
	</div>
</div>
</body>
</html>