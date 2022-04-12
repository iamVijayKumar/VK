import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class comp1 extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><TITLE>Document Title</TITLE>");
  out.println("<style>a{color:black}</style></HEAD>");
  out.println("<BODY bgcolor=skyblue text=black>");
  out.println("<form name=admin method=get action='http://localhost:8080/servlet/compadd'>");
  out.println("<font face=Verdana><br><h2><p align=center>	Company Details Maintenance</h2>");
  out.println("<br><b><table><tr>");
  out.println("<td><b><font size=-1>Company Name</td>");
  out.println("<td><input type=text name=t1 value= ></td>");
  out.println("<td><b><font size=-1>Company Address</td><td><input type=text name=t2 value= ></td>");
  out.println("</tr><tr><td><b><font size=-1>Company Country</td>");
  out.println("<td><input type=text name=t3 value= > </td><td><b><font size=-1>Company City</td>");
  out.println("<td><input type=text name=t4 value= ></td></tr><tr>");
  out.println("<td><b><font size=-1>Company Area </td><td><input type=text name=t5 value= ></td>");
  out.println("<td><b><font size=-1>Phone </td><td><input type=text name=t6 value= ></td>");
  out.println("</tr><tr><td><b><font size=-1>Mail</td>");
  out.println("<td><input type=text name=t7 value= ></td><td><b><font size=-1>URL</td>");
  out.println("<td><input type=text name=t8 value=  ></td></tr><tr><td><b><font size=-1>Manager Name</td>");
  out.println("<td><input type=text name=t9 value= ></td><td><b><font size=-1>Year Of Origin</td>");
  out.println("<td><input type=text name=t10 value=  ></td></tr></table><br><br><center>");
  out.println("	            <input type=submit name=ad value='Add'> <input type=reset name=ss value='Cancel'> <a href='http://localhost:8080/servlet/companye'><b>Back</b></a>");
  out.println("</center></form></body></html>");
 }
}







