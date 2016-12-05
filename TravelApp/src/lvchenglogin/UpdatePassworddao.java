package lvchenglogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;

public class UpdatePassworddao {
	ResultSet resultSet = null;
	public void updatepassworddao(String accountname,String password){
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement=connection.prepareStatement("update user set password='"+password+"' where account_name='"+accountname+"'");
			statement.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
	}

}
