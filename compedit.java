import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class compedit extends HttpServlet {

  String s1=""; String s2="";
  String ss1="";
  int a=0;

  Connection c8;
  Statement stt;
  ResultSet rs1;
  String t1;
  int tno;
  String Division;

  

  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {
      
      
      
        t1=req.getParameter("t1");
       // tno=Integer.parseInt(req.getParameter("t1"));
        PrintWriter pw=res.getWriter();
        //pw.println(tno);
        try{
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          c8=DriverManager.getConnection("jdbc:odbc:hrms","","");
         stt=c8.createStatement();
         rs1=stt.executeQuery("select *from company where cname="+"'"+t1+"'");
         rs1.next();
         pw.println("<html>");
         pw.println("<body bgcolor=skyblue><h3><center>Edit Company</center></h3><form method=post action='http://localhost:8080/servlet/compedit'>");
         pw.println("<table border=0 cellpadding=5 cellsapceing=5 align=center>");
         pw.println("<td>Company name<td><input type=text name=cname value="+ rs1.getString(1)+"><tr>");
         pw.println("<td>Company address<td><input type=text name=caddress value="+rs1.getString(2)+"><tr>");
         pw.println("<td>country<td><input type=text name=country value="+rs1.getString(3)+"><tr>");
         pw.println("<td>city <td><input type=text name=city value="+rs1.getString(4)+"><tr>");
         pw.println("<td>area<td><input type=text name=area value="+rs1.getString(5)+"><tr>");
         pw.println("<td>phone<td><input type=text name=phone value="+rs1.getInt(6)+"><tr>");
         pw.println("<td>email<td><input type=text name=email value="+rs1.getString(7)+"><tr>");
         pw.println("<td>url<td><input type=text name=url value="+rs1.getString(8)+"><tr>");
         pw.println("<td>mname<td><input type=text name=mname value="+rs1.getString(9)+"><tr>");
         pw.println("<td>year of start<td><input type=text name=yos value="+rs1.getString(10)+"><tr>");
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
        
        String cname=req.getParameter("cname");
        String caddress=req.getParameter("caddress");
        String country=req.getParameter("country");
        String city=req.getParameter("city");
        String area=req.getParameter("area");
        String phone1=req.getParameter("phone");
        int phone=Integer.parseInt(phone1);
        String email=req.getParameter("email");
        String url=req.getParameter("url");
        String mname=req.getParameter("mname");
        String yos=req.getParameter("yos");
        
        try
         {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          con1=DriverManager.getConnection("jdbc:odbc:hrms","","");
          st=con1.createStatement();
         String test1="UPDATE company SET cname ="+"'"+cname+"'"+",address="+"'"+caddress+"'"+",country="+"'"+country+"'"+",city="+"'"+city+"'"+",area="+"'"+area+"'"+",phone="+"'"+phone+"'"+",email="+"'"+email+"'"+",url="+"'"+url+"'"+",mname="+"'"+mname+"'"+",yos="+"'"+yos+"'"+" where cname="+"'"+cname+"'";
         //pw.println(test1);
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
         pw.println("<br><br><br><a href='http://localhost:8080/servlet/companye'>BACK</a></center>");
         pw.println("</body></html>");
       }
     }










