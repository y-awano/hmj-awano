<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="biz.KeizibanBean"%>


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
<jsp:useBean id="list" class="biz.KeizibanBean" scope="request"/>
<%
for(int i=0; i < list.size(); i++){
String str = (String) list.get( i );
out.println( i + ":" + str + "\n" + "\n");
}
%>



  </body>
</html>