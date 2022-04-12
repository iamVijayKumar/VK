import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class projadd extends HttpServlet
{
 Connection c2;
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
  {
   rs.setContentType("text/html");
   PrintWriter out=rs.getWriter();
   
   String pcode1=re.getParameter("t1");
   int pcode=Integer.parseInt(pcode1);
   String pcat=re.getParameter("t2");
   String pplace=re.getParameter("t3");
   String cname=re.getParameter("t4");
   String cnature=re.getParameter("t5");
   String pname=re.getParameter("t6");
   String parea=re.getParameter("t7");
   String psdate=re.getParameter("t8");
   String pedate=re.getParameter("t9");
   //String yos=re.getParameter("t10");  
     
   try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     c2=DriverManager.getConnection("jdbc:odbc:hrms");
     Statement s=c2.createStatement();
     ResultSet r;
     r=s.executeQuery("select pcode from projectm");
     int temp=0;
     while(r.next())
      {
         if(pcode==r.getInt(1))
          {
            temp=1;
            break;
          }
      }
     if(temp==1)
      {
        out.println("<html><body bgcolor=skyblue><center><br><br><br>");              
       out.println("<h2>Project code Already Exist, Please Try Again</h2>");
       out.println("<br><br><br><a href=http://localhost:8080/servlet/projm2>BACK</a></center>");   
       out.println("</body></html>");
      }
     else
      {
        String str="insert into projectm values("+pcode+",'"+pcat+"','"+pplace+"','"+cname+"','"+cnature+"','"+pname+"','"+parea+"','"+psdate+"','"+pedate+"')";
        //out.println(str);
        s.executeUpdate(str); 
        out.println("<html><body bgcolor=skyblue><center><br><br><br>");
        out.println("<h2>PROJECT DETAILS ARE STORED</h2>");
        out.println("<br><br><br><a href=http://localhost:8080/servlet/projm2>BACK</a></center>");
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