<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
   <th>Product Id</th>
   <th>Name</th>
   <th>Qty</th>
   <th>Price</th>
   <th>ExpDate</th>
   <th>Cid</th>
   <th>Actions</th>
</tr>
<c:forEach var="prod" items="${plist}">
  <tr>
    <td>${prod.pid}</td>
    <td>${prod.pname}</td>
    <td>${prod.qty}</td>
    <td>${prod.price}</td>
    <td>${prod.ldt}</td>
    <td>${prod.cid}</td>
    <td>
      <a href="editproduct/${prod.pid}">edit</a> /
       <a href="deleteproduct/${prod.pid}">delete</a>
    </td>
          
  </tr>
</c:forEach>
</table>
<form action="addnewproduct" >
  <button type="submit" name="btn" id="add">Add new Product</button>
</form>
</body>
</html>