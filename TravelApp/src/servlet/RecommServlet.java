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

import beans.Image;
import dao.ImgDao;
import dao.MultiTableDao;
import multibean.GoodUser;
import multibean.RecommInfoVo;
import multibean.RecommJudgeUser;
import multibean.RecommUser;

public class RecommServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RecommServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pWriter = response.getWriter();
		//获得参数
		int mLimit = Integer.parseInt(request.getParameter("mLimit"));
		int nLimit = Integer.parseInt(request.getParameter("nLimit"));
		//推荐，及其推荐者信息
		MultiTableDao tableDao = new MultiTableDao();
		List<RecommUser> lUsers = tableDao.findRecommUser(mLimit,nLimit);
		ImgDao imgDao = new ImgDao();
		List<RecommInfoVo> infoVos = new ArrayList<>();
		//查找点赞、评论、推荐的图片
		for(RecommUser user:lUsers){
			
			List<GoodUser> glist = tableDao.findGoodUser("推荐",user.getRecId());
			List<Image> imgs = imgDao.selectByKindId("推荐", user.getRecId());
			List<RecommJudgeUser> judgeUsers = tableDao.findRecommJudge(user.getRecId());
			infoVos.add(new RecommInfoVo(user, glist, imgs, judgeUsers));
		}
		System.out.println("--------这是recommservlet"+infoVos.size());
//		System.out.println("这是图片infoVos.get(0).getImages().get(0)="+infoVos.get(0).getImages().get(0));
		pWriter.write(new Gson().toJson(infoVos));
		pWriter.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
