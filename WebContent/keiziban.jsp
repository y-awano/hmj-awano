<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>

    <h1>掲示板</h1>

    <form action="Databasetest" method="GET">
        <input name="name" type="text">
        <input name="msg" type="text">
        <input type="submit">
    </form>

   <%
      String msg = (String)session.getAttribute("message");
      if (msg == null || msg.equals("")) {
        out.println("<br/>※お名前を入力ください。<br/>");
      } else {
        out.println("<br/><h3>" + msg + "</h3><br/>");
      }
    %>

  </body>
</html>