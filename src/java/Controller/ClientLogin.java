/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin_piyush
 */
@WebServlet(name = "ClientLogin", urlPatterns = {"/ClientLogin"})
public class ClientLogin extends HttpServlet {

    private String user;
    private String pass;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
         Connection connection = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","Albin##123");
            String username = request.getParameter("login");
            String password = request.getParameter("password");

            String s = "select fname,username,password,mobile from clientregister";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {
                String fname = rs.getString(1);
                String mob = rs.getString(4);
                user = rs.getString(2);
                pass = rs.getString(3);

                if (username.equals(user) && password.equals(pass)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("fname", fname);
                    session.setAttribute("username", username);
                    session.setAttribute("mobile",mob);
                    pw.println("<script type=\"text/javascript\">");
                   // pw.println("alert('Login Successfully..!');");
                    pw.println("window.location.href = \"Home.jsp\";");
                    pw.println("</script>");                   
                }
            }
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Username or Password is Incorrect..!');");
            pw.println("window.location.href = \"clientLogin.jsp\";");
            pw.println("</script>");

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
