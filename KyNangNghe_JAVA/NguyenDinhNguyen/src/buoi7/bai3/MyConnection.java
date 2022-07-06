package buoi7.bai3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	public static Connection getConnection() {
		Connection con = null;

		String url = "jdbc:mysql://localhost/db_quanlynhanvien?characterEncoding=UTF-8";
		String user = "admin";
		String pw = "";
		if (con != null) {
			return con;
		} else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pw);
				System.out.println("Connect successfully");
			} catch (Exception ex) {
				System.out.println("Connect Failure");
				ex.printStackTrace();
			}
			return con;
		}

	}
	public ResultSet getInfo(String sql) {
		ResultSet rs = null;
		try {
			Statement stmt = this.getConnection().createStatement();
			
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}
}
