package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CollectVo;
import dao.CollectDao;

public class CollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CollectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		String kind = request.getParameter("kind");
		String kindId = request.getParameter("kindId");
		String account = request.getParameter("account");
		System.out.println("flag = "+flag +"; kind = "+kind+" ; kindId = "+kindId+" ; account = "+account);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm");
		String stime =format.format(date);
		
		CollectDao collectDao = new CollectDao();
		CollectVo collectVo = new CollectVo(kind, Integer.parseInt(kindId), stime, account);
		switch(flag){
		case "select":
			boolean isCollect = collectDao.selectByKindId(collectVo);
			System.out.println("--------------isCollect = "+isCollect);
			response.getWriter().write(isCollect+"");
			response.getWriter().close();
			break;
		case "insert":
			try {//插入数据库
				collectDao.insertColect(collectVo);
				response.getWriter().write("true");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
		    if (collectDao.selectByKindId(collectVo)) {//为true，则删除
		    	collectDao.deleteColect(collectVo);
				response.getWriter().write("true");
			} else {
				response.getWriter().write("该收藏不存在");
			}
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
