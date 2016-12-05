package shoppingcartservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingcartdao.GetCartProductdao;
import shoppingcartdao.Inputshoppingcart;
import beans.JoinShoppingCart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class InputShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public InputShoppingCartServlet() {
        super();
      
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		List<JoinShoppingCart> list=new ArrayList<JoinShoppingCart>();
		String flag=request.getParameter("flag");
	
		switch(flag){
		case "1":
			String ShoppingCartProduct=request.getParameter("ShoppingCartProduct");
			 Type type = new TypeToken<List<JoinShoppingCart>>(){}.getType();
				Gson mGson=new Gson();
				list.addAll((Collection<? extends JoinShoppingCart>) mGson.fromJson(ShoppingCartProduct,type));
				JoinShoppingCart cart=list.get(0);
				GetCartProductdao mCartProductdao=new GetCartProductdao();
				if(mCartProductdao.getcartprodcut(cart.getAccountname(), Integer.parseInt(cart.getShopping_cart_product_id()))){
					Inputshoppingcart inputshoppingcart=new Inputshoppingcart();
					inputshoppingcart.Inputshopcart(cart.getShopping_cart_time(), cart.getShopping_cart_product_id(), cart.getShopping_cart_product_count(), cart.getAccountname());
					  
					printWriter.write("yes");
				}
				else{
					printWriter.write("no");
					
				}
				break;
			case "2":
				String ShoppingCartProduct1=request.getParameter("ShoppingCartProduct");
				 Type type1 = new TypeToken<List<JoinShoppingCart>>(){}.getType();
					Gson mGson1=new Gson();
					list.addAll((Collection<? extends JoinShoppingCart>) mGson1.fromJson(ShoppingCartProduct1,type1));
					JoinShoppingCart cart1=list.get(0);
					GetCartProductdao mCartProductdao1=new GetCartProductdao();
					if(mCartProductdao1.getcartprodcut(cart1.getAccountname(), Integer.parseInt(cart1.getShopping_cart_product_id()))){
						printWriter.write("yes");
					}
					else{
						printWriter.write("no");
					}
					break;
					default:
						break;
					
		}
		
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
