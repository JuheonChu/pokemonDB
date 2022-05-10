package com.pokemon.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pokemon.dao.*;
import com.pokemon.dto.*;

public class PairsAction implements Action{
	
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		
		PairsDAO dao = PairsDAO.getInstance();
	
		
		ArrayList<PairsDTO> dtoArr = dao.selectPairsDefault();
		
		System.out.println(dtoArr);
		
		
		String sortCriteria = "";
		String [] sort = {"default", "strength","name"};
		
	
		System.out.println(dtoArr.toString());
		
		request.setAttribute("pairs", dtoArr);
		request.setAttribute("sort",sort);
		request.setAttribute("criteria", sortCriteria);

		
		String url="pairs.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
