package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.Document;
import mediatheque.Mediatheque;
import mediatheque.Utilisateur;

public class RendreDoc extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession laSession = request.getSession(true);
		Utilisateur user = (Utilisateur) laSession.getAttribute("user");
		List<Document> d = new ArrayList<Document>();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (user.getNom() == null) {
			out.println("<h1>Veuillez vous connecter</h1>");
			out.println("<meta http-equiv=\"refresh\" content=\"2;URL='connection'\">");
		}

		else {

			Mediatheque m = Mediatheque.getInstance();
			try {
				d = m.getDocuUser(user.getId_user());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.println("<h1>Quel document voulez vous rendre ?</h1>");

			out.println("<table>");
			for (int i = 0; i < d.size(); i++) {
				out.println("<tr>");
				out.print("<td><b>" + d.get(i).getType() + "</b></td>");
				out.print("<td>" + d.get(i).getTitre() + "</td>");
				out.print("<td>" + d.get(i).getArtiste() + "</td>");
				out.print("<td>" + d.get(i).getAnnee() + "</td>");
				out.println("<form action=\"retoursucces\"> ");
				out.print("<td><input type=\"submit\" value=\"Rendre ce document\"></td>");
				out.print("<td><input type=\"hidden\" name=\"iddoc\" value=" + d.get(i).getIddoc() + "></td>");
				out.println("</form>");
				out.println("</tr>");
			}
			out.println("</table>");
			
		}

	}

}
