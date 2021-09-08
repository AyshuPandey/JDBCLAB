package com.sample;
import java.sql.*;
public class PrepareDemo {

	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		CallableStatement cst = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + "XE", "system", "system");
			System.out.println("Connection....");
			stmt1 = con.prepareStatement("Select * from product where  manufacturer = ? AND price > ?");
			stmt1.setString(1, "INDIA");
			stmt1.setInt(2, 6000);
			
			rs = stmt1.executeQuery();
			while(rs.next()) {
				System.out.print(" " + rs.getInt(1));
				System.out.print(" " + rs.getString(2));
				System.out.print(" " + rs.getInt(3));
				System.out.print(" " + rs.getString(4));
				System.out.println();
			} 
			
			stmt2 = con.prepareStatement("insert into product(proid, proname, price) values(?,?,?)");
			stmt2.setInt(1, 1012);
			stmt2.setString(2, "Frame");
			stmt2.setInt(3, 200);
			
			int r = stmt2.executeUpdate();
			System.out.println("Status for insert " + r);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
