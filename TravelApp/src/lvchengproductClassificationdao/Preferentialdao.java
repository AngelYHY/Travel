package lvchengproductClassificationdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;
import utils.JDBCutil;
import dao.ClassificationProduct;

public class Preferentialdao implements ClassificationProduct {

	@Override
	public List<Product> getLimitNews(int m, int n,String gouwudingweicityname) {
		List<Product> list = new ArrayList<Product>();
		
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
	
		try {
			
			String jinritehui="今日特惠";
			statement = connection.prepareStatement("select * from product where product_city='"+gouwudingweicityname+"' and product_categoty_id='"+jinritehui+"' order by pk_product_id desc limit ?,?");
			statement.setInt(1, m);
			statement.setInt(2, n);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int productId = resultSet.getInt(1);
				String productCity = resultSet.getString(2);
				String productName = resultSet.getString(3);
				
				String productCategotyId = resultSet.getString(4);
				String productDiscription = resultSet.getString(5);
				float productPrice = resultSet.getFloat(6);
				int productStock=resultSet.getInt(7);
				String productCountUnit=resultSet.getString(8);
				String productPicture1=resultSet.getString(9);
				String productPicture2=resultSet.getString(10);
				String productPicture3=resultSet.getString(11);
     
			Product bean = new Product(productId, productCity, productName, productCategotyId, productDiscription, productPrice, productStock, productCountUnit, productPicture1, productPicture2, productPicture3);
			System.out.println(list);
			list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(connection);
		}
		
		return list;
	}

		
		
		
		
	

}
