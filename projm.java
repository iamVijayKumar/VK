import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class projm extends HttpServlet {


   public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {

        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");      
        pw.println("<html><head><center><h4>Human Resource Management System</h4></center> <style>a{color:black}</style></head><body align=center bgcolor=skyblue text=black><br><br><br><br><br><center>");
        pw.println("<font size=5 color='black'>");
        //pw.println("<pre align=center>")
        pw.println("<a href=http://localhost:8080/servlet/projm1?xx=1><B>Add Project<b></a><Br>");
        pw.println("<a href=http://localhost:8080/servlet/projm1?xx=2><B>Delete Project<b></a><Br>");
        pw.println("<a href=http://localhost:8080/servlet/projm1?xx=3><B>Edit Project<b></a><Br>");
        pw.println("<a href=http://localhost:8080/servlet/projm1?xx=4><B>View Project<b></a><Br>");
        pw.println("<br><br><a href=http://localhost:8080/servlet/amodule><h5>BACK</h5></a></center></body>");
        pw.println("</html>");
     }
     }



