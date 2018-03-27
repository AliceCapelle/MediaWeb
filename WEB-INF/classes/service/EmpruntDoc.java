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

import mediatheque.Mediatheque;
import persistantdata.Document;

public class EmpruntDoc extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Document> d = new ArrayList<Document>();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Mediatheque m = Mediatheque.getInstance();
			d = m.tousLesDocuments();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		out.println("<h1>Choisissez votre document</h1>");
		
		out.println("<table>");
		for (int i = 0; i < d.size(); i++) {
			out.println("<tr>");
			out.print("<td><b>"+d.get(i).getType()+"</b></td>");
			out.print("<td>"+d.get(i).getTitre()+"</td>");
			out.print("<td>"+ d.get(i).getArtiste() +"</td>");
			out.print("<td>"+ d.get(i).getAnnee()+"</td>");
			out.print("<td><input type=\"submit\" name=\"Emprunter le document\" value=" + d.get(i)+ "></td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}
}
