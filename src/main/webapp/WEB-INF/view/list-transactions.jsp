<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions list</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>
</head>
<body>
	<div id = "wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div id = "container">
			<br>
			<input type="button" value="Add Transaction"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"
			/>
			<div id="content">
				<table>
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Realisation time (days)</th>
						<th>Action</th>
					</tr>
					<c:forEach var = "transaction" items="${transactions}">
						<c:url var="updateLink" value="/transaction/showFormForUpdate">
							<c:param name="transactionId" value="${transaction.id}" />
						</c:url>
						<c:url var="deleteLink" value="/transaction/delete">
							<c:param name="transactionId" value="${transaction.id}" />
						</c:url>
						<c:url var="detailLink" value="/transaction/showFormForUpdateDetails">
						    <c:param name="transactionId" value="${transaction.id}" />
                        </c:url>
						<tr>
							<td>${transaction.name}</td>
							<td>${transaction.price}</td>
							<td>${transaction.realisationTime}</td>
							<td>
							<a href="${updateLink}">Update</a> 
							| 
							<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this transaction?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>				
			</div>
			<p>
            <a href="${pageContext.request.contextPath}/customer/list">Customer List</a>
            </p>
		</div>
	</div>
</body>
</html>