package productorderservlet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import productorderdao.IspayUpdateCartdao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class IspayUpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public IspayUpdateCartServlet() {
        super();
       
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter printWriter = response.getWriter();
		Gson mGson=new Gson();
		List<Integer> list=new ArrayList<>();
		String result = "";
		result=request.getParameter("order_id_list");
		String ispay_time=request.getParameter("ispay_time");
		 Type types = new TypeToken<List<Integer>>(){}.getType();
		list.addAll( (Collection<? extends Integer>) mGson.fromJson(result,types));
		IspayUpdateCartdao ispayUpdateCartdao=new IspayUpdateCartdao();
		ispayUpdateCartdao.ispayupdatecart(list,ispay_time);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
