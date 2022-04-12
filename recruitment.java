import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class recruitment extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><TITLE>Document Title</TITLE><style>a{color:black}</style></HEAD>");
  out.println("<BODY bgcolor=skyblue text=black><form name=instr><font face=Verdana>");
  out.println("<br><h2><p align=center>	Recruitment Process</h2>");
  out.println("<br><br><b><font size=-1></MARQUEE>");
  out.println("<a href='http://localhost:8080/servlet/rectdirect'>Direct Recruitment</a><br></br>");
  out.println("<a href='http://localhost:8080/servlet/campinter1'>Campus Interviews</a><br></br>");
  out.println("<a href='http://localhost:8080/servlet/rectproject1'>Absorbing Project Trainee</a><br></br>");
  out.println("<a href='http://localhost:8080/servlet/amodule'>Back</a><br><br>");
  out.println("</form></body></html>");
 }
}



