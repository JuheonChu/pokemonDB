package com.pokemon.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pokemon.dao.*;
import com.pokemon.dto.*;

public class SearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String search = request.getParameter("tsword").trim();
		String searchRes = "Search Results: ";
		System.out.println("Results: " + search);

		SearchDAO sd = SearchDAO.getInstance(); //Singleton
		
		ArrayList<Object> res = new ArrayList<>();
		
		
		
		ArrayList<PokemonDTO> pok = new ArrayList<PokemonDTO>();
		ArrayList<TrainersDTO> trainers = new ArrayList<TrainersDTO>();
		
		
		pok =  sd.searchPokemon(search); // nullpointerexception
		trainers = sd.selectTrainers(search);
		
		for(int i = 0; i < pok.size(); i++) {
			res.add(pok.get(i));
			
		}
		
		for(int i = 0; i < trainers.size(); i++) {
			res.add(trainers.get(i));
		}
		
		if(res.size() == 0) {
			System.out.println("search Fail!");
			request.setAttribute("search", search);
			RequestDispatcher rd = request.getRequestDispatcher("searchFail.jsp");
			rd.forward(request, response);
		}else {
			searchRes += search;
			request.setAttribute("pokemon", pok);
			request.setAttribute("trainers", trainers);
			request.setAttribute("res", res);
			request.setAttribute("search",searchRes);
			RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		}

	}

}
