package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import multibean.GoodUser;
import multibean.RecommJudgeUser;
import multibean.RecommUser;
import multibean.ReleaseUser;
import utils.JDBCutil;

public class MultiTableDao {

	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	//根据发布，找发布人的信息；并将两张表所需要用到的信息整合
	//int releaseId; String relAccount; String relContent; String relTime;
	//int userId; String account; String userName; String headImg;
	//=====release_id_pk,account_name_fk,release_content,release_time
	//=====pk_user_id,account_name,user_name,head_picture_addr
	public List<ReleaseUser> findRelUser(int m,int n){
		String sql = "select t1.release_id_pk,t1.account_name_fk,t1.release_content,t1.release_time"
				+ ",t2.pk_user_id,t2.account_name,t2.user_name,t2.head_picture_addr "
				+ "from release_send t1,user t2 "
				+ "where t1.account_name_fk=t2.account_name "
				+ "order by t1.release_time desc "
				+ "limit ?,?";
    	conn = JDBCutil.getConnection();
    	List<ReleaseUser> releaseUsers = new ArrayList<>();
    	try {
			st = conn.prepareStatement(sql);
			st.setInt(1, m);
			st.setInt(2, n);
			rs = st.executeQuery();
		    while (rs.next()) {
				releaseUsers.add(new ReleaseUser(rs.getInt("release_id_pk"),rs.getString("account_name_fk")
						,rs.getString("release_content"),rs.getString("release_time")
						,rs.getInt("pk_user_id"),rs.getString("account_name")
						,rs.getString("user_name"),rs.getString("head_picture_addr")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	return releaseUsers;
	}
	
	public List<ReleaseUser> findRelUserByAccount(String account){
		String sql = "select t1.release_id_pk,t1.account_name_fk,t1.release_content,t1.release_time"
				+ ",t2.pk_user_id,t2.account_name,t2.user_name,t2.head_picture_addr "
				+ "from release_send t1,user t2 "
				+ "where t1.account_name_fk=t2.account_name "
				+ "and t1.account_name_fk=?"
				+ "order by t1.release_time desc";
    	conn = JDBCutil.getConnection();
    	List<ReleaseUser> releaseUsers = new ArrayList<>();
    	try {
			st = conn.prepareStatement(sql);
			st.setString(1, account);
			rs = st.executeQuery();
		    while (rs.next()) {
				releaseUsers.add(new ReleaseUser(rs.getInt("release_id_pk"),rs.getString("account_name_fk")
						,rs.getString("release_content"),rs.getString("release_time")
						,rs.getInt("pk_user_id"),rs.getString("account_name")
						,rs.getString("user_name"),rs.getString("head_picture_addr")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	return releaseUsers;
	}
	
	//根据推荐，查找推荐人信息；并整合
	//int recId, String proName, String recReason, String recTime
	//, String account, String recLink,
	//int userId, String userName, String headImg
	//===recommend_id_pk,product_name,recomm_reason,recomm_time
	//recomm_account,recomm_link
	//pk_user_id,user_name,head_picture_addr
	public List<RecommUser> findRecommUser(int m,int n){
		String sql = "select t1.recommend_id_pk,t1.product_name,t1.recomm_reason,"
				+ "t1.recomm_time,t1.recomm_account,t1.recomm_link,"
				+ "t2.pk_user_id,t2.user_name,t2.head_picture_addr "
				+ "from recommend t1,user t2 "
				+ "where t1.recomm_account=t2.account_name "
				+ "order by t1.recomm_time "
				+ "limit ?,?";
		List<RecommUser> list = new ArrayList<>();
		conn = JDBCutil.getConnection();
		
		try {
			//conn = JdbcUtils.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, m);
			st.setInt(2, n);
			rs = st.executeQuery();
			while(rs.next()){
				list.add(new RecommUser(rs.getInt("recommend_id_pk")
						, rs.getString("product_name"), rs.getString("recomm_reason")
						, rs.getString("recomm_time"), rs.getString("recomm_account")
						, rs.getString("recomm_link"), rs.getInt("pk_user_id")
						, rs.getString("user_name"), rs.getString("head_picture_addr")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
	}
	
	public List<RecommUser> findRecUserByAccount(String account){
		String sql = "select t1.recommend_id_pk,t1.product_name,t1.recomm_reason,"
				+ "t1.recomm_time,t1.recomm_account,t1.recomm_link,"
				+ "t2.pk_user_id,t2.user_name,t2.head_picture_addr "
				+ "from recommend t1,user t2 "
				+ "where t2.account_name=t1.recomm_account "
				+ "and t1.recomm_account=? "
				+ "order by t1.recomm_time ";
		List<RecommUser> list = new ArrayList<>();
		conn = JDBCutil.getConnection();
		
		try {
			//conn = JdbcUtils.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, account);
			rs = st.executeQuery();
			while(rs.next()){
				list.add(new RecommUser(rs.getInt("recommend_id_pk")
						, rs.getString("product_name"), rs.getString("recomm_reason")
						, rs.getString("recomm_time"), rs.getString("recomm_account")
						, rs.getString("recomm_link"), rs.getInt("pk_user_id")
						, rs.getString("user_name"), rs.getString("head_picture_addr")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
	}
	
	//点赞，及点赞人信息  goodnum
	//int goodId; String kind; int kindId; String goodAccount;
	//int userId; String userName; String headImg;
	//=====good_id,good_kind,good_kind_id,good_account
	////pk_user_id,user_name,head_picture_addr
	public List<GoodUser> findGoodUser(String kind,int kindId){
		String sql = "select t1.good_id,t1.good_kind,t1.good_kind_id,"
				+ "t1.good_account,t2.pk_user_id,t2.user_name,t2.head_picture_addr "
				+ "from goodnum t1,user t2 "
				+ "where t1.good_account=t2.account_name and good_kind=? and good_kind_id=?";
		conn = JDBCutil.getConnection();
		List<GoodUser> list = new ArrayList<>();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, kind);
			st.setInt(2, kindId);
			rs = st.executeQuery();
			while(rs.next()){
				list.add(new GoodUser(rs.getInt("good_id"), rs.getString("good_kind")
						, rs.getInt("good_kind_id"), rs.getString("good_account")
						, rs.getInt("pk_user_id")
						, rs.getString("user_name"), rs.getString("head_picture_addr")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
	}
	
	
	//int recJudgeId, int recommId, String account
	//, String name, String judgeContent, String time,
	//String pName
	//====recommend_evaluate_id_pk,recommend_id_fk,account_name_fk,
	//evaluate_content,evaluate_time,eval_pname
	//推荐评价表
	public List<RecommJudgeUser> findRecommJudge(int recommId) {
		List<RecommJudgeUser> list = new ArrayList<>();
		String sql = "select t1.recommend_evaluate_id_pk,t1.recommend_id_fk,"
				+ "t1.account_name_fk,t1.evaluate_content,"
				+ "t1.evaluate_time,t1.eval_pname,"
				+ "t2.user_name,t2.head_picture_addr "
				+ "from recommend_evaluate t1,user t2 "
				+ "where t1.account_name_fk=t2.account_name and "
				+ "recommend_id_fk=? "
				+ "order by t1.evaluate_time desc";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, recommId);
			rs = st.executeQuery();
			while (rs.next()) {
				
				list.add(new RecommJudgeUser(rs.getInt("recommend_evaluate_id_pk")
						, rs.getInt("recommend_id_fk")
						, rs.getString("account_name_fk"), rs.getString("user_name"), 
						rs.getString("evaluate_content"), rs.getString("evaluate_time"),
						rs.getString("eval_pname"),rs.getString("head_picture_addr")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
	}
	
	
}
