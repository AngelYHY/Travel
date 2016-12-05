package minedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;
import beans.ReceiveAddress;
import dao.DeleteAddress;

public class DeleteAddressdao implements DeleteAddress{
	ResultSet resultSet = null;
	@Override
	public void deleteaddress(ReceiveAddress receiveAddress) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		int receive_id=receiveAddress.getReceive_id();
		try {
			statement=connection.prepareStatement("delete from receive_address where receive_id_pk="+receive_id+" ");
			statement.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
		
		
		
		
	}
	

}
