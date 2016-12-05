package lvchenglogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpDatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpDatePasswordServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter printWriter = response.getWriter();
		String accountname=request.getParameter("name");
		String passwd=request.getParameter("password");
		UpdatePassworddao updatePassworddao=new UpdatePassworddao();
		updatePassworddao.updatepassworddao(accountname, passwd);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
