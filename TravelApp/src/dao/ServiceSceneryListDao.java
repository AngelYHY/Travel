package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.SceneryListVo;
import utils.JDBCutil;

/**
 * 数据库emp的表cityList中的 增删改查 操作
 * @author Administrator
 *
 */
public class ServiceSceneryListDao {
	Connection conn=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	//SceneryListVo(String title, String grade, int price_min
	//, int comm_cnt, int cityId, String address,
	//int sid, String url, String imgurl)
	//title,grade,price_min,comm_cnt,cityId,address,sid,url,imgurl
	public void addScenery (SceneryListVo sceneryListVo) throws SQLException{
		String sql="insert into scenery_list(title,grade,price_min,comm_cnt"
				+ ",cityId,address,sid,url,imgurl) values(?,?,?,?,?,?,?,?,?)";
		try {
			conn=JDBCutil.getConnection();
			st=conn.prepareStatement(sql);
			
			st.setString(1, sceneryListVo.getTitle());
			st.setString(2, sceneryListVo.getGrade());
			st.setFloat(3, sceneryListVo.getPrice_min());
			st.setInt(4, sceneryListVo.getComm_cnt());
			st.setInt(5, sceneryListVo.getCityId());
			st.setString(6, sceneryListVo.getAddress());
			st.setInt(7, sceneryListVo.getSid());
			st.setString(8, sceneryListVo.getUrl());
			st.setString(9, sceneryListVo.getImgurl());
			
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
    public void deleteScenery (int sid) throws SQLException{
    	String sql="delete from scenery_list where sid=?";
		try {
			conn=JDBCutil.getConnection();
			st=conn.prepareStatement(sql);
			
			st.setInt(1, sid);
			
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
  //title,grade,price_min,comm_cnt,cityId,address,sid,url,imgurl
    public void updateScenery (SceneryListVo sceneryListVo) throws SQLException{
    	String sql="update scenery_list set title=?,grade=?,price_min=?"
    			+ "comm_cnt=?,cityId=?,address=?,url=?,imgurl=?  where sid=?";
		try {
			conn=JDBCutil.getConnection();
			st=conn.prepareStatement(sql);
			
			st.setString(1, sceneryListVo.getTitle());
			st.setString(2, sceneryListVo.getGrade());
			st.setFloat(3, sceneryListVo.getPrice_min());
			st.setInt(4, sceneryListVo.getComm_cnt());
			st.setInt(5, sceneryListVo.getCityId());
			st.setString(6, sceneryListVo.getAddress());
			
			st.setString(7, sceneryListVo.getUrl());
			st.setString(8, sceneryListVo.getImgurl());
			
			st.setInt(9, sceneryListVo.getSid());
			
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
    }
    
    public SceneryListVo selectBySidScenery (int sid) throws SQLException{
    	String sql = "select * from scenery_list where  sid = ?";
    	SceneryListVo sListVo = null;
    	try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
		    st.setInt(1, sid);
		    rs = st.executeQuery();
		    
			if(rs.next()){
				sListVo = new SceneryListVo(rs.getString("title"),rs.getString("grade"),rs.getFloat("price_min")
						,rs.getInt("comm_cnt"),rs.getInt("cityId"),rs.getString("address"),rs.getInt("sid")
						,rs.getString("url"),rs.getString("imgurl"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return sListVo;
    }
    
    public List<SceneryListVo> selectAllScenery (SceneryListVo sceneryListVo) throws SQLException{
    	String sql = "select * from scenery_list";//--------表cityList
    	List<SceneryListVo> list = new ArrayList<SceneryListVo>();
    	try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				list.add(new SceneryListVo(rs.getString("title"),rs.getString("grade"),rs.getFloat("price_min")
						,rs.getInt("comm_cnt"),rs.getInt("cityId"),rs.getString("address"),rs.getInt("sid")
						,rs.getString("url"),rs.getString("imgurl")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;	
    }
    //根据景点标题查找id
    public SceneryListVo selectBySceneryTitle (String title) throws SQLException{
    	String sql = "select * from scenery_list where  title = ?";
    	SceneryListVo sListVo = null;
    	try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
		    st.setString(1, title);
		    rs = st.executeQuery();
		    
			if(rs.next()){
				sListVo =
				 new SceneryListVo(rs.getString("title"),rs.getString("grade"),rs.getFloat("price_min")
						,rs.getInt("comm_cnt"),rs.getInt("cityId"),rs.getString("address"),rs.getInt("sid")
						,rs.getString("url"),rs.getString("imgurl"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return sListVo;
    }
    //搜索n条景点数据
    public List<SceneryListVo> selectPartBySid (int sid ,int mfirst,int nNum) throws SQLException{
    	String sql = "select * from scenery_list where  sid = ? limit ?,?";
    	List<SceneryListVo> list = new ArrayList<>();
    	try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
		    st.setInt(1, sid);
		    st.setInt(2, mfirst);
		    st.setInt(3, nNum);
		    rs = st.executeQuery();
		    
			while(rs.next()){
				list.add(new SceneryListVo(rs.getString("title"),rs.getString("grade"),rs.getFloat("price_min")
						,rs.getInt("comm_cnt"),rs.getInt("cityId"),rs.getString("address"),rs.getInt("sid")
						,rs.getString("url"),rs.getString("imgurl")));
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
