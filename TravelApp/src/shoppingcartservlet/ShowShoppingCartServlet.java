package shoppingcartservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingcartdao.AccountNameGetShopCartdao;
import shoppingcartdao.GetAllShopCartProduct;
import shoppingcartdao.GetShowShopCartProductdao;
import beans.JoinShoppingCart2;
import beans.Product;
import beans.ShowShoppingCart;

import com.google.gson.Gson;


public class ShowShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowShoppingCartServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		String result = "";
		String accountname="";
		String flag = request.getParameter("flag");
	switch (flag){
	case "1":
		accountname=request.getParameter("accountname");
		int startIndex = Integer.parseInt(request.getParameter("startIndex"));
		int count=Integer.parseInt(request.getParameter("count"));
		
	AccountNameGetShopCartdao accountNameGetShopCartdao=new AccountNameGetShopCartdao();
//	根据用户名和一次加载的购物车物品的数量返回得到购物车的商品
	List<JoinShoppingCart2> list1=new ArrayList<JoinShoppingCart2>();
	list1=accountNameGetShopCartdao.getShopCart(startIndex, count, accountname);
//	显示商品的第一张照片，和商品名称和商品价格
	List<Product> list2=new ArrayList<Product>();
//	list3为整个显示界面需要的数据的集合
	List<ShowShoppingCart> list3=new ArrayList<ShowShoppingCart>();
	for(int i=0;i<list1.size();i++){
		int productId=list1.get(i).getShopping_cart_product_id();
		String accountName=list1.get(i).getAccountname();
		String shopCartTime=list1.get(i).getShopping_cart_time();
		String shopCartId=String.valueOf(list1.get(i).getShopping_cart_id());
		String productCount=String.valueOf(list1.get(i).getShopping_cart_product_count());
//		再来根据商品的ID来获得商品的的第一张照片，和商品名称和商品价格
		GetShowShopCartProductdao getShowShopCartProductdao=new GetShowShopCartProductdao();
		System.out.println("qq"+productId);
		list2=getShowShopCartProductdao.getShowShopCartProduct(productId);
		if(list2!=null){
		String picture1=list2.get(0).getProductPicture1();
		String productName=list2.get(0).getProductName();
		float ProductPrice=list2.get(0).getProductPrice();
		int productStock=list2.get(0).getProductStock();
		ShowShoppingCart bean=new ShowShoppingCart(shopCartId, String.valueOf(productId), picture1, productName, String.valueOf(ProductPrice), String.valueOf(productStock), productCount, accountName, shopCartTime);
	list3.add(bean);}
		else{
		continue;
	}
	}
	
	result = gson.toJson(list3);
	System.out.println(result);
	printWriter.write(result);
		
		break;
		case "2":
//			查询该用户购物车里面所有的物品的总量
			accountname=request.getParameter("accountname");
		
			GetAllShopCartProduct getAllShopCartProduct=new GetAllShopCartProduct();
			int count1=0;
			count1=getAllShopCartProduct.getShopCartCount(accountname);
			printWriter.write(count1 + "");
		System.out.println(count1);
			break;
	
	
	
	}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
