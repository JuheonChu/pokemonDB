package com.pokemon.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pokemon.dao.*;
import com.pokemon.dto.*;

public class PlaceAction implements Action{
	
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		
		PlaceDAO dao = PlaceDAO.getInstance();
	
		
		ArrayList<PlaceDTO> dtoArr = dao.selectPlaecesDefault();
		
		System.out.println(dtoArr);
		
		
		String sortCriteria = "";
		String [] sort = {"default", "strength","name"};
		
	
		
		
		request.setAttribute("places", dtoArr);
		request.setAttribute("sort",sort);
		request.setAttribute("criteria", sortCriteria);

		
		String url="place.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
