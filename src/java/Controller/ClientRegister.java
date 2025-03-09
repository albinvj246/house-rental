/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ClientRegister", urlPatterns = {"/ClientRegister"})
public class ClientRegister extends HttpServlet {

    Client user;

    public ClientRegister() {
        this.user = new Client();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter pw = response.getWriter();
        user.setFname(request.getParameter("fname"));
        user.setLname(request.getParameter("lname"));
        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setGender(request.getParameter("gender"));
        user.setAddress(request.getParameter("address"));
        user.setCity(request.getParameter("city"));
        user.setMobile(request.getParameter("mobile"));

        //String flag = request.getParameter("check");
        //response.getWriter().println(flag);
        //response.getWriter().println(user);
         Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","Albin##123");
            PreparedStatement pst = connection.prepareStatement("insert into clientregister(fname,lname,email,mobile,gender,username,password,address,city) values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, user.getFname());
            pst.setString(2, user.getLname());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getMobile());
            pst.setString(5, user.getGender());
            pst.setString(6, user.getUsername());
            pst.setString(7, user.getPassword());
            pst.setString(8, user.getAddress());
            pst.setString(9, user.getCity());
            int i = pst.executeUpdate();
            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Register Successfully..!');");
                pw.println("window.location.href = \"index.html\";");
                pw.println("</script>");
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Enter Valid Details and try again Later..!!!');");
                pw.println("window.location.href = \"ClientRegister.jsp\";");
                pw.println("</script>");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientRegister.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
