package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {
	public static final String DRIVERMANAGER="com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/jt_db";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	public static void main(String[] args){
		try {
			Class.forName(DRIVERMANAGER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(
					"select id, name, money "
					+ "from account; ");
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + " 姓名: " + rs.getString("name") + " 存款: " + rs.getInt("money"));
			}
			rs.close();
			statement.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
