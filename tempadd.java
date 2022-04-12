import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class tempadd extends HttpServlet
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
   String jcode1=re.getParameter("t4");
   int jcode=Integer.parseInt(jcode1);
   String tcategory=re.getParameter("t5");
   String tplace=re.getParameter("t6");
   String sdate=re.getParameter("sdate");
   String smon=re.getParameter("smon");
   String syear=re.getParameter("syear");
   String edate=re.getParameter("edate");
   String emon=re.getParameter("emon");
   String eyear=re.getParameter("eyear");
   String tperson=re.getParameter("t9");
  
   String tsdate=sdate+smon+syear;
   String tedate=edate+emon+eyear;      
   try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     c5=DriverManager.getConnection("jdbc:odbc:hrms");
     Statement s=c5.createStatement();
     ResultSet r;
     r=s.executeQuery("select ecode from temployee");
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
       out.println("<h2>Employee code Already Exist, Please Try Again</h2>");
       out.println("<br><br><br><a href=http://localhost:8080/servlet/tempemploy2>BACK</a></center>"); 
       out.println("</body></html>"); 
       
      }
     else
      {
        String str="insert into temployee values("+ecode+",'"+ename+"','"+email+"',"+jcode+",'"+tcategory+"','"+tplace+"','"+tsdate+"','"+tedate+"','"+tperson+"')";
        //out.println(str);
        s.executeUpdate(str); 
        out.println("<html><body bgcolor=skyblue><center><br><br><br>");
        out.println("<h2>Trainee Details Are Stored</h2>");
        out.println("<br><br><br><a href=http://localhost:8080/servlet/tempemploy2>BACK</a></center>");
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