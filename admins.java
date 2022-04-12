import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
public class admins extends HttpServlet
{
 public void doPost(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException 
  {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  String name=re.getParameter("aname");
  String pass=re.getParameter("apass");
  Connection con;
  try
   {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     con=DriverManager.getConnection("jdbc:odbc:hrms");
     Statement s1=con.createStatement();
     ResultSet r1=s1.executeQuery("select *from admin");
     int temp=0;
    while(r1.next())
      {
     if(name.equals(r1.getString(1)) && pass.equals(r1.getString(2)))
         {
          temp=1;
	  break;
         }
       }
     if(temp==1)
       {
         rs.sendRedirect("http://localhost:8080/servlet/amodule");
       } 
      else
       {
         out.println("<body bgcolor=skyblue><center>");
         out.println("<h2 align=center><br><br><br>");
         out.println("YOU ARE NOT A ADMINISTRATOR");
         out.println("</h2><br><br><a href='http://localhost:8080/servlet/admins1'><font size=-1><br><br><b>Back</b></center>");
       }
      
    }
   catch(SQLException sqle)
    {
      out.println(sqle);
    }
   catch(ClassNotFoundException cnfe)
    {
      out.println(cnfe);
    }
   }
 }  
  
   
 