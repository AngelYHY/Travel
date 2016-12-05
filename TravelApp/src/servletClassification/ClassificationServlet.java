package servletClassification;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lvchengproductClassificationdao.AllCultural;
import lvchengproductClassificationdao.AllFood;
import lvchengproductClassificationdao.AllKeepsakedao;
import lvchengproductClassificationdao.AllPreferentialdao;
import lvchengproductClassificationdao.Culturaldao;
import lvchengproductClassificationdao.Food;
import lvchengproductClassificationdao.Keepsakedao;
import lvchengproductClassificationdao.Preferentialdao;
import beans.Product;

import com.google.gson.Gson;

public class ClassificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassificationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// flag标志位表示不同的查询
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		// 声明服务器返回给客户端结果字符串
		String result = "";
		
		
	
		String gouwudingweicityname;
		String flag = request.getParameter("flag");
		
//		if(gouwudingweicityname==null){
//			gouwudingweicityname="苏州";
//		}
		
		
//		System.out.println("sSSSSSSSS"+gouwudingweicityname); 
		switch (flag) {

		case "1":
			// 分页查询
			System.out.println(flag);
			int startIndex = Integer.parseInt(request
					.getParameter("startIndex"));
			 gouwudingweicityname=request.getParameter("cityname");
			 System.out.println(gouwudingweicityname);
			int count = Integer.parseInt(request.getParameter("count"));
			System.out.println("startIndex is " + startIndex + ",count is "
					+ count);
			Preferentialdao jinritehui = new Preferentialdao();
			List<Product> list1 = jinritehui.getLimitNews(startIndex, count,gouwudingweicityname);
			result = gson.toJson(list1);
			System.out.println(result);
			System.out.println("======分页查询======获取商品数据flag= "+flag);
			printWriter.write(result);
			break;
		case "2":
			gouwudingweicityname=request.getParameter("cityname");
			 System.out.println(gouwudingweicityname);
			AllPreferentialdao allcount = new AllPreferentialdao();
			int count1 = 0;
			try {
				count1 = allcount.getNewsCount(gouwudingweicityname);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			printWriter.write(count1 + "");
			break;
		case "3":
			// 分页查询
			System.out.println(flag);
			gouwudingweicityname=request.getParameter("cityname");
			 System.out.println(gouwudingweicityname);
			int startIndex2 = Integer.parseInt(request
					.getParameter("startIndex"));
			int count2 = Integer.parseInt(request.getParameter("count"));
			System.out.println("startIndex is " + startIndex2 + ",count is "
					+ count2);
			Keepsakedao jinianpin = new Keepsakedao();
			List<Product> list2 = jinianpin.getLimitNews(startIndex2, count2,gouwudingweicityname);
			result = gson.toJson(list2);
			System.out.println(result);
			printWriter.write(result);
			break;
		case "4":
			gouwudingweicityname=request.getParameter("cityname");
			 System.out.println(gouwudingweicityname);
			AllKeepsakedao alljinianpindao = new AllKeepsakedao();
			int count4 = 0;
			try {
				count4 = alljinianpindao.getNewsCount(gouwudingweicityname);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			printWriter.write(count4 + "");
			break;
		case "5":
			// 分页查询
			gouwudingweicityname=request.getParameter("cityname");
			 System.out.println(gouwudingweicityname);
			System.out.println(flag);
			int startIndex5 = Integer.parseInt(request
					.getParameter("startIndex"));
			int count5 = Integer.parseInt(request.getParameter("count"));
			System.out.println("startIndex is " + startIndex5 + ",count is "
					+ count5);
			Culturaldao wenhuachanpindao=new Culturaldao();
			List<Product> list5 = wenhuachanpindao.getLimitNews(startIndex5, count5,gouwudingweicityname);
			result = gson.toJson(list5);
			System.out.println(result);
			printWriter.write(result);
			break;
		case "6":
			gouwudingweicityname=request.getParameter("cityname");
			 System.out.println(gouwudingweicityname);
			AllCultural wAllwenhuachanpin=new AllCultural();
			int count6 = 0;
			try {
				count6 = wAllwenhuachanpin.getNewsCount(gouwudingweicityname);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			printWriter.write(count6 + "");
			break;
		case "7":
			// 分页查询
			gouwudingweicityname=request.getParameter("cityname");
			 System.out.println(gouwudingweicityname);
			System.out.println(flag);
			int startIndex7 = Integer.parseInt(request
					.getParameter("startIndex"));
			int count7 = Integer.parseInt(request.getParameter("count"));
			System.out.println("startIndex is " + startIndex7 + ",count is "
					+ count7);
			Food meishitechan=new Food();
			List<Product> list7 = meishitechan.getLimitNews(startIndex7, count7,gouwudingweicityname);
			result = gson.toJson(list7);
			System.out.println(result);
			printWriter.write(result);
			break;	
		case "8":
			gouwudingweicityname=request.getParameter("cityname");
			 System.out.println("aa"+gouwudingweicityname);
			AllFood mAllmeishitechan=new AllFood();
			int count8 = 0;
			try {
				count8 = mAllmeishitechan.getNewsCount(gouwudingweicityname);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			printWriter.write(count8 + "");
			break;
		default:
			System.out.println("没有对应的flag");
			break;
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
