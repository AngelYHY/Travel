package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.RecommendedVo;
import utils.JDBCutil;

public class RecommDao {//推荐的增
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public void intsertRecomm(RecommendedVo rVo) {
		String sql = "insert into recommend(recommend_id_pk,"
				+ "product_name,recomm_reason,recomm_time,"
				+ "recomm_account,recomm_link) values(null,?,?,?,?,?)";
        conn = JDBCutil.getConnection();
        try {
			st = conn.prepareStatement(sql);
			st.setString(1, rVo.getProName());
			st.setString(2, rVo.getRecReason());
			st.setString(3, rVo.getRecTime());
			st.setString(4, rVo.getAccount());
			st.setString(5, rVo.getRecLink());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public RecommendedVo selectByUserTime(String account , String time) {
		String sql = "select * from recommend where recomm_account=? "
				+ "and recomm_time=?";
		conn = JDBCutil.getConnection();
		RecommendedVo rVo = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, account);
			st.setString(2, time);
			rs = st.executeQuery();
			while (rs.next()) {
				rVo = new RecommendedVo(rs.getInt("recommend_id_pk")
						, rs.getString("product_name"), rs.getString("recomm_reason")
						, account, time, rs.getString("recomm_link"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return rVo;
	}
	
	public int recommCount() {
		
		String sql = "select count(*) from recommend";
		int count = 0;
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCutil.releaseConnection(conn);
		}
		return count ;
	}

}
