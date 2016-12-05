package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.PlanVo;
import utils.JDBCutil;

public class PlanDao {

	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	public void insertPlan(PlanVo planVo) throws SQLException{
		String sql = "insert into travel_plan(plan_id_pk,account_name_fk,sdate,feature_id_fk) values(null,?,?,?) ";	
//		Date date = new Date();//util 计划的时间是根据日历，不是插入数据库时的时间
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		String sdate = dateformat.format(date);
		String sdate = planVo.getSdate();
		System.out.println("date = "+sdate);
		try {
			conn = JDBCutil.getConnection();
			st = conn.prepareStatement(sql);
			
			st.setString(1, planVo.getAccount());
			st.setString(2, sdate);
			st.setInt(3, planVo.getFeatureId());//第三个参数是3不是2
			
			st.executeUpdate();
			System.out.println("插入成功account="
			   +planVo.getAccount()+";sdate="+sdate+";sid="+planVo.getFeatureId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public List<PlanVo> selectPlanByAccount(String account){
		String sql = "select * from travel_plan where account_name_fk =? order by sdate";
		List<PlanVo> list = new ArrayList<>();
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, account);
			rs = st.executeQuery();
			
			while (rs.next()) {
				list.add(new PlanVo(rs.getInt("plan_id_pk"),rs.getString("account_name_fk"), 
						rs.getString("sdate"), rs.getInt("feature_id_fk")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		return list;
	}
	
	public void deleteByPlanId(int planId) {
		String sql = "delete from travel_plan where plan_id_pk=?";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, planId);
			st.executeUpdate();
			System.out.println("删除的id为planId = "+planId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
	}
	
	public void updateSdate(PlanVo planVo) {
		String sql = "update travel_plan set sdate=? where plan_id_pk=?";
		conn = JDBCutil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, planVo.getSdate());
			st.setInt(2, planVo.getPlanId());
			st.executeUpdate();
			System.out.println("更新计划表");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(conn);
		}
		
		
	}
	
}
