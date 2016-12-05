package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import multibean.FeatureJudge;
import utils.JDBCutil;

public class FeatureJudgeDao {

	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	public List<FeatureJudge> findFeatureJudgeUser
	(Integer sid,int m,int n){
		String sql = "select t1.feature_evaluate_id_pk"
				+ ",t1.feature_sid_fk"
				+ ",t1.user_name_fk,t1.score,t1.feature_evaluate"
				+ ",t1.time"
				+ ",t2.head_picture_addr "
				+ "from feature_evaluate t1,user t2 "
				+ "where t1.user_name_fk=t2.user_name "
				+ "and t1.feature_sid_fk=? "
				+ "limit ?,?";
		conn = JDBCutil.getConnection();
		List<FeatureJudge> jList = new ArrayList<>();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, sid);
			st.setInt(2, m);
			st.setInt(3, n);
			rs = st.executeQuery();
			while (rs.next()) {
				//String headImg, String judgeName
	            //, String judgeContent, int sceneJudgeId
	            //, float score, int sid, String time
	            //, String userName
				jList.add(new FeatureJudge(rs.getString("head_picture_addr")
						, rs.getString("user_name_fk"), rs.getString("feature_evaluate")
						, rs.getInt("feature_evaluate_id_pk"), rs.getFloat("score")
						, rs.getInt("feature_sid_fk"), rs.getString("time")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		
		return jList;
	}
	
	public boolean insertFeatureJudge(FeatureJudge judge) {
		String sql = "insert into feature_evaluate(feature_evaluate_id_pk"
				+ ",feature_sid_fk,user_name_fk,score"
				+ ",feature_evaluate,time)"
				+ " values(null,?,?,?,?,?)";
		conn = JDBCutil.getConnection();
		boolean flag = false;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, judge.getSid());
			//account换成username
			st.setString(2, judge.getJudgeName());
			st.setFloat(3, judge.getScore());
			st.setString(4, judge.getJudgeContent());
			st.setString(5, judge.getTime());
			
			st.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return flag;
	}
	
	public int findJudgeIdByTime(String time) {
		String sql = "select feature_evaluate_id_pk from feature_evaluate "
				+ "where time=?";
		conn = JDBCutil.getConnection();
		int id = 0;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, time);
			rs = st.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		
		return id;
	}
}
