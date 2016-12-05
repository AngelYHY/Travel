package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SceneryCityDao;

public class FindCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindCityServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cityId = request.getParameter("cityId");
		SceneryCityDao cityDao = new SceneryCityDao();
		String cityName = cityDao.findCityById(Integer.parseInt(cityId));
		response.getWriter().write(cityName);
		response.getWriter().close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
