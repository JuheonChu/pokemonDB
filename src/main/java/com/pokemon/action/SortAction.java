package com.pokemon.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pokemon.dao.*;
import com.pokemon.dto.*;

public class SortAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String sort = request.getParameter("sort");
		
		
		String select = request.getParameter("select");
		
		
		PokemonDAO dao = PokemonDAO.getInstance();
		ArrayList <PokemonDTO> pokemon = (ArrayList<PokemonDTO>)request.getAttribute("pokemon");

		
		if(sort.equals("strength-asc")) {
			pokemon = dao.selectPokemonByWeakest();
//			out.println("<script>$('#default').setAttribute('selected');</script>");
		}else if(sort.equals("strength-desc")) {
			pokemon = dao.selectPokemonByStrongest();
//			out.println("<script>$('#price-desc').setAttribute('selected');</script>");
		}else if(sort.equals("default")){
			pokemon = dao.selectPokemonDefault();
//			out.println("<script>$('#price-asc').setAttribute('selected');</script>");
		}
		//System.out.println("Sort Action 클래스에서 product: " + product);
		request.setAttribute("pokemon", pokemon);
		request.setAttribute("select", select);

		request.setAttribute("sort",sort);
	
		
		
		request.getRequestDispatcher("pokemon_list.jsp").forward(request, response);
		
		
	}

}