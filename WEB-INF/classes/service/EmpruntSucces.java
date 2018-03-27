package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.EmpruntException;
import mediatheque.Mediatheque;
import mediatheque.Utilisateur;
import persistantdata.Document;

public class EmpruntSucces extends HttpServlet {
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
				m.emprunt(d, user);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EmpruntException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			out.println("<h1>Le document " + d.getTitre() + " a été emprunté avec succes</h1>");
		}
	}
}