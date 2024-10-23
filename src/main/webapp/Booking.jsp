<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Utility.DisplayCars" %>

<!DOCTYPE html>

<html>

<head>

<title>Car Rental</title>
<%@ include file="HeadLinks.jsp" %>

</head>

<body>

<%@ include file="Header.jsp" %>

<% 
	String ID = request.getParameter("id"); 
	DisplayCars.BigPic(ID);
%>
<div class="d-flex justify-content-center">
	<div class='col-9 py-3'>
		<a><div class=' position-relative ratio' style='--bs-aspect-ratio: 30%;'>
				<img src='images/<%= DisplayCars.Image %>' class='object-fit-cover rounded-top-3 shadow' />
			</div>
            <div class='package-info rounded-bottom-3 shadow'>
                <h5 class='capitalize fs-1'><%= DisplayCars.Name %></h5>
                <h6 class='fs-4'>₹<%= DisplayCars.Rent %> / Day</h6>
                <h6 class='fs-4'><%= DisplayCars.Mileage %> km/l</h6>
		</div></a>
	</div>
</div>

<%@ include file="Footer.jsp" %>


</body>

</html>