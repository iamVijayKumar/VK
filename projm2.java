import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class projm2 extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><TITLE>Document Title</TITLE><style>a{color:black}</style></HEAD><BODY bgcolor=skyblue text=black>");
  out.println("<form name=prjmast method=get action='http://localhost:8080/servlet/projadd'>");
  out.println("<font face=Verdana><h2><p align=center>	Project Maintenance</h2>");
  out.println("<br><b><table><tr><td><font size=-1><b>Project Code</td><td><input type=text name=t1 value= ></td>");
  out.println("<td><font size=-1><b>Project Category</td><td><input type=text name=t2 value= ></td>");
  out.println("</tr><tr><td><font size=-1><b>Project Place</td><td><select name=t3><option name=1 value=OnShore>OnShore<option name=2 value=OffShore>OffShore</select></td>");
  out.println("<td><font size=-1><b>Client Name</td><td><input type=text name=t4 value= ></td></tr>");
  out.println("<tr><td><font size=-1><b>Client Nature </td><td><input type=text name=t5 value= ></td>");
  out.println("<td><font size=-1><b>Project Name </td><td><input type=text name=t6 value= ></td>");
  out.println("</tr><tr><td><font size=-1><b>Project Area</td><td><input type=text name=t7 value= ></td>");
  out.println("<td><font size=-1><b>Project From Date</td><td><input type=text name=t8 value=  ></td>");
  out.println("</tr><tr><td><font size=-1><b>Project To Date</td><td><input type=text name=t9 value=  ></td>");
  out.println("</tr></table><br><center>		<br><br><input type=submit name=ad value='Add'> <input type=reset name=ss value='Cancel'><br><a href='http://localhost:8080/servlet/projm'>Back</a><br><br></center>");
  out.println("</form></body></html>");
 }
}
