package lvchenglogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;




public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		String account = request.getParameter("account");
		UserDao userDao = new UserDao();
		UserVo userVo = userDao.selectByAccount(account);
		response.getWriter().write(new Gson().toJson(userVo));
		
		response.getWriter().close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		UserDao userDao = new UserDao();
		UserVo userVo = userDao.selectByAccount(account);
		
		response.getWriter().write(new Gson().toJson(userVo));
		System.out.println("找账号信息post:"+userVo);
		response.getWriter().close();
	}

}
