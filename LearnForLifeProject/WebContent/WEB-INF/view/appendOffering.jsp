<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
input[type=text] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=submit] {
    width: 50%;
    background-color: SlateBlue;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
h1 {
    color: SlateBlue;
}
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: SlateBlue;
	color: white;
}
</style>
</head>
<body>
<h1>List Of Course Offerings Of - <c:out value="${courseName}"/></h1>
	<table id="customers">
		<tr>
			<th>TUTOR NAME</th>
			<th>PRICE</th>
			<th>DURATION</th>
		</tr>
		<c:forEach items="${listOfCourseOfferings}" var="courseOffering">
			<tr>
				<td>${courseOffering.tutor.tutorName}</td>
				<td>${courseOffering.price}</td>
				<td>${courseOffering.duration}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
<h1>Append Your Offering</h1>
	<form:form  action="${pageContext.request.contextPath}/appendCourse/${courseName}/${userId}" 						
				modelAttribute="courseOfferingFields" 
				method="POST">
		<h5> Enter the Price</h5><form:input path="price"/>
		<h5> Enter Duration </h5><form:input path="duration"/>
		<input type="submit" value="Submit Your Offering">
	</form:form>
</body>
</html>