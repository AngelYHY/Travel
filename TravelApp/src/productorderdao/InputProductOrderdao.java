package productorderdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.JDBCutil;
import beans.ProductOrder;
import dao.InputProductOrder;

public class InputProductOrderdao implements InputProductOrder {

	@Override
	public List<Integer> inputproductorder(List<ProductOrder> olist, List<Integer> cartlist) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
//		返回的商品订单的Id
		List<Integer> list = new ArrayList<Integer>();
		int order_id=0;
		int cart_id=0;
		
		for(int i=0;i<olist.size();i++){
			String account_name=olist.get(i).getAccount_name();
			int product_id=olist.get(i).getProduct_id();
			int product_count=olist.get(i).getProduct_count();
			int receive_id=olist.get(i).getReceive_id();
			String order_time=olist.get(i).getOrder_time();
		
		try {
//			插入订单
			statement = connection.prepareStatement("insert into product_order(product_id_fk,product_count,receive_id_fk,account_name_fk,order_time,is_pay,is_back_product,is_receive,is_evaluate) values(?,?,?,?,?,?,?,?,?) ");
			statement.setInt(1, product_id);
			statement.setInt(2, product_count);
			statement.setInt(3, receive_id);
			statement.setString(4, account_name);
			statement.setString(5, order_time);
			statement.setInt(6, 0);
			statement.setInt(7, 0);
			statement.setInt(8, 0);
			statement.setInt(9, 0);
			
			statement.executeUpdate();
			
//			查询刚插入的订单的id，返回订单id，通过订单Id来改变订单的支付状态
			statement=connection.prepareStatement("select order_id_pk from product_order where account_name_fk='"+account_name+"' and order_time='"+order_time+"'and product_id_fk="+product_id+" ");
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				order_id=resultSet.getInt(1);
				System.out.println(order_id+"xc");
				list.add(order_id);
			}
			statement=connection.prepareStatement("select product_stock from product where pk_product_id="+product_id+"");
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				int product_stock=resultSet.getInt(1);
				int stock=product_stock-product_count;
				
			statement=connection.prepareStatement("update product set product_stock="+stock+" where pk_product_id="+product_id+"");
			statement.executeUpdate();
			}
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		for(int i=0;i<cartlist.size();i++){
		cart_id=Integer.parseInt((String.valueOf(cartlist.get(i)))) ;

		try {
			statement=connection.prepareStatement("delete from shopping_cart where shopping_cart_id_pk="+cart_id+"");
			statement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
	
			JDBCutil.releaseConnection(connection);
	
		
		
		return list;
	}

}
