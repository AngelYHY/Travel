package productorderstateservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderstatedao.RemindIsbackProductdao;


public class RemindIsbackProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RemindIsbackProductServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter printWriter = response.getWriter();
		String result=request.getParameter("order_id");
		String buyer_message=request.getParameter("buyer_message");
		int order_id=Integer.parseInt(result);
		RemindIsbackProductdao reminds=new RemindIsbackProductdao();
		reminds.remind(order_id, buyer_message);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
