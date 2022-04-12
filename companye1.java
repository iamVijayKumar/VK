import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class companye1 extends HttpServlet 
{

   String s1=""; 
   int a=0;

   public void doGet(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException {

       PrintWriter pw=res.getWriter();

       s1=req.getParameter("xx");

       a=Integer.parseInt(s1);

       pw.println("<html><body bgcolor=skyblue text=black ><font size=5>");

       if(a==1)
       {
         res.sendRedirect("http://localhost:8080/servlet/comp1");
       }

       if(a==2)
        {
res.sendRedirect("http://localhost:8080/servlet/compdelete");
/*          pw.println("<form method=get action='http://localhost:8080/servlet/compdelete'>");
          pw.println("<input type=text name=t1>");
         // pw.println("<input type=text name=t1>");
          pw.println("<input type=submit value='submit'>");
          pw.println("</form>");*/
       }
       if(a==3)
       {
          pw.println("<form method=get action='http://localhost:8080/servlet/compedit'>");
          pw.println("<br><br><br><br><center><pre>Enter Company Name to Edit <input type=text name=t1></pre>");
          pw.println("<br><br><input type=submit value='submit'></center>");
          pw.println("</form>");
          
       }
       if(a==4)
       {
          res.sendRedirect("http://localhost:8080/servlet/compview");
       }
       pw.println("<style>a{color:black}</style><center><h4><a href='http://localhost:8080/servlet/companye'>BACK</a></h4></center>");

   }
   }


         

