
import Controller.ClientRegister;
import Entity.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AdminRegister", urlPatterns = {"/AdminRegister"})
public class AdminRegister extends HttpServlet {

    Admin adm = new Admin();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        adm.setFname(request.getParameter("fname"));
        adm.setLname(request.getParameter("lname"));
        adm.setUsername(request.getParameter("username"));
        adm.setPassword(request.getParameter("password"));
        adm.setEmail(request.getParameter("email"));
        adm.setMobile(request.getParameter("mobile"));
        adm.setGender(request.getParameter("gender"));
        adm.setAddress(request.getParameter("address"));
        adm.setCity(request.getParameter("city"));
 Connection connection = null;
        try {

                        Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","Albin##123");
            PreparedStatement pst = connection.prepareStatement("insert into adminlogin(username, password,fname,lname,email,mobile,gender,address,city) values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, adm.getUsername());
            pst.setString(2, adm.getPassword());
            pst.setString(3, adm.getFname());
            pst.setString(4, adm.getLname());
            pst.setString(5, adm.getEmail());
            pst.setString(6, adm.getMobile());
            pst.setString(7, adm.getGender());            
            pst.setString(8, adm.getAddress());
            pst.setString(9, adm.getCity());
            int i = pst.executeUpdate();
            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Register Successfully..!');");
                pw.println("window.location.href = \"AdminLogin.jsp\";");
                pw.println("</script>");
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Enter Valid Details and try again Later..!!!');");
                pw.println("window.location.href = \"AdminRegister.jsp\";");
                pw.println("</script>");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
