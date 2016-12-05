package productorderstateservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderstatedao.InputEvaluatedao;
import beans.Evaluate;

import com.google.gson.Gson;


public class InputEvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InputEvaluateServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		Evaluate evaluate;
		String result = "";
		result=request.getParameter("evaluate");
		evaluate=gson.fromJson(result,Evaluate.class);
		InputEvaluatedao inputEvaluatedao=new InputEvaluatedao();
		inputEvaluatedao.inputevaluate(evaluate);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
