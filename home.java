import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class home extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><head></head><style>a{color:black}</style></HEAD><BODY bgcolor=skyblue text=black>");
  out.println("<font face=arial><br><br><br>");
  out.println("<h1><p align=center>Welcome to Hindustan Software Limited</p></h1><br><br>");
  out.println("<h2><p align=center>Human Resource Management System</p></h2>");
  out.println("<br><br><br><p align=center>");
  out.println("<a href='http://localhost:8080/servlet/newuserlogin1'><b><font size=-1>New User</font></b></a>");
  out.println("	&nbsp;&nbsp;&nbsp;");
  out.println("<center><br><br><h4><a href='http://localhost:8080/servlet/usersmodule'><b><font size=-1>Existing User Login</font></b></a></h4></center>");
  out.println("</p><br><h4><i><a href='http://localhost:8080/servlet/admins1'><center>HRManager Login</center></a></i></h4>");
  out.println("</font></BODY></HTML>");
 }
}



