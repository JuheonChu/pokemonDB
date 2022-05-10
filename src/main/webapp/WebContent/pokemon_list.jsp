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
request.setAttribute("pokemon", pokemon);

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

		<div style="text-align: right; vertical-align: top; position:relative; top:200px;" class="selectmenu">

				<button class="hasFilter" data-click-area="PW">
					Filter <i><img src="https://raw.githubusercontent.com/JuheonChu/nikePractice/master/WebContent/images/filterdesc.jpg" alt="filter"
						style="max-width: 13.48px; max-height: 24px;" /></i>
				</button>

				<select name="sort" id="sort" class="sort"
					onchange="if(this.value)location.href=(this.value)">
					<option id="default"
						value="PokemonController?command=sort&sort=default&select=name"
						<%
						if("name".equals(select)) {
					%> selected
						<%
						}
					%>>Name</option>

					<option id="strength-desc"
						value="PokemonController?command=sort&sort=strength-desc&select=strength-desc"
						<%
							if("Strength".equals(select)) {
					%> selected
						<%			
							}
					%>>Strength</option>

					<option id="strength-asc"
						value="PokemonController?command=sort&sort=strength-asc&select=strength-asc"
						<%
							if("Weak".equals(select)){
						%> selected
						<%		
							}
					
					%>>Weak</option>
				</select>
			</div>


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