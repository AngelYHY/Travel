package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.CitySceneVo;
import utils.JDBCutil;

public class CitySceneDao {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public void insertCityScene(CitySceneVo vo) {
		String sql = "insert into city_scene(city_scene_id"
				+ ",title,content,time1,time2,city_name) values(null,?,?,?,?,?)";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, vo.getTitle());
			st.setString(2, vo.getContent());
			st.setString(3, vo.getTime1());
			st.setString(4, vo.getTime2());
			st.setString(5, vo.getCityName());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public List<CitySceneVo> findByCityName(String cityName){
		List<CitySceneVo> list = new ArrayList<>();
		String sql = "select * from city_scene where city_name=?";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, cityName);
			rs = st.executeQuery();
			while (rs.next()) {
				list.add(new CitySceneVo(rs.getString("title"), rs.getString("content")
						, rs.getString("time1"), rs.getString("time2"), cityName));
				
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
