package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class Connection extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<h1>Bienvenue dans votre mediatheque</h1>");
		out.println(" <form action=\"verification\"> Login:<br>");
		out.println("<input type=\"text\" name=\"login\"><br>");
		out.println("Password:<br>");
		out.println("<input type=\"password\" name=\"mdp\">");
		out.println(" <input type=\"submit\" value=\"Se connecter\">");
		out.println("</form>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("</body>");
		out.println("</html>");
	}
}
