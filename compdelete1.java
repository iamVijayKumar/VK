import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class compdelete1 extends HttpServlet {

  String s1=""; String s2="";
  String ss1="";
  int a=0;

  Connection c6;
  Statement st;


  public void init(ServletConfig sc) throws ServletException {
    try{
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       c6=DriverManager.getConnection("jdbc:odbc:hrms","","");
       }catch(Exception ee1) {}
  }

  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {

        PrintWriter pw=res.getWriter();

        
        s2=req.getParameter("t1");
       // a=Integer.parseInt(s2);

        try{

        st=c6.createStatement();
        ss1="delete * from company where cname="+"'"+s2+"'";
                
        st.executeUpdate(ss1);

        //pw.println("deleted");
pw.println("<html><body bgcolor=skyblue><br><br><br><br><br><br>");
        pw.println("<center><h2>Record Deleted</h2><br><br><a href='http://localhost:8080/servlet/companye'>BACK</a></center>");
        }catch(SQLException sqle){pw.println(sqle);}


        }
        }




