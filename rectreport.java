import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class rectreport extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><head><title></title><style>a{color:black}</style></HEAD>");
  out.println("<body bgcolor=skyblue text=black><form name=rep><font face=Verdana>");
  out.println("<h2 align=center>	Reports - Human Resource Management System</h2><br>");
  out.println("<center><font size=-1><b><strong>  <br><br><a href='http://localhost:8080/servlet/empreport'>Employee  Report </a>");
  out.println("<br><br><a href='http://localhost:8080/servlet/rectdetails'>Recruitment Report </a>");
  out.println("<br><br><a href='http://localhost:8080/servlet/compreport'>Company Report</a>");
  out.println("<br><br><a href='http://localhost:8080/servlet/projreport'>Project Report</a>");
  out.println("<br><br><a href='http://localhost:8080/servlet/amodule'> Back</a>");
  out.println("</center></b></strong></form></body></html>");
 }
}