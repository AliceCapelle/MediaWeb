package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bibliothecaire extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<h1>Bienvenue dans votre espace bibliothecaire</h1>");
		out.println("<h2>Ajouter un livre</h2>");
		
		out.println(" <form action=\"ajoutdoc\"> Type:<br>");
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
