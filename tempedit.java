import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class tempedit extends HttpServlet {

  String s1=""; String s2="";
  String ss1="";
  int a=0;

  Connection c8;
  Statement stt;
  ResultSet rs1;
  int tno;
  String Division;

  

  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {
      
      
      

        tno=Integer.parseInt(req.getParameter("t1"));
        PrintWriter pw=res.getWriter();
        //pw.println(tno);
        try{
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          c8=DriverManager.getConnection("jdbc:odbc:hrms","","");
         stt=c8.createStatement();
         rs1=stt.executeQuery("select *from temployee where ecode="+tno);
         rs1.next();
         pw.println("<html>");
         pw.println("<body bgcolor=skyblue><form method=post action='http://localhost:8080/servlet/tempedit'>");
         pw.println("<table border=0 cellpadding=5 cellsapceing=5 align=center>");
         pw.println("<td>Employee No<td><input type=text name=ecode1 value="+ rs1.getInt(1)+"><tr>");
         pw.println("<td>Emp name <td><input type=text name=ename value="+rs1.getString(2)+"><tr>");
         pw.println("<td>Email<td><input type=text name=email value="+rs1.getString(3)+"><tr>");
         pw.println("<td>Job Code <td><input type=text name=jcode value="+rs1.getInt(4)+"><tr>");
         pw.println("<td>Train Category<td><input type=text name=tcategory value="+rs1.getString(5)+"><tr>");
         pw.println("<td>Train place<td><input type=text name=tplace value="+rs1.getString(6)+"><tr>");
         pw.println("<td>Train SDate<td><input type=text name=tsdate value="+rs1.getString(7)+"><tr>");
         pw.println("<td>Train EDate<td><input type=text name=tedate value="+rs1.getString(8)+"><tr>");
         pw.println("<td>Train Person<td><input type=text name=tperson value="+rs1.getString(9)+"><tr>");
         pw.println("</table><br><center><input type=submit value=Submit></center></form></body></html>");
         rs1.close();
         stt.close();
         c8.close();
        }
         catch(SQLException se)
         {
          pw.println("Ex(GET) "+ se);
         }
        catch(ClassNotFoundException se2)
          {
           pw.println("Ex(GET) "+ se2);
          }
     }

     public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
        
      
       
        PreparedStatement pr;
        res.setContentType("text/html");
        Connection con1;
        Statement st;
        
        PrintWriter pw=res.getWriter();
        
        String ecode1=req.getParameter("ecode1");
        int ecode=Integer.parseInt(ecode1);
        String ename=req.getParameter("ename");
        String email=req.getParameter("email");
        String jcode1=req.getParameter("jcode");
        int jcode=Integer.parseInt(jcode1); 
        String tcategory=req.getParameter("tcategory");
        String tplace=req.getParameter("tplace");
        String tsdate=req.getParameter("tsdate");
        String tedate=req.getParameter("tedate");
        String tperson=req.getParameter("tperson");
        
        try
         {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          con1=DriverManager.getConnection("jdbc:odbc:hrms","","");
          st=con1.createStatement();
         String test1="UPDATE temployee SET ecode ="+"'"+ecode+"'"+",ename="+"'"+ename+"'"+",email="+"'"+email+"'"+",jcode="+"'"+jcode+"'"+",tcategory="+"'"+tcategory+"'"+",tplace="+"'"+tplace+"'"+",tsdate="+"'"+tsdate+"'"+",tedate="+"'"+tedate+"'"+",tperson="+"'"+tperson+"'"+" where ecode="+ecode;
        // pw.println(test1);
         st.executeUpdate(test1); 
          }
         catch(SQLException se)
          {
           pw.println("Ex(POST) "+ se);
          }
         catch(ClassNotFoundException se1)
          {
           pw.println("Ex(POST) "+ se1);
          }
          pw.println("<html><body bgcolor=skyblue><br><br><br><center><h1>");
         pw.println("Record Updated </h1>");
         pw.println("<br><br><br><a href='http://localhost:8080/servlet/tempemploy'>BACK</a></center>");
         pw.println("</body></html>");
       }
     }










