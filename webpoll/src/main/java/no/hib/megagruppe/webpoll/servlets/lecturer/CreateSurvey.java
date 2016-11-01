package no.hib.megagruppe.webpoll.servlets.lecturer;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.megagruppe.webpoll.services.SecurityService;

/**
 * Servlet implementation class CreateSurvey
 */
@WebServlet("/createsurvey")
public class CreateSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
    SecurityService securityService;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Her setter vi navnet på undersøkelsen
		 * 
		 * En knapp for å lage et nytt spørsmål.
		 * En knapp for lagre undersøkelsen (Må ha minst ett spørsmål)
		 *  
		 */
		
		if(securityService.isLoggedIn()) {
			request.getSession().setAttribute("surveyName", "Undersøkelse test");
			request.getRequestDispatcher("WEB-INF/lecturer/createsurvey.jsp").forward(request, response);
		} else {
			response.sendRedirect("index");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
