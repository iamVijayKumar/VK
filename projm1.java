import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class projm1 extends HttpServlet 
{

   String s1=""; 
   int a=0;

   public void doGet(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException {

       PrintWriter pw=res.getWriter();

       s1=req.getParameter("xx");

       a=Integer.parseInt(s1);

       pw.println("<html><body bgcolor=skyblue text=black ><style>a{color:black}</style><font size=5>");

       if(a==1)
       {
         res.sendRedirect("http://localhost:8080/servlet/projm2");
       }

       if(a==2)
        {
          pw.println("<form method=get action='http://localhost:8080/servlet/projdelete'>");
          pw.println("<br><br><br><br><center><pre>Enter Project code to delete <input type=text       name=t1></pre><br><br>");
         
         
          pw.println("<input type=submit value='submit'></center>");
          pw.println("</form>");
       }
       if(a==3)
       {
          pw.println("<form method=get action='http://localhost:8080/servlet/projedit'>");
          pw.println("<br><br><br><br><center><pre>Enter Project code to Edit <input type=text name=t1></pre>");
          pw.println("<br><br><input type=submit value='submit'></center>");
          pw.println("</form>");
       }
       if(a==4)
       {
            res.sendRedirect("http://localhost:8080/servlet/projview");
       }
       
      
	pw.println("<h4><center><a href='http://localhost:8080/servlet/projm'>Back</a></center></h4>");
   }
   }


         

