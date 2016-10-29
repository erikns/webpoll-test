package no.hib.megagruppe.webpoll.servlets.answerSurvey;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The student is done answering the poll.
 */
@WebServlet("/PollCompleted")
public class PollCompletedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("poll") == null) {
			response.sendRedirect("/");
		} else {
			request.getRequestDispatcher("/studentdone.jsp").forward(request, response);
		}

	}
}
