<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.NumberFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.pokemon.dto.*"%>
<%@ page import="com.pokemon.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<jsp:include page="./includeFile.jsp" />
<link rel="stylesheet" type="text/css" href="./css/pokemon.css" />

<head>
<meta charset="UTF-8">
<title>Pokemon Trainers</title>

<%
ArrayList<PairsDTO> pairs = (ArrayList<PairsDTO>) request.getAttribute("pairs");
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
				<h1 class="text-color-primary-dark">Pokemon Trainers</h1>
			</ul>

		</div>

		<!-- Filter -->


		<div class="list">
			<ul id="testList">
				<li class="proList">
					<%
					int k = 0;
					PairsDTO pdto = null;
					for (int i = 0; i < pairs.size(); i++) { //Trainer
						if(k == pairs.size())break;
					
						PairsDTO dto = pairs.get(k);
					%> <a> <!-- detailed page -->
						<div class="pair" style="display: inline-block; text-align: center; width:100%;">
						<div style = "text-align:center;">
							<img src="<%=dto.getImage()%>" 
								style="height: 300px;" /><br> <span class="trainer-name"
								style="font-weight: bold; font-size: 30px;"><%=dto.getOwner()%></span><br>
							<span class="trainer-type"
								style="font-weight: bold; font-size: 30px;"><%=dto.getType()%></span>
						</div><br><br>
							<%
							for (int j = 0; j < dto.getNum_pokemon(); j++) {
								
								pdto = pairs.get(k);
								
							%>
							<div class="pokemon">
								<img src="<%=pdto.getImg()%>" style="height: 300px;"/><br />
								<span class="pokemon-name"
									style="font-weight: bold; font-size: 30px;"><%=pdto.getName()%></span><br>
								<input type="button" id="type1" value="<%=pdto.getType1()%>"
									style="background: <%=pdto.getColor1()%>;border:none; border-radius:5px; width:30%;">

								<%
								if (!pdto.getType2().equals("None")) {
								%>
								<input type="button" id="type2" value="<%=pdto.getType2()%>"
									style="width:30%;background:<%=pdto.getColor2()%>;border:none; border-radius:5px;">
								<%
								}
								%>
								<h4>
									<span style="color: red; font-weight: bold;">Strength</span>:
									<%=pdto.getStrength()%></h4>
								<h4>
									<span style="color: blue; font-weight: bold;">Level</span>:
									<%=pdto.getLevel()%></h4>
							</div>
							<%
								k++;
								
							} //end of the inner for-loop
							%>
							<br><br/><br/>
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