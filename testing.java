import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
public class testing extends HttpServlet
{
 Connection con; 
 public void doGet(HttpServletRequest re,HttpServletResponse rs) throws IOException,ServletException
  {
    rs.setContentType("text/html");
    PrintWriter out=rs.getWriter();
    Statement s=null,s1=null;
    ResultSet r=null,r2=null; 
    double a1;
    a1=java.lang.Math.random();
    a1=a1*1000;
    int a2=(int)a1;
    int a3=a2%4;
    a3=a3+1;
    Integer a4=new Integer(a3);
    HttpSession hs=re.getSession(true);
    hs.putValue("key",a4); 
    try
     {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       con=DriverManager.getConnection("jdbc:odbc:hrms");
       s=con.createStatement();
       s1=con.createStatement();
       r=s.executeQuery("select * from questions where [sno]="+a3);
       r2=s1.executeQuery("select * from choice where [qno]="+a3);	
      /* while(r2.next())
        {
          out.println(r2.getString(2));
           out.println(r2.getString(3));
          out.println(r2.getString(4));
          out.println(r2.getString(5));
        }

       while(r.next())
       {
          out.println(r.getString(2));
          out.println(r.getString(3));
          out.println(r.getString(4));
          out.println(r.getString(5));
          out.println(r.getString(6));
          out.println(r.getString(7));
          out.println(r.getString(8));
       }*/
       r.next();
       r2.next();       
       out.println("<html><body bgcolor=skyblue><br><h2><center>QUESTIONS</center></h2>");
       out.println("<form method=post action='http://localhost:8080/servlet/results'>");
      
       String c1,c2,c3,c4;
       c1=r2.getString(2);
       //out.println(c1);
       c2=r2.getString(3);
       c3=r2.getString(4);
       c4=r2.getString(5);
       out.println("<br><br><h3>1."+r.getString(2)+"</h3>");
       out.println("<input type=radio name=q1 value="+"'"+c1+"'"+">"+c1);
       out.println("<input type=radio name=q1 value="+"'"+c2+"'"+">"+c2);
       out.println("<input type=radio name=q1 value="+"'"+c3+"'"+">"+c3);
       out.println("<input type=radio name=q1 value="+"'"+c4+"'"+">"+c4);
       r2.next();

       c1=r2.getString(2);
       c2=r2.getString(3);
       c3=r2.getString(4);
       c4=r2.getString(5);
       out.println("<br><br><h3>2."+r.getString(3)+"</h3>");
       out.println("<input type=radio name=q2 value="+"'"+c1+"'"+">"+c1);
       out.println("<input type=radio name=q2 value="+"'"+c2+"'"+">"+c2);
       out.println("<input type=radio name=q2 value="+"'"+c3+"'"+">"+c3);
       out.println("<input type=radio name=q2 value="+"'"+c4+"'"+">"+c4);
       r2.next();

       c1=r2.getString(2);
       c2=r2.getString(3);
       c3=r2.getString(4);
       c4=r2.getString(5);
       out.println("<br><br><h3>3."+r.getString(4)+"</h3>");
       out.println("<input type=radio name=q3 value="+"'"+c1+"'"+">"+c1);
       out.println("<input type=radio name=q3 value="+"'"+c2+"'"+">"+c2);
       out.println("<input type=radio name=q3 value="+"'"+c3+"'"+">"+c3);
       out.println("<input type=radio name=q3 value="+"'"+c4+"'"+">"+c4);
       r2.next();

       c1=r2.getString(2);
       c2=r2.getString(3);
       c3=r2.getString(4);
       c4=r2.getString(5);
       out.println("<br><br><h3>4."+r.getString(5)+"</h3>");
       out.println("<input type=radio name=q4 value="+"'"+c1+"'"+">"+c1);
       out.println("<input type=radio name=q4 value="+"'"+c2+"'"+">"+c2);
       out.println("<input type=radio name=q4 value="+"'"+c3+"'"+">"+c3);
       out.println("<input type=radio name=q4 value="+"'"+c4+"'"+">"+c4);
       r2.next();

       c1=r2.getString(2);
       c2=r2.getString(3);
       c3=r2.getString(4);
       c4=r2.getString(5);
       out.println("<br><br><h3>5."+r.getString(6)+"</h3>");
       out.println("<input type=radio name=q5 value="+"'"+c1+"'"+">"+c1);
       out.println("<input type=radio name=q5 value="+"'"+c2+"'"+">"+c2);
       out.println("<input type=radio name=q5 value="+"'"+c3+"'"+">"+c3);
       out.println("<input type=radio name=q5 value="+"'"+c4+"'"+">"+c4);
       r2.next();

       c1=r2.getString(2);
       c2=r2.getString(3);
       c3=r2.getString(4);
       c4=r2.getString(5);
       out.println("<br><br><h3>6."+r.getString(7)+"</h3>");
       out.println("<input type=radio name=q6 value="+"'"+c1+"'"+">"+c1);
       out.println("<input type=radio name=q6 value="+"'"+c2+"'"+">"+c2);
       out.println("<input type=radio name=q6 value="+"'"+c3+"'"+">"+c3);
       out.println("<input type=radio name=q6 value="+"'"+c4+"'"+">"+c4);
       r2.next();

       c1=r2.getString(2);
       c2=r2.getString(3);
       c3=r2.getString(4);
       c4=r2.getString(5);
       out.println("<br><br><h3>7."+r.getString(8)+"</h3>");
       out.println("<input type=radio name=q7 value="+"'"+c1+"'"+">"+c1);
       out.println("<input type=radio name=q7 value="+"'"+c2+"'"+">"+c2);
       out.println("<input type=radio name=q7 value="+"'"+c3+"'"+">"+c3);
       out.println("<input type=radio name=q7 value="+"'"+c4+"'"+">"+c4);
       //r2.next();
       
       out.println("<br><br><br><center><input type=submit value=send></center>");
       out.println("</form></body></html>");
     }
    catch(SQLException sqle)
     {
      out.println(sqle);
     }
    catch(ClassNotFoundException cnfe)
     {
      out.println(cnfe);
     }
    try
    {
     s.close();s1.close();r2.close();r.close();
    }
    catch(SQLException sqle1)
    {
     out.println(sqle1);
    } 
  }
}
   