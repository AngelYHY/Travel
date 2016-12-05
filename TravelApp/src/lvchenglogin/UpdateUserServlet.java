package lvchenglogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserVo userVo = new Gson().fromJson(
				request.getParameter("userVo"), UserVo.class);
		UserDao userDao = new UserDao();
		boolean flag = userDao.updateUser(userVo);
		response.getWriter().write(flag+"");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
