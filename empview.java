import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class empview extends HttpServlet {

   Connection c4;
   Statement st;
   ResultSet rs;
   String s1="";
   String ss1="";


   public void init(ServletConfig sc) throws ServletException
  {
    try
    {

       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       c4=DriverManager.getConnection("jdbc:odbc:hrms","","");
     }
     catch(Exception ee4){}
   }

   public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {

         PrintWriter pw=res.getWriter();

         //s1=req.getParameter("s1");

         try{

         st=c4.createStatement();

         ss1="select * from employee";

         rs=st.executeQuery(ss1);

         pw.println("<html><body bgcolor=skyblue><h4><style>a{color:black}</style></h4><br><center><h2>Employee Details</h2></center><br>");
         pw.println("<table border=2 align=center>");
         pw.println("<tr><th>Employee No</th><th>E name</th><th>Email</th><th>Quali</th><th>Ccexp</th><th>Pcexp</th><th>Bgroup</th><th>DOB</th><th>JobCode </th><th>JobNature</th><th>Mstatus</th><th>Reference</th><th>Paddress</th><th>Peradd</th></tr>");
         int temp=0;
         while(rs.next())
          {
                   temp=1;
                   pw.println("<tr><td>" +rs.getInt(1) +"</td><td>" +rs.getString(2)+"</td><td>" +rs.getString(3) +"</td><td>" +rs.getString(4) +"</td><td>" +rs.getString(5) +"</td><td>" +rs.getString(6) +"</td><td>" +rs.getString(7) +"</td><td>" +rs.getString(8) +"</td><td>" +rs.getInt(9) +"</td><td>" +rs.getString(10) +"</td><td>" +rs.getString(11) +"</td><td>" +rs.getString(12) +"</td><td>" +rs.getString(13) +"</td><td>" +rs.getString(14) +"</td></tr>");
          }

         pw.println("</table>");
         pw.println("<br><br>");
         pw.println("<br><br><center><a href='http://localhost:8080/servlet/employ'>BACK</a></center><br><br>");
         if(temp==0)
           pw.println("NO DATA FOUND");
         

         }catch(SQLException ee1) {pw.println(ee1);}

}
}


         
