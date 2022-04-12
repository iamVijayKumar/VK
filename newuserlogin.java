import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class newuserlogin extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><body bgcolor=skyblue><center><h4>Human Resource Management System</h4></center> <h1><center> New User Registration Form </center></h1>");
  out.println("<title> HRMS</title>  <form method=get action='http://localhost:8080/servlet/usersreg'>");
  out.println("  <table border=0 align=center>  <tr><td>User Name</td><td><input type=text name=t1></td></tr>");
  out.println("  <tr><td>Password </td><td><input type=password name=t2></td></tr>  <tr><td>Sex </td><td><input type=text name=t3></td></tr>");
  out.println("  <tr><td>Date of birth </td><td><input type=text name=t4></td></tr>  <tr><td>Address </td><td><textarea rows=5 cols=20 name=t5></textarea></td></tr>");
  out.println("  <tr><td>City </td><td><input type=text name=t6></td></tr>  <tr><td>Country </td><td><input type=text name=t7></td></tr>");
  out.println("  <tr><td>Qualification </td><td><input type=text name=t8></td></tr>  <tr><td>Skills summary </td><td><textarea rows=5 cols=20 name=t9></textarea></td></tr>");
  out.println("  <tr><td>Phone </td><td><input type=text name=t10></td></tr>  <tr><td>Email </td><td><input type=text name=t11></textarea></td></tr>");
  out.println("  <tr><td>Email1 </td><td><input type=text name=t12></textarea></td></tr>  <tr><td colspan=2 align=center><input type=submit value='submit'></td></tr>");
  out.println("  </table>");
  out.println("  <br><center><b><a href='http://localhost:8080/servlet/home'><strong><font size=-1><b>Back</b></font></strong></a></center></form></body></html>");
 }
}