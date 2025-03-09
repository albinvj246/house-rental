/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import Entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
/**
 *
 * @author Piyush
 */
@WebServlet(name = "EditUserProfile", urlPatterns = {"/EditUserProfile"})
public class EditUserProfile extends HttpServlet {

    User u = new User();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        u.setFname(request.getParameter("fname"));
        u.setLname(request.getParameter("lname"));
        u.setEmail(request.getParameter("email"));
        u.setUsername(request.getParameter("username"));
        u.setGender(request.getParameter("gender"));
        u.setAddress(request.getParameter("address"));
        u.setCity(request.getParameter("city"));
        u.setMobile(request.getParameter("mobile"));
Connection connection = null;
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","Albin##123");
            PreparedStatement pst = connection.prepareStatement("update userregister set fname = ? , lname = ? ,email = ?, mobile = ? , gender = ? ,  address = ?, city = ?   where username = '" + u.getUsername() + "' ");
            pst.setString(1, u.getFname());
            pst.setString(2, u.getLname());
            pst.setString(5, u.getGender());
            pst.setString(7, u.getCity());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getMobile());
            pst.setString(6, u.getAddress());

            int i = pst.executeUpdate();
            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Update Successfully..!');");
                pw.println("window.location.href = \"UserHome.jsp\";");
                pw.println("</script>");
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Not-Update try again Later..!!!');");
                pw.println("window.location.href = \"UserHome.jsp\";");
                pw.println("</script>");
            }

        } catch (ClassNotFoundException | SQLException e) {
        }

    }
}
