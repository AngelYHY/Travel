package productorderstatedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;
import beans.Evaluate;

public class InputEvaluatedao {
	ResultSet resultSet = null;
	public void inputevaluate(Evaluate evaluate){
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		
		int order_id=evaluate.getOrder_id();
		int product_id=evaluate.getProduct_id();
		int product_count=evaluate.getProduct_count();
		String accountname=evaluate.getAccountname();
		String evaluate_content=evaluate.getEvaluate_content();
		String evaluate_time=evaluate.getEvaluate_time();
		
		try {
			statement = connection
					.prepareStatement("insert into evaluate(order_id_fk,product_id_fk,account_name_fk,evaluate_time,product_count,evaluate_content) values(?,?,?,?,?,?) ");
		statement.setInt(1, order_id);
		statement.setInt(2, product_id);
		statement.setString(3, accountname);
		statement.setString(4, evaluate_time);
		statement.setInt(5, product_count);
		statement.setString(6, evaluate_content);
		statement.executeUpdate();
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(connection);
		}
		
		
		
		
	}
	

}
