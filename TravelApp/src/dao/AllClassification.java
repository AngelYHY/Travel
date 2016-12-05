package dao;

import java.sql.SQLException;

public interface AllClassification {
	//查询今日特惠总数据抽象方法
		public int getNewsCount(String gouwudingweicityname) throws SQLException;
}
