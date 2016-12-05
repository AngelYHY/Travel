package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.GoodVo;
import utils.JDBCutil;

public class GoodDao {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public void insertDood(String kind,int kindId,String account){//第一次点赞创建一条记录，点赞数为1
		String sql = "insert into goodnum(good_id,good_kind,good_kind_id,good_account)"
				+ " values(null,?,?,?)";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, kind);
			st.setInt(2, kindId);
			st.setString(3, account);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public void deleteDood(String kind,int kindId,String account) {
		String sql = "delete from goodnum where good_kind=? and good_kind_id=? and good_account=?";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, kind);
			st.setInt(2, kindId);
			st.setString(3, account);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public ArrayList<GoodVo> selectPartByKindId(String kind,int kindId) {//查出该发布所有点赞的对象
		String sql = "select * from goodnum where good_kind=? and good_kind_id=?";
		conn = JDBCutil.getConnection();
		ArrayList<GoodVo> goodVoList = new ArrayList<>();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, kind);
			st.setInt(2, kindId);
			
			rs = st.executeQuery();
			while (rs.next()) {//查询记录，而不是只查询一个good_num
				goodVoList.add(new GoodVo(rs.getInt("good_id"), rs.getString("good_kind")
						, rs.getInt("good_kind_id"), rs.getString("good_account")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return goodVoList;
	}
	
	public GoodVo selectOneByAccount(String kind,int kindId,String account) {//查出该发布所有点赞的对象
		String sql = "select * from goodnum where good_kind=? and good_kind_id=? and good_account=?";
		conn = JDBCutil.getConnection();
		GoodVo goodVo = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, kind);
			st.setInt(2, kindId);
			st.setString(3, account);
			System.out.println("GoodDao中的selectNum---kind="+kind+";kindId="+kindId);
			
			rs = st.executeQuery();
			while (rs.next()) {//查询记录，而不是只查询一个good_num
				goodVo = new GoodVo(rs.getInt("good_id"), rs.getString("good_kind")
						, rs.getInt("good_kind_id"), rs.getString("good_account"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return goodVo;
	}
	
}
