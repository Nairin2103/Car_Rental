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

<section class="packages py-5">
    <div class="container py-lg-4 py-sm-3">
        <h3 class="heading text-capitalize text-center fs-3">Discover our Cars</h3>
        <p class="text mt-2 mb-5 text-center">Explore our diverse range of Cars. From rugged SUVs for adventurous road trips to sleek sedans for a smooth, comfortable ride, find the perfect car for your next journey.</p>
        <div class="row">
            
            <%= DisplayCars.GetInfo() %>
            
        </div>
    </div>
</section>

<%@ include file="Footer.jsp" %>

</body>

</html>