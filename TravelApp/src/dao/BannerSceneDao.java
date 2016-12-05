package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BannerSceneVo;
import utils.JDBCutil;

public class BannerSceneDao {
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	public void insertScene(BannerSceneVo vo){
		String sql = "insert into banner_scene(scene_id"
				+ ",title,intro,tips,open_time,trip_time,city_name) values(null,)";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, vo.getTitle());
			st.setString(2, vo.getIntro());
			st.setString(3, vo.getTips());
			st.setString(4, vo.getOpen_time());
			st.setString(5, vo.getTrip_time());
			st.setString(6, vo.getCity_name());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}		
	}
	
	public List<BannerSceneVo> findPartScene(int m,int n){
		String sql = "select * from banner_scene limit ?,?";
		List<BannerSceneVo> list = new ArrayList<>();
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, m);
			st.setInt(2, n);
			rs = st.executeQuery();
			while (rs.next()) {
				list.add(new BannerSceneVo(rs.getInt("scene_id"), rs.getString("title")
						, rs.getString("intro"), rs.getString("tips")
						, rs.getString("open_time"), rs.getString("trip_time")
						, rs.getString("city_name")));
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
