<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h1> Welcome - <c:out value="${user.username}"/></h1> 
<h1>List Of Courses</h1>
	<table id="customers">
		<tr>
			<th>COURSE NAME</th>
			<th>COUNT OF PROFESSORS AVAILABLE</th>
			<th>ACTION</th>
		</tr>
		<c:forEach items="${listOfCoursesAndCount}" var="courseAndCount">
			<tr>
				<td>${courseAndCount.key}</td>
				<td>${courseAndCount.value}</td>
				<td>
				<a href="${pageContext.request.contextPath}/selectTutors/${courseAndCount.key}/${user.username}">
						<button type="button">VIEW</button>
				</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<h1> Courses Taken by Student - <c:out value="${user.username}"/> </h1>
	<table id="customers">
		<tr>
			<th>COURSE NAME</th>
			<th>TUTOR NAME</th>
			<th>DURATION</th>
		</tr>
		<c:forEach items="${coursesOfStudent}" var="courseOfStudent">
			<tr>
				<td>${courseOfStudent.courseName}</td>
				<td>${courseOfStudent.tutor.tutorName}</td>
				<td>${courseOfStudent.duration}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>