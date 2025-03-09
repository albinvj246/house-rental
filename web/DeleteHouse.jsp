<%-- 
    Document   : DeleteHouse
    Created on : 3 Sep, 2020, 9:59:05 AM
    Author     : Admin
--%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete House Details</title>
    </head>
    <body>
        <%
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
            Connection connection = null;
            Statement stmt = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","Albin##123");
            stmt = (Statement) con.createStatement();
            String query = "delete from  addhouse " + "where id = '" + id + "'";
            stmt.executeUpdate(query);
            con.close();
            RequestDispatcher rd = request.getRequestDispatcher("HouseDetails.jsp");
            rd.forward(request, response);
        %>
    </body>
</html>
