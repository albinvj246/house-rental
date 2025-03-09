/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import Controller.ClientLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import java.sql.DriverManager;
/**
 *
 * @author Admin
 */
@WebServlet(name = "CustomerLogin", urlPatterns = {"/CustomerLogin"})
public class CustomerLogin extends HttpServlet {

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

            String s = "select id, fname,username,password from UserRegister";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {
                int id = rs.getInt(1);
                String fname = rs.getString(2);
                user = rs.getString(3);
                pass = rs.getString(4);

                if (username.equals(user) && password.equals(pass)) {
                    HttpSession csession = request.getSession();
                    csession.setAttribute("customername", fname);
                    csession.setAttribute("customerusername", username);
                    csession.setAttribute("customerid", id);
                    pw.println("<script type=\"text/javascript\">");
                   // pw.println("alert('Login Successfully..!');");
                    pw.println("window.location.href = \"UserHome.jsp\";");
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
