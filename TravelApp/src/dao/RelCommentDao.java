package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.RelComment;
import utils.JDBCutil;

public class RelCommentDao {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public void insertComment(RelComment relComment) {
		String sql="insert into release_evaluate(release_evaluate_id_pk,release_id_fk,"
				+ "release_evaluate_account_fk,release_evaluate_content,release_evaluate_time,"
				+ "p_rel_eval_name) values(null,?,?,?,?,?)";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, relComment.getReleaseId());
			st.setString(2, relComment.getAccount());
			st.setString(3, relComment.getContent());
			st.setString(4, relComment.getCommentTime());
			st.setString(5, relComment.getpName());
		
			st.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public ArrayList<RelComment> selectByRelId(int relId) {//根据发布id查找(有根据account查找username)
		String sql = "select t1.release_evaluate_id_pk,t1.release_id_fk,"
				+ "t1.release_evaluate_account_fk,t1.release_evaluate_time,"
				+ "t1.release_evaluate_content,t1.p_rel_eval_name,"
				+ "t2.user_name "
				+ "from release_evaluate t1,user t2 "
				+ "where t1.release_evaluate_account_fk=t2.account_name "
				+ "and t1.release_id_fk=? "
				+ "order by t1.release_evaluate_time";
		//String sql = "select * from release_evaluate where release_id_fk=?";
		conn = JDBCutil.getConnection();
		ArrayList<RelComment> list = new ArrayList<>();
		RelComment relComment = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, relId);
			rs = st.executeQuery();
			while (rs.next()) {
				//int relCommentId, int releaseId, String account
	          // , String commentTime, String content,int pname,
				relComment = new RelComment(rs.getInt("release_evaluate_id_pk"), rs.getInt("release_id_fk"), 
						rs.getString("release_evaluate_account_fk"),rs.getString("user_name")
						, rs.getString("release_evaluate_time")
						, rs.getString("release_evaluate_content"), rs.getString("p_rel_eval_name"));
				list.add(relComment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
	}
	
	public RelComment selectByCommId(int commId) {//根据发布id查找
		String sql = "select * from release_evaluate where release_id_fk=? "
				+ "order by release_evaluate_time desc";
		conn = JDBCutil.getConnection();
		RelComment relComment = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, commId);
			rs = st.executeQuery();
			while (rs.next()) {
				relComment = new RelComment(rs.getInt("release_evaluate_id_pk"), rs.getInt("release_id_fk"), 
						rs.getString("release_evaluate_account_fk"), rs.getString("release_evaluate_time")
						, rs.getString("release_evaluate_content"), rs.getString("p_rel_eval_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return relComment;
	}
	
	public void deleteById(int relComId){//根据评论的id
		String sql = "delete from release_evaluate where release_evaluate_id_pk=?";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, relComId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
}
