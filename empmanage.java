import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class empmanage extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><TITLE>Document Title</TITLE><style>a{color:black}</style></HEAD>");
  out.println("<BODY bgcolor=skyblue text=black><form name=empma >");
  out.println("<font face=Verdana><h2 align=center>	Employee Details Management</h2><table><tr>");
  out.println("<td><font size=-2 face=Verdana><b>Employee Code</td><td><font size=-2 face=Verdana><input type=text name=empcode value= ></td>");
  out.println("<td><font size=-2 face=Verdana><b>Employee Name</td><td><font size=-2 face=Verdana><input type=text name=empname value= ></td>");
  out.println("</tr><tr><td><font size=-2 face=Verdana><b>Email ID</td><td><font size=-2 face=Verdana><input type=text name=emailid value= > </td>");
  out.println("<td><font size=-2 face=Verdana><b>Qualification</td><td><font size=-2 face=Verdana><input type=text name=qulification value= ></td>");
  out.println("</tr><tr><td><font size=-2 face=Verdana><b>Year of Eeperience </td><td><font size=-2 face=Verdana><input type=text name=yrofexp value= ></td>");
  out.println("<td><font size=-2 face=Verdana><b>Previous Year Eeperience </td><td><font size=-2 face=Verdana><input type=text name=preveexp value= ></td>");
  out.println("</tr><tr><td><font size=-2 face=Verdana><b>Blood Group</td><td><font size=-2 face=Verdana><input type=text name=bloodgroup value= ></td>");
  out.println("<td><font size=-2 face=Verdana><b>Date of Birth</td><td><font size=-2 face=Verdana><input type=text name=dob value=  ></td>");
  out.println("</tr><tr><td><font size=-2 face=Verdana><b>Job Code</td><td><font size=-2 face=Verdana><input type=text name=jobcode value= ></td>");
  out.println("<td><font size=-2 face=Verdana><b>Job Nature</td><td><font size=-2 face=Verdana><input type=text name=jobnature value= ></td>");
  out.println("</tr><tr><td><font size=-2 face=Verdana><b>Marriage  Status</td><td><font size=-2 face=Verdana><input type=text name=marrsta value= ></td>");
  out.println("<td><font size=-2 face=Verdana><b>Reference By</td><td><font size=-2 face=Verdana><input type=text name=refby value=></td>");
  out.println("</tr><tr><td><font size=-2 face=Verdana><b>Present Adress</td><td><font size=-2 face=Verdana><input type=text name=preseadd value=></td>");
  out.println("<td><font size=-2 face=Verdana><b>Permanent Address</td><td><font size=-2 face=Verdana><input type=text name=peradd value=> </td>");
  out.println("</tr></table><pre>		<input type=submit name=ad value='Add'> <input type=submit name=modi value='Modify'> <input type=submit name=del value='Delete'> <input type=submit name=view value='View'> <input type=reset name=ss value='Cancel'> <a href=http://localhost:8080/servlet/amodule><b>Back</b></a>");
  out.println("</pre></form></body></html>");
 }
}



