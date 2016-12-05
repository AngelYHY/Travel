package shoppingcartdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;
import dao.GetCartProduct;

public class GetCartProductdao implements GetCartProduct {

	@Override
	public boolean getcartprodcut(String accountname, int productid) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from shopping_cart where account_name_fk='"+accountname+"' and product_id_fk='"+productid+"' ");
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(connection);
		}
		return true; 
		
		
		
		
	}



	

}
