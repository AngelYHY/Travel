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
import com.google.gson.reflect.TypeToken;

import beans.Image;
import beans.ImgVo;
import dao.FeatureJudgeDao;
import dao.ImgDao;
import multibean.FeaJudgeImageVo;
import multibean.FeatureJudge;

/**
 * Servlet implementation class FeatureJudgeServlet
 */
public class FeatureJudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FeatureJudgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		FeatureJudge judge = new Gson().fromJson(
				request.getParameter("judgeUser"), FeatureJudge.class);
		System.out.println("景点评价用户name："+judge.getJudgeName()+";sid="+judge.getSid());
		
		String flag = request.getParameter("flag");
		System.out.println("flag = "+flag);
		
		PrintWriter pWriter = response.getWriter();
		FeatureJudgeDao jDao = new FeatureJudgeDao();
		ImgDao imgDao = new ImgDao();
		switch (flag) {
		case "select":
			ArrayList<FeaJudgeImageVo> fImageVos = new ArrayList<>();
			List<FeatureJudge> fJudgeList = jDao.findFeatureJudgeUser(judge.getSid(), 0, 10);
			if (fJudgeList == null) {
				System.out.println("fJudgeList == null");
			} else {
				System.out.println("fJudgeList.size = "+fJudgeList.size());
			}
			for(FeatureJudge fJudge2:fJudgeList){
				//根据名字，查出相应评价的图片
				System.out.println("评价时，已查到评价人，查图；name = "+fJudge2.getJudgeName());
				ArrayList<Image> imgList = imgDao.selectByUserName("景点评价", fJudge2.getSceneJudgeId()
						,fJudge2.getJudgeName());
				System.out.println("景点评价图片："+imgList.size());
				fImageVos.add(new FeaJudgeImageVo(fJudge2, imgList));
			}
			System.out.println("fImageVos.size()="+fImageVos.size());
			pWriter.write(new Gson().toJson(fImageVos));
			pWriter.close();
			break;
		case "insert":
			
			jDao.insertFeatureJudge(judge);
			int id = jDao.findJudgeIdByTime(judge.getTime());
			//插入图片
			java.lang.reflect.Type type = new TypeToken<ArrayList<Image>>(){}.getType();
			ArrayList<Image> imgList = new Gson().fromJson(request.getParameter("image"), type);
		    if (imgList == null) {
				System.out.println("没有插入图片");
			} else {
				for(Image img:imgList){
					//使用的插入图片是用 多个字段的imgVo---userName
					imgDao.insertSceneJudge(new ImgVo(0, "景点评价", id
							, img.getUrl(), img.getWidth(), img.getHeight(),judge.getJudgeName()));
				}
			}
	
			pWriter.write("true");
			pWriter.close();
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
