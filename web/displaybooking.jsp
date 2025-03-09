<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   <%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Client Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">${AdminName}</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->


                <!-- Divider 
                <hr class="sidebar-divider">

                <!-- Heading 
                <div class="sidebar-heading">
                    Interface
                </div>

                 Nav Item - Pages Collapse Menu -->


                <!-- Nav Item - Utilities Collapse Menu 
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>Utilities</span>
                    </a>-->
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header"></h6>
                            <a class="collapse-item" href="AdminDashboard.jsp">Home</a>
                            <a class="dropdown-item" href="AdminLogin.jsp" data-toggle="modal" data-target="#logoutModal">
                                Logout
                            </a>
                            <a class="collapse-item" href="">----</a>
                            <a class="collapse-item" href="">----</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">
                <!-- Heading -->
                <div class="sidebar-heading">
                    Interface
                </div>
                 <li class="nav-item">
                    <a class="nav-link" href="AdminDashboard.jsp">
                        <i class="fas fa-user"></i>
                        <span>Home</span></a>
                </li>
                <!-- Nav Item - Pages Collapse Menu -->
                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="ViewClients.jsp">
                        <i class="fas fa-home"></i>
                        <span>Clients</span></a>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item">
                    <a class="nav-link" href="ViewUsers.jsp">
                        <i class="fas fa-home"></i>
                        <span>Users</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ViewHouses.jsp">
                        <i class="fas fa-home"></i>
                        <span>Houses</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="displaybooking.jsp">
                        <i class="fas fa-home"></i>
                        <span>Booking's</span></a>
                </li>
<li class="nav-item">
                    <a class="nav-link" href="adminFeedback.jsp">
                        <i class="fas fa-home"></i>
                        <span>Review Feedback's</span></a>
                </li>
                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column" style="background: url(img/i2.jpg) no-repeat center center fixed; background-size: cover; -o-background-size: cover; -moz-background-size: cover; -webkit-background-size: cover;">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->
                        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>                         

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${AdminName}</span>
                                    <i class="fas fa-user"></i>
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#ProfileModal">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="AdminLogin.jsp" ">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav><title>Admin Feedback Page</title>
<style>


.feedback-table {
    flex: 1; /* Let the tables grow flexibly */
    background-color: #ffffff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow-x: auto; /* Allow horizontal scrolling if needed */
    margin-left:  -20%; /* Add space between tables */
    width: 140%; /* Set width of table container */
}

table {
    width: calc(100% - 40px); /* Occupy full width of parent minus padding */
    margin-bottom: 20px;
    border-collapse: collapse;
    white-space: nowrap; /* Prevent text wrapping */
}

table,
th,
td {
    border: 1px solid #dee2e6;
    padding: 12px;
    text-align: left;
   /* overflow: hidden; /* Hide overflow content 
    text-overflow: ellipsis; /* Display ellipsis for overflow content */
}

th {
    background-color: #343a40;
    color: #ffffff;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

tr:hover {
    background-color: #e9ecef;
}

h2,
h3 {
    color: #343a40;
}


    </style>
</head>
<body>
    <div class="container">
        <font color="white" ><b><h1 class="text-center">BOOKING DETAILS</h1></font></b>
       
            <div class="feedback-table">
             
                <table>
                    <tr>
                        <th>CUSTOMER_ID</th>
                        <th>CUSTOMER_Name</th>
                        <th>CUSTOMER_Email</th>
                        <th>CUSTOMER_PHONE</th>
                        <th>HOUSE_NAME</th>
                        <th>OWNER_PHONE</th>
                        <th>PAYMENT_METHOD</th>
                        <th>TRANSFER_NUMBER</th>
                    </tr>
                    <%
                        // Database connection and data retrieval for client feedback
                        Connection connection = null;
                        Statement statement = null;
                        ResultSet resultSet = null;

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house", "root", "Albin##123");
                            statement = connection.createStatement();
                            resultSet = statement.executeQuery("SELECT * FROM booking_details");

                            while (resultSet.next()) {
                                int id = resultSet.getInt("booking_id");
                                String name = resultSet.getString("customer_name");
                                String email = resultSet.getString("customer_email");
                                String phone = resultSet.getString("customer_phone");
                                String house = resultSet.getString("house_name");
                                String ophone = resultSet.getString("owner_phone");
                                String payment = resultSet.getString("payment_method");
                                String transfer = resultSet.getString("transfer_number");
                    %>
                    <tr>
                        <td><%= id %></td>
                        <td><%= name %></td>
                        <td><%= email %></td>
                        <td><%= phone %></td>
                        <td><%= house %></td>
                        <td><%= ophone %></td>
                        <td><%= payment %></td>
                        <td><%= transfer %></td>
                    </tr>
                    <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
                            if (statement != null) try { statement.close(); } catch (SQLException e) { e.printStackTrace(); }
                            if (connection != null) try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
                        }
                    %>
                </table>
            </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
