package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.RecommendedVo;
import beans.ReleaseVo;
import dao.RecommDao;
import dao.ReleaseDao;

public class UserRelRecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRelRecServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //用户进行发布、推荐的内容，插入数据库
	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter printWriter = response.getWriter();
		String flag = request.getParameter("flag");
		switch (flag) {//图片另外插入
		case "release"://进行发布插入
			String rel = request.getParameter("releaseVo");
			ReleaseVo rVo = new Gson().fromJson(rel, ReleaseVo.class);
			ReleaseDao rDao = new ReleaseDao();
			rDao.insertRel(rVo);
			ReleaseVo resultVo = rDao.selectByUserTime
					(rVo.getRelAccount(), rVo.getRelTime());
			printWriter.write(new Gson().toJson(resultVo));
			break;
		case "recomm"://推荐插入
			String rec = request.getParameter("recommend");
			RecommendedVo rVo2 = new Gson().fromJson(rec, RecommendedVo.class);
			RecommDao recommDao = new RecommDao();
			recommDao.intsertRecomm(rVo2);
			RecommendedVo recommendedVo = recommDao.selectByUserTime
					(rVo2.getAccount(), rVo2.getRecTime());
			printWriter.write(new Gson().toJson(recommendedVo));
			break;
		case "relCount":
			ReleaseDao releaseDao = new ReleaseDao();
			int count = releaseDao.selectCount();
			printWriter.write(count+"");
			break;
		case "recCount":
			RecommDao recommDao2 = new RecommDao();
			int count2 = recommDao2.recommCount();
			printWriter.write(count2+"");
			break;
		default:
			break;
		}
		printWriter.close();
	}

	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
