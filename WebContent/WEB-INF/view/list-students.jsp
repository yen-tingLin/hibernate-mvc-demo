<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<link type="text/css" rel="stylesheet" href="${pageContent.request.contextPath}/HibernateMvcDemo/myResources/css/style.css"/>
		
	</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Students</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		
			<!-- html table  -->		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<!-- loop over and list all students -->
				<c:forEach var="tempStudent" items="${all_students}">
					
					<tr>
						<td> ${tempStudent.firstName}</td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.email} </td>
					</tr>	
								
				</c:forEach>

			</table>
<!-- 			
			Id : {student_by_id.id}
			<br><br>
			First name : {student_by_id.firstName}
			<br><br>
-->					
		</div>
	</div>	
	
	
</body>
</html>