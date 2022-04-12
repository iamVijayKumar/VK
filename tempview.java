import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class tempview extends HttpServlet {

   Connection c4;
   Statement st;
   ResultSet rs;
   String s1="";
   String ss1="";


   public void init(ServletConfig sc) throws ServletException
  {
    try
    {

       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       c4=DriverManager.getConnection("jdbc:odbc:hrms","","");
     }
     catch(Exception ee4){}
   }

   public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {

         PrintWriter pw=res.getWriter();

         //s1=req.getParameter("s1");

         try{

         st=c4.createStatement();

         ss1="select * from temployee";

         rs=st.executeQuery(ss1);

         pw.println("<html><body bgcolor=skyblue><br><center><h2>Trainee Details</h2></center><br>");
         pw.println("<table border=1 align=center>");
         pw.println("<tr><th>Employee No</th><th>Employee name</th><th>Email</th><th>JobCode</th><th>Training Category</th><th>Training Place</th><th>TSDate</th><th>TEDate</th><th>Train Person</th></tr>");
         int temp=0;
         while(rs.next())
          {
                   temp=1;
                   pw.println("<tr><td>" +rs.getInt(1) +"</td><td>" +rs.getString(2)+"</td><td>" +rs.getString(3) +"</td><td>" +rs.getInt(4) +"</td><td>" +rs.getString(5) +"</td><td>" +rs.getString(6) +"</td><td>" +rs.getString(7) +"</td><td>" +rs.getString(8) +"</td><td>"+rs.getString(9)+"</td></tr>");
          }

         pw.println("</table>");
         pw.println("<br><br>");
         pw.println("<br><br><center><a href='http://localhost:8080/servlet/tempemploy'>BACK</a></center><br><br>");
         if(temp==0)
           pw.println("NO DATA FOUND");
         

         }catch(SQLException ee1) {pw.println(ee1);}

}
}


         
