package lvchengproductClassificationdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AllClassification;
import utils.JDBCutil;

public class AllFood implements AllClassification{

	@Override
	public int getNewsCount(String gouwudingweicityname) throws SQLException {
		int count = 0;
		// 获取数据库连接
		String meishitechan="美食特产";
		Connection connection = JDBCutil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		// 获取数据库操作类
		try {
			statement = connection
					.prepareStatement("select count(*) from product where product_city='"+gouwudingweicityname+"' and product_categoty_id='"+meishitechan+"'");
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
