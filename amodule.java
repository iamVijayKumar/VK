import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class amodule extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<HTML><HEAD><META NAME='GENERATOR' Content='Microsoft Developer Studio'>");
  out.println("<META HTTP-EQUIV='Content-Type' content='text/html; charset=iso-8859-1'>");
  out.println("<TITLE>Document Title</TITLE><style>a{color:black}</style></HEAD>");
  out.println("<center><h4>Human Resource Management System</h4></center><BODY bgcolor=skyblue text=black><form name=admin ><font face=Verdana><br>");
  out.println("<h2><p align=center>	Administration Module</h2>");
  out.println("<br><br><b><font size=-1>");
  out.println("<a href='http://localhost:8080/servlet/projm'>Project Maintenance</a><br><br>");
  out.println("<a href='http://localhost:8080/servlet/companye'>Company Details</a><br><br>");
  out.println("<a href='http://localhost:8080/servlet/employ'>Employee Details</a><br><br>");
  out.println("<a href='http://localhost:8080/servlet/tempemploy'>Employee Training Details</a><br><br>");
  out.println("<a href='http://localhost:8080/servlet/recruitment'>Recruitment Process</a><br><br>");
  out.println("<a href='http://localhost:8080/servlet/rectreport'>Recruitment Report</a><br><br>");
  out.println("<a href='http://localhost:8080/servlet/admins1'>Back</a></b></body></html>");
 }
}


