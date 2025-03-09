import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/InsertBookingServlet")
public class InsertBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String url = "jdbc:mysql://localhost:3306/house";
    private static final String username = "root";
    private static final String password = "Albin##123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        
        String customerName = request.getParameter("customer_name");
        String customerEmail = request.getParameter("customer_email");
        String customerPhone = request.getParameter("customer_phone");
        String customerOTP = request.getParameter("customer_otp");
        String houseName = request.getParameter("house_name");
        String ownerPhone = request.getParameter("owner_phone");
        String paymentMethod = request.getParameter("payment_method");
        String transferNumber = request.getParameter("transfer_number");
        String paymentOTP = request.getParameter("payment_otp");

        try {
            // Initialize the connection
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertBookingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // SQL query to insert data
            String sql = "INSERT INTO booking_details (customer_name, customer_email, customer_phone, customer_otp, house_name, owner_phone, payment_method, transfer_number, payment_otp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set parameters for the prepared statement
                statement.setString(1, customerName);
                statement.setString(2, customerEmail);
                statement.setString(3, customerPhone);
                statement.setString(4, customerOTP);
                statement.setString(5, houseName);
                statement.setString(6, ownerPhone);
                statement.setString(7, paymentMethod);
                statement.setString(8, transferNumber);
                statement.setString(9, paymentOTP);

                // Execute the query
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    response.getWriter().println("Payment done!''successfully Booked!");
                } else {
                    response.getWriter().println("Failed to insert booking details.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
