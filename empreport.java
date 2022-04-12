import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class empreport extends HttpServlet {

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
   public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
   {
    res.setContentType("text/html");
    PrintWriter pw=res.getWriter();
    pw.println("<html><body bgcolor=skyblue>");
    pw.println("<form method=post action='http://localhost:8080/servlet/empreport'>");
    pw.println("<center><br><br><br><br><h3><input type=radio name=t value=emp> Employee Report<br>");
    pw.println("<br><input type=radio name=t value=tra> Trainee Report</h3>");
    pw.println("<br><br><br><input type=submit value=Display></center>");
    pw.println("<br><br><center><a href='http://localhost:8080/servlet/rectreport'>BACK</a></center><br><br>");
    pw.println("</form></body></html>");
   }

   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
     {

         res.setContentType("text/html");
         PrintWriter pw=res.getWriter();
         String str=req.getParameter("t");
         if(str.equals("emp"))
         {    
         try{

         st=c4.createStatement();

         ss1="select * from employee";

         rs=st.executeQuery(ss1);

         pw.println("<html><body bgcolor=skyblue><center><h3>EMPLOYEE REPORT</h3><br><br>");
         pw.println("<table border=2 align=center>");
         pw.println("<tr><th>Employee No</th><th>E name</th><th>Email</th><th>Quali</th><th>Ccexp</th><th>Pcexp</th><th>Bgroup</th><th>DOB</th><th>JobCode </th><th>JobNature</th><th>Mstatus</th><th>Reference</th><th>Paddress</th><th>Peradd</th></tr>");
         int temp=0;
         while(rs.next())
          {
                   temp=1;
                   pw.println("<tr><td>" +rs.getInt(1) +"</td><td>" +rs.getString(2)+"</td><td>" +rs.getString(3) +"</td><td>" +rs.getString(4) +"</td><td>" +rs.getString(5) +"</td><td>" +rs.getString(6) +"</td><td>" +rs.getString(7) +"</td><td>" +rs.getString(8) +"</td><td>" +rs.getInt(9) +"</td><td>" +rs.getString(10) +"</td><td>" +rs.getString(11) +"</td><td>" +rs.getString(12) +"</td><td>" +rs.getString(13) +"</td><td>" +rs.getString(14) +"</td></tr>");
          }

         pw.println("</table>");
         pw.println("<br><br>");
         pw.println("<a href='http://localhost:8080/servlet/empreport'>BACK</a></center></body></html>");
         if(temp==0)
           pw.println("NO DATA FOUND");
         

         }catch(SQLException ee1) {pw.println(ee1);}
       }
  
         if(str.equals("tra"))
         {    
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
         pw.println("<br><br><center><a href='http://localhost:8080/servlet/empreport'>BACK</a></center><br><br>");
         if(temp==0)
           pw.println("NO DATA FOUND");
         
         

         }catch(SQLException ee1) {pw.println(ee1);}
       }

}
}


         
