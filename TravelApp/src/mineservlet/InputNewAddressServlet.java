package mineservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minedao.InputNewAddressdao;
import beans.ReceiveAddress;

import com.google.gson.Gson;

public class InputNewAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public InputNewAddressServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		ReceiveAddress receiveAddress;
		String result = "";
		result=request.getParameter("receiveAddress");
		receiveAddress=gson.fromJson(result,ReceiveAddress.class);
	    InputNewAddressdao inputNewAddressdao=new InputNewAddressdao();
	    inputNewAddressdao.inputnewaddress(receiveAddress);
	    
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
