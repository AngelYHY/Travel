package productdetailsdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;
import beans.ProductShop;

public class ProductDetailsdao {
	
	public ProductShop productdetails(int product_id) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ProductShop product = null;
		try {
			statement = connection.prepareStatement("select * from product where pk_product_id='"+product_id+"'");
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				int pk_product_ids=resultSet.getInt(1);
				String pk_product_id=String.valueOf(pk_product_ids);
				String product_city=resultSet.getString(2);
				String product_name=resultSet.getString(3);
				String product_categoty_id=resultSet.getString(4);
				String product_discription=resultSet.getString(5);
				float product_price=resultSet.getFloat(6);
				int product_stock=resultSet.getInt(7);
				String product_count_unit=resultSet.getString(8);
				String product_picture1=resultSet.getString(9);
				String product_picture2=resultSet.getString(10);
				String product_picture3=resultSet.getString(11);
			product=new ProductShop(pk_product_id, product_city, product_name, product_categoty_id, product_discription, product_price, product_stock, product_count_unit, product_picture1, product_picture2, product_picture3);
				
			}
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		
		
		
		
		
		
		return product;
	}

}
