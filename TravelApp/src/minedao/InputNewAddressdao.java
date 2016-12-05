package minedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.ReceiveAddress;
import dao.InputNewAddress;
import utils.JDBCutil;

public class InputNewAddressdao implements InputNewAddress {
	ResultSet resultSet = null;
	@Override
	public void inputnewaddress(ReceiveAddress receiveAddress) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		String accountname = receiveAddress.getAccount_name();
		String name = receiveAddress.getName();
		String phone_num = receiveAddress.getPhone_num();
		String province = receiveAddress.getProvince();
		String city = receiveAddress.getCity();
		String detailed_addr = receiveAddress.getDetailed_addr();
		int default_address = receiveAddress.getDefault_address();
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
			statement = connection
					.prepareStatement("insert into receive_address(account_name,name,phone_num,province,city,detailed_addr,default_address) values(?,?,?,?,?,?,?) ");
			statement.setString(1, accountname);
			statement.setString(2, name);
			statement.setString(3, phone_num);
			statement.setString(4, province);
			statement.setString(5, city);
			statement.setString(6, detailed_addr);
			statement.setInt(7, default_address);

			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(connection);
		}

	}

}
