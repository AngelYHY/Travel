package productorderstateservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderstatedao.DeleteOrderIspaydao;


public class DeleteOrderIspayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteOrderIspayServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result=request.getParameter("order_id");
		String results=request.getParameter("product_count");
		String resultss=request.getParameter("product_id");
		int product_count=Integer.parseInt(results);
		int order_id=Integer.parseInt(result);
		int product_id=Integer.parseInt(resultss);
		DeleteOrderIspaydao deleteOrderIspaydao=new DeleteOrderIspaydao();
		deleteOrderIspaydao.deleteorderispay(order_id, product_count, product_id);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
