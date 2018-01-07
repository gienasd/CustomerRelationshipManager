<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/add-customer-style.css" />"/>
<style> .error {color:red} </style>
</head>
<body>
<div id = "wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div id = "container">
			<h3>Save Customer</h3>
			
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">

				<form:hidden path="id" />
				<table>
					<tbody>
						<tr>
							<td><label>First name: </label></td>
							<td><form:input path="firstName" /></td>
							<td><form:errors path="firstName" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label>Last name: </label></td>
							<td><form:input path="lastName" /></td>
							<td><form:errors path="lastName" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label>Email: </label></td>
							<td><form:input path="email" /></td>
							<td><form:errors path="email" cssClass="error"/></td>
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