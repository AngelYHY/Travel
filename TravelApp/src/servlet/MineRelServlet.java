package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Image;
import beans.RelComment;
import beans.RelSayContentVo;
import dao.ImgDao;
import dao.MultiTableDao;
import dao.RelCommentDao;
import multibean.GoodUser;
import multibean.ReleaseUser;

public class MineRelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MineRelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String account = request.getParameter("account");
		MultiTableDao tableDao = new MultiTableDao();
		List<ReleaseUser> list = tableDao.findRelUserByAccount(account);//找到发布及其发布者信息
		List<RelSayContentVo> list2 = new ArrayList<>();
		ImgDao imgDao = new ImgDao();
		RelCommentDao commentDao = new RelCommentDao();
		//查点赞表，评价表
		for (ReleaseUser user:list) {
			ArrayList<GoodUser> gVos = (ArrayList<GoodUser>) tableDao.findGoodUser("发布",user.getReleaseId());
			ArrayList<Image> imgs = imgDao.selectByKindId("发布", user.getReleaseId());
			ArrayList<RelComment> cList = commentDao.selectByRelId(user.getReleaseId());
			list2.add(new RelSayContentVo(user, gVos, imgs, cList));
		}
		
		response.getWriter().write(new Gson().toJson(list2));
		System.out.println("MineRelServlet:"+list2.size());
		//ReleaseUser releaseUser, ArrayList<GoodVo> goodList, ArrayList<Image> imgList,
		//ArrayList<RelComment> commentList---------我们需要的数据
		response.getWriter().close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
