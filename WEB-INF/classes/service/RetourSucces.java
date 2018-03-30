package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.Document;
import mediatheque.EmpruntException;
import mediatheque.Mediatheque;
import mediatheque.Utilisateur;

public class RetourSucces extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession laSession = request.getSession(true);
		Utilisateur user = (Utilisateur) laSession.getAttribute("user");
		int iddoc = Integer.parseInt(request.getParameter("iddoc"));

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (user.getNom() == null) {
			out.println("<h1>Veuillez vous connecter</h1>");
			out.println("<meta http-equiv=\"refresh\" content=\"2;URL='connection'\">");
		} else {
			Mediatheque m = Mediatheque.getInstance();
			Document d = null;
			try {
				d = m.getDocument(iddoc);
				m.retour(d);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			out.println("<h1>Le document " + d.getTitre() + " a été rendu avec succes</h1>");
			out.println("<form action=\"emprunt\">");
			out.println("<input type=\"submit\" value=\"Emprunter un livre\">");
			out.println("</form>");

			out.println("<form action=\"retour\">");
			out.println("<input type=\"submit\" value=\"Rendre un livre\">");
			out.println("</form>");
		}

	}
}
