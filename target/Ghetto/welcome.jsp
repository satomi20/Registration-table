<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.12.2021
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@page import="controller.User"%>
<%@ page import="controller.UserDatabase" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("logUser");
    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome Page</title>
</head>
<body>
<h1> Welcome,  %></h1>
<h3>Your Account ID: <%= user.getId() %> </h3>
<h3>Your Email: <%= user.getEmail() %> </h3>
<h3>Your Password: <%= user.getPassword() %></h3>

<button><a href="LogoutServlet">Log Out</a></button>
</body>
</html>