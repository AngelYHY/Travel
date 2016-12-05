package shoppingcartdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.JDBCutil;
import beans.JoinShoppingCart;
import dao.InputShoppingCart;

public class Inputshoppingcart implements InputShoppingCart{
	List<JoinShoppingCart> list = new ArrayList<JoinShoppingCart>();
	ResultSet resultSet = null;
	@Override
	public void Inputshopcart(String time, String productid,
			String product_count, String accountName) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		
		try {
			statement = connection.prepareStatement("insert into shopping_cart(account_name_fk,product_id_fk,product_count,shopping_cart_time) values(?,?,?,?)");
			statement.setString(1,accountName);
			statement.setInt(2,Integer.parseInt(productid));
			statement.setInt(3,Integer.parseInt(product_count));
			statement.setString(4, time);
		statement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
	
		
	}

}
