package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.Mediatheque;
import mediatheque.Utilisateur;

public class Bibliothecaire extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession laSession = request.getSession(true);
		Utilisateur user = (Utilisateur) laSession.getAttribute("user");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (user == null) {
			response.sendRedirect("connection"); 
		}
		
		else if (user.getType().equals("User")) {
			response.sendRedirect("user"); 
		}

		else {
			out.println("<html>");
			out.println("<head>");
			out.println("<h1>Bienvenue dans votre espace bibliothecaire " + user.getNom() + "</h1>");

			out.println("<form action=\"ajoutdoc\">");
			out.println("<input type=\"submit\" value=\"Ajouter un document\">");
			out.println("</form>");
			
			out.println("<form method=\"post\">");
			out.println("<input type=\"submit\" value=\"Deconnection\">");
			out.println("</form>");

		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getSession().invalidate();
		response.sendRedirect("connection");
	}

}
