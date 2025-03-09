import Entity.feedbackc;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class submitFeedbackuser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final feedbackc adm = new feedbackc();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        // Retrieve form parameters and set them to the feedback object
        adm.setname(request.getParameter("name"));
        adm.setEmail(request.getParameter("email"));
        adm.setfeedback(request.getParameter("feedback"));

        Connection connection = null;
        PreparedStatement pst = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house", "root", "Albin##123");
            // Prepare the SQL statement
            pst = connection.prepareStatement("INSERT INTO feedbackuser(name, email, feedback) VALUES (?, ?, ?)");

            // Set the parameters for the prepared statement
            pst.setString(1, adm.getname());
            pst.setString(2, adm.getEmail());
            pst.setString(3, adm.getfeedback());

            // Execute the update
            int i = pst.executeUpdate();
            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Submitted successfully!');");
                pw.println("window.location.href = \"UserHome.jsp\";");
                pw.println("</script>");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(submitFeedback.class.getName()).log(Level.SEVERE, null, ex);
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Submission failed. Please try again later.');");
            pw.println("window.location.href = \"UserHome.jsp\";");
            pw.println("</script>");
        } finally {
            // Close resources
            try {
                if (pst != null) pst.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(submitFeedback.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
