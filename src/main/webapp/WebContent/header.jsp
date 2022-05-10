<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./includeFile.jsp"/>

<script>
	$(function() {
		$(".searchBar").focus(function() {
			this.placeholder = "";
			$(".dark").show();
		});
		$(".searchBar").blur(function() {
			this.placeholder = "Search";
			$(".dark").hide();
		});

		

		$("#tsearchbtn").click(function() {
			$("#tsword").focus();
		});
	});
</script>

<title>Pokemon</title>
</head>
<body>

	<header id="hd" class="page-pok">
		<h1>
			<a href="${pageContext.request.contextPath}/index.jsp"><img
				src="https://pokemonkorea.co.kr/img/main_logo.png" alt="pokemon"></a>
		</h1>
		<div class="container flex-justify-space">
			<button type="button" class="js-mn no-style" title="menu">
				<span></span> <span></span> <span></span>
			</button>
			<nav id="gnb">
				<ul class="gnb">
					<li class=""><a href="#" class="warning "><i
							class="icon-news"></i>Community</a></li>
					<!-- used as a board -->


					<li><a href="#" class="danger "><i class="icon-ball"></i>Goods</a>
					</li>
					<li class="d-lg-none d-block"><a href="#"><i
							class="icon-ball-c"></i>Pokemons</a></li>
					<li class="d-lg-none d-block"><a
						href="http://www.pokemonstore.co.kr" target="_blank"
						class="btn-pokemongo"> <img
							src="https://pokemonkorea.co.kr/img/Pokemongo.png" alt=""
							class="mr-2">
					</a></li>



				</ul>
			</nav>
			<ul id="acc">
				<li class="d-lg-block d-none">
				<a href="${pageContext.request.contextPath}/PokemonController?command=pokemon"><i
						class="icon-ball-c"></i>Pokemons</a></li>

				
					<li id = "trainer" class="d-lg-block d-none" style = "position: relative;
    top: -23px;">
					<a href="${pageContext.request.contextPath}/PokemonController?command=pairs" style = "display:grid;">
					<img src="https://img.icons8.com/color/48/000000/player-female.png"/>Trainers</a></li>
				
			</ul>
		</div>

		<div id="search" class="search-book bg-dark2">
			<div class="search-wrp" style = "padding: 40px 15px;">
			<h2 class="col-lg-1 col-12 text-wh"><img src="https://pokemonkorea.co.kr/img/icon/icon_ball_b.png" alt=""> Pokemon Book</h2>
				
				<form action="${pageContext.request.contextPath}/PokemonController?command=search" method="post" style = "display:inherit;width:100%;">
						<input type="text" placeholder="Search"
							onblur="this.placeholder='Search'" name="tsword" id="tsword" 
							style = "margin-left: 100px; margin-right: 0px;"/>
						<button type="submit" onclick=""
						class="no-style btn-search" style = "background-color:red;">
						
					</button>
						</form>
				<!-- <div class="searchDiv">
		
					
		
				</div> -->
				
				<!-- <form action="../nike/ProductController?command=surf" method="post"> -->
					
					<!-- <input type="text" placeholder="Search" name="tsword" id="tsword"
						onkeypress="if(event.keyCode==13) {totsearch(); return false;}"
						value="" style = "margin-left: 100px; margin-right: 0px;">
					<button type="button" onclick="totsearch()"
						class="no-style btn-search" style = "background-color:red;">
						<p class="sr-only">Search</p>
					</button> -->
				<!-- </form> -->
			</div>
		</div>





	</header>

</body>
</html>