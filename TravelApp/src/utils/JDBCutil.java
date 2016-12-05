package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCutil {

	private static DataSource  dataSource = null;
	static{
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("无法获取数据库链接");
		}
	}
	
	public static void releaseConnection(Connection conn){
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e){e.printStackTrace();}
		
	}
	
}
