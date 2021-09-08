
package com.sample;
import java.sql.*;
public class ConnectionDemo{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "system";
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, username,password);
		stmt = con.createStatement();
		rs = stmt.executeQuery("Select * from product");
		
		while(rs.next()) {
		System.out.println(" " + rs.getInt(1));
		System.out.println(" " + rs.getString(2));
		System.out.println(" " + rs.getInt(3));
		System.out.println(" " + rs.getString(4));
	} 
	rs.close();
	con.close();
	stmt.close();
	
}
}