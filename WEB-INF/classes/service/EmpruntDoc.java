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
			d =  m.tousLesDocuments();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		for(int i = 0; i<d.size(); i++) {
			out.print("<p>"+d.get(i).getTitre()+"		"+d.get(i).getArtiste() +"		"+ d.get(i).getAnnee() +"</p>");
			out.print("<input type=\"submit\" value=\"Emprunter le document\">");
		}
		
		
		
		
	}
}
