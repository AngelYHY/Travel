package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.SceneryCityNameVo;
import utils.JDBCutil;

public class SceneryCityDao {
	
	Connection conn=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	
	//查找景点名称，城市名，图片
	public List<SceneryCityNameVo>  selectSceneryCity (String s) throws SQLException{
		
		List<SceneryCityNameVo> listName = new ArrayList<SceneryCityNameVo>();//
		String sql="select * from scenery_list where title like '"+s+"' or address like '"+s+"'";
		
        ServiceCityListDao cityDao = new ServiceCityListDao();
        
		try {
			conn=JDBCutil.getConnection();
			st=conn.prepareStatement(sql);
			rs = st.executeQuery();
		    while(rs.next()){
		    	String cityName = cityDao.findCityName(rs.getInt("cityId"));//查城市 名
		    	listName.add(new SceneryCityNameVo(rs.getInt("sid"),rs.getString("title"),cityName,rs.getString("imgurl")));
		    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return listName;
	}
	
	public String findCityById(int id){
		String sql = "select cityName from citylist where cityId=?";
		conn = JDBCutil.getConnection();
		String cityName = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()){
				cityName = rs.getString("cityName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return cityName;
	}
}
