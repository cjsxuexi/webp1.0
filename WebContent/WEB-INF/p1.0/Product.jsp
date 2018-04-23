<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/view/productServlet" method="post">
	
		<table>
			<thead>商品清单</thead>
			<tr>
				<th>商品id</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>商品描述</th>
				<th>商品sku</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${Products}" var="product">
				<tr>
					<td>${product.pid }</td>
					<td>${product.pname }</td>
					<td>${product.pricate }</td>
					<td>${product.introduce }</td>
					<td>${product.pno }</td>
					<td><a href="${pageContext.request.contextPath }/view/catServlrt?id=${product.pid}">添加</a>
				</tr>
			
			</c:forEach>
			
		</table>
	
	</form>

</body>
</html>