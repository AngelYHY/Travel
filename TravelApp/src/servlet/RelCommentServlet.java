package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.RelComment;
import dao.RelCommentDao;
import dao.UserDao;

/**
 * Servlet implementation class RelCommentServlet
 */
public class RelCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RelCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String flag = request.getParameter("flag");
    	int relId = Integer.parseInt(request.getParameter("releaseId"));
    	
    	RelCommentDao relCommentDao = new RelCommentDao();
    	switch (flag) {
		case "insertParent"://插入父评价
			//0--id自增不用填；0--没有父级评论；0--是否有子评论（没有,1为有）===这个对象用的构造方法参数较少
			String account = request.getParameter("account");
	    	String content = request.getParameter("content");
	    	String time = request.getParameter("time");
			RelComment relCommentLess = new RelComment(0, relId, account, time, content, null);
			relCommentDao.insertComment(relCommentLess);
			response.getWriter().write("true");
			response.getWriter().close();
			break;
		case "insertChild"://插入子评论
			String account2 = request.getParameter("account");
	    	String content2 = request.getParameter("content");
	    	String time2 = request.getParameter("time");
			//int parentRelId = Integer.parseInt(request.getParameter("pCommentId"));
	    	String pName = request.getParameter("AspName");
			RelComment relCommentLess2 = new RelComment(0, relId, account2, time2, content2,pName);
			relCommentDao.insertComment(relCommentLess2);
			response.getWriter().write("true");
			response.getWriter().close();
			break;
		case "selectRelId"://根据发布的id查找，
			ArrayList<RelComment> rcList = relCommentDao.selectByRelId(relId);
			UserDao userDao = new UserDao();
			for(RelComment rc:rcList){
				RelComment needRelCom;
				String commentName = userDao.selectByAccount(rc.getAccount()).getUserName();
				//int relCommentId, int releaseId, String account
	            //, String commentTime, String content,String pName
				needRelCom = new RelComment(rc.getRelCommentId(), rc.getReleaseId()
						, rc.getAccount(), commentName
						, rc.getCommentTime(), rc.getContent(), rc.getpName());	
				rcList.add(needRelCom);
			}
			
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(rcList));//我们所需要的RelComment，参数多一个
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
