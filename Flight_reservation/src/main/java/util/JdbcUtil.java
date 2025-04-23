package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	private static Connection con;
	public static Connection auto_connect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_reservation","root","password");
	    return con;
	}

}
