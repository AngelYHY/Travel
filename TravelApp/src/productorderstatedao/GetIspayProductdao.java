package productorderstatedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.JDBCutil;
import beans.Product;

public class GetIspayProductdao {
	
	public List<Product> getIspayProduct(int product_id){
		List<Product> list=new ArrayList<Product>();
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("select * from product where pk_product_id="+product_id+"");
		
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
		
			String product_name=resultSet.getString("product_name");
		float product_price=resultSet.getFloat("product_price");
		String product_picture1=resultSet.getString("product_picture1");
		int product_stock=resultSet.getInt("product_stock");
			Product product=new Product(product_name,product_price, product_stock, product_picture1);
			list.add(product);
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
