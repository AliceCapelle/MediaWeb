package persistantdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import mediatheque.Mediatheque;

public class DataBase {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String mdp;
	private static Connection con;
	
	public static void main(String [ ] args)
	{
		ConnecterDataBase();
		
	}
	
	public static void ConnecterDataBase() {
		driver = "org.mariadb.jdbc.Driver";
		url = "jdbc:mariadb://localhost/projet_java";
		user = "projet_java";
		mdp = "java";
		con = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, mdp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("success");
	}
	
	public static Connection getConnection() {
		return con;
	}
	
}
