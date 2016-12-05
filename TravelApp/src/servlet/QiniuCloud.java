package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiniu.util.Auth;

import utils.QiniuCloudFactory;


/**
 * Servlet implementation class QiniuCloud
 */
public class QiniuCloud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QiniuCloud() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String bucketname = new String(request.getParameter("bucketname").getBytes(
				"iso-8859-1"), "utf-8");

		PrintWriter out = response.getWriter();

		if (!bucketname.isEmpty()) {
			
			out.print(getUpToken(bucketname));
			
			System.out.println("Token:"+getUpToken(bucketname));
		} else {
			out.print("fail");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String target = request.getParameter("target");
		PrintWriter out = response.getWriter();

		QiniuCloudFactory.Download util = new QiniuCloudFactory.Download();
		String url = util.download(target);

		out.print(url);
		System.out.println(target + "\n" + url);
	}

	// token
	public String getUpToken(String bucketname) {
		Auth auth = QiniuCloudFactory.getAuth();
		return auth.uploadToken(bucketname);
	}

}
