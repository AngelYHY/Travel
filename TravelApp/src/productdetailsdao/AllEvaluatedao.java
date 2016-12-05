package productdetailsdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.JDBCutil;
import beans.Evaluate;

public class AllEvaluatedao {
	
	public List<Evaluate> allevaluate(int m,int n,int product_id){
		List<Evaluate> list=new ArrayList<Evaluate>();
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("select * from evaluate where product_id_fk="+product_id+" order by evaluate_id_pk desc limit ?,?");
			statement.setInt(1, m);
			statement.setInt(2, n);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int evaluate_id=resultSet.getInt(1);
				int order_id=resultSet.getInt(2);
			//	int producid=resultSet.getInt(3);
				String account_name=resultSet.getString(4);
				String evaluate_time=resultSet.getString(5);
				int product_count=resultSet.getInt(6);
				String evaluate_content=resultSet.getString(7);
				Evaluate bean=new Evaluate(evaluate_id, order_id, product_id, account_name, evaluate_time, product_count, evaluate_content);
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
