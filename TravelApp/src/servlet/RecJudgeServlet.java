package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.RecommJudgeDao;
import multibean.RecommJudgeUser;

/**
 * Servlet implementation class RecJudgeServlet
 */
public class RecJudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RecJudgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String s = request.getParameter("judgeUser");
		System.out.println(s);
		
		RecommJudgeUser jUser = new Gson().fromJson(s, RecommJudgeUser.class);
		RecommJudgeDao judgeDao = new RecommJudgeDao();
		judgeDao.insertJudge(jUser);
		System.out.println("评论："+jUser.getJudgeContent());
		response.getWriter().write("true");
		response.getWriter().close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
