
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
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String Empno = request.getParameter("Eno");
		int e = Integer.parseInt(Empno);
		pw.println(Empno);
		try {

			Class.forName("org.postgresql.Driver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
			PreparedStatement pst = con.prepareStatement("delete from CRUD where eno=?");
			pst.setInt(1, e);
			int i = pst.executeUpdate();
			if (i != 0) {
				pw.println("<br>Record has been Deleted");
			} else {
				pw.println("<br>failed to delete the data");
			}
		} catch (Exception e1) {
			pw.println(e1);
		}
	}
}
