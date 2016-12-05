package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.CityListVo;
import utils.JDBCutil;

/**
 * 数据库emp的表cityList中的 增删改查 操作
 * @author Administrator
 *
 */
public class ServiceCityListDao {
	Connection conn=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	
	public void addCity (CityListVo cityListVo) throws SQLException{
		String sql="insert into citylist(cityId,cityName,provinceId) values(?,?,?)";
		try {
			conn=JDBCutil.getConnection();
			st=conn.prepareStatement(sql);
			
			st.setInt(1, cityListVo.getCityId());
			st.setString(2, cityListVo.getCityName());
			st.setInt(3,cityListVo.getProvinceId());
			
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
    public void deleteCity (int id) throws SQLException{
    	String sql="delete from citylist where id=?";
		try {
			conn=JDBCutil.getConnection();
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}

    public void updateCity (CityListVo cityListVo) throws SQLException{
    	String sql="update citylist set cityName=?,provinceId=?where cityId=?";
		try {
			conn=JDBCutil.getConnection();
			st=conn.prepareStatement(sql);
			st.setString(1, cityListVo.getCityName());
			st.setInt(2, cityListVo.getProvinceId());
			st.setInt(3, cityListVo.getCityId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
    }
    
    public CityListVo selectOneCity (int cityId) throws SQLException{
    	String sql = "select * from citylist where cityId = ?";
    	CityListVo cListVo = null;
    	try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
		    st.setInt(1, cityId);
		    rs = st.executeQuery();
			if(rs.next()){
				cListVo = new CityListVo(rs.getInt("cityId"),rs.getString("cityName"),rs.getInt("provinceId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return cListVo;
    }
    
    public List<CityListVo> selectAllCity () throws SQLException{
    	String sql = "select * from citylist";//--------表cityList
    	List<CityListVo> list = new ArrayList<CityListVo>();
    	try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				list.add(new CityListVo(rs.getInt("cityId"),rs.getString("cityName"),rs.getInt("provinceId")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;	
    }
    
    //根据id查找 城市名称
    public String findCityName (int cityId) throws SQLException{
    	String sql = "select * from citylist where cityId = ?";
    	String cityName = null;
    	try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
		    st.setInt(1, cityId);
		    rs = st.executeQuery();
		    
			if(rs.next()){
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
    //------通过省份pid查询所有城市
    
    public List<CityListVo> selectCity (int provinceId) throws SQLException{
    	String sql = "select * from citylist where provinceId = 16";
    	List<CityListVo> list = new ArrayList<CityListVo>();
    	try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
		    //st.setInt(1, provinceId);
		    rs = st.executeQuery();
		    
			while(rs.next()){  //---------查询出多条数据用while！！！不用if	
				list.add(new CityListVo(rs.getInt("cityId"),rs.getString("cityName"),rs.getInt("provinceId")));
			}
			
			System.out.println(list.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
    }
}
