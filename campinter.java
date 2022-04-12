import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class campinter extends HttpServlet
{
 Connection c;
 public void doPost(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
  {
   rs.setContentType("text/html");
   PrintWriter out=rs.getWriter();
   String rcode=re.getParameter("t1");
   String name=re.getParameter("t2");
   String cname=re.getParameter("t3");
   String caddress=re.getParameter("t4");
   String date=re.getParameter("date");
   String mon=re.getParameter("mon");
   String year=re.getParameter("year");
   String perfor=re.getParameter("t6");
   String parea=re.getParameter("t7");
   String aot=re.getParameter("t8");
   String refby=re.getParameter("t9");
   
   String doi=date+"/"+mon+"/"+year;
   try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     c=DriverManager.getConnection("jdbc:odbc:hrms");
     Statement s=c.createStatement();
     ResultSet r;
     r=s.executeQuery("select reccode from campus");
     int temp=0;
     while(r.next())
      {
         if(rcode.equals(r.getString(1)))
          {
            temp=1;
            break;
          }
      }
     if(temp==1)
       {
        out.println("<html><body bgcolor=skyblue><br><br><br><center>");
        out.println("<h3>Recruitment Code Already Exist, Please Try Again</h3>");
        out.println("<br><br><br><a href='http://localhost:8080/servlet/recruitment'>Back</a>");
        out.println("</center></body></html>");
       } 
     else
      {

        String str="insert into campus values('"+rcode+"','"+name+"','"+cname+"','"+caddress+"','"+doi+"','"+perfor+"','"+parea+"','"+aot+"','"+refby+"')";
        //out.println(str);
        if(perfor.equals("Very Good") || perfor.equals("Good"))
         {
           s.executeUpdate(str); 
           out.println("<html><body bgcolor=skyblue><br><br><br><br><center>");
           out.println("<h3>DETAILS ARE STORED</h3>");
       //  out.println("<a href='http://localhost:8080/usermo.html'>Proceed Further</a>");
           out.println("<br><br><br><a href='http://localhost:8080/servlet/recruitment'>Back</a>");
           out.println("</center></body></html>");
         }
        else
          rs.sendRedirect("http://localhost:8080/servlet/campinter1"); 
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