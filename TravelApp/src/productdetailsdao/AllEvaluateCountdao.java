package productdetailsdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;

public class AllEvaluateCountdao {
	
	public int allcount(int product_id){
		int count=0;
		Connection connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection
					.prepareStatement("select count(*) from evaluate where product_id_fk='"+product_id+"'");
		
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.releaseConnection(connection);
		}
		return count;
		
		
		
		

	}

}
