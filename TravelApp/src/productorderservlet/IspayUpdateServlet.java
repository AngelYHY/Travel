package productorderservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderdao.IsplayUpdatedao;

public class IspayUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public IspayUpdateServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter printWriter = response.getWriter();
		String result = "";
		result=request.getParameter("order_id");
		String ispay_time=request.getParameter("ispay_time");
		int order_id=Integer.parseInt(result);
		IsplayUpdatedao isplayUpdatedao=new IsplayUpdatedao();
		isplayUpdatedao.isplayupdate(order_id,ispay_time);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
