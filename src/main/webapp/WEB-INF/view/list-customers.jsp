<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers list</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>
</head>
<body>
	<div id = "wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div id = "container">
			<br>
			<input type="button" value="Add Customer" 
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"
			/>
			<div id="content">
				<table>
					<tr>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
						<th>Action</th>
						<th>More...</th>
					</tr>	
					<c:forEach var = "tempCustomer" items="${customers}">
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						<c:url var="detailLink" value="/customer/showFormForUpdateDetails">
						    <c:param name="customerId" value="${tempCustomer.id}" />
                        </c:url>
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>
							<a href="${updateLink}">Update</a> 
							| 
							<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							</td>
							<td>
							<a href="${detailLink}">Details</a>
							</td>
						</tr>
					</c:forEach>
				</table>				
			</div>
			<p>
            <a href="${pageContext.request.contextPath}/transaction/list">Transaction List</a>
            </p>
		</div>
	</div>
</body>
</html>