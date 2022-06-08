package utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import jdk.nashorn.internal.ir.ForNode;

public class DBConn2 {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@np.silly.monster:1521/xe", "odoung", "1234");
		return conn;
	}
}
