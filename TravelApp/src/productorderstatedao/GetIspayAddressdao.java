package productorderstatedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.JDBCutil;
import beans.ReceiveAddress;

public class GetIspayAddressdao {
	
	public List<ReceiveAddress> getispayaddress(int receive_id){
		List<ReceiveAddress> list=new ArrayList<ReceiveAddress>();
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("select * from receive_address where receive_id_pk="+receive_id+"");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
			
			String name=resultSet.getString("name");
			String phone_num=resultSet.getString("phone_num");
			String province=resultSet.getString("province");
			String city=resultSet.getString("city");
			String detailed_addr=resultSet.getString("detailed_addr");
			ReceiveAddress bean=new ReceiveAddress(name, phone_num, province, city, detailed_addr);
			list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
		
		
		return list;
		
	}
	

}
