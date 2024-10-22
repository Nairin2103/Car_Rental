<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.DriverManager" %>

<!DOCTYPE html>

<html>

<head>

<title>Car Rental</title>
<%@ include file="HeadLinks.jsp" %>

</head>

<body>

<%@ include file="Header.jsp" %>

<form runat="server">
    <section class="packages py-5">
        <div class="container py-lg-4 py-sm-3">
            <h3 class="heading text-capitalize text-center">Discover our Cars</h3>
            <p class="text mt-2 mb-5 text-center">Explore our diverse range of Cars. From rugged SUVs for adventurous road trips to sleek sedans for a smooth, comfortable ride, find the perfect car for your next journey.</p>
            <div class="row">
                
                <!-- <div class='col-lg-3 col-sm-6 py-3 grow-div'>
                    <a href="PackageDetails.aspx?Destination=WorldTour">
                    <div class='position-relative ratio' style='--bs-aspect-ratio: 66.67%;'>
                        <img src='images/worldtour.jpg' class='object-fit-cover rounded-top-3 shadow' />
                    </div>
                    <div class='package-info rounded-bottom-3 shadow'>
                        <h5 class='capitalize'>Around the Globe</h5>
                    </div>
                    </a>
                </div> -->

                <% DisplayCars dc = new DisplayCars();%>
                <%= dc.GetInfo() %>

            </div>
        </div>
    </section>
    </form>

<%@ include file="Footer.jsp" %>


</body>

</html>