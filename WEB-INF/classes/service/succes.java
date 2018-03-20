package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class succes extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	HttpSession laSession = request.getSession(true);
	String login = request.getParameter("login");
	String password = request.getParameter("mdp");
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<h1>"+login+"</h1>");
    out.println("<h1>"+password+"</h1>");
}
}
