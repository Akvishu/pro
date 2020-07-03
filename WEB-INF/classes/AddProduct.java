import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class AddProduct extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			String name = req.getParameter("name");
			String info = req.getParameter("info");
			int price = Integer.parseInt (req.getParameter("price"));
			Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","vishal");
				Statement st = c.createStatement();
				st.executeUpdate( "insert into product_ifo values ('"+name+"',"+price+",'"+info+"')");
				out.print("<html><body>");
				out.print("<h3>Product added succseessfully</h3>");
				out.print("<a href='index.html'> Home page</a> ");
				out.print("</body></html>");
				out.close();
		}catch(Exception e){
			out.print(e);
		}
	}
}
