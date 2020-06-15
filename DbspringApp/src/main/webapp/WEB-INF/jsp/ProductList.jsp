<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 </head>
 <body>
 <div class="container">

<h1>List of Products</h1>
<h3><a href="newProduct">Add Product</a></h3>

<div>
<p:if test="${!empty products}">
 <h2>List of Products</h2>
 <table class="table table-stripped table-responsive table-hover">
 <tr>
 <th>Product Id</th>
 <th>Product Name</th>
 <th>Quantity</th>
 <th>Brand</th>
 <th>Price</th>
</tr>
<p:forEach items="${products}" var="p">
<tr>
<td>${p.pid}</td>
<td>${p.pname}</td>
<td>${p.qty}</td>
<td>${p.pbrand}</td>
<td>${p.pprice}</td>
<td align="center">
<a href="/spring-prod-web-mvc/spring/edit/${p.pid}">
<input type="button" value="EDIT" class="btn btn-info">
</a> 
</td>
<td>
<a href="/spring-prod-web-mvc/spring/delete?id=${p.pid}">
<input type="button" value="DELETE" class="btn btn-primary">
</a></td>
</tr>
</p:forEach>
</table>
 </p:if>
 </div>
</div>
 
 </body>
 </html>