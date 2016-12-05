package productorderservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderdao.InputProductOrderdao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import beans.ProductOrder;


public class InputProductOrderServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
  
    public InputProductOrderServlet() {
        super();
       
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		Gson mGson=new Gson();
//		定义一个订单id的集合
		List<Integer> list=new ArrayList<Integer>();
//		订单的集合
		List<ProductOrder> olist=new ArrayList<ProductOrder>();
//		从购物车里商品的购物车Id
		List<Integer> cartlist=new ArrayList<>();
		String result=request.getParameter("olist");
		String results=request.getParameter("cartlist");
		 Type type = new TypeToken<List<ProductOrder>>(){}.getType();
		 Type types = new TypeToken<List<Integer>>(){}.getType();
		olist.addAll((Collection<? extends ProductOrder>) mGson.fromJson(result,type));
		cartlist.addAll( mGson.fromJson(results,types));
		
		InputProductOrderdao inputProductOrderdao=new InputProductOrderdao();
		list=inputProductOrderdao.inputproductorder(olist, cartlist);
		String order_id_list=mGson.toJson(list);
		printWriter.write(order_id_list);
		System.out.println(order_id_list+"qq");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
