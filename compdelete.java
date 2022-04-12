import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class compdelete extends HttpServlet {

   Connection c5;
   Statement st;
   ResultSet rs;
   String s1="";
   String ss1="";


   public void init(ServletConfig sc) throws ServletException {
    try{

       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       c5=DriverManager.getConnection("jdbc:odbc:hrms","","");
       }catch(Exception ee4){}
   }

   public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {

         PrintWriter pw=res.getWriter();

//         s1=req.getParameter("s1");

         try{

         st=c5.createStatement();

         ss1="select * from company";

         rs=st.executeQuery(ss1);

         pw.println("<html><body bgcolor=skyblue><style>a{color:black}</style>");
         pw.println("<table border=2 align=center>");
         pw.println("<tr><th>Company name </th><th>Address</th><th>country</th><th>city</th><th>area</th><th>phone</th><th>email</th><th>url</th><th>Manager name</th><th>Year of origin</th></tr>");

         while(rs.next())
         {
           
              pw.println("<tr><td>" +rs.getString(1) +"</td><td>" +rs.getString(2) +"</td><td>" +rs.getString(3) +"</td><td>" +rs.getString(4) +"</td><td>" +rs.getString(5) +"</td><td>" +rs.getInt(6) +"</td><td>" +rs.getString(7) +"</td><td>" +rs.getString(8) +"</td><td>" +rs.getString(9) +"</td><td>" +rs.getString(10) +"</td></tr>");
         }

         pw.println("</table>");
         pw.println("<br><br>");

         pw.println("<form method=get action=http://localhost:8080/servlet/compdelete1>");
         pw.println("<table border=0 align=center>");
         
         pw.println("<tr><td>Enter the Company name</td><td><input type=text name=t1></td></tr>");
         pw.println("<tr><td colspan=2 align=center><br><br><input type=submit value=Delete></td></tr>");
         pw.println("</table>");
         pw.println("</form>");
	 pw.println("<style>a{color:black}</style><center><h4><a href='http://localhost:8080/servlet/companye'>BACK</a></h4></center>");
         pw.println("</body></html>");

         }
        catch(SQLException sqle) {
         pw.println(sqle);}

}
}


         
