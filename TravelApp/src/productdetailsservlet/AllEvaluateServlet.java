package productdetailsservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productdetailsdao.AllEvaluateCountdao;
import productdetailsdao.AllEvaluatedao;
import beans.Evaluate;

import com.google.gson.Gson;


public class AllEvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AllEvaluateServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		//Evaluate evaluate;
		String flag=request.getParameter("flag");
		String product_ids=request.getParameter("product_id");
		int product_id=Integer.parseInt(product_ids);
		switch(flag){
		case "1":
			List<Evaluate> list=new ArrayList<Evaluate>();
			String startIndex=request.getParameter("startIndex");
			String count=request.getParameter("count");
			int m=Integer.parseInt(startIndex);
			int n=Integer.parseInt(count);
			AllEvaluatedao allEvaluatedao=new AllEvaluatedao();
			list=allEvaluatedao.allevaluate(m, n, product_id);
			String result = gson.toJson(list);
			System.out.println(result);
			printWriter.write(result);
			
			
		break;
		case "2":
			AllEvaluateCountdao allEvaluateCountdao=new AllEvaluateCountdao();
		int count1=	allEvaluateCountdao.allcount(product_id);
		printWriter.write(count1 + "");
			
			break;
		
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
