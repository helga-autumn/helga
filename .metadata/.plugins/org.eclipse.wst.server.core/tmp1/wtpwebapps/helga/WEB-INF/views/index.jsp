<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<h2></h2>
	<form method="post">
	<table>

		<tr>
			<th>FirstName:</th>
			<td><input name="firstName" type="text"/></td>
		</tr>

<tr>
			<th>Id:</th>
			<td><input name= "id" type="value"/></td>
			</tr>




		<tr>
			<th></th>
			<td><input type="submit" value=""/></td>
		</tr>
	</table>
	</form>
	<table>
	
	<tr>
	<select name = "sellerId"
	<foreach>
	<option value ="${s.id}">
	${s.firstName} </option>
	</foreach>
	
	<c:if test="${persons.size() ne 0}">
		<c:forEach begin="0" end="${persons.size()-1}" var="index">
			<tr>
				<td>FirstName: </td>
				<td>${persons.get(index).firstName}</td>
				<td>;</td>

				<td>Id:</td>
                <td>${persons.get(index).id}</td>
                				<td>;</td>





				<c:url value="/" var="url"/>
				<td><a href="${url}${index}"></a></td>
			</tr>
		</c:forEach>
	</c:if>
		<c:if test="${persons.size() eq 0}">
			<p>Nothing</p>
		</c:if>
	</table>

	<!--
	<div>
		<h2>Create a free Spitter account</h2>
		<sf:form method="POST" modelAttribute="spitter"       enctype="multipart/form-data">
		<fieldset>
		<table cellspacing="0">
			<tr>
				<th><sf:label path="buyer">User:</sf:label></th>
					<td>
						<sf:input path="buyer" size="15" maxlength="15" />
				  		<small id="buyer_msg">No spaces, please.</small><br/>
				  		<sf:errors path="buyer" cssClass="error" />
				  	</td>
			</tr>
		</table>
		</fieldset>
		</sf:form>
	</div>
	-->

</body>
</html>