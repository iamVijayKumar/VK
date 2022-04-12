import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class rectdetails extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><TITLE>Document Title</TITLE><style>a{color:black}</style></HEAD>");
  out.println("<BODY bgcolor=skyblue text=black><form name=instr><font face=Verdana><br>");
  out.println("<h2><p align=center>	Recruitment Report</h2><br><br><b><font size=-1>");
  out.println("</MARQUEE><a href='http://localhost:8080/servlet/rectdirectrep'>Direct Recruitment Details</a><br></br>");
  out.println("<a href='http://localhost:8080/servlet/campreport'>Campus Interviews Details</a><br>");
  out.println("</br><a href='http://localhost:8080/servlet/projrec'>Project Trainee Details</a><br></br>");
  out.println("<a href='http://localhost:8080/servlet/amodule'>Back</a><br><br></form></body></html>");
 }
} 



