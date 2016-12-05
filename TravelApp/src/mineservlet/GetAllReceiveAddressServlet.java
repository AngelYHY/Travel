package mineservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReceiveAddress;

import com.google.gson.Gson;

import minedao.GetAllReceiveAddressdao;


public class GetAllReceiveAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetAllReceiveAddressServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		String result = "";
		String accountname=request.getParameter("accountname");
		List<ReceiveAddress> list=new ArrayList<ReceiveAddress>();
		
		GetAllReceiveAddressdao getAllReceiveAddressdao=new GetAllReceiveAddressdao();
		list=getAllReceiveAddressdao.getAllAddress(accountname);
		result = gson.toJson(list);
		
		printWriter.write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
