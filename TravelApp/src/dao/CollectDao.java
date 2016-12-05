package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.CollectVo;
import utils.JDBCutil;

public class CollectDao {

	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	public void insertColect(CollectVo colectVo) throws SQLException{
		String sql = "insert into collect(collect_id,kind,kind_id,stime,account)"
				+ " values(null,?,?,?,?)";
		try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, colectVo.getKind());
			st.setInt(2, colectVo.getKindId());
			st.setString(3, colectVo.getStime());
			st.setString(4, colectVo.getAccount());
			st.executeUpdate();
			System.out.println("CollectDao插入Collect");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCutil.releaseConnection(conn);
		}
	}
	
	
    public void deleteColect(CollectVo colectVo) {
		String sql = "delete from collect where kind=? and kind_id=? and account=?";
		try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, colectVo.getKind());
			st.setInt(2, colectVo.getKindId());
			st.setString(3, colectVo.getAccount());
			st.executeUpdate();
			System.out.println("CollectDao删除Collect");
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
    
    public boolean selectByKindId(CollectVo collectVo) {
    	String sql = "select * from collect where kind=? and kind_id=? and account=?";
    	conn = JDBCutil.getConnection();
    	boolean flag = false;
    	try {
			st = conn.prepareStatement(sql);
			st.setString(1, collectVo.getKind());
			st.setInt(2, collectVo.getKindId());
			st.setString(3, collectVo.getAccount());
			rs = st.executeQuery();
			System.out.println("CollectDao查看是否收藏返回Boolean--Collect");
			if (rs.next()) {//如果不为空
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
    	
		return flag;
	}
}
