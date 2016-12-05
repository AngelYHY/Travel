package productorderstatedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;

public class DeleteOrderIspaydao {
	
	public void deleteorderispay(int order_id,int product_count,int product_id){
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
//			先删除订单
			statement = connection.prepareStatement("delete from product_order where order_id_pk="+order_id+"");
			statement.executeUpdate();
//			再来改商品的库存，你修改订单后，商品的库存应该加上你订单中商品的数量
//			先根据商品的Id查出商品的库存。
			statement=connection.prepareStatement("select product_stock from product where pk_product_id="+product_id+"");
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				int product_stock=resultSet.getInt(1);
				int stock=product_stock+product_count;
//				修改库存
			statement=connection.prepareStatement("update product set product_stock="+stock+" where pk_product_id="+product_id+"");
			statement.executeUpdate();
			}
			
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
	}
	

}
