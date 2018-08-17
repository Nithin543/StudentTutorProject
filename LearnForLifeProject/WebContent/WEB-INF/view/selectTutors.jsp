<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
<body>
	<h1>
		Welcome -
		<c:out value="${userName}" />
	</h1>
	<h1>
		List Of Tutors For Course -
		<c:out value="${courseName}" />
	</h1>
	<form:form action="${pageContext.request.contextPath}/assignStudent/${userName}" modelAttribute="check_box" method="POST">
		<table id="customers">
			<tr>
				<th>SELECT COURSES</th>
				<th>TUTOR NAME</th>
				<th>PRICE</th>
				<th>DURATION</th>
			</tr>
			<c:forEach items="${tutorsOfACourse}" var="tutorCourse">
				<tr>
					<td> 
						<form:checkbox path="listOfTutors" value="${tutorCourse.tutor.tutorName}" />
					</td>
					<td>${tutorCourse.tutor.tutorName}</td>
					<td>${tutorCourse.price}</td>
					<td>${tutorCourse.duration}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="SUBMIT YOUR REQUEST">
	</form:form>
</body>
</html>