package lvchengproductClassificationdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBCutil;
import dao.AllClassification;

public class AllKeepsakedao implements AllClassification {

	@Override
	public int getNewsCount(String gouwudingweicityname) throws SQLException {
		int count = 0;
		// 获取数据库连接
		String jinianpin="旅城纪念品";
		Connection connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		// 获取数据库操作类
		try {
			statement = connection
					.prepareStatement("select count(*) from product where product_city='"+gouwudingweicityname+"' and product_categoty_id='"+jinianpin+"'");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(connection);
		}
		
		return count;
	}

}
