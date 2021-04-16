package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test3 {
	public static final String DRIVERMANAGER="com.mysql.cj.jdbc.Driver";
	//最后面的是数据库名
	public static final String URL = "jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	public static void main(String[] args) throws Exception {
		Class.forName(DRIVERMANAGER);
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		Statement statement = conn.createStatement();
		//.excuteUpdate()返回的是修改的行数
		int row = statement.executeUpdate(
				"update account "
				+ "set money=money+1000 "
				+ "where name='andy';");
		System.out.println("影响行数是: "+ row);
		ResultSet rs = statement.executeQuery(
				"select name, money "
				+ "from account; ");
		while(rs.next()) {
			System.out.println("名字: " + rs.getString("name") + " money: " + rs.getInt("money"));
		}
		rs.close();
		statement.close();
		conn.close();
	}
}
