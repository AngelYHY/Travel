package shoppingcartservlet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingcartdao.DeleteShopCartProductdao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class DeleteShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteShoppingCartServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> list=new ArrayList<>();
		String result=request.getParameter("result");
		System.out.println(result);
		String accountname=request.getParameter("accountname");
		Type type = new TypeToken<List<String>>(){}.getType();
		Gson mGson=new Gson();
		list.addAll(mGson.fromJson(result, type));
		for(int i=0;i<list.size();i++){
			DeleteShopCartProductdao mDeleteShopCartProductdao=new DeleteShopCartProductdao();
			mDeleteShopCartProductdao.deletecart(accountname, String.valueOf(list.get(i)));		
			
		}
		
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
