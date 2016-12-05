package productorderstatedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;

public class UpdateIsEvaluatedao {
	ResultSet resultSet = null;
	public void updateisevaluate(String evaluate_time,int order_id){
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement=connection.prepareStatement("update product_order set is_evaluate="+1+",evaluate_time='"+evaluate_time+"' where order_id_pk="+order_id+"");
			statement.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
	
		
		
	}
	

}
