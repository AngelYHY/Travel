package lvchenglogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;

public class ShowUserdao {
	
	public UserVo showuser(String accountname){
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserVo user=null;
		
		try {
			statement = connection.prepareStatement("select * from user where account_name='"+accountname+"'");
		
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				int user_id=resultSet.getInt(1);
				String account_name=resultSet.getString(2);
				String password=resultSet.getString(3);
				String user_name=resultSet.getString(4);
				String address=resultSet.getString(5);
				String phone_num=resultSet.getString(6);
				int age=resultSet.getInt(7);
				String sex=resultSet.getString(8);
				String head_picture_addr=resultSet.getString(9);
				user=new UserVo(user_id, account_name, password, user_name, address, phone_num, age, sex, head_picture_addr);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
	
		
		
		
		
		
		return user;
	
	}

}
