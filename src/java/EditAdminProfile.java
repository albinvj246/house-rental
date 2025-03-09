

import Entity.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditAdminProfile", urlPatterns = {"/EditAdminProfile"})
public class EditAdminProfile extends HttpServlet {

    Admin adm = new Admin();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        adm.setFname(request.getParameter("fname"));
        adm.setLname(request.getParameter("lname"));
        adm.setEmail(request.getParameter("email"));
        adm.setUsername(request.getParameter("username"));
        adm.setGender(request.getParameter("gender"));
        adm.setAddress(request.getParameter("address"));
        adm.setCity(request.getParameter("city"));
        adm.setMobile(request.getParameter("mobile"));
Connection connection = null;
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","Albin##123");
            PreparedStatement pst = connection.prepareStatement("update adminlogin set fname = ? , lname = ? ,email = ?, mobile = ? , gender = ? ,  address = ?, city = ?   where username = '" + adm.getUsername() + "' ");
            pst.setString(1, adm.getFname());
            pst.setString(2, adm.getLname());
            pst.setString(5, adm.getGender());
            pst.setString(7, adm.getCity());
            pst.setString(3, adm.getEmail());
            pst.setString(4, adm.getMobile());
            pst.setString(6, adm.getAddress());

            int i = pst.executeUpdate();
            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Update Successfully..!');");
                pw.println("window.location.href = \"AdminDashboard.jsp\";");
                pw.println("</script>");
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Not-Update try again Later..!!!');");
                pw.println("window.location.href = \"AdminDashboard.jsp\";");
                pw.println("</script>");
            }

        } catch (ClassNotFoundException | SQLException e) {
        }
        
        
    }

}
