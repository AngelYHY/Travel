package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.GoodVo;
import dao.GoodDao;

public class GoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String flag = request.getParameter("flag");
    	String kind = request.getParameter("kind");
    	String kindId = request.getParameter("kindId");
    	String account = request.getParameter("account");
    	GoodDao goodDao = new GoodDao();
    	switch (flag) {
		case "selectNum":
			ArrayList<GoodVo> goodVoList = goodDao.selectPartByKindId(kind, Integer.parseInt(kindId));
			if (goodVoList == null || goodVoList.size()==0) {
				response.getWriter().write("0");
			} else {
				response.getWriter().write(goodVoList.size()+"");
			}
			response.getWriter().close();
			break;
		case "insert":
			GoodVo goodVo = goodDao.selectOneByAccount(kind, Integer.parseInt(kindId),account);
			if (goodVo == null) {
				goodDao.insertDood(kind, Integer.parseInt(kindId),account);
				response.getWriter().write("true");
			} else {
				response.getWriter().write("false");
			}
			response.getWriter().close();
			break;
		case "delete":
			goodDao.deleteDood(kind, Integer.parseInt(kindId),account);
			response.getWriter().write("true");
			response.getWriter().close();
			break;
		case "isHas":
			GoodVo goodVo2 = goodDao.selectOneByAccount(kind, Integer.parseInt(kindId),account);
			if (goodVo2 == null) {
				response.getWriter().write("false");//不存在
			} else {
				response.getWriter().write("true");//存在
			}
			response.getWriter().close();
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
