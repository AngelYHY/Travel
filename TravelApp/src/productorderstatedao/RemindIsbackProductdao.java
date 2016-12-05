package productorderstatedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;

public class RemindIsbackProductdao {
	
	ResultSet resultSet = null;
	public void remind(int order_id,String buyer_message ){
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		String message=buyer_message+"请发货";
		try {
			statement = connection.prepareStatement("update product_order set buyer_message='"+message+"' where order_id_pk="+order_id+"");
			statement.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
		
		
	}

}
