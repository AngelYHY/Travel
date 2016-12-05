package mineservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minedao.ModifyAddressdao;
import beans.ReceiveAddress;

import com.google.gson.Gson;


public class ModifyAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModifyAddressServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		ReceiveAddress receiveAddress;
		String result = "";
		result=request.getParameter("receiveAddress");
		receiveAddress=gson.fromJson(result,ReceiveAddress.class);

		ModifyAddressdao modifyAddressdao=new ModifyAddressdao();
		modifyAddressdao.modifyaddress(receiveAddress);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
