import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class compadd extends HttpServlet
{
 Connection c7;
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
  {
   rs.setContentType("text/html");
   PrintWriter out=rs.getWriter();
   
   String cname=re.getParameter("t1");
   String cadd=re.getParameter("t2");
   String ccountry=re.getParameter("t3");
   String ccity=re.getParameter("t4");
   String carea=re.getParameter("t5");
   String cphone1=re.getParameter("t6");
   int cphone=Integer.parseInt(cphone1); 
   String cmailid=re.getParameter("t7");
   String curl=re.getParameter("t8");
   String cmname=re.getParameter("t9");
   String cyos=re.getParameter("t10");  
   
   try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     c7=DriverManager.getConnection("jdbc:odbc:hrms");
     Statement s=c7.createStatement();
     ResultSet r;
     r=s.executeQuery("select cname from company");
     int temp=0;
     while(r.next())
      {
         if(cname.equals(r.getString(1)))
          {
            temp=1;
            break;
          }
      }
     if(temp==1)
     {
       out.println("<html><body bgcolor=skyblue><center><br><br><br>");              
       out.println("<h2>Company Name Already Exist, Please Try Again</h2>");
       out.println("<br><br><br><a href=http://localhost:8080/servlet/comp1>BACK</a></center>"); 
       out.println("</body></html>"); 
     }
     else
      {
        String str="insert into company values('"+cname+"','"+cadd+"','"+ccountry+"','"+ccity+"','"+carea+"',"+cphone+",'"+cmailid+"','"+curl+"','"+cmname+"','"+cyos+"')";
        //out.println(str);
        s.executeUpdate(str); 
        out.println("<html><body bgcolor=skyblue><center><br><br><br>");
        out.println("<h2>Company Details Are Stored</h2>");
        out.println("<br><br><br><a href=http://localhost:8080/servlet/comp1>BACK</a></center>");
        out.println("</body></html>");
        
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