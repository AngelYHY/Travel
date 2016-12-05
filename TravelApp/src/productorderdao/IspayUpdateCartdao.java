package productorderdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import utils.JDBCutil;
import dao.IspayUpdateCart;

public class IspayUpdateCartdao implements IspayUpdateCart{
	ResultSet resultSet = null;
	@Override
	public void ispayupdatecart(List<Integer> list,String ispay_time) {
		Connection connection = null;
		connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		
		int order_id;
		
             for(int i=0;i<list.size();i++){
            	
            	 order_id=Integer.parseInt((String.valueOf(list.get(i))));
            	
            		try {
						statement=connection.prepareStatement("update product_order set is_pay="+1+",pay_time='"+ispay_time+"' where order_id_pk="+order_id+" ");
						statement.executeUpdate();
            		
            		
            		} catch (SQLException e) {
					
						e.printStackTrace();
					} finally {
						JDBCutil.releaseConnection(connection);
					}
            	 
             }
					
				
		
	}

}
