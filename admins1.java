import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class admins1 extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<HTML><HEAD>");
  out.println("<META NAME='GENERATOR' Content='Microsoft Developer Studio'>");
  out.println("<META HTTP-EQUIV='Content-Type' content='text/html; charset=iso-8859-1'>");
  out.println("<TITLE>Document Title</TITLE>");
  out.println("<style>a{color:black}</style></HEAD>");
  out.println("<center><h4>Human Resource Management System</h4></center> <BODY bgcolor=skyblue text=black>");
  out.println("<form name=admin method=post action='http://localhost:8080/servlet/admins'>");
  out.println("<font face=Verdana><br><h3>");
  out.println("<p align=center>");
  out.println("		Administrator Login Form");
  out.println("</h3></p><table border=0 align=center><p>&nbsp;</p>");
  out.println("<tr>	<td><font size=-1><b>		Admin Name	  	</td>");
  out.println("	<td>		<input type=text name=aname>	</td></tr>");
  out.println("<tr>	<td>	</td>	</tr><tr>	<td>	</td>   </tr>");
  out.println("<tr>	<td>	</td>	</tr><tr>	<td>	</td>   </tr>");
  out.println("<tr>	<td><font size=-1><b>		Admin Password		</td>");
  out.println("	<td>		<input type=password name=apass>	</td></tr></table><br><br>");
  out.println("<p align=center>");
  out.println("<input type='submit'  value='Submit'>");
  out.println("<input type='reset'  value='Cancel'>");
  out.println("<br><br><br><a href='http://localhost:8080/servlet/home'><strong><font size=-1><b>Back</b></font></strong></a>");
  out.println("</p></form></BODY></HTML>");
 }
}




