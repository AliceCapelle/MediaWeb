package mediatheque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String mdp;
	private static Connection con;
	
	public static void ConnecterDataBase() {
		driver = "org.postgresql.Driver";
		url = "jdbc:postgresql://localhost:5432/java_project";
		user = "alice";
		mdp = "alice";
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
	
	@Override
	protected void finalize() throws SQLException {
		this.con.close();
	}
	
}
