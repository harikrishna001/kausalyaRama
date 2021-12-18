<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  
<!DOCTYPE html>
<html>
<head>

<script>

function confirmDelete()
{

	return confirm("Are you sure ,you want to delete")

	}

</script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<title>InsertTitleHere</title>

<h3>view contacts</h3>

<a href="loadForm">+ Add New Contact</a>
<table border="1">

<thead>
<tr>
 
 <th>S.No</th>
 <th>Name</th>
 <th>Email</th>
 <th>Number</th>
 
 <th>Action</th>
 </tr>


</thead>

<tbody>

<!--  contacts numchi okokkaobject thesi c ki isthadi jsp for each edi-->
<c:forEach  items="${contacts}" var="c" varStatus="count"><!-- ekkada  [varstatus] anedi index record retrive avvagae okkokka record count chesi number print chesthadi 1,2,3 record ala ok-->

<tr>
<td>${count.index+1}</td>

<td>${c.contactName}</td>
<td>${c.contactNumber}</td>
<td>${c.contactEmail}</td>

<!--  edit edi contactid ni queryparameter ga send chesthunnam amte edit or update kodite ayokka id record varaku details vasthe edit chestham amte ikkada onerecord varake edit kottina record varake retrive annattlu query parameter amduke vadedi ok -->
<td><a href="editContact?cid=${c.contactId}">Edit</a> &nbsp; 
         <!--evidam ga c.contactid kodithe pothadi or contactid anedi ela vasthadi amte [c] anedi object adi contact details hold one by one record retrive chesi damtlo jsp page lo rasthadi kada button dani meda vumtadi click ivvagane modifie avuthadi ok ayokka id meda last lo link pettam kabatti modefie  -->

<a href="deleteContact?cid=${c.contactId}" onclick="return confirmDelete()">Delete</a></td>
</tr>


</c:forEach>
</tbody>

</table>
</body>
</html>