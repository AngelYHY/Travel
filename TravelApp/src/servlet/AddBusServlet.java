package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.BusJsonVo;
import beans.BusVo;
import beans.SceneryListVo;
import beans.UrlAndKeyVo;
import dao.ServiceSceneryListDao;

public class AddBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //将接口的公交数据插入数据库
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		ServiceSceneryListDao sceneryListDao = new ServiceSceneryListDao();
		Gson gson = new Gson();
    	UrlAndKeyVo urlAndKeyVo = new UrlAndKeyVo();
    	SceneryListVo vo = null;
		try {
			vo = sceneryListDao.selectBySceneryTitle(title);
			//cityListVo = new ServiceCityListDao().selectOneCity(vo.getCityId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String urlBus = urlAndKeyVo.getUrlBus();
		String keyDtBus = urlAndKeyVo.getKeyDtBus();
		String httpBus = urlBus+"?key="+keyDtBus+"&city="+vo.getSid()+"&station=";
		String result = getDataCharacterSet(httpBus+title, "UTF-8");
		BusJsonVo bJsonVo = gson.fromJson(result, BusJsonVo.class);
		BusVo busVo = bJsonVo.getResult();
		busVo.getResult();
	}
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
 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
