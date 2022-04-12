import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class usersreg extends HttpServlet
{
 Connection c;
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
  {
   rs.setContentType("text/html");
   PrintWriter out=rs.getWriter();
   String name=re.getParameter("t1");
   String passwd=re.getParameter("t2");
   String sex=re.getParameter("t3");
   String date=re.getParameter("date");
   String mon=re.getParameter("mon");
   String year=re.getParameter("year");
   String address=re.getParameter("t5");
   String city=re.getParameter("t6");
   String country=re.getParameter("t7");
   String pin=re.getParameter("pin");
   long pincode=Long.parseLong(pin);
   String quali=re.getParameter("t8");
   String skill=re.getParameter("t9");
   String phone1=re.getParameter("t10");  
   long phone=Long.parseLong(phone1);
   String e1=re.getParameter("t11");  
   String e2=re.getParameter("t12");
   String dob=date+"/"+mon+"/"+year; 

try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     c=DriverManager.getConnection("jdbc:odbc:hrms");
     Statement s=c.createStatement();
     ResultSet r;
     r=s.executeQuery("select username from userreg");
     int temp=0;
     while(r.next())
      {
         if(name.equals(r.getString(1)))
          {
            temp=1;
            break;
          }
      }
     if(temp==1)
       {
        out.println("<html><body bgcolor=skyblue><center>");
        out.println("<br><br><br><pre align=center>");
        out.println("<h3>Sorry,UserName Already Exist, Please Try Again</h3><br><br>");
        out.println("<a href='http://localhost:8080/servlet/newuserlogin1'>Back</a>");
        out.println("</center></body></html>");
       } 
     else
      {
        String str="insert into userreg values('"+name+"','"+passwd+"','"+sex+"','"+dob+"','"+address+"','"+city+"','"+country+"',"+pincode+",'"+quali+"','"+skill+"',"+phone+",'"+e1+"','"+e2+"')";
        //out.println(str);
        s.executeUpdate(str); 
        out.println("<html><body bgcolor=skyblue><center>");
        out.println("<br><br><br><pre align=center>");
        out.println("<h3>YOUR DETAILS ARE STORED</h3><br><br>");
        out.println("<a href='http://localhost:8080/servlet/usersmodule'>Proceed Further</a>");
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