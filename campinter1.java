import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class campinter1 extends HttpServlet
{
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws ServletException,IOException
 {
  rs.setContentType("text/html");
  PrintWriter out=rs.getWriter();
  out.println("<html><head><title></title><style>a{color:black}</style>");
  out.println("</HEAD><BODY bgcolor=skyblue text=black><font face=Verdana>");
  out.println("<form name=us  method=post action='http://localhost:8080/servlet/campinter'>");
  out.println("<center><h2>Campus Interview</h2><br><table><tr>");
  out.println("<td><font face=Verdana size=-1><b> Recruitment Code</td>");
  out.println("<td><font face=Verdana size=-1><b><input type=text name=t1></td>");
  out.println("<td><font face=Verdana size=-1><b>Name</td>");
  out.println("<td><font face=Verdana size=-1><b><input type=text name=t2></td></tr>");
  out.println("<tr><td><font face=Verdana size=-1><b>College Name</td>");
  out.println("<td><font face=Verdana size=-1><b>  <input type=text name=t3></td>");
  out.println("<td><font face=Verdana size=-1><b>College Address</td><td><font face=Verdana size=-1><b><input type=text name=t4></td>");
  out.println("</tr><tr><td><font face=Verdana size=-1><b>Date of Interview</td>");
  out.println("<td><font face=Verdana size=-1><b>");
  out.println("  <Select name=date>");
  out.println("  <option name=1>1");
  out.println("  <option name=2>2");
  out.println("  <option name=3>3");
  out.println("  <option name=4>4");
  out.println("  <option name=5>5");
  out.println("  <option name=6>6");
  out.println("  <option name=7>7");
  out.println("  <option name=8>8");
  out.println("  <option name=9>9");
  out.println("  <option name=10>10");
  out.println("  <option name=11>11");
  out.println("  <option name=12>12");
  out.println("  <option name=13>13");
  out.println("  <option name=14>14");
  out.println("  <option name=15>15");
  out.println("  <option name=16>16");
  out.println("  <option name=17>17");
  out.println("  <option name=18>18");
  out.println("  <option name=19>19");
  out.println("  <option name=20>20");
  out.println("  <option name=21>21");
  out.println("  <option name=22>22");
  out.println("  <option name=23>23");
  out.println("  <option name=24>24");
  out.println("  <option name=25>25");
  out.println("  <option name=26>26");
  out.println("  <option name=27>27");
  out.println("  <option name=28>28");
  out.println("  <option name=29>29");
  out.println("  <option name=30>30");
  out.println("  <option name=31>31");
  out.println("  </select>");
  out.println("  <select name=mon>");
  out.println("  <option name=1 value=jan>Jan"); 
  out.println("  <option name=2 value=feb>Feb");
  out.println("  <option name=3 value=mar>Mar");
  out.println("  <option name=4 value=apr>Apr");
  out.println("  <option name=5 value=may>May");
  out.println("  <option name=6 value=jun>jun");
  out.println("  <option name=7 value=jly>Jly");
  out.println("  <option name=8 value=aug>Aug");
  out.println("  <option name=9 value=sep>Sep");
  out.println("  <option name=10 value=oct>Oct");
  out.println("  <option name=11 value=nov>Nov");
  out.println("  <option name=12 value=dec>Dec");
  out.println("  </select>");
  out.println("  <select name=year>");
  out.println("  <option name=1 value=2000>2000");
  out.println("  <option name=2 value=2001>2001");
  out.println("  <option name=3 value=2002>2002");
  out.println("  <option name=4 value=2003>2003");
  out.println("  <option name=5 value=2004>2004");
  out.println("  <option name=6 value=2005>2005");
  out.println("  </select>");
  out.println("<td><font face=Verdana size=-1><b>Performance</td>");
  out.println("       <td><font face=Verdana size=-1><b><select name='t6'>");
  out.println("        <option value='Very Good'>Very Good</option>        <option value='Good'>Good</option>");
  out.println("        <option value='Bad'>Bad</option>");
  out.println("         </select></td></tr><tr>");
  out.println("<td><font face=Verdana size=-1><b> Placement Area</td>");
  out.println("<td><font face=Verdana size=-1><b><input type=text name=t7></td>");
  out.println("<td><font face=Verdana size=-1><b>Area of Training </td>");
  out.println("<td><font face=Verdana size=-1><b><input type=text name=t8></td>");
  out.println("</tr><tr> <td><font face=Verdana size=-1><b>Reference By </td>");
  out.println("<td><font face=Verdana size=-1><b><input type=text name=t9></td></tr></table><br>");
  out.println(" <input type=submit name=send value=Send>  <input type=reset name=submit value=Cancel> &nbsp;&nbsp;<br><br><a href='http://localhost:8080/servlet/recruitment'><font size=-1><b>Back</b></font></a>");
  out.println("</center></form></body></html>");
 }
}













