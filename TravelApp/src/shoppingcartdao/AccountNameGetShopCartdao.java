package shoppingcartdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AccountNameGetShopCart;
import utils.JDBCutil;
import beans.JoinShoppingCart2;

public class AccountNameGetShopCartdao implements AccountNameGetShopCart {

	@Override
	public List<JoinShoppingCart2> getShopCart(int m, int n, String accountname) {
		List<JoinShoppingCart2> list = new ArrayList<JoinShoppingCart2>();
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from shopping_cart where account_name_fk='"+accountname+"'order by shopping_cart_id_pk desc limit ?,?");
			statement.setInt(1, m);
			statement.setInt(2, n);
			resultSet = statement.executeQuery();
			while (resultSet.next()){
				int shoppingCartId=resultSet.getInt(1);
				String accountName=resultSet.getString(2);
				int productId=resultSet.getInt(3);
				int productCount=resultSet.getInt(4);
				String shoppingCartTime=resultSet.getString(5);
				JoinShoppingCart2 bean=new JoinShoppingCart2(shoppingCartId, accountName, productId, productCount, shoppingCartTime);
		
				list.add(bean);
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCutil.releaseConnection(connection);
		}
		return list;
	}

}
