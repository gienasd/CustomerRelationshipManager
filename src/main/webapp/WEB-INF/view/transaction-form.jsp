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
			
			<form:form action="saveTransaction" modelAttribute="transaction" method="POST">

				<form:hidden path="id" />
				<table>
					<tbody>
						<tr>
							<td><label>Name: </label></td>
							<td><form:input path="name" /></td>
							<td><form:errors path="name" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label>Price: </label></td>
							<td><form:input path="price" /></td>
							<td><form:errors path="price" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label>Realisation time (days): </label></td>
							<td><form:input path="realisationTime" /></td>
							<td><form:errors path="realisationTime" cssClass="error"/></td>
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
			 	<a href="${pageContext.request.contextPath}/transaction/list">Back to Transaction List</a>
			</p>
			
		</div>
	</div>
</body>
</html>