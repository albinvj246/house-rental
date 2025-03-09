/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.House;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddHouse", urlPatterns = {"/AddHouse"})
@MultipartConfig(maxFileSize = 16177216)
public class AddHouse extends HttpServlet {

    House house;
    InputStream inputStream = null;

    public AddHouse() {
        this.house = new House();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

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
        Part filePart = request.getPart("photo");
 Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","Albin##123");
            PreparedStatement ps = connection.prepareStatement("insert into addhouse(hname,category,bedroom,email,city,mobile,address,descr,photo,price,availcheck) values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, house.getHname());
            ps.setString(2, house.getCategory());
            ps.setString(3, house.getBedroom());
            ps.setString(4, house.getEmail());
            ps.setString(5, house.getCity());
            ps.setString(6, house.getMobile());
            ps.setString(7, house.getAddress());
            ps.setString(8, house.getDescription());
            inputStream = filePart.getInputStream();
            ps.setBlob(9, inputStream);
            ps.setString(10, house.getPrice());
            ps.setString(11, house.getavailcheck());
            int i = ps.executeUpdate();

            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('House Add Sucessfully');");
                pw.println("window.location.href = \"Home.jsp\";");
                pw.println("</script>");
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Error...!!!!Try Again Later..');");
                pw.println("window.location.href = \"ClientAddHouse.jsp\";");
                pw.println("</script>");
            }

        } catch (ClassNotFoundException | SQLException e) {

        }
    }

}
