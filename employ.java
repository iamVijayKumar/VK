import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class employ extends HttpServlet {


   public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {

        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");      
        pw.println("<html><head><style>a{color:black}</style></head><body align=center bgcolor=skyblue text=black><br><br><br><center>");
        pw.println("<font size=5>");
        
        pw.println("<a href=http://localhost:8080/servlet/employ1?xx=1><B>Add EmployeeDetails<b></a><Br>");
        pw.println("<a href=http://localhost:8080/servlet/employ1?xx=2><B>Delete EmployeeDetails<b></a><Br>");
        pw.println("<a href=http://localhost:8080/servlet/employ1?xx=3><B>Edit EmployeeDetails<b></a><Br>");
        pw.println("<a href=http://localhost:8080/servlet/employ1?xx=4><B>View EmployeeDetails<b></a><Br>");
pw.println("<br><br><a href=http://localhost:8080/servlet/amodule><h5>BACK</h5></a></center></body>");
                pw.println("</html>");
     }
     }



