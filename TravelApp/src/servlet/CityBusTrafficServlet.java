package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import beans.BusJsonVo;
import beans.CityListVo;
import beans.SceneryListVo;
import beans.TicketJsonVo;
import beans.TicketVo;
import beans.TrafficJsonVo;
import beans.TrafficVo;
import beans.UrlAndKeyVo;
import dao.ServiceCityListDao;
import dao.ServiceSceneryListDao;

public class CityBusTrafficServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CityBusTrafficServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Gson gson = new Gson();
    	UrlAndKeyVo urlAndKeyVo = new UrlAndKeyVo();
    	PrintWriter writer = response.getWriter();
    	String flag = request.getParameter("flag");
    	String title = request.getParameter("title");// 景点标题--查表得景点id
		ServiceSceneryListDao sceneryListDao = new ServiceSceneryListDao();
		SceneryListVo vo = null;
		CityListVo cityListVo = null;
		try {
			vo = sceneryListDao.selectBySceneryTitle(title);
			cityListVo = new ServiceCityListDao().selectOneCity(vo.getCityId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String realTitle = title.replace(cityListVo.getCityName(), "").replaceAll("市", "");
    	switch (flag) {
		case "CityBus":
			String urlBus = urlAndKeyVo.getUrlBus();
			String keyDtBus = urlAndKeyVo.getKeyDtBus();
			String httpBus = urlBus+"?key="+keyDtBus+"&city="+vo.getSid()+"&station=";
			String result = getDataCharacterSet(httpBus+title, "UTF-8");
			BusJsonVo bJsonVo = gson.fromJson(result, BusJsonVo.class);
			if ("0".equals(bJsonVo.getError_code())) {
				writer.write(gson.toJson(bJsonVo));
			} else {//说明站点title不对，要修改
				String title2 = title.replaceAll(cityListVo.getCityName(), "").replaceAll("市", "");//将title里面包含的城市名去掉
				String result2 = getDataCharacterSet(httpBus+title2, "UTF-8");
				BusJsonVo bJsonVo2 = gson.fromJson(result2, BusJsonVo.class);
				if ("0".equals(bJsonVo2.getError_code())) {
					writer.write(gson.toJson(bJsonVo2));
					System.out.println("公交bJsonVo2:"+gson.toJson(bJsonVo2));
				} else {
					String[] title3 = title2.split("(");
					String result3 = getDataCharacterSet(httpBus+title3[0], "UTF-8");
					BusJsonVo bJsonVo3 = gson.fromJson(result3, BusJsonVo.class);
					if ("0".equals(bJsonVo3.getError_code())) {
						writer.write(gson.toJson(bJsonVo3));
						System.out.println("公交bJsonVo3:"+gson.toJson(bJsonVo3));
					} else {
						String title4 = title3[1].replace(title3[1], ")");
						String result4 = getDataCharacterSet(httpBus+title4, "UTF-8");
						BusJsonVo bJsonVo4 = gson.fromJson(result4, BusJsonVo.class);
						if ("0".equals(bJsonVo4.getError_code())) {
							writer.write(gson.toJson(bJsonVo4));
							System.out.println("公交bJsonVo4:"+gson.toJson(bJsonVo4));
						} else {
							writer.write("暂无公交信息\n");
							writer.write("62路(仕泰隆工业博览城-商贸城);62路(商贸城-仕泰隆工业博览城);\n65路(京沪高速(楚州出口)-新城公交停保厂);65路(京沪高速收费站-淮安国际商城);65路(新城公交停保厂-京沪高速(楚州出口));65路(淮安国际商城-京沪高速收费站);\n游1路(汽车东站-汽车南站);"
							+ "游1路(汽车南站-汽车东站);游1路(淮安汽车东站-淮安汽车南站);游1路(淮安汽车南站-淮安汽车东站)");
						}
					}
				}
			}
			writer.close();
			break;
        case "CityTraffic":
			String urlTraffic = urlAndKeyVo.getUrlTraffic();
			String keyDtTraffic = urlAndKeyVo.getKeyDtTraffic();
			String httpTraffic = urlTraffic+"?key="+keyDtTraffic+"&location="+vo.getSid();
			String resultTraffic = getDataCharacterSet(httpTraffic, "UTF-8");
			TrafficJsonVo tJsonVo = gson.fromJson(resultTraffic, TrafficJsonVo.class);
			List<TrafficVo> list = new ArrayList<>();
			if (tJsonVo != null) {
				if (tJsonVo.getResult()!=null) {
					for(TrafficVo a:tJsonVo.getResult()){
						if (a != null &&a.getDescription().contains(realTitle)) {
							list.add(a);
							System.out.println("CityTraffic，list.add(a);数据不为空");
						}
					}
				}
			} else {
				System.out.println("CityTraffic，list.add(a);数据-----为空");
			}
			
			if (list != null) {
				writer.write(gson.toJson(list));
				System.out.println("交通数据："+gson.toJson(list));
			}
		    writer.close();
			break;
        case "Ticket":
        	String urlTicket = urlAndKeyVo.getUrlTicket();
        	String keyTicket = urlAndKeyVo.getKey();//haoService的景点门票信息
        	String httpTicket = urlTicket+"?sid="+vo.getSid()+"&key="+keyTicket;
        	String resultTicket = getDataCharacterSet(httpTicket, "UTF-8");
        	TicketJsonVo ticketJsonVo = gson.fromJson(resultTicket, TicketJsonVo.class);
        	if (ticketJsonVo != null) {
        		System.out.println("ticketJsonVo不为空");
        		List<TicketVo> list2 = ticketJsonVo.getResult();
            	for(int i = 1 ;i<list2.size(); i++){
            		if (list2.get(i-1).getName() == list2.get(i).getName()) {//标题相同
    					if (Float.parseFloat(list2.get(i-1).getPrice())
    							>Float.parseFloat(list2.get(i).getPrice())) {
    						list2.remove(list2.get(i-1).getPrice());//取价格最大的
    					} else {
    						list2.remove(list2.get(i).getPrice());
    					}
    				}
            	}
            	writer.write(gson.toJson(list2));
            	System.out.println("门票数据："+gson.toJson(list2));
			} else {
				String string = "暂无数据\n南京海底世界成人票年卡,price=390;"
						+ "南京海底世界成人票(周五-周日，夜场票：18:00-20:30),price=100;"
						+ "南京海底世界儿童票,price=95;"
						+ "游南京海底世界,住南京金丝利喜来登酒店1晚，距汉中门地铁站约400米【江苏精品汇】,price=818;"
						+ "游南京海底世界,住南京国际会议大酒店1晚（至景区步行约3分钟）,price=708;"
						+ "住南京钟山宾馆(江苏省会议中心)1晚，位于中山陵景区，（自选加购）南京海底世界/明孝陵,price=600";
				writer.write(string);
			}
        	writer.close();
        	break;
		default:
			break;
		}
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
 	
 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
