package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatheque.Mediatheque;
import mediatheque.PersistentMediatheque;
import mediatheque.Utilisateur;
import persistantdata.MediathequeData;

public class Verification extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession laSession = request.getSession(true);
		String login = request.getParameter("login");
		String password = request.getParameter("mdp");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (login != null && password != null) {
			if (login.equals("admin") && password.equals("admin")) {
				mediatheque.PersistentMediatheque m = new MediathequeData();
				out.println("<h1>" + login + "</h1>");
				out.println("<h1>" + password + "</h1>");
				out.println("<h1> Succes !</h1>");
				// on instancie la mediahteque
				// on afficher un message de succes
			} else
				try {
					Utilisateur user = Mediatheque.getInstance().getUser(login, password);
					if (user == null) {
						out.println("<h1>Cet utilisateur n'existe pas</h1>");
						out.println("<meta http-equiv=\"refresh\" content=\"2;URL='connection'\">");
					}

					else if (user.getType().equals("Bibliothecaire")) {
						out.println("<meta http-equiv=\"refresh\" content=\"0;URL='bibliothecaire'\">");
					}

					else if (user.getType().equals("User")) {
						laSession.setAttribute("Login", login);
						out.println("<meta http-equiv=\"refresh\" content=\"0;URL='user'\">");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
}
