import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class userview extends HttpServlet {

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
         int temp=0;
         try{

         st=c4.createStatement();

         ss1="select * from company";

         rs=st.executeQuery(ss1);
         pw.println("<html><body bgcolor=skyblue><center><h3>COMPANY DETAILS</h3><br><br>");
         pw.println("<table border=2 align=center>");
         pw.println("<tr><th>Company name </th><th>Address</th><th>country</th><th>city</th><th>area</th><th>phone</th><th>email</th><th>url</th><th>Manager name</th><th>Year of origin</th></tr>");

         while(rs.next())
         {
           
              pw.println("<tr><td>" +rs.getString(1) +"</td><td>" +rs.getString(2) +"</td><td>" +rs.getString(3) +"</td><td>" +rs.getString(4) +"</td><td>" +rs.getString(5) +"</td><td>" +rs.getInt(6) +"</td><td>" +rs.getString(7) +"</td><td>" +rs.getString(8) +"</td><td>" +rs.getString(9) +"</td><td>" +rs.getString(10) +"</td></tr>");
          temp=1;
         }

         pw.println("</table>");
         pw.println("<br><br>");

                 
         pw.println("<br><br>");
         pw.println("<a href='http://localhost:8080/servlet/usersmodule'>BACK</a></center>");
         if(temp==0)
           pw.println("NO DATA FOUND");
         

         }catch(SQLException ee1) {pw.println(ee1);}

}
}


         
