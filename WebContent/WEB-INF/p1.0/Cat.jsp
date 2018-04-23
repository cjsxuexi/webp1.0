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

	<form action="${pageContext.request.contextPath }/view/catServlrt">
		<table>
			<thead>购物车清单</thead>
			<tr>
				<th>商品名</th>
				<th>商品数量</th>
				<th>商品小计</th>
			</tr>
			<c:forEach items="${Car.catMap }" var="entry">
				<tr>
					<td>${entry.value.product.pname}</td>
					<td>${entry.value.number}</td>
					<td>${entry.value.subtotal }</td>
				</tr>
			</c:forEach>
			<tfoot>
				<tr>
					<th>总金额：</th>
					<td>${Car.totalSum }</td>
				</tr>
			</tfoot>
		</table>
		
	
	</form>

</body>
</html>