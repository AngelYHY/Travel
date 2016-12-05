package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.CityListVo;
import beans.ResultJsonVo;
import beans.UrlAndKeyVo;
import dao.ServiceCityListDao;

/**
 * Servlet implementation class CityListServlet
 */
public class AddCityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddCityListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UrlAndKeyVo urlKey = new UrlAndKeyVo();
		String httpUrl = urlKey.getUrl()+"?key="+urlKey.getKey();
		String result = getDataCharaterSet(httpUrl,"UTF-8");//----从接口地址获得数据--方法
		
		Gson gson = new Gson();
		
		ResultJsonVo resultJsonVo = gson.fromJson(result,ResultJsonVo.class);
		System.out.println(resultJsonVo.getError_code());
		
		if("0".equals(resultJsonVo.getError_code())){
			ArrayList<CityListVo> arrayList = resultJsonVo.getArrayList();
			
			System.out.println(arrayList.get(0));
			
			ServiceCityListDao cityDao = new ServiceCityListDao();
			for(CityListVo c:arrayList){
				try {
					cityDao.addCity(c);//--------添加到数据库，ServiceCityListDao操作里面的方法
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		response.getWriter().write(result);
	}

	//--------方法getDataCharaterSet()
	 public String getDataCharaterSet(String url, String charaterset) {
	        
		    String resData = null;
	        StringBuffer s = new StringBuffer();
	        BufferedReader bReader = null;
	      
	            URL urlWeb;
				try {
					urlWeb = new URL(url);
					URLConnection connection = urlWeb.openConnection();
		            
					bReader = new BufferedReader(new InputStreamReader(
		                    connection.getInputStream(), charaterset));
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
	        return s.toString();
	    }
	 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
