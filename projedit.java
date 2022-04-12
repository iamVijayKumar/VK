import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class projedit extends HttpServlet {

  String s1=""; String s2="";
  String ss1="";
  int a=0;

  Connection con;
  Statement st;
  ResultSet rs;
  int tno;
  String Division;

  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {

        tno=Integer.parseInt(req.getParameter("t1"));
        PrintWriter pw=res.getWriter();
        try{
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          con=DriverManager.getConnection("jdbc:odbc:hrms","","");
         st=con.createStatement();
         rs=st.executeQuery("select * from projectm where pcode="+tno);
         rs.next();
         pw.println("<html>");
         pw.println("<body bgcolor=skyblue><h3><center>Project Edit</center></h3><form method=post action='http://localhost:8080/servlet/projedit'>");
         pw.println("<table border=0 cellpadding=5 cellsapceing=5 align=center>");
         pw.println("<td>Project No<td><input type=text name=pno value="+ rs.getInt(1)+"><tr>");
         pw.println("<td>Project Category<td><input type=text name=ptype value="+rs.getString(2)+"><tr>");
         pw.println("<td>Project place<td><input type=text name=pplace value="+rs.getString(3)+"><tr>");
         pw.println("<td>Client name <td><input type=text name=cname value="+rs.getString(4)+"><tr>");
         pw.println("<td>Client nature<td><input type=text name=cnature value="+rs.getString(5)+"><tr>");
         pw.println("<td>Project name<td><input type=text name=pname value="+rs.getString(6)+"><tr>");
         pw.println("<td>Project area<td><input type=text name=parea value="+rs.getString(7)+"><tr>");
         pw.println("<td>Project sdate<td><input type=text name=psdate value="+rs.getString(8)+"><tr>");
         pw.println("<td>Project edate<td><input type=text name=pedate value="+rs.getString(9)+"><tr>");
         pw.println("</table><br><center><input type=submit value=Submit></center></form></body></html>");
         st.close();
         con.close();
        }
         catch(SQLException se)
         {
          pw.println("Ex(GET) "+ se);
         }
      catch(ClassNotFoundException cnf)
         {
          pw.println("Ex(GET) "+ cnf);
         }
     }

     public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
        PreparedStatement pr;
        res.setContentType("text/html");
        Connection con1;
        Statement st;
        PrintWriter pw=res.getWriter();
        int pno=Integer.parseInt(req.getParameter("pno"));
        //pw.println(teno);
        String ptype=req.getParameter("ptype");
        String pplace=req.getParameter("pplace");
        String cname=req.getParameter("cname");
        String cnature=req.getParameter("cnature");
        String pname=req.getParameter("pname");
        String parea=req.getParameter("parea");
        String psdate=req.getParameter("psdate");
        String pedate=req.getParameter("pedate");
        try
         {
         con1=DriverManager.getConnection("jdbc:odbc:hrms","","");
         st=con1.createStatement();
         String test1="UPDATE projectm SET pcode ="+"'"+pno+"'"+",pcat="+"'"+ptype+"'"+",pplace="+"'"+pplace+"'"+",cname="+"'"+cname+"'"+",cnature="+"'"+cnature+"'"+",pname="+"'"+pname+"'"+",parea="+"'"+parea+"'"+",psdate="+"'"+psdate+"'"+",pedate="+"'"+pedate+"'"+" where pcode="+pno;
         //pw.println(test1);
         st.executeUpdate(test1); 
          }
         catch(SQLException se)
          {
           pw.println("Ex(POST) "+ se);
          }
         pw.println("<html><body bgcolor=skyblue><br><br><br><center><h1>");
         pw.println("Record Updated </h1>");
         pw.println("<br><br><br><a href='http://localhost:8080/servlet/projm'>BACK</a></center>");
         pw.println("</body></html>");
       }
     }

