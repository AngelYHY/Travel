package productorderservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderdao.InputProductOrder2dao;
import beans.ProductOrder;

import com.google.gson.Gson;


public class InputProductOrder2Servlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
  
    public InputProductOrder2Servlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		ProductOrder productOrder;
		String result = "";
		result=request.getParameter("productOrder");
		productOrder=gson.fromJson(result, ProductOrder.class);
		InputProductOrder2dao inputProductOrder2dao=new InputProductOrder2dao();
		int order_id=inputProductOrder2dao.inputproductorder(productOrder);
		printWriter.write(order_id+"");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
