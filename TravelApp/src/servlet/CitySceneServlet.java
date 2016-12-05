package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.CitySceneVo;
import dao.CitySceneDao;

public class CitySceneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CitySceneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String flag = request.getParameter("flag");
		CitySceneDao citySceneDao = new CitySceneDao();
		PrintWriter pWriter = response.getWriter();
		switch (flag) {
		case "select":
			String cityName = request.getParameter("cityName");
			List<CitySceneVo> list = new ArrayList<>();
			list.addAll(citySceneDao.findByCityName(cityName));
			System.out.println("城市景点攻略数据,时间"+list.get(0).getTime1());
			pWriter.write(new Gson().toJson(list));
			break;
        case "insert":
        	CitySceneVo vo = new Gson().fromJson(request.getParameter("CitySceneVo")
        			, CitySceneVo.class);
        	citySceneDao.insertCityScene(vo);
        	break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
