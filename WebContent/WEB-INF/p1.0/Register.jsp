<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/service/register" method="post">
	<table>
		<tr>
			<th>名字</th>
			<td><input name="username" type="text" value="${UserBean.username}"></td>
			<td style="color :red ;font-size : 0.4rem;font-style:italic;">${UserBean.errorsMap.userNameError }<td>
		</tr>
		<tr>
			<th>密码</th>
			<td><input name="password" type="text" value="${UserBean.password }"></td>
			<td style="color :red ;font-size : 0.4rem;font-style:italic;">${UserBean.errorsMap.passwordError }<td>
		</tr>
		<tr>
			<th>性别</th>
			<td><input type="radio" name="sex" value='0'
				<c:if test="${ UserBean.sex==0 }">checked="checked"</c:if>
			><label>男</label>
				<input type="radio" name="sex" value='1'
					<c:if test="${ UserBean.sex==1 }">checked="checked"</c:if>
				><label>女</label></td>
			<td style="color :red ;font-size : 0.4rem;font-style:italic;">${UserBean.errorsMap.sexError }<td>
		</tr>
		<tr>
			<th>生日</th>
			<td><input name="birthday" type="text" value="${UserBean.birthday }"></td>
			<td style="color :red ;font-size : 0.4rem;font-style:italic;">${UserBean.errorsMap.birthdayError }<td>
		</tr>
		<tr>
			<th>爱好</th>
			<td><input type="checkbox" name="hobby" value='0'
				<c:forEach var="ho" items="${ UserBean.hobby}">
					<c:if test="${ho=='0'}"> checked="checked"</c:if>
				</c:forEach>>唱歌
			<input type="checkbox" name="hobby" value='1'
				<c:forEach var="ho" items="${ UserBean.hobby}">
					<c:if test="${ho=='1'}"> checked="checked"</c:if>
				</c:forEach>>跳舞
			<input type="checkbox" name="hobby" value='2'
			<c:forEach var="ho" items="${ UserBean.hobby}">
					<c:if test="${ho=='2'}"> checked="checked"</c:if>
				</c:forEach>>玩游戏</td>
			<td style="color :red ;font-size : 0.4rem;font-style:italic;">${UserBean.errorsMap.hobbyError }<td>
		</tr>
		<tr>
			<th>学历</th>
			<td><select name="education">
				<option value="xiaoxue" 
					<c:if test="${UserBean.education=='xiaoxue' }">
						selected="selected"
					</c:if>
				>小学</option>
				<option value="zhongxue"
					<c:if test="${UserBean.education=='zhongxue' }">
						selected="selected"
					</c:if>
				>中学</option>
				<option value="daxue"
					<c:if test="${UserBean.education=='daxue' }">
						selected="selected"
					</c:if>
				>大学</option>
				<option value="yanjiusheng"
					<c:if test="${UserBean.education=='yanjiusheng' }">
						selected="selected"
					</c:if>
				>研究生</option>
			</select></td>
			<td style="color :red ;font-size : 0.4rem;font-style:italic;">${UserBean.errorsMap.educationError }<td>
		</tr>
		<tr>
			<th>简介</th>
			<td><textarea rows="20" cols="60" name="introduce" ></textarea></td>
			
		</tr>
		<tr>
			<td><input value="提交" type="submit"></td>
		</tr>
	</table>
	</form>

</body>
</html>
