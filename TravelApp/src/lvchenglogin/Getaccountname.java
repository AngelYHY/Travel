package lvchenglogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JDBCutil;


public class Getaccountname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Getaccountname() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String phone=request.getParameter("phone");
		String sql1="select account_name from user where phone_num='"+phone+"'";
		Connection c=null;

		PreparedStatement s=null;
		ResultSet r=null;
		c=JDBCutil.getConnection();
		try {
			s=c.prepareStatement(sql1);
			r = s.executeQuery();
			if(r.next()){
				String name=r.getString(1);
				out.print(name);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				s.close();
				
				JDBCutil.releaseConnection(c);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
