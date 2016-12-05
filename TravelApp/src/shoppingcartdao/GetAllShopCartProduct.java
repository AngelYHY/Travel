package shoppingcartdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;
import dao.AllShopCartProduct;

public class GetAllShopCartProduct implements AllShopCartProduct {

	@Override
	public int getShopCartCount(String accountname){
		int count=0;
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select count(*) from shopping_cart where '"+accountname+"' ");
		
		resultSet = statement.executeQuery();
		if (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(connection);
		}
		
		return count;
	}

}
