import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
public class results extends HttpServlet
{
 Connection c=null; 
 int rcode1;
 public void doPost(HttpServletRequest re,HttpServletResponse rs) throws IOException,ServletException
  {
    rs.setContentType("text/html");
    PrintWriter out=rs.getWriter();
    int mark=0,temp=0,rcode;
    try
     {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       c=DriverManager.getConnection("jdbc:odbc:hrms");
       Statement s=c.createStatement();
       Statement s1=c.createStatement();
       Statement st1=c.createStatement();
       Statement st=c.createStatement();
       HttpSession hp=re.getSession(true);
       Integer in=(Integer)hp.getValue("key");
       int no=in.intValue();
      // String a="SELECT answers.[no], answers.a1, answers.a2, answers.a3, answers.a4, answers.a5, answers.a6, answers.a7 FROM answers WHERE (((answers.[no])="+no+"))";
       String a="select *from answers where [no]="+no;
       //out.println(a);
       ResultSet r=st.executeQuery(a);
       //out.println(r.next());
      /* while(r.next())
       {
        out.println(r.getString(2));
        out.println(r.getString(3));
        out.println(r.getString(4));
        out.println(r.getString(5));
        out.println(r.getString(6));
        out.println(r.getString(7));
        out.println(r.getString(8));
       }*/
       HttpSession hs=re.getSession(true);
       String a1=re.getParameter("q1");
       //out.println(a1);
       String a2=re.getParameter("q2");
       //out.println(a2);
       String a3=re.getParameter("q3");
       //out.println(a3);
       String a4=re.getParameter("q4");
       //out.println(a4);
       String a5=re.getParameter("q5");
       //out.println(a5);
       String a6=re.getParameter("q6");
       //out.println(a6);
       String a7=re.getParameter("q7");
       //out.println(a7);
       while(r.next())
       {
        if(a1.equalsIgnoreCase(r.getString(2)))
          mark=mark+1;
        if(a2.equalsIgnoreCase(r.getString(3)))
          mark=mark+1;
        if(a3.equalsIgnoreCase(r.getString(4)))
          mark=mark+1;
        if(a4.equalsIgnoreCase(r.getString(5)))
          mark=mark+1;
        if(a5.equalsIgnoreCase(r.getString(6)))
          mark=mark+1;
        if(a6.equalsIgnoreCase(r.getString(7)))
          mark=mark+1;
        if(a7.equalsIgnoreCase(r.getString(8)))
          mark=mark+1;
       }
     // out.println(mark);
      if(mark>5)
       {
         String name=(String)hs.getValue("username");
         String pass=(String)hs.getValue("password");
         ResultSet rs1=st.executeQuery("select * from rdirect");
            while(rs1.next())
               {
                  temp=1;
                  break;
               }
               if(temp==1)
                {
                  rs1=st1.executeQuery("select max(rcode) from rdirect");                 
                  while(rs1.next())
                    { 
                        rcode1=rs1.getInt(1);
                        rcode1=rcode1+1;
                    }
                }
             else
               {
                rcode1=1;
               }
         s1.executeUpdate("insert into rdirect values("+rcode1+",'"+name+"','"+pass+"',"+mark+")");  
         out.println("<html>");
         out.println("<center><body bgcolor=skyblue><center><br><br><br>");
         out.println("<h3>CONGRATS! YOU ARE SELECTED</h3></body></center>");
         out.println("<br><br>Please contact us in the following address<br>");
         out.println("<br>Hindustan Software Limited<br>");
         out.println("No.120 Wallajah Road,<br>");
         out.println("Triplicane, Chennai-2");
         out.println("<br><br><a href='http://localhost:8080/servlet/home'><h4>BACK</h4></a></center>");
       }  
      else
       {
         out.println("<html>");
         out.println("<center><body bgcolor=skyblue><center><br><br><br>");
         //out.println("<h2 align=center>");
         out.println("<h3>SORRY YOU ARE NOT SELECTED. BETTER LUCK NEXT TIME</h3></body></center>");
         out.println("<br><br><a href='http://localhost:8080/servlet/home'><h4>BACK</h4></a></center>");
       }
       
     }
    catch(SQLException sqle)
     {
      out.println(sqle);
     }
    catch(ClassNotFoundException cnfe)
     {
      out.println(cnfe);
     }
  }
}
   