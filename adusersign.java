import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class adusersign extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><head><title></title><style>a{color:black}</style></head>");
  out.println("<body bgcolor=skyblue text=black><form name=per  >");
  out.println("<font face=Verdana><h2 align=center>	Users Login Module</h2><br><br>");
  out.println("<table align=center><tr>");
  out.println("<td><font size=-1 face=Verdana><b>User name</b></font></td><td><input type=text name=uname></td>");
  out.println("</tr><tr><td><font size=-1 face=Verdana><b>Password</b></font></td>");
  out.println("<td><input type=password name=upass> </td></tr></table>");
  out.println("<br><br><center>");
  out.println("    <input type=submit name=sub1 value=Submit>    <input type=reset name=can value=Cancel>");
  out.println("</center><br><center>&nbsp;&nbsp;");
  out.println("	<a href='http://localhost:8080/servlet/usersmodule'><font size=-1><b>Back</b></font></a>");
  out.println("	&nbsp;&nbsp;	<a href='http://localhost:8080/servlet/newuserlogin'><font size=-1><b>New User</b></font></a>");
  out.println("</center></form></body></html>");
 }
} 