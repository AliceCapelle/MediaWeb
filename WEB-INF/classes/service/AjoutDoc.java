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
import persistantdata.MediathequeData;

public class AjoutDoc extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
			out.println("<h1>Ici</h1>");
			m.nouveauDocument(type, titre, nom, annee);
			out.println("<h1>Réussi</h1>");
		} catch (Exception e) {
			
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errors.toString();
			
			out.println("<h4>"+errors+"</h4>");
		}

	}
}
