import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class projreport extends HttpServlet {

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
    pw.println("<html><body bgcolor=skyblue><center><br><br><br>");
    pw.println("<form method=post action='http://localhost:8080/servlet/projreport'>");
    pw.println("<h3><input type=radio name=t value=offs> OffShore Projects Report");
    pw.println("<br><br><input type=radio name=t value=ons> OnShore Project Report Report</h3>");
    pw.println("<br><br><input type=submit value=Display><center>");
    pw.println("<br><br><a href='http://localhost:8080/servlet/rectreport'>BACK</a>");	
    pw.println("</form></body></html>");
   }

   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
     {

         res.setContentType("text/html");
         PrintWriter pw=res.getWriter();
         String str=req.getParameter("t");
         if(str.equals("offs"))
         {    
         try{

         st=c4.createStatement();

         ss1="select * from projectm where pplace='offshore'";

         rs=st.executeQuery(ss1);

         pw.println("<html><body bgcolor=skyblue><center><h3>OFFSHORE PROJECT DETAILS</h3><br><br>");
         pw.println("<table border=2 align=center>");
         pw.println("<tr><th>Project No</th><th>Project Type</th><th>Project place</th><th>Client name</th><th>Client nature</th><th>Project name</th><th>Project area</th><th>Project sdate</th><th>Project edate</th></tr>");
         int temp=0;
         while(rs.next())
          {
                   temp=1;
                   pw.println("<tr><td>" +rs.getInt(1) +"</td><td>" +rs.getString(2)+"</td><td>" +rs.getString(3) +"</td><td>" +rs.getString(4) +"</td><td>" +rs.getString(5) +"</td><td>" +rs.getString(6) +"</td><td>" +rs.getString(7) +"</td><td>" +rs.getString(8) +"</td><td>" +rs.getString(9) +"</td></tr>");
          }

         pw.println("</table>");
         pw.println("<br><br>");
         pw.println("<a href='http://localhost:8080/servlet/projreport'>BACK</a></center></body></html>");
         if(temp==0)
           pw.println("NO DATA FOUND");
         

         }catch(SQLException ee1) {pw.println(ee1);}
         }
        if(str.equals("ons"))
         {    
         try{

         st=c4.createStatement();

         ss1="select * from projectm where pplace='onshore'";

         rs=st.executeQuery(ss1);

         pw.println("<html><body bgcolor=skyblue><center><h3>ONSHORE PROJECT DETAILS</h3><br><br>");
         pw.println("<table border=2 align=center>");
         pw.println("<tr><th>Project No</th><th>Project Type</th><th>Project place</th><th>Client name</th><th>Client nature</th><th>Project name</th><th>Project area</th><th>Project sdate</th><th>Project edate</th></tr>");
         int temp=0;
         while(rs.next())
          {
                   temp=1;
                   pw.println("<tr><td>" +rs.getInt(1) +"</td><td>" +rs.getString(2)+"</td><td>" +rs.getString(3) +"</td><td>" +rs.getString(4) +"</td><td>" +rs.getString(5) +"</td><td>" +rs.getString(6) +"</td><td>" +rs.getString(7) +"</td><td>" +rs.getString(8) +"</td><td>" +rs.getString(9) +"</td></tr>");
          }

         pw.println("</table>");
         pw.println("<br><br>");
         pw.println("<a href='http://localhost:8080/servlet/projreport'>BACK</a></center></body></html>");
         if(temp==0)
           pw.println("NO DATA FOUND");
         

         }catch(SQLException ee1) {pw.println(ee1);}
      }
}
}


         
