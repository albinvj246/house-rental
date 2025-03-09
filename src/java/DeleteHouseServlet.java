import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteHouseServlet")
public class DeleteHouseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String houseId = request.getParameter("houseId");

       if (houseId != null && !houseId.isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house", "root", "Albin##123")) {
                    String sql = "DELETE FROM addhouse WHERE id = ?";
                    try (PreparedStatement ps = connection.prepareStatement(sql)) {
                        ps.setString(1, houseId);
                        ps.executeUpdate();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Optionally, set an error message in request scope to display on the JSP page
                request.setAttribute("errorMessage", "Error deleting house: " + e.getMessage());
                request.getRequestDispatcher("ViewHouses.jsp").forward(request, response);
                return;
            }
        }

        response.sendRedirect("ViewHouses.jsp");
    }
}
