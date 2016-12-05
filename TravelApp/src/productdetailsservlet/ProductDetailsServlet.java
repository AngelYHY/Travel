package productdetailsservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productdetailsdao.ProductDetailsdao;
import beans.ProductShop;

import com.google.gson.Gson;

public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductDetailsServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		ProductShop productShop;
		String product_ids=request.getParameter("product_id");
		int product_id=Integer.parseInt(product_ids);
		ProductDetailsdao productDetailsdao=new ProductDetailsdao();
		productShop=productDetailsdao.productdetails(product_id);
		
		String result=gson.toJson(productShop);
		printWriter.write(result);
		System.out.println(result);
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
