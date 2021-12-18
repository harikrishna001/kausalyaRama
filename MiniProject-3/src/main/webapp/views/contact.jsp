<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h1>save contactdetails here</h1>

<p><font color='green'>${sucessMsg}</font></p><!-- data save ayethe green color lo sucess ani message lakapothe red color lo error ani ravali ok -->
<p><font color='green'>${errMsg}</font></p>

 <!--  savecontact anedi path details ichhi submit kodithe controller lo ayokka method ki pothadi damtho patu contactid kuda first 
 time [null] ga pothadi next vachhi id base chesukoni controller ki pothadi update appudu  
 DENIGURIMCHI [ASHOKMINIPROJECT1.TXT NOTEPAD LO CHEPPANU CHUDU .DIFFERNCE KOSAM [miniprojecyt2,miniproject] rendu chudu ardamavuthadi ok
  -->
<form:form action="saveContact?contactId=${contact.contactId}" modelAttribute="contact" method="POST">

<table>
<tr>

<td>ContactName</td>

<td><form:input path="contactName"/></td>

</tr>

<tr>

<td>ContactEmail</td>

<td><form:input path="contactEmail"/></td>

</tr>
<tr>

<td>ContactNumber</td>

<td><form:input path="contactNumber"/></td>

</tr>

<tr>

<td></td>

<td><input type="submit" value="save"></td>

</tr>

</table>
</form:form>
<a href="viewContacts">View All Contacts</a>
</body> 
</html>