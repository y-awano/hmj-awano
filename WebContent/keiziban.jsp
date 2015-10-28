<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="biz.KeizibanBean"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.Iterator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean class="java.util.ArrayList" id="KeizibanBean" scope="request" />
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>

    <h1>掲示板</h1>

<%
request.setCharacterEncoding("utf-8");
%>


    <form action="Databasetest" method="GET">
        <input name="name" type="text">
        <input name="msg" type="text">
        <input type="submit">
    </form>
<hr>

<%ArrayList list= (ArrayList) request.getAttribute("KeizibanBean"); %>
<%
for(int i=0; i < KeizibanBean.size(); i++){
String str = (String) KeizibanBean.get( i );
out.println( i + ":" + str + "\n" + "\n");
}

%>

  </body>
</html>