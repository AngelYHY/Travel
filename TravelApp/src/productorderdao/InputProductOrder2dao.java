package productorderdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;
import beans.ProductOrder;
import dao.InputProductOrder2;

public class InputProductOrder2dao implements InputProductOrder2 {
	
	@Override
	public int inputproductorder(ProductOrder productOrder) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int order_id = 0;
		int product_count=productOrder.getProduct_count();
		int product_id=productOrder.getProduct_id();
		String order_time=productOrder.getOrder_time();
		int receive_id=productOrder.getReceive_id();
		String account_name=productOrder.getAccount_name();
		String buyer_message=productOrder.getBuyer_message();
		try {
			statement = connection.prepareStatement("insert into product_order(product_id_fk,product_count,receive_id_fk,account_name_fk,order_time,buyer_message,is_pay,is_back_product,is_receive,is_evaluate) values(?,?,?,?,?,?,?,?,?,?)");
		statement.setInt(1, product_id);
		statement.setInt(2, product_count);
		statement.setInt(3, receive_id);
		statement.setString(4, account_name);
		statement.setString(5, order_time);
		statement.setString(6, buyer_message);
		statement.setInt(7, 0);
		statement.setInt(8, 0);
		statement.setInt(9, 0);
		statement.setInt(10, 0);
		statement.executeUpdate();
//		提交订单成功后要把商品的库存减去相应的数量
		statement=connection.prepareStatement("select product_stock from product where pk_product_id="+product_id+"");
		resultSet = statement.executeQuery();
		if(resultSet.next()) {
			int product_stock=resultSet.getInt(1);
			int stock=product_stock-product_count;
			
		statement=connection.prepareStatement("update product set product_stock="+stock+" where pk_product_id="+product_id+"");
		statement.executeUpdate();
		}
		
		statement=connection.prepareStatement("select order_id_pk from product_order where account_name_fk='"+account_name+"' and order_time='"+order_time+"' ");
		resultSet = statement.executeQuery();
		if(resultSet.next()) {
			order_id=resultSet.getInt(1);
		}
	
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		return order_id;
		
		
	}

}
