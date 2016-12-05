package mineservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minedao.DeleteAddressdao;
import beans.ReceiveAddress;

import com.google.gson.Gson;


public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteAddressServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		ReceiveAddress receiveAddress;
		String result = "";
		result=request.getParameter("receiveAddress");
		receiveAddress=gson.fromJson(result,ReceiveAddress.class);
		DeleteAddressdao deleteAddressdao=new DeleteAddressdao();
		deleteAddressdao.deleteaddress(receiveAddress);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
