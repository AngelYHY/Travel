package productorderstateservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderstatedao.UpdateIsEvaluatedao;


public class UpdateIsEvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateIsEvaluateServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String evaluate_time=request.getParameter("evaluate_time");
		String order_ids=request.getParameter("order_id");
		int order_id=Integer.parseInt(order_ids);
		UpdateIsEvaluatedao updateIsEvaluatedao=new UpdateIsEvaluatedao();
		updateIsEvaluatedao.updateisevaluate(evaluate_time, order_id);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
