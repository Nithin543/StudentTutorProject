<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
input[type=text] {
	width: 50%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password] {
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
.dropbtn:hover, .dropbtn:focus {
    background-color: #2980B9;
}
.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #ff000;
    min-width: 160px;
    overflow: auto;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-content a {
    color: white;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="register" modelAttribute="registration"
		method="POST">
		<form:input path="username" placeholder="Enter User Name" />
		<br>
		<br>
		<form:input path="password" type="password"
			placeholder="Enter Password" />
		<br>
		<br>
		<form:input path="email" placeholder="Enter Email" />
		<br>
		<br>
		<div class="dropdown">
		<form:select path="role" class="dropbtn">
		<div  class="dropdown-content">
			<form:options items="${registration.roleOptions}"  />
			</div>
		</form:select>
		</div>
		<br>
		<br>
		MALE: <form:radiobutton path="gender" value="MALE" />
		FEMALE: <form:radiobutton path="gender" value="FEMALE" />
		<br>
		<br>
		<input type="submit" value="Register">
	</form:form>
</body>
</html>