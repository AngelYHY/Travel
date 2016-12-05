package shoporderdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ReceiveAddress;
import utils.JDBCutil;

public class DefaultAddressdao{
	
	public List<ReceiveAddress> defaultaddress(String accountname){
		List<ReceiveAddress> list=new ArrayList<ReceiveAddress>();
	Connection connection = null;
	connection = JDBCutil.getConnection();
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
		statement = connection.prepareStatement("select * from receive_address where account_name='"+accountname+"' and default_address="+1+"");
		resultSet = statement.executeQuery();
		while (resultSet.next()){
			int receive_id=resultSet.getInt(1);
			String account_name=resultSet.getString(2);
			String name=resultSet.getString(3);
			String phone_num=resultSet.getString(4);
			String province=resultSet.getString(5);
			String city=resultSet.getString(6);
			String detailed_addr=resultSet.getString(7);
			int default_address=resultSet.getInt(8);
			ReceiveAddress beans=new ReceiveAddress(receive_id, account_name, name, phone_num, province, city, detailed_addr, default_address);
			list.add(beans);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCutil.releaseConnection(connection);
	}
	return list;
	
	}
}
