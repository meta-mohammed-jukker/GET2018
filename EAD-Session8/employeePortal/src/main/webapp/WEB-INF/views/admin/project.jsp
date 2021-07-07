<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Project</title>
</head>
<body>
	<form name="addProjectForm" method="post" action="addProject">
		<table>

			<tr>
				<td>Project Description:</td>
				<td><input type="text" name="projectDescription" /></td>
			</tr>

			<tr>
				<td>Project Start Date:</td>
				<td><input type="date" name="projectStartDate" /></td>
			</tr>

			<tr>
				<td>Project End Date:</td>
				<td><input type="date" name="projectEndDate" /></td>
			</tr>

			<tr>
				<td>Project Logo:</td>
				<td><input type="file" name="upload" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>