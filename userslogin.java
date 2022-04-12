import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
public class userslogin extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html>");
  out.println("<head>");
  out.println("<title></title>");
  out.println("<style>a{color:black}</style></head>");
  out.println("<body bgcolor=skyblue text=black>");
  out.println("<form name=per  method=post action='http://localhost:8080/servlet/userslogin'>");
  out.println("<font face=Verdana>");
  out.println("<h2 align=center>");
  out.println("	Users Login Module");
  out.println("</h2><br><br><table align=center><tr>");
  out.println("<td><font size=-1 face=Verdana><b>User name</b></font></td>");
  out.println("<td><input type=text name=uname></td></tr><tr>");
  out.println("<td><font size=-1 face=Verdana><b>Password</b></font></td>");
  out.println("<td><input type=password name=upass> </td></tr></table><br><br>");
  out.println("<center><input type=submit name=sub1 value=Submit>");
  out.println("<input type=reset name=can value=Cancel></center><br>");
  out.println("<center>&nbsp;&nbsp;<a href='http://localhost:8080/servlet/usersmodule'><font size=-1><b>Back</b></font></a>");
  out.println("	&nbsp;&nbsp;<a href='http://localhost:8080/servlet/newuserlogin1'><font size=-1><b>New User</b></font></a>");
  out.println("</center>");
  out.println("</form></body></html>");
 }
 public void doPost(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException 
  {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  HttpSession hp=re.getSession(true);
  String name=re.getParameter("uname");
  String pass=re.getParameter("upass");
  hp.putValue("username",name);
  hp.putValue("password",pass);
  Connection con;
  try
   {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     con=DriverManager.getConnection("jdbc:odbc:hrms");
     Statement s=con.createStatement();
     ResultSet r=s.executeQuery("select *from userreg");
     int temp=0;
     while(r.next())
      {
        if(name.equals(r.getString(1)) && pass.equals(r.getString(2)))
         {
          temp=1;
         }
      }
      if(temp==1)
       {
         out.println("<HTML>");
         out.println("<HEAD><center><META NAME='GENERATOR' Content='Microsoft Developer Studio'>");
         out.println("<META HTTP-EQUIV='Content-Type' content='text/html' charset=iso-8859-1>");
         out.println("<TITLE>Document Title</TITLE><style>a{color:blue}</style></HEAD>");
         out.println("<BODY bgcolor=skyblue><br><br><p align=center>");
         out.println("<font face=Verdana size=-1> <b>Hello,<u><font color=red></font></u></b></font>");
         out.println("<br><br><br>");
         out.println("<h3><a href='http://localhost:8080/servlet/testing' style='color: rgb(0,0,255)'>Click here for Online Test</a></h3>");
         out.println("<br><br><br><br><br>");
         out.println("<a href='http://localhost:8080/servlet/usersmodule'>Back</a>&nbsp;&nbsp;");
         out.println("<a href='http://localhost:8080/servlet/home'>Home Page</a></center></BODY></HTML>");
       } 
      else
       {
         out.println("<body bgcolor=skyblue><center><br><br><br>");
         out.println("<h2 align=center>");
         out.println("YOU ARE NOT A VALID USER");
         out.println("</h2><br><br><a href='http://localhost:8080/servlet/usersmodule'><font size=-1><b>Back</b></center>");
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
  
   
 