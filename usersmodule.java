import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class usersmodule extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><head><style>a{color:black}</style></HEAD>");
  out.println("<BODY bgcolor=skyblue text=black><form name=usemo> <font face=Verdana>");
  out.println("<br><br><br><h2 align=center>	Users Modules");
  out.println("</h2><br><br><br><p align=center><font size=-1><b>	");
  out.println("<a href='http://localhost:8080/servlet/userslogin'>Recruitment Process</a><br><br><a href='http://localhost:8080/servlet/userview'>Company Details</a><br><br>");
  out.println("<a href='http://localhost:8080/servlet/home'><b>Back</b></a></font>");
  out.println("</p></font></form></body></html>");
 }
}

