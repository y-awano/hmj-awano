<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="biz.KeizibanBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean class= "biz.KeizibanBean" id="List" scope="request" />
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

<%=KeizibanBean ke = request.getAttribute("KeizibanBean");

for(int i=1;i<=ke.length;i++){
	  System.out.println(ke[i]);
	}
%>


<!--for(int i=1;i<=ke.length;i++){

}  -->
  </body>
</html>