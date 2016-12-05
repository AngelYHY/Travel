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

import com.google.gson.Gson;

import utils.JDBCutil;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ok");
		PrintWriter out = response.getWriter();
		out.write("还不错");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("come");
		String name = request.getParameter("name");
		String passwd = request.getParameter("psw");
		PrintWriter out = response.getWriter();

		String sql1 = "select * from user where account_name='" + name + "'";
		Gson gson = new Gson();
		Connection c = null;

		PreparedStatement s = null;
		ResultSet r = null;
		c = JDBCutil.getConnection();

		try {
			s = c.prepareStatement(sql1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			r = s.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String res;
		try {
			if (r.next()) {

				String a = (String) r.getObject("password");
				if (a.equals(passwd)) {
					System.out.println("come yes");
					res = gson.toJson("yes");
					out.print(res);
				} else {
					System.out.println("come no");
					res = gson.toJson("no");
					out.print(res);
				}

			} else {
				res = gson.toJson("no");
				out.print(res);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
