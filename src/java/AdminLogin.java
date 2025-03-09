

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet(name = "AdminLogin", urlPatterns = {"/AdminLogin"})
public class AdminLogin extends HttpServlet {
    private String user;
    private String pass;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
    String username = request.getParameter("login");
    String password = request.getParameter("password");
    PrintWriter pw = response.getWriter();
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","Albin##123");
            String s = "select id,username,password,fname from adminlogin";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(s);
            boolean loggedIn = false;
            while (rs.next()) {
                int id = rs.getInt(1);
                user = rs.getString(2);
                pass = rs.getString(3);
                String name = rs.getString(4);

                if (username.equals(user) && password.equals(pass)) {
                    HttpSession adminSession = request.getSession();
                    adminSession.setAttribute("AdminUsername", user);
                    adminSession.setAttribute("AdminID", id);
                    adminSession.setAttribute("AdminName", name); 
                    pw.println("<script type=\"text/javascript\">");
                   // pw.println("alert('Login Successfully..!');");
                    pw.println("window.location.href = \"AdminDashboard.jsp\";");
                    pw.println("</script>");
                    loggedIn = true;
                    break;
                }
            }
            if (!loggedIn) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Username or Password is Incorrect..!');");
                pw.println("window.location.href = \"AdminLogin.jsp\";");
                pw.println("</script>");
            }
         else {
            // Database connection failed
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Database connection failed. Please try again later.');");
            pw.println("window.location.href = \"AdminLogin.jsp\";");
            pw.println("</script>");
        }
           
        }
        catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace(); // Print the stack trace to standard error
    pw.println("<script type=\"text/javascript\">");
    pw.println("alert('An error occurred while processing your request. Please try again later.');");
    pw.println("window.location.href = \"AdminLogin.jsp\";");
    pw.println("</script>");
}

    }
}