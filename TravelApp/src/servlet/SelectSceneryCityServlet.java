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

import beans.SceneryCityNameVo;
import dao.SceneryCityDao;

/**
 * Servlet implementation class SelectSceneryCityServlet
 */
public class SelectSceneryCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectSceneryCityServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");//根据输入的文字查找
		System.out.println(text);
		//String text = "江苏金鸡湖";///你;好;过;上;看;见;的;恢;复;健;康;S;D;卡;很;感;慨;
		PrintWriter writer = response.getWriter();
		String result = null;
		try {
			result = doSelectSceneryCity(text);//搜索景点和城市--方法
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writer.write(result);//输出
		writer.close();
		System.out.println(result);
	}
	
	
	//搜索景点和城市--方法
	private String doSelectSceneryCity(String text) throws SQLException{
		SceneryCityDao sceneryCityDao = new SceneryCityDao();
		List<SceneryCityNameVo> listName = new ArrayList<SceneryCityNameVo>();
		
		char[] c = text.toCharArray();//将字符串转成一个个字
		StringBuffer sb = new StringBuffer();
		for(char cc:c){
			sb.append(cc+"%");
		}
		listName.addAll(sceneryCityDao.selectSceneryCity(sb.toString()));//查询出 景点，城市，图片
		Gson gson = new Gson();
		String result = gson.toJson(listName);
		return result;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
