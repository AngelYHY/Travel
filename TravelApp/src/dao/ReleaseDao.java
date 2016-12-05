package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ReleaseVo;
import utils.JDBCutil;

public class ReleaseDao {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public void insertRel(ReleaseVo releaseVo){
		String sql = "insert into release_send(release_id_pk,account_name_fk"
				+ ",release_content,release_time) values(null,?,?,?) ";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, releaseVo.getRelAccount());
			st.setString(2, releaseVo.getRelContent());
			st.setString(3, releaseVo.getRelTime());
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public ArrayList<ReleaseVo> selectLimit(int m,int n){
		String sql = "select * from release_send limit ?,?";
		conn = JDBCutil.getConnection();
		ArrayList<ReleaseVo> list = new ArrayList<>();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, m);
			st.setInt(2, n);
			rs = st.executeQuery();
			while(rs.next()){
				list.add(new ReleaseVo(rs.getInt("release_id_pk"), rs.getString("account_name_fk")
						, rs.getString("release_content"), rs.getString("release_time")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
	}
	
	public void deleteById(int releaseId){
		String sql = "delete from release_send where release_id_pk=?";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, releaseId);
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public ReleaseVo selectById(int releaseId){
		String sql = "select * from release_send where release_id_pk=?";
		conn = JDBCutil.getConnection();
		ReleaseVo vo = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, releaseId);
			rs = st.executeQuery();
			if (rs.next()) {//只找一个记录，用if
				vo = new ReleaseVo(rs.getInt("release_id_pk")
			       , rs.getString("account_name_fk"), rs.getString("release_content")
			       , rs.getString("release_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return vo;
	}
	
	public ArrayList<ReleaseVo> selectAll(){
		String sql = "select * from release_send";//release是MySQL的关键字，而表和字段都不能是关键字
		conn = JDBCutil.getConnection();
		ArrayList<ReleaseVo> list = new ArrayList<>();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				list.add(new ReleaseVo(rs.getInt("release_id_pk"), rs.getString("account_name_fk")
						, rs.getString("release_content"), rs.getString("release_time")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
	}
	
	public ReleaseVo selectByUserTime(String account,String time){
		String sql = "select * from release_send where account_name_fk=? and "
				+ "release_time=?";
		conn = JDBCutil.getConnection();
		ReleaseVo vo = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, account);
			st.setString(2, time);
			rs = st.executeQuery();
			if (rs.next()) {//只找一个记录，用if
				vo = new ReleaseVo(rs.getInt("release_id_pk")
			       , rs.getString("account_name_fk"), rs.getString("release_content")
			       , rs.getString("release_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return vo;
	}
	
	public int selectCount(){
		String sql = "select count(*) from release_send";
		int count = 0;
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return count;
	}
}
