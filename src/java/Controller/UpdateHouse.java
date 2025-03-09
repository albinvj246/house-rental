/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.House;
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
 * @author Admin
 */
@WebServlet(name = "UpdateHouse", urlPatterns = {"/UpdateHouse"})
public class UpdateHouse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        //response.getWriter().println(request.getParameter("id"));

        House house = new House();
        house.setId(Integer.parseInt(request.getParameter("id")));
        house.setHname(request.getParameter("hname"));
        house.setCategory(request.getParameter("category"));
        house.setBedroom(request.getParameter("bedroom"));
        house.setEmail(request.getParameter("email"));
        house.setCity(request.getParameter("city"));
        house.setMobile(request.getParameter("mobile"));
        house.setAddress(request.getParameter("address"));
        house.setDescription(request.getParameter("description"));
        house.setPrice(request.getParameter("price"));
         house.setavailcheck(request.getParameter("availcheck"));
        //response.getWriter().println(house);
        

Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","Albin##123");
            PreparedStatement pst = con.prepareStatement("update addhouse set hname = ? , category = ? , bedroom=? , email = ?,city = ?, mobile = ? ,address = ?, descr = ? , price = ? , availcheck = ? where id = '" + house.getId() + "' ");
            pst.setString(1, house.getHname());
            pst.setString(2, house.getCategory());
            pst.setString(3, house.getBedroom());
            pst.setString(4, house.getEmail());
            pst.setString(5, house.getCity());
            pst.setString(6, house.getMobile());
            pst.setString(7, house.getAddress());
            pst.setString(8, house.getDescription());
            pst.setString(9, house.getPrice());
            pst.setString(10, house.getavailcheck());
            int i = pst.executeUpdate();
            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Update Successfully..!');");
                pw.println("window.location.href = \"Home.jsp\";");
                pw.println("</script>");
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Not-Update try again Later..!!!');");
                pw.println("window.location.href = \"UpdateHouse.jsp\";");
                pw.println("</script>");
            }

        } catch (ClassNotFoundException | SQLException e) {
        }
    }

}
