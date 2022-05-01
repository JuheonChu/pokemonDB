package com.pokemon.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/PokemonController")
public class PokemonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Encoding UTF-8
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String command = request.getParameter("command"); //pokemon 
	
	
		ActionFactory af = ActionFactory.getInstance();//Singleton ìƒ?ì œ
		Action action = null;
		
		action = af.getAction(command);
		
		if(action != null) {
			try {
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}