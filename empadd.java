import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class empadd extends HttpServlet
{
 Connection c5;
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
  {
   rs.setContentType("text/html");
   PrintWriter out=rs.getWriter();
   
   String ecode1=re.getParameter("t1");
   int ecode=Integer.parseInt(ecode1);
   String ename=re.getParameter("t2");
   String email=re.getParameter("t3");
   String quali=re.getParameter("t4");
   String pexp=re.getParameter("t5");
   String ppexp=re.getParameter("t6");
   String bg=re.getParameter("t7");
   String date=re.getParameter("date");
   String mon=re.getParameter("mon");
   String year=re.getParameter("year");
   String jc=re.getParameter("t9");
   String jn=re.getParameter("t10");  
   String ms=re.getParameter("t11");  
   String ref=re.getParameter("t12");   
   String padd=re.getParameter("t13");  
   String padd1=re.getParameter("t14");  
String dob=date+mon+year;   
   try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     c5=DriverManager.getConnection("jdbc:odbc:hrms");
     Statement s=c5.createStatement();
     ResultSet r;
     r=s.executeQuery("select ecode from employee");
     int temp=0;
     while(r.next())
      {
         if(ecode==r.getInt(1))
          {
            temp=1;
            break;
          }
      }
     if(temp==1)
      {
       out.println("<html><body bgcolor=skyblue><center><br><br><br>");              
       out.println("<h2>employee code Already Exist, Please Try Again</h2>");
       out.println("<br><br><br><a href=http://localhost:8080/servlet/employ2>BACK</a></center>"); 
       out.println("</body></html>"); 
       
      }
     else
      {
        String str="insert into employee values("+ecode+",'"+ename+"','"+email+"','"+quali+"','"+pexp+"','"+ppexp+"','"+bg+"','"+dob+"',"+jc+",'"+jn+"','"+ms+"','"+ref+"','"+padd+"','"+padd1+"')";
        //out.println(str);
        s.executeUpdate(str); 
        out.println("<html><body bgcolor=skyblue><center><br><br><br>");
        out.println("<h2>Employee Details Are Stored</h2>");
        out.println("<br><br><br><a href=http://localhost:8080/servlet/employ2>BACK</a></center>");
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