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

import beans.BannerSceneVo;
import beans.Image;
import dao.BannerSceneDao;
import dao.ImgDao;
import multibean.SceneImgVo;

public class BannerSceneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BannerSceneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		int m = Integer.getInteger(request.getParameter("m"));
//		int n = Integer.getInteger(request.getParameter("n"));
		int m = 0;
		int n = 4;
		PrintWriter pWriter = response.getWriter();
		BannerSceneDao sceneDao = new BannerSceneDao();
		ImgDao imgDao = new ImgDao();
		List<SceneImgVo> sceneImgVos = new ArrayList<>();
		List<BannerSceneVo> sceneVos = sceneDao.findPartScene(m, n);
		for(BannerSceneVo sceneVo :sceneVos){
			ArrayList<Image> imgList= imgDao.selectByKindId("轮播景点", sceneVo.getId());
			System.out.println("轮播景点图片size = "+imgList.size()+";id = "+sceneVo.getId());
			sceneImgVos.add(new SceneImgVo(sceneVo, imgList));
		}
		System.out.println("轮播景点，size = "+sceneImgVos.size());
		pWriter.write(new Gson().toJson(sceneImgVos));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
