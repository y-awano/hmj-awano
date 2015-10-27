package biz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Databasetest extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

    	response.setContentType("text/html; charset=UTF-8");
    	request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>データベーステスト</title>");
        out.println("</head>");
        out.println("<body>");

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root";

        try {

        	 Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password);
            String namae =(String)request.getParameter("name");
            String msg =(String)request.getParameter("msg");

            Statement stmt = conn.createStatement();
            String sqlinsert = "insert into test.samplekeizban(name,posting_context) values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlinsert);
            pstmt.setString(1, namae);
            pstmt.setString(2, msg);
            pstmt.executeUpdate();

            String sql = "SELECT name,posting_date,posting_context FROM test.samplekeizban";
            ResultSet rs = stmt.executeQuery(sql);
//            ArrayList<String> ar = new ArrayList<String>();
            ArrayList<KeizibanBean>  list  =  new  ArrayList<KeizibanBean>();


            while(rs.next()){



            	KeizibanBean  kei  =  new  KeizibanBean();
            	  kei.setName(rs.getString("name"));
            	  kei.setPosting_date(rs.getString("posting_date"));
            	  kei.setPosting_context( rs.getString("posting_context"));
            	  System.out.println(rs.getString("name"));
            	  System.out.println(kei);


            	  list.add(kei);

                String name = rs.getString("name");
                String posting_date = rs.getString("posting_date");
                String posting_context = rs.getString("posting_context");
//                ar.add(name,posting_date,posting_context);
                out.println("<p>");
                out.println("名前:" + name + ", 投稿時間:" + posting_date + ", 投稿内容:" + posting_context);
                out.println("</p>");
            }

            ServletContext context = this.getServletContext();

  		  RequestDispatcher dispatcher = context.getRequestDispatcher("/keiziban.jsp");
              		request.setAttribute("KeizibanBean", list);
  		  dispatcher.forward(request,response);

            rs.close();
            stmt.close();

        }catch (ClassNotFoundException e){
            out.println("ClassNotFoundException:" + e.getMessage());
        }catch (SQLException e){
            out.println("SQLException:" + e.getMessage());
        }catch (Exception e){
            out.println("Exception:" + e.getMessage());
        }finally{
            try{
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                out.println("SQLException:" + e.getMessage());
            }
        }

        out.println("</body>");
        out.println("</html>");
    }
}
