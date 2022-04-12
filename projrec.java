import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class projrec extends HttpServlet {

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

         ss1="select * from rproject";

         rs=st.executeQuery(ss1);

         pw.println("<html><body bgcolor=skyblue>");
         pw.println("<center><h3>PROJECT TRAINEE DETAILS</h3></center><br><br><table border=2 align=center>");
         pw.println("<tr><th>RCode</th><th>Name</th><th>Project title</th><th>Project Lang.</th><th>Project Place</th><th>Project SDate</th><th>Project EDate</th><th>Date of Interview</th><th>Email</th><th>Address</th><th>Quali</th></tr>");
         int temp=0;
         while(rs.next())
          {
                   temp=1;
                   pw.println("<tr><td>" +rs.getString(1) +"</td><td>" +rs.getString(2)+"</td><td>" +rs.getString(3) +"</td><td>" +rs.getString(4) +"</td><td>" +rs.getString(5) +"</td><td>" +rs.getString(6) +"</td><td>" +rs.getString(7) +"</td><td>" +rs.getString(8) +"</td><td>" +rs.getString(9) +"</td><td>" +rs.getString(10) +"</td><td>" +rs.getString(11) +"</td></tr>");
          }

         pw.println("</table>");
         pw.println("<br><br><br><br><center><a href='http://localhost:8080/servlet/rectdetails'>BACK</a></center><br><br>");
         if(temp==0)
           pw.println("NO DATA FOUND");
         

         }catch(SQLException ee1) {pw.println(ee1);}

}
}


         
