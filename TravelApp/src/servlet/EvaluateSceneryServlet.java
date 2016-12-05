package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EvaluateSceneryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EvaluateSceneryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");
		switch (flag) {//插入评价
		case "insert":
			
			break;
        case "select"://查找景点评价
			
			break;
		default:
			break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
