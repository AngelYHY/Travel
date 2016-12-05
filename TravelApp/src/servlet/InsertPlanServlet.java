package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.PlanJsonVo;
import beans.PlanVo;
import beans.SceneryListVo;
import dao.PlanDao;
import dao.ServiceCityListDao;
import dao.ServiceSceneryListDao;

public class InsertPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertPlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter w = response.getWriter();
		String flag = request.getParameter("flag");//flag=insert ;select
		String accountName = request.getParameter("accountName");
		PlanDao planDao = new PlanDao();//操作
		switch(flag){
		  case "insert":
			  String sdate = request.getParameter("sdate");
			  String ssid = request.getParameter("sid");
			  int sid = Integer.parseInt(ssid);
				
				try {
					planDao.insertPlan(new PlanVo(0,accountName,sdate,sid));//插入数据
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				w.write("success");
				w.close();
			 break;
		  case "select":
			  String real = request.getParameter("CompileTime");
			  String ss = request.getParameter("getWhich");
			  Gson gson= new Gson();
			  ServiceCityListDao serviceCityDao = new ServiceCityListDao();
			  ServiceSceneryListDao serviceSceneryListDao = new ServiceSceneryListDao();
			  List<PlanVo> listPlan = planDao.selectPlanByAccount(accountName);
			  List<PlanJsonVo> planJsonVos = new ArrayList<>();
			  //List<PlanJsonVo>
			  if (listPlan != null) {
				  for (int i = 0; i < listPlan.size(); i++) {
					  PlanVo planVo = listPlan.get(i);
					  if (ss.equals("newPlan")) {//获取当前时间之后的计划，当遇到小的时间时跳出本次循环
						        if (planVo.getSdate().compareTo(real)<0){continue;}
					     }else {//获取历史计划，时间大的舍弃
						        if (planVo.getSdate().compareTo(real)>=0){continue;}
					     }
					  try {
						SceneryListVo sceneryListVo = serviceSceneryListDao.selectBySidScenery(planVo.getFeatureId());
						String cityName = serviceCityDao.findCityName(sceneryListVo.getCityId());
				        planJsonVos.add(new PlanJsonVo(planVo, sceneryListVo, cityName));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  }
			   }
			  w.write(gson.toJson(planJsonVos));
			  w.close();
			  break;
		  case "delete":
			  String planId = request.getParameter("planId");
			  planDao.deleteByPlanId(Integer.parseInt(planId));
			  System.out.println("删除planId的Servlet"+planId);
			  break;
		  case "update":
			  String planId2 = request.getParameter("planId");
			  String sdate2 = request.getParameter("sdate");
			  planDao.updateSdate(new PlanVo(Integer.parseInt(planId2), accountName, sdate2, 0));//景点sid不需要用到
			  break;
			  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
