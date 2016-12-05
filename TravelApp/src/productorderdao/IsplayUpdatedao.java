package productorderdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;
import dao.IsplayUpdate;

public class IsplayUpdatedao implements IsplayUpdate {
	ResultSet resultSet = null;
	@Override
	public void isplayupdate(int order_id,String ispay_time) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement=connection.prepareStatement("update product_order set is_pay="+1+",pay_time='"+ispay_time+"' where order_id_pk="+order_id+" ");
			statement.executeUpdate();
		
		
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
		
	}

}
