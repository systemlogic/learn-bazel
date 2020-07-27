<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>Hello RestApp Test. Base URL is <%= request.getRequestURL() %></h3>

<h2>Department operations</h2>
<pre class="pres">
<table border="1" >
	<tr><th>path</th><th>Request Type</th><th>Description</th></tr>
	<tr><td><%= request.getRequestURL() %>dept</td><td>GET</td><td>Get all department</td></tr>
	<tr><td><%= request.getRequestURL() %>dept/{id}</td><td>GET</td><td>Get information pertaining to specified Department id</td></tr>
	<tr><td><%= request.getRequestURL() %>dept/{deptid}/{deptDesc}</td><td>POST</td><td>Add specified Department to Database</td></tr>
	<tr><td><%= request.getRequestURL() %>dept/{deptid}/{deptDesc}</td><td>PUT</td><td>Change the specified Department in Database</td></tr>
	<tr><td><%= request.getRequestURL() %>dept/{id}</td><td>Delete</td><td>Delete the department identified by id</td></tr>
</table></pre>
<p>Use Header as <b>Accept: application/json</b> OR <b>Accept: application/xml</b></p>
<h2>Employee operations</h2>
<pre class="pres">
<table border="1" >
	<tr><th>path</th><th>Request Type</th><th>Description</th></tr>
	<tr><td><%= request.getRequestURL() %>emp/{id}</td><td>GET</td><td>Get employee information identified by id</td></tr>
	<tr><td><%= request.getRequestURL() %>empList/{did}</td><td>GET</td><td>Get all employee list in department identified by did.</td></tr>
	<tr><td><%= request.getRequestURL() %>emp/{id}/{firstName}/{lastName}/{dept}</td><td>POST</td><td>Add employee identified by information</td></tr>
	<tr><td><%= request.getRequestURL() %>emp/{id}/{firstName}/{lastName}/{dept}</td><td>PUT</td><td>Update employee information identified by id</td></tr>
	<tr><td><%= request.getRequestURL() %>emp/{id}</td><td>Delete</td><td>Delete the employee information identified by id</td></tr>
</table></pre>



</body>
</html>
