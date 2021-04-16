package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {
		
	public static final String DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/db10";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	public static void main(String[] args) throws Exception{
		Class.forName(DRIVER);	
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "SELECT id, name "
				+ "FROM emp";
		PreparedStatement state = conn.prepareStatement(sql);
		ResultSet rs = state.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID: "+rs.getInt("id")+" 姓名: " + rs.getString("name"));
		}
	}
}
