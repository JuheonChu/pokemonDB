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
.product{
	text-align:center;
}
</style>
</head>
<body>
	<div class="header">
		<jsp:include page="./header.jsp" />
	</div>
	
	<div class="content" style = "margin-top: 300px;">
		<div class="search-text">
			<h2>
			Search Results for ${search} does not exist
			</h2>
		</div>
		
		
	</div>
	
	
	
</body>
</html>