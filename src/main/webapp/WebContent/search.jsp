<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pokemon.dto.PokemonDTO"%>
<%@ page import="com.pokemon.dto.TrainerDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pokemon.dao.SearchDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./includeFile.jsp" />
<link rel="stylesheet" type="text/css" href="./css/pokemon.css"  />

<title>Search Results:</title>
<style>
.search-text {
	text-align: center;
	padding: 100px 0px;
	border-bottom: 1px solid gray;
}
.search-result {
	width: 100%;
	padding: 10px;
}
.search-item {
	padding-inline-start: 0px;
	list-style-type: none;
}
.search-item {
	padding: 10px;
}

</style>
</head>
<body>
	<%
		ArrayList<Object> res = (ArrayList<Object>)request.getAttribute("res");
		ArrayList<Object> pokRes = (ArrayList<Object>)request.getAttribute("pokemon");
		String search = (String)request.getAttribute("search");
	%>
	<div class="header">
		<jsp:include page="./header.jsp" />
	</div>
	
	<div class="content">
		<div class="search-text">
			<h2><% if(search != null){ %>
				<%= search %>
			<%}else{%>
				<%= "Search results: No Results" %>	
		<% 	} %>
			
			</h2>
		</div>
		<%if(res.size() != 0){ %>
		<ul id="testList">
		
			<li class="proList" style = "margin-top:0px;">
				<%for(int i = 0; i < res.size();i++){ 
					Object dto  = res.get(i);
					if(dto.hashCode() ==1){
					
					PokemonDTO poke = (PokemonDTO)dto;
											%>
				
					<a class = "search-result"> <!-- detailed page if can -->
						<div class="pokemon">
							<img src= "<%=poke.getImg() %>" /><br /> <span
								class="pokemon-name" style = "font-weight:bold;font-size:30px;"><%=poke.getName() %></span><br> 
								<input type="button" id="type1" value="<%=poke.getType1() %>" 
								style = "background: <%= poke.getColor1() %>;border:none; border-radius:5px; width:50%;">
								
								<%if(!poke.getType2().equals("None")){ %>

								<input type="button" id="type2" value="<%= poke.getType2() %>" style="width:30%;background:<%=poke.getColor2() %>;border:none; border-radius:5px;">
								<%} %>
							<h4>
								<span style = "color:red; font-weight: bold;">Strength</span>:
								<%=poke.getStrength() %></h4>
						</div>
				</a>
				<%} else if(dto.hashCode() == 2){
					TrainerDTO trainer = (TrainerDTO)dto;
															%>
				
					<a class = "search-result"> <!-- detailed page if can -->
						<div class="pokemon" style = "font-weight:bold;font-size:30px;">
							<img src= "<%=trainer.getImage()%>"><br> <span
								class="pokemon-name" style = "font-weight:bold;font-size:30px;"><%=trainer.getName() %></span><br> 
								<h4 > <%= trainer.getType() %></h4>
								
							<h4 style = "width:150%;">
								<span style = "color:red; font-weight: bold;">pokemons</span>:
								<%=trainer.getNum_pokemon()%>
							</h4>
						</div>
				</a>
				<%} //end of the else-if
					} //end of the for-loop %>
			</li>
			
		</ul>
		<%} %>
		
	</div>
	
	
	<div class="footer">
		<%@ include file="./footer.jsp"%>
	</div>
</body>
</html>