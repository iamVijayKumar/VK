import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class empdelete extends HttpServlet {

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

         ss1="select * from employee";

         rs=st.executeQuery(ss1);

         pw.println("<html><body bgcolor=skyblue><style>a{color:black}</style>");
         pw.println("<table border=2 align=center>");
         pw.println("<tr><th>Ecode </th><th>Ename</th><th>Eid</th><th>Qual</th><th>PExp</th><th>PPExp</th><th>BGroup</th><th>DOB</th><th>JCode</th><th>JNature</th><th>Mstatus</th><th>Ref</th><th>Padd</th><th>PPadd</th></tr>");

         while(rs.next())
         {
           
              pw.println("<tr><td>" +rs.getInt(1) +"</td><td>" +rs.getString(2) +"</td><td>" +rs.getString(3) +"</td><td>" +rs.getString(4) +"</td><td>" +rs.getString(5) +"</td><td>" +rs.getString(6) +"</td><td>" +rs.getString(7) +"</td><td>" +rs.getString(8) +"</td><td>" +rs.getInt(9) +"</td><td>" +rs.getString(10) +"</td><td>" +rs.getString(11) +"</td><td>" +rs.getString(12) +"</td><td>" +rs.getString(13) +"</td><td>" +rs.getString(14) +"</td></tr>");
         }

         pw.println("</table>");
         pw.println("<br><br>");

         pw.println("<form method=get action=http://localhost:8080/servlet/empdelete1>");
         pw.println("<table border=0 align=center>");
         
         pw.println("<tr><td>Enter the Employee No</td><td><input type=text name=t1></td></tr>");
         pw.println("<tr><td colspan=2 align=center><br><br><input type=submit value=Delete></td></tr>");
         pw.println("</table>");
         pw.println("</form>");
	 pw.println("<center><a href='http://localhost:8080/servlet/employ'>Back</a></center>");
         pw.println("</body></html>");
         }
        catch(SQLException sqle) {
         pw.println(sqle);}

}
}


         
