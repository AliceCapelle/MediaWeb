package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.Mediatheque;
import mediatheque.Utilisateur;
import persistantdata.MediathequeData;

public class AjoutDoc extends HttpServlet {
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
			out.println("<h2>Ajouter un livre</h2>");

			out.println(" <form method=\"post\"> Type:<br>");
			out.println("<input type=\"text\" name=\"type\"><br>");
			out.println("Titre:<br>");
			out.println("<input type=\"text\" name=\"titre\"><br>");
			out.println("Artiste:<br>");
			out.println("<input type=\"text\" name=\"artiste\"><br>");
			out.println("Annee:<br>");
			out.println("<input type=\"text\" name=\"annee\"><br>");
			out.println("<br>");
			out.println("<input type=\"submit\" value=\"Ajouter le Document\">");
			out.println("</form>");

			out.println("</head>");
			out.println("</body>");
			out.println("</html>");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession laSession = request.getSession(true);
		int type = Integer.parseInt(request.getParameter("type"));
		String titre = request.getParameter("titre");
		String nom = request.getParameter("artiste");
		int annee = Integer.parseInt(request.getParameter("annee"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Mediatheque m = Mediatheque.getInstance();
			m.nouveauDocument(type, titre, nom, annee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.println("<h1>Le document " + titre + " a été crée avec succes</h1>");
		out.println("<form action=\"bibliothecaire\">");
		out.println("<input type=\"submit\" value=\"Retourner au menu\">");
		out.println("</form>");

	}
}
