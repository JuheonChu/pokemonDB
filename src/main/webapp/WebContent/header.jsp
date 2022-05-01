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
			this.placeholder = "검색";
			$(".dark").hide();
		});

		function totsearch() {

			var sword;
			sword = $("#tsword").val();

			console.log(sword)

			if (sword == "") {
				swal({
					title : "",
					text : "Insert words to search.",
					timer : 1500,
					showConfirmButton : true
				});
				return;
			} else {
				document.location.href = "/search?sword=" + sword;
			}

		}

		$("#tsearchbtn").click(function() {
			$("#tsword").focus();
		});
	});
</script>


</head>
<body>

	<header id="hd" class="page-pok">
		<h1>
			<a href="/"><img
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
				<a href="PokemonController?command=pokemon"><i
						class="icon-ball-c"></i>Pokemons</a></li>

				<li>
					<button type="button" id="tsearchbtn" class="no-style collapsed"
						data-toggle="collapse" data-target="#search">
						<i class="icon-search"></i>Search
					</button>
				</li>
			</ul>
		</div>

		<div id="search" class="search-book bg-dark2">
			<div class="search-wrp" style = "padding: 40px 15px;">
			<h2 class="col-lg-1 col-12 text-wh"><img src="https://pokemonkorea.co.kr/img/icon/icon_ball_b.png" alt=""> Pokemon Book</h2>
				<input type="text" placeholder="Search" name="tsword" id="tsword"
					onkeypress="if(event.keyCode==13) {totsearch(); return false;}"
					value="" style = "margin-left: 100px; margin-right: 0px;">
				<button type="button" onclick="totsearch()"
					class="no-style btn-search" style = "background-color:red;">
					<p class="sr-only">Search</p>
				</button>
			</div>
		</div>





	</header>

</body>
</html>