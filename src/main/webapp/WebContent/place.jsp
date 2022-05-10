<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.NumberFormat"%>
<%@ page import="java.util.*"%>
<%@ page import = "java.lang.*" %>
<%@ page import="com.pokemon.dto.*"%>
<%@ page import="com.pokemon.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<jsp:include page="./includeFile.jsp" />
<link rel="stylesheet" type="text/css" href="./css/pokemon.css" />

<head>
<meta charset="UTF-8">
<title>Place Book</title>

<%
PlaceDAO placeDao = PlaceDAO.getInstance();
ArrayList<PlaceDTO> places = (ArrayList<PlaceDTO>) request.getAttribute("places");


String select = (String) request.getAttribute("select");

%>

<style>

.g72-filter:before {
	font-family: nike-glyphs;
	margin-left: 5px;
	content: "\E615";
	display: inline-block;
	font-size: inherit;
	line-height: inherit;
	vertical-align: top;
	font-style: normal;
	font-variant: normal;
	font-weight: 400;
}
.hasFilter {
	background-color: white;
	border: none;
	width: 100px;
	font-size: 18px;
	font-weight: 400;
}
#sort {
	width: 100px;
	border: none;
	font-size: 18px;
	font-weight: 400;
}
</style>

</head>
<body>
	<div class="header">

		<jsp:include page="./header.jsp" />
	</div>

	<div class="content" style="display: inline-block;">
		<div class="section-header" style="margin-top: 50px;">
			<ul>
				<h1 class="text-color-primary-dark">Pokemon Book</h1>
			</ul>

		</div>


		<div class="list">
			<ul id="testList">
				<li class="proList">
					<%
					for (int i = 0; i < places.size(); i++) {
						PlaceDTO place = places.get(i);
						
						
					%> 
					 <a class="search-result"> <!-- detailed page if can -->
					<div class="pokemon" style="font-weight: bold; font-size: 30px;">
						<img src="<%=place.getImg()%>"><br> <span
							class="pokemon-name" style="font-weight: bold; font-size: 30px;"><%=place.getName()%></span><br>
						<h4>
							<%=place.getName()%>(<%= place.getId()%>)</h4>

						<h5 style="width: 100%;">
							<span style="font-weight:600;">Description</span>:
							<%=place.getDescription()%>
						</h5>
					</div>
			</a> <%
 	} //end of the for loop
 %>
				</li>
			</ul>
		</div>
	</div>
	

</body>
</html>