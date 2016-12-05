package productorderstateservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderstatedao.IsReceivedao;


public class IsReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public IsReceiveServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result=request.getParameter("order_id");
		int order_id=Integer.parseInt(result);
		String receive_time=request.getParameter("receive_time");
	IsReceivedao isReceivedao=new IsReceivedao();
	isReceivedao.isreceive(order_id, receive_time);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
