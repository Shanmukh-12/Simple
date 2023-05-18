
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertintoDatabase
 */
@WebServlet("/InsertintoDatabase")
public class InsertintoDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertintoDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String Empno = request.getParameter("Eno");
		int e = Integer.parseInt(Empno);
		String empname = request.getParameter("ename");
		String job = request.getParameter("ejob");
		String esal = request.getParameter("esal");
		Double s = Double.parseDouble(esal);
		String designation = request.getParameter("ed");
		pw.println(Empno);
		pw.println(empname);
		pw.println(job);
		pw.println(esal);
		pw.println(designation);
		try {

			Class.forName("org.postgresql.Driver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
			PreparedStatement pst = con.prepareStatement("insert into CRUD values(?,?,?,?,?)");
			pst.setInt(1, e);
			pst.setString(2, empname);
			pst.setString(3, job);
			pst.setDouble(4, s);
			pst.setString(5, designation);

			int i = pst.executeUpdate();
			if (i != 0) {
				pw.println("<br>Record has been inserted");
			} else {
				pw.println("<br>failed to insert the data");
			}
		} catch (Exception e1) {
			pw.println(e1);
		}

	}

}
