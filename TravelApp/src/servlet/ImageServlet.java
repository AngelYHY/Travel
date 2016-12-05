package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Image;
import beans.ImgVo;
import dao.ImgDao;

public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");
		PrintWriter pwWriter = response.getWriter();
		ImgVo imgVo = null;
		ImgDao imgDao = new ImgDao();
		switch (flag) {
		case "insertRel":
			int relId = Integer.parseInt(request.getParameter("relId"));			       
			Image imgRel = new Gson().fromJson(request.getParameter("image")
					,Image.class);
			imgVo = new ImgVo(0, "发布", relId
					, imgRel.getUrl(), imgRel.getWidth(), imgRel.getHeight());
			imgDao.insert(imgVo);
			pwWriter.write("true");
			break;
        case "insertRec":
        	int recId = Integer.parseInt(request.getParameter("recId"));
        	Image imgRec = new Gson().fromJson(request.getParameter("image")
					,Image.class);
        	imgVo = new ImgVo(0, "推荐", recId
					, imgRec.getUrl(), imgRec.getWidth(), imgRec.getHeight());
			imgDao.insert(imgVo);
			pwWriter.write("true");
        	break;
        case "insertScenery":
        	int sceneryId = Integer.parseInt(request.getParameter("sceneryId"));
        	Image imgSce = new Gson().fromJson(request.getParameter("image")
					,Image.class);
        	imgVo = new ImgVo(0, "推荐", sceneryId
					, imgSce.getUrl(), imgSce.getWidth(), imgSce.getHeight());
			imgDao.insert(imgVo);
			pwWriter.write("true");
        	break;
		default:
			break;
		}
		pwWriter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
