package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<h1>Bienvenue dans votre espace abonné</h1>");
		
		out.println("<form action=\"emprunt\">");
		out.println("<input type=\"submit\" value=\"Emprunter un livre\">");
		out.println("</form>");
		
		out.println("<form action=\"retour\">");
		out.println("<input type=\"submit\" value=\"Rendre un livre\">");
		out.println("</form>");
		
	}
}
