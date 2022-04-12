import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class rectproject extends HttpServlet
{
 Connection c;
 public void doPost(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
  {
   rs.setContentType("text/html");
   PrintWriter out=rs.getWriter();
   String rcode=re.getParameter("t1");
   String name=re.getParameter("t2");
   String ptitle=re.getParameter("t3");
   String plang=re.getParameter("t4");
   String pplace=re.getParameter("t5");
   String sdate=re.getParameter("sdate");
   String smon=re.getParameter("smon");
   String syear=re.getParameter("syear");
   String edate=re.getParameter("edate");
   String emon=re.getParameter("emon");
   String eyear=re.getParameter("eyear");
   String idate=re.getParameter("idate");
   String imon=re.getParameter("imon");
   String iyear=re.getParameter("iyear");
   String email=re.getParameter("t9");
   String address=re.getParameter("t10");   
   String quali=re.getParameter("t11");

String pfd=sdate+"/"+smon+"/"+syear;
String ptd=edate+"/"+emon+"/"+eyear;
String doi=idate+"/"+imon+"/"+iyear;

   try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     c=DriverManager.getConnection("jdbc:odbc:hrms");
     Statement s=c.createStatement();
     ResultSet r;
     r=s.executeQuery("select reccode from rproject");
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
        out.println("<html><body bgcolor=skyblue><center>");
        out.println("<br><br><br><h3>Recruitment Code Already Exist, Please Try Again</h3>");
        out.println("<br><br><br><a href='http://localhost:8080/servlet/recruitment'>Back</a>");
        out.println("</center></body></html>");
       } 
     else
      {

        String str="insert into rproject values('"+rcode+"','"+name+"','"+ptitle+"','"+plang+"','"+pplace+"','"+pfd+"','"+ptd+"','"+doi+"','"+email+"','"+address+"','"+quali+"')";
        //out.println(str);
        
           s.executeUpdate(str); 
           out.println("<html><body bgcolor=skyblue><center>");
           out.println("<br><br><br><h3>DETAILS ARE STORED</h3>");
       //  out.println("<a href='http://localhost:8080/usermo.html'>Proceed Further</a>");
           out.println("<br><br><br><a href='http://localhost:8080/servlet/rectproject1'>Back</a>");
           out.println("</center></body></html>");
              
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