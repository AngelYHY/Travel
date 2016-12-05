package shoppingcartdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.JDBCutil;
import beans.Product;
import dao.GetShowShopCartProduct;

public class GetShowShopCartProductdao implements GetShowShopCartProduct  {

	@Override
	public List<Product> getShowShopCartProduct(int productid) {
		List<Product> list=new ArrayList<Product>();
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
statement = connection.prepareStatement("select * from product where pk_product_id="+productid+" ");
resultSet = statement.executeQuery();

if(resultSet.next()) {
	String picture1=resultSet.getString("product_picture1");
	String productName=resultSet.getString("product_name");
	float productPrice=resultSet.getFloat("product_price");
	int productStock=resultSet.getInt("product_stock");
	Product bean=new Product(productName, productPrice, productStock, picture1);
	list.add(bean);
	
}else{
	return null;
}



		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally {
			JDBCutil.releaseConnection(connection);
		}
		return list;
	}

}
