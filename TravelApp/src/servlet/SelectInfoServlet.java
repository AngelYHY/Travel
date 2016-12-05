package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.SceneryListVo;
import beans.UrlAndKeyVo;
import dao.ServiceSceneryListDao;

public class SelectInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String flag = request.getParameter("flag");//是flag不是sid！！
		String title = request.getParameter("title");// 景点标题--查表得景点id
		System.out.println("接收的title"+title);
		ServiceSceneryListDao sceneryListDao = new ServiceSceneryListDao();
		SceneryListVo vo = null;
		try {
			vo = sceneryListDao.selectBySceneryTitle(title);
		    
			if (vo == null ) {
				System.out.println("SelectInfoServlet查出的SceneryListVo为null-------------------");
				return;
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UrlAndKeyVo urlKey = new UrlAndKeyVo();
		String key = urlKey.getKey();
		switch(flag){
		case "findSid":
			System.out.println("我们要的数据vo"+vo.getSid());
        	Gson gson = new Gson();
        	response.getWriter().write(gson.toJson(vo));
        	response.getWriter().close();
			break;
		case "info":
			// 网络请求
        	System.out.println("网络请求");
    		String httpInfo = urlKey.getUrlInfo() + "?sid=" + vo.getSid() + "&key=" + key;
    		String result = getDataCharacterSet(httpInfo, "UTF-8");
    		response.getWriter().write(result);
    		response.getWriter().close();
    		System.out.println(result);
			break;
		case "info2":
			// 网络请求
			int sid = Integer.parseInt(request.getParameter("sid"));
        	System.out.println("网络请求2");
    		String httpInfo2 = urlKey.getUrlInfo() + "?sid=" + sid + "&key=" + key;
    		String result2 = getDataCharacterSet(httpInfo2, "UTF-8");
    		response.getWriter().write(result2);
    		response.getWriter().close();
    		System.out.println(result2);
			break;
		case "SceneryList":
			String mfirst = request.getParameter("mfirst");
			String nNum = request.getParameter("nNum");
			List<SceneryListVo> list = new ArrayList<>();
			try {
				list.addAll(sceneryListDao.selectPartBySid(vo.getSid()
						, Integer.parseInt(mfirst), Integer.parseInt(nNum)));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Gson gsonlist = new Gson();
			response.getWriter().write(gsonlist.toJson(list));
			response.getWriter().close();
			break;
			default:
				break;
		/*case "Ticket"://请求需参数flag，title----在cityBusTrafficServlet写了更具体合理的
			String urlTicket = urlKey.getUrlTicket();
			String httpTicket = urlTicket+"?sid="+vo.getSid()+"&key="+key;
			String resultTicket = getDataCharacterSet(httpTicket, "UTF-8");
    		response.getWriter().write(resultTicket);
    		System.out.println("resultTicket = "+resultTicket);
			break;*/
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// --------方法getDataCharacterSet()----接口请求，获得数据
	public String getDataCharacterSet(String url, String characterset) {
		String resData = null;
		StringBuffer s = new StringBuffer();
		BufferedReader bReader = null;// -----输入流
		URL urlWeb;

		try {
			urlWeb = new URL(url);
			URLConnection conn = urlWeb.openConnection();
			bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), characterset));
			while (null != (resData = bReader.readLine())) {
				s.append(resData);
			}
			bReader.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s.toString();// -----返回字符串
	}

}
