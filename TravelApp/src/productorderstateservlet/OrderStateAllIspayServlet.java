package productorderstateservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderstatedao.GetAllisPayProductOrderdao;
import productorderstatedao.GetIspayAddressdao;
import productorderstatedao.GetIspayProductdao;
import beans.Product;
import beans.ProductOrder;
import beans.ProductOrderState;
import beans.ReceiveAddress;

import com.google.gson.Gson;


public class OrderStateAllIspayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public OrderStateAllIspayServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		List<ProductOrderState> list1=new ArrayList<ProductOrderState>();
		List<ProductOrder> list2=new ArrayList<ProductOrder>();
//		根据用户名先查出商品的订单的一些信息，有多少订单，放到订单的集合中，然后根据提单集合中的商品Id,和收货地址的id，
//		来获取一些商品的具体信息和收货地址的一些具体信息
		String accountname=request.getParameter("accountname");
		
		GetAllisPayProductOrderdao getAllisPayProductOrderdao=new GetAllisPayProductOrderdao();
//		先获得订单的一些信息
		list2=getAllisPayProductOrderdao.getallispayproductorder(accountname);

//		用一个for循环，遍历其中,根据订单中商品id去查商品的一些具体情况，和收货地址的一些具体地址
		for(int i=0;i<list2.size();i++){
			int order_id=list2.get(i).getOrder_id();
		  int product_id=list2.get(i).getProduct_id();
		  int receive_id=list2.get(i).getReceive_id();
		  int product_count=list2.get(i).getProduct_count();
		  String account_name=list2.get(i).getAccount_name();
		  String order_time=list2.get(i).getOrder_time();
		  String buyer_message=list2.get(i).getBuyer_message();
		  GetIspayProductdao getIspayProduct=new GetIspayProductdao();
		  
		  List<Product> list3=new ArrayList<Product>();
		 list3=getIspayProduct.getIspayProduct(product_id);
		String product_name=list3.get(0).getProductName();
		String product_price=String.valueOf(list3.get(0).getProductPrice());
		String product_picture1=list3.get(0).getProductPicture1();
		
		List<ReceiveAddress> list4=new ArrayList<ReceiveAddress>();
		GetIspayAddressdao getIspayAddressdao=new GetIspayAddressdao();
		list4=getIspayAddressdao.getispayaddress(receive_id);
		String name=list4.get(0).getName();
		String phone_num=list4.get(0).getPhone_num();
		String province=list4.get(0).getProvince();
		String city=list4.get(0).getCity();
		String detailed_addr=list4.get(0).getDetailed_addr();
		
		ProductOrderState bean=new ProductOrderState(name, phone_num, detailed_addr, province, city, product_price, product_picture1, product_name, null, buyer_message, null, 0, null, 0, null,0,null,0, order_time, account_name, product_id, product_count, receive_id, order_id);
		list1.add(bean);
		
		
		}
		String result1=gson.toJson(list1);
		
		printWriter.write(result1);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
