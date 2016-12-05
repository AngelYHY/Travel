package lvchenglogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowUserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		String accountname=request.getParameter("accountname");
		UserVo user;
		ShowUserdao showUserdao=new ShowUserdao();
		user=showUserdao.showuser(accountname);
		String result=gson.toJson(user);
		printWriter.write(result);
		System.out.println(result);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
