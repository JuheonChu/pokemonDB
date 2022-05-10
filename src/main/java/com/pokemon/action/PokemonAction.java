package com.pokemon.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pokemon.dao.PokemonDAO;
import com.pokemon.dto.PokemonDTO;

public class PokemonAction implements Action{
	
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		
		PokemonDAO dao = PokemonDAO.getInstance();
	
		
		ArrayList<PokemonDTO> dtoArr = dao.selectPokemonDefault();
		
		
		
		String sortCriteria = "";
		String [] sort = {"default", "strength","name"};
		
		String [] types = {"Grass", "Poison", "Fire", "Flying", "Water", "Bug", "Normal", "Electric",
				"Ground", "Fighting", "Psychic", "Rock", "Steel", "Ice", "Ghost", "Dragon"};
		
		String [] colors = {"#9bcc50 50%", "#b97fc9 50%", "#fd7d24 50%", "#3dc7ef 50%", "#4592c4 50%", "#729f3f 50%", "#4c4466 50%", "#eed535 50%",
				"#f7de3f 50%", "#d56723 50%", "#f366b9 50%", "#a38c21 50%", "#9eb7b8 50%", "#51c4e7 50%", "#7b62a3 50%", "#f16e57 50%" }; //RGB colors

		
		
		System.out.println(dtoArr.toString());
		
		request.setAttribute("pokemon", dtoArr);
		request.setAttribute("type", types);
		request.setAttribute("sort",sort);
		request.setAttribute("criteria", sortCriteria);
		request.setAttribute("colors", colors);
		
		String url="pokemon_list.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
