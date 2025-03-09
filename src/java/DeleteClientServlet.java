import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteClientServlet")
public class DeleteClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientId = request.getParameter("clientId");
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house", "root", "Albin##123");
            statement = connection.createStatement();
            String sql = "DELETE FROM clientregister WHERE id = " + clientId;
            int result = statement.executeUpdate(sql);

            if (result > 0) {
                response.sendRedirect("ViewClients.jsp?message=Client+deleted+successfully");
            } else {
                response.sendRedirect("ViewClients.jsp?error=Unable+to+delete+client");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ViewClients.jsp?error=An+error+occurred");
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
