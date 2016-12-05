package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UserVo;
import utils.JDBCutil;

public class UserDao {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public void insertUser(UserVo userVo){
		String sql = "insert into user(pk_user_id,account_name,password,user_name,address,"
				+ "phone_num,age,sex,head_picture_addr) values(null,?,?,?,?,?,?,?,?)";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userVo.getAccount());
			st.setString(2, userVo.getPassword());
			st.setString(3, userVo.getUserName());
			st.setString(4, userVo.getAddress());
			st.setString(5, userVo.getPhoneNum());
			st.setInt(6, userVo.getAge());
			st.setString(7, userVo.getSex());
			st.setString(8, userVo.getHeadImg());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public boolean updateUser(UserVo userVo){
		String sql = "update user set user_name=?,address=?,"
				+ "age=?,sex=?,head_picture_addr=?) values(?,?,?,?,?)";
		conn = JDBCutil.getConnection();
		boolean flag = false;
		try {
			st = conn.prepareStatement(sql);		
			st.setString(1, userVo.getUserName());
			st.setString(2, userVo.getAddress());			
			st.setInt(3, userVo.getAge());
			st.setString(4, userVo.getSex());
			st.setString(5, userVo.getHeadImg());
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
	//查找，根据账号查找
	public UserVo selectByAccount(String account){
		String sql = "select * from user where account_name=?";
		conn = JDBCutil.getConnection();
		UserVo userVo = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, account);
			rs = st.executeQuery();
			while (rs.next()) {
				userVo = new UserVo(rs.getInt("pk_user_id"), rs.getString("account_name")
						, rs.getString("password"), rs.getString("user_name"),rs.getString("address")
						, rs.getString("phone_num"), rs.getInt("age"), rs.getString("sex")
						, rs.getString("head_picture_addr"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return userVo;
	}
	
	//修改密码
	//更改手机
}
