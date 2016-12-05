package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import multibean.RecommJudgeUser;
import utils.JDBCutil;

public class RecommJudgeDao {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public void insertJudge(RecommJudgeUser judgeUser){
		String sql = "insert into recommend_evaluate(recommend_evaluate_id_pk,"
				+ "recommend_id_fk,account_name_fk,evaluate_content"
				+ ",evaluate_time,eval_pname)"
				+ " values(null,?,?,?,?,?)";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, judgeUser.getRecommId());
			st.setString(2, judgeUser.getAccount());
			st.setString(3, judgeUser.getJudgeContent());
			st.setString(4, judgeUser.getTime());
			st.setString(5, judgeUser.getpName());
			st.executeUpdate();
			System.out.println("插入评价--："+judgeUser.getJudgeContent());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			JDBCutil.releaseConnection(conn);
		}
		
	}
}
