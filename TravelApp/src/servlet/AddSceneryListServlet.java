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

import beans.CityListVo;
import beans.ResultJsonVo2;
import beans.SceneryListVo;
import beans.UrlAndKeyVo;
import dao.ServiceCityListDao;
import dao.ServiceSceneryListDao;

/**添加江苏省景点名，景点id等数据完成
 * Servlet implementation class AddSceneryListServlet
 */
public class AddSceneryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSceneryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //---------?pid=2&cid=45&page=1&key=您申请的APPKEY-----需要4个参数
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		
		//----查询pid，和cid---
		ServiceCityListDao cityDao = new ServiceCityListDao();
		List<CityListVo> list = null ;
		try {
			list = cityDao.selectCity(16);//这里直接使用pid=16查询江苏省，			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		UrlAndKeyVo urlKey = new UrlAndKeyVo();
		Gson gson = new Gson();
		String key = urlKey.getKey();
		//------list中的第一条语句不是我们需要的（第一条是省份不是城市）因此i=1
		for(int i = 1 ; i < list.size() ; i++){//--江苏所有城市list---i=1
			int cid = list.get(i).getCityId();//4南京，6苏州，9无锡
			//-----先用page=1（完成），之后再用page=2,3,4（4页就只有南京、苏州、无锡还有景点，无锡只有5页）
			String httpUrlScenery = urlKey.getUrlScenery()+"?pid=16"+"&cid="+cid+"&page=6&key="+key;
			String result = getDataCharacterSet(httpUrlScenery, "UTF-8");
			ResultJsonVo2 resultJsonVo2 = gson.fromJson(result, ResultJsonVo2.class);
			if("0".equals(resultJsonVo2.getError_code())){
				ArrayList<SceneryListVo> arrayList = resultJsonVo2.getArrayList();
				ServiceSceneryListDao sceneryDao = new ServiceSceneryListDao();
				for(SceneryListVo sVo:arrayList){
					try {
						
						sceneryDao.addScenery(sVo);//--数据插入数据库的--景点列表
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			response.getWriter().write(result);//-----每个城市景点第一页
		}
		
		
		
	}

	//--------方法getDataCharacterSet()----接口请求，获得数据
	public String getDataCharacterSet(String url,String characterset){
		String resData  = null;
		StringBuffer s = new StringBuffer();
		BufferedReader bReader = null;//-----输入流
		URL urlWeb;
	
		try {
			urlWeb = new URL(url);
			URLConnection conn = urlWeb.openConnection();
			bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),characterset));
			while(null != (resData = bReader.readLine())){
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
		
		return s.toString();//-----返回字符串
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
