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

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ok");
		PrintWriter out = response.getWriter();
		out.write("好像真的进来了");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String phone = request.getParameter("phone");
		PrintWriter out = response.getWriter();

		String sql = "insert into user(account_name,password,phone_num,head_picture_addr) values(?,?,?,?)";
		String sql1 = "select * from user where account_name='" + name + "'";
		String sql2 = "select * from user where phone_num='" + phone + "'";

		Connection c = null;

		PreparedStatement s = null;
		ResultSet r = null;
		c = JDBCutil.getConnection();
		Gson gson = new Gson();

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

		try {
			if (r.next()) {
				out.print(gson.toJson("no"));
				return;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			s = c.prepareStatement(sql2);
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

		try {
			if (r.next()) {
				out.print(gson.toJson("no1"));
				return;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			s = c.prepareStatement(sql);
			s.setObject(1, name);
			s.setObject(2, passwd);
			s.setObject(3, phone);
			s.setString(4, "http://img3.imgtn.bdimg.com/it/u=167648379,2590666920&fm=21&gp=0.jpg");
			s.executeUpdate();
			out.print(gson.toJson("yes"));

			return;
		} catch (Exception e) {

			e.printStackTrace();

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
