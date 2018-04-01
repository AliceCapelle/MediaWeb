package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.Mediatheque;
import mediatheque.Utilisateur;
import persistantdata.MediathequeData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Connection extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<h1>Bienvenue dans votre mediatheque</h1>");
		out.println(" <form method=\"post\"> Login:<br>");
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession laSession = request.getSession(true);
		String login = request.getParameter("login");
		String password = request.getParameter("mdp");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (login != null && password != null) {
			if (login.equals("admin") && password.equals("admin")) {
				mediatheque.PersistentMediatheque m = new MediathequeData();
				out.println("<h1> MediaWeb est operationnel !</h1>");
				out.println("<form action=\"connection\">");
				out.println("<input type=\"submit\" value=\"Retourner à l'accueil\">");
				out.println("</form>");
			} else
				try {
					Utilisateur user = Mediatheque.getInstance().getUser(login, password);
					if (user == null) {
						response.sendRedirect("connection");
					}

					else if (user.getType().equals("Bibliothecaire")) {
						laSession.setAttribute("user", user);
						response.sendRedirect("bibliothecaire");  
					}

					else if (user.getType().equals("User")) {
						laSession.setAttribute("user", user);
						response.sendRedirect("user");  
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
}
