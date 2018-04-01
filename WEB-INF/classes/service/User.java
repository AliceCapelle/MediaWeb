package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.Utilisateur;

public class User extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession laSession = request.getSession(true);
		Utilisateur user = (Utilisateur) laSession.getAttribute("user");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if (user == null) {
			response.sendRedirect("connection");
		} else if (user.getType().equals("Bibliothecaire")) {
			response.sendRedirect("bibliothecaire");
		}
		
		else {
			out.println("<html>");
			out.println("<head>");
			out.println("<h1>Bienvenue dans votre espace abonné " + user.getNom() + "</h1>");
			
			out.println("<form action=\"emprunt\">");
			out.println("<input type=\"submit\" value=\"Emprunter un livre\">");
			out.println("</form>");
			
			out.println("<form action=\"retour\">");
			out.println("<input type=\"submit\" value=\"Rendre un livre\">");
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
