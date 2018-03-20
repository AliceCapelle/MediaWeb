package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class connection extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		/*HttpSession laSession = request.getSession(true);
		String login = request.getParameter("login");
		String password = request.getParameter("mdp");
		//User user = new User(login, password);*/
	
		
		//laSession.setAttribute("user", user);
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");

	    //String confirmation = user.toString();

	    out.println("<h1>Bienvenue dans votre mediatheque</h1>");
	    out.println(" <form action=\"succes\"> Login:<br>");
	    out.println("<input type=\"text\" name=\"login\"><br>");
	    out.println("Password:<br>");
	    out.println("<input type=\"text\" name=\"mdp\">");
	    out.println(" <input type=\"submit\" value=\"Submit\">");
	    out.println("</form>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("</body>");
        out.println("</html>");
	}
}
