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
	
	public static void ConnecterDataBase() {
		driver = "org.mariadb.jdbc.Driver";
		url = "jdbc:mariadb://localhost:3306/projet_java";
		user = "root";
		mdp = "";
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
	}
	
	public static Connection getConnection() {
		return con;
	}
	
}
