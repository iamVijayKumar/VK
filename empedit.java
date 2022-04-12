import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class empedit extends HttpServlet {

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
         rs1=stt.executeQuery("select *from employee where ecode="+tno);
         rs1.next();
         pw.println("<html>");
         pw.println("<body bgcolor=skyblue><center><h4><b>Edit Employee</b></h4></center><form method=post action='http://localhost:8080/servlet/empedit'>");
         pw.println("<table border=0 cellpadding=5 cellsapceing=5 align=center>");
         pw.println("<td>Employee No<td><input type=text name=ecode1 value="+ rs1.getInt(1)+"><tr>");
         pw.println("<td>Emp name Category<td><input type=text name=ename value="+rs1.getString(2)+"><tr>");
         pw.println("<td>Email<td><input type=text name=email value="+rs1.getString(3)+"><tr>");
         pw.println("<td>Qualification <td><input type=text name=quali value="+rs1.getString(4)+"><tr>");
         pw.println("<td>Exp<td><input type=text name=ccexp value="+rs1.getString(5)+"><tr>");
         pw.println("<td>Previous Exp<td><input type=text name=pcexp value="+rs1.getString(6)+"><tr>");
         pw.println("<td>BGroup<td><input type=text name=bgroup value="+rs1.getString(7)+"><tr>");
         pw.println("<td>Dob<td><input type=text name=dob value="+rs1.getString(8)+"><tr>");
         pw.println("<td>Jcode<td><input type=text name=jcode value="+rs1.getInt(9)+"><tr>");
         pw.println("<td>Jnature<td><input type=text name=jnature value="+rs1.getString(10)+"><tr>");
         pw.println("<td>MStatus<td><input type=text name=mstatus value="+rs1.getString(11)+"><tr>");
         pw.println("<td>Reference<td><input type=text name=ref value="+rs1.getString(12)+"><tr>");
         pw.println("<td>Present Address<td><input type=text name=paddress value="+rs1.getString(13)+"><tr>");
         pw.println("<td>Permanant Add<td><input type=text name=peradd value="+rs1.getString(14)+"><tr>");
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
        String quali=req.getParameter("quali");
        String ccexp=req.getParameter("ccexp");
        String pcexp=req.getParameter("pcexp");
        String bgroup=req.getParameter("bgroup");
        String dob=req.getParameter("dob");
        String jcode1=req.getParameter("jcode");
        int jcode=Integer.parseInt(jcode1);
        String jnature=req.getParameter("jnature");
        String mstatus=req.getParameter("mstatus");
        String ref=req.getParameter("ref");
        String paddress=req.getParameter("paddress");
        String peradd=req.getParameter("peradd");
        try
         {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          con1=DriverManager.getConnection("jdbc:odbc:hrms","","");
          st=con1.createStatement();
         String test1="UPDATE employee SET ecode ="+"'"+ecode+"'"+",ename="+"'"+ename+"'"+",email="+"'"+email+"'"+",quali="+"'"+quali+"'"+",ccexp="+"'"+ccexp+"'"+",pcexp="+"'"+pcexp+"'"+",bgroup="+"'"+bgroup+"'"+",dob="+"'"+dob+"'"+",jcode="+"'"+jcode+"'"+",jnature="+"'"+jnature+"'"+",mstatus="+"'"+mstatus+"'"+",ref="+"'"+ref+"'"+",paddress="+"'"+paddress+"'"+",peradd="+"'"+peradd+"'"+" where ecode="+ecode;
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
         pw.println("<br><br><br><a href='http://localhost:8080/servlet/employ'>BACK</a></center>");
         pw.println("</body></html>");
       }
     }










