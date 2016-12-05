package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Image;
import beans.ImgVo;
import utils.JDBCutil;

public class ImgDao {
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public boolean insert(ImgVo imgVo){
		
		String sql = "insert into img(img_id,kind,kind_id,img_addr,img_width,img_height)"
				+ " values(null,?,?,?,?,?)";
		conn = JDBCutil.getConnection();
		boolean flag = false;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, imgVo.getKind());
			st.setInt(2, imgVo.getKindId());
			st.setString(3, imgVo.getImgAddr());
			st.setInt(4, imgVo.getImgWidth());
			st.setInt(5, imgVo.getImgHeight());
			st.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return flag;
	}
	//img_user_name数据库多加一个字段为了判断那条评论的图片是谁的
    public boolean insertSceneJudge(ImgVo imgVo){
		
		String sql = "insert into img(img_id,kind,kind_id,img_addr,img_width,img_height,"
				+ "img_user_name)"
				+ " values(null,?,?,?,?,?,?)";
		conn = JDBCutil.getConnection();
		boolean flag = false;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, imgVo.getKind());
			st.setInt(2, imgVo.getKindId());
			st.setString(3, imgVo.getImgAddr());
			st.setInt(4, imgVo.getImgWidth());
			st.setInt(5, imgVo.getImgHeight());
			
			st.setString(6, imgVo.getUserName());
			
			st.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return flag;
	}
	public ArrayList<Image> selectByKindId(String kind,int kindId){
		String sql = "select * from img where kind=? and kind_id=?";
		ArrayList<Image> list = new ArrayList<>();
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, kind);
			st.setInt(2, kindId);
			rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Image(rs.getString("img_addr")
						,rs.getInt("img_width"),rs.getInt("img_height")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
	}
	
	//
	public ArrayList<Image> selectByUserName(String kind,int kindId,String name){
		String sql = "select * from img where kind=? and kind_id=? and img_user_name=?";
		ArrayList<Image> list = new ArrayList<>();
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, kind);
			st.setInt(2, kindId);
			st.setString(3, name);
			
			rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Image(rs.getString("img_addr")
						,rs.getInt("img_width"),rs.getInt("img_height")));
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
