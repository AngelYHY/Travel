package minedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.ReceiveAddress;
import dao.ModifyAddress;
import utils.JDBCutil;

public class ModifyAddressdao implements ModifyAddress {
	ResultSet resultSet = null;
	@Override
	public void modifyaddress(ReceiveAddress receiveAddress) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		
		int receive_id=receiveAddress.getReceive_id();
		//String accountname = receiveAddress.getAccount_name();
		String name = receiveAddress.getName();
		String phone_num = receiveAddress.getPhone_num();
		String province = receiveAddress.getProvince();
		String city = receiveAddress.getCity();
		String detailed_addr = receiveAddress.getDetailed_addr();
		int default_address = receiveAddress.getDefault_address();
//		如果当前要修改的这个这个地址是默认地址，这时如果其他地址有默认地址就要把它删掉。
		if(default_address==1){
			try {
				statement=connection.prepareStatement("update receive_address set default_address="+0+"   ");
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		try {
			statement=connection.prepareStatement("update receive_address set name=?,phone_num=?,province=?,city=?,detailed_addr=?,default_address=? where receive_id_pk="+receive_id+"");
			statement.setString(1, name);
			statement.setString(2, phone_num);
			statement.setString(3, province);
			statement.setString(4, city);
			statement.setString(5, detailed_addr);
			statement.setInt(6, default_address);
			statement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
		
	}
}
