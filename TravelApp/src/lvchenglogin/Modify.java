package lvchenglogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JDBCutil;

public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Modify() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String passwd=request.getParameter("passwd");
		String phone=request.getParameter("phone");
		PrintWriter out=response.getWriter();
		
		
		
		String sql="update user set password=? where phone_num=? ";
	
		
		
		
		
		

		Connection c=null;

		PreparedStatement s=null;
	//	ResultSet r=null;
		c=JDBCutil.getConnection();

		
		

		
		
		
// �����޸�
		try{
			s=c.prepareStatement(sql);
			
			s.setObject(1, passwd);
			s.setObject(2, phone);
		s.executeUpdate();	
		out.print("yes");
		
		}catch(Exception e){
			out.print("nophone");
            return;
		}
		
		
		try {
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCutil.releaseConnection(c);
		}
		
		
		
		
		
		
		
		
	
		
		
		
	}
		
		
		
		
	

}
