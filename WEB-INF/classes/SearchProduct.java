import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class SearchProduct extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			String name = req.getParameter("name");
			out.print("<html><body>");
			out.print("<h1>Hellow Mr. Aakash Ji</h1>");
			Class.forName("com.mysql.jdbc.Driver");
		   Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","vishal");
		   Statement st=c.createStatement();
		   ResultSet rs=st.executeQuery( "select * from product_ifo where name like '%"+name+"%' ");
           int f=0;
	           while(rs.next()) 
	           {
	           		f=1 ;
	  				out.print("Name : <b>"+rs.getString("name")+"</b><br>");
					out.print("Price : <b>"+rs.getString("price")+"</b><br>");
	  				out.print("Info : <b>"+rs.getString("info")+"</b><hr>");
				}
            if(f==0)
              {
               out.print("---Product not founnd---");
               }
			out.print("</body></html>");
			out.close();
		}catch(Exception e){
			out.print(e);
		}
	}
}
