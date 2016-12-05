package shoppingcartdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;
import dao.DeleteShopCartProduct;

public class DeleteShopCartProductdao implements DeleteShopCartProduct {
	ResultSet resultSet = null;
	@Override
	public void deletecart(String accountname, String id){
		int cartid=Integer.parseInt(id);
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		try {
		statement = connection.prepareStatement("delete from shopping_cart where account_name_fk='"+accountname+"' and shopping_cart_id_pk='"+cartid+"'");
		statement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
	}

}
