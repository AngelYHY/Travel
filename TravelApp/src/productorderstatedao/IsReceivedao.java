package productorderstatedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;

public class IsReceivedao {
	ResultSet resultSet = null;
	public void isreceive(int order_id,String receive_time){
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement=connection.prepareStatement("update product_order set is_receive="+1+",receive_time='"+receive_time+"' where order_id_pk="+order_id+"");
			statement.executeUpdate();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
		
		
	}


}
