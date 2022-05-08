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
<title>Pokemon Book</title>

<%
PokemonDAO dao = PokemonDAO.getInstance();
ArrayList<PokemonDTO> pokemon = (ArrayList<PokemonDTO>) request.getAttribute("pokemon");

String[] types = (String[]) request.getAttribute("type");

String [] colors = (String [])request.getAttribute("colors");

String select = (String) request.getAttribute("select");
//System.out.println("select: " + select);
String explainType = "";
%>

<style>


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

		<!-- Filter -->


		<div class="list">
			<ul id="testList">
				<li class="proList">
					<%
					for (int i = 0; i < pokemon.size(); i++) {
						PokemonDTO dto = pokemon.get(i);
						
						
						
						/* String [] colorStr = dto.getColor().split(";"); */
					%> 
					<a> <!-- detailed page -->
						<div class="pokemon">
							<img src="<%=dto.getImg()%>" /><br /> <span
								class="pokemon-name" style = "font-weight:bold;font-size:30px;"><%=dto.getName()%></span><br> 
								<input type="button" id="type1" value="<%=dto.getType1()%>" 
								style = "background: <%= dto.getColor1()%>;border:none; border-radius:5px; width:30%;">
								
								<%if(!dto.getType2().equals("None")){ %>
								<input type="button" id="type2" value="<%=dto.getType2()%>" style="width:30%;background:<%=dto.getColor2()%>;border:none; border-radius:5px;">
								<%} %>
							<h4>
								<span style = "color:red; font-weight: bold;">Strength</span>:
								<%=dto.getStrength()%></h4>
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