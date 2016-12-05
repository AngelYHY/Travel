package shoporderservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import shoporderdao.DefaultAddressdao;
import beans.ReceiveAddress;


public class DefaultAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DefaultAddressServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String accountname=request.getParameter("accountname");
		List<ReceiveAddress> list=new ArrayList<ReceiveAddress>();
		Gson gson = new Gson();
		String result = "";
		DefaultAddressdao defaultAddressdao=new DefaultAddressdao();
		list=defaultAddressdao.defaultaddress(accountname);
		result = gson.toJson(list);
		printWriter.write(result);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
