<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details View</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/add-customer-style.css" />"/>
</head>
<body>
<div id = "wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div id = "container">
			<form:form action="saveDetails" modelAttribute="detail" method="POST">
			    <form:input type="hidden" path="customer.id"  value="${customer.id}"/>
			    <h3>Customer details for ${customer.firstName} ${customer.lastName}</h3>
				<table>
					<tbody>
						<tr>
							<td><label>Phone number:</label></td>
							<td><form:input path="phoneNumber" /></td>
						</tr>
						<tr>
							<td><label>Address: </label></td>
							<td><form:input path="address" /></td>
						</tr>
						<tr>
							<td><label>Pesel: </label></td>
							<td><form:input path="pesel" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			
			<div style="clear; both;"></div>
			
			<p>
			 	<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</p>
		</div>
	</div>
</body>
</html>