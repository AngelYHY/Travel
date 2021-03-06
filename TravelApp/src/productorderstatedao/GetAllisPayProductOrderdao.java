package productorderstatedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.JDBCutil;
import beans.ProductOrder;

public class GetAllisPayProductOrderdao {
	
	
	public List<ProductOrder> getallispayproductorder(String accountname){
		List<ProductOrder> list=new ArrayList<ProductOrder>();
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("select * from product_order where account_name_fk='"+accountname+"' and is_pay="+0+"");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int order_id=resultSet.getInt(1);
				int product_id=resultSet.getInt(2);
				int product_count=resultSet.getInt(3);
				int receive_id=resultSet.getInt(4);
				String account_name=resultSet.getString(5);
				String order_time=resultSet.getString(6);
				String buyer_message=resultSet.getString("buyer_message");
				ProductOrder bean=new ProductOrder(product_count, order_id, product_id, receive_id, account_name, order_time, 0, null, 0, null, 0, null, 0, buyer_message, null, null);
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
