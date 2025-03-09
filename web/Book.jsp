<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Booking Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4; /* Background color for the page */
    }
    .container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        background-color: #fff; /* Background color for the container */
    }
    h1 {
        text-align: center;
        color: #333;
    }
    .customer-details, .payment-options, .service-charge {
        margin-bottom: 20px;
        text-align: center; /* Center-aligning text */
    }
    .button-container {
        text-align: center;
    }
    label {
        display: block;
        margin-bottom: 5px;
        color: #333; /* Color for labels */
    }
    input, select {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    .btn {
        display: inline-block;
        background-color: #007bff; /* Button color */
        color: #fff;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
        cursor: pointer; /* Cursor style */
    }
    .btn:hover {
        background-color: #0056b3; /* Button color on hover */
    }
    p {
        color: #007bff; /* Color for service charge */
        font-weight: bold;
    }
      button {
        border: 1px solid #000; /* Set the default border color */
        padding: 10px 20px ; /* Adjust padding as needed */
        background-color: #fff; /* Set the background color */
        margin-bottom: -20px;
        cursor: pointer; /* Change cursor to pointer on hover */
        transition: border-color 0.3s; /* Smooth transition for border color change */
    }

    button:hover {
        border-color: transparent; /* Set border color to transparent on hover */
    }
</style>
</head>

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
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
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
                    <div class="sidebar-brand-text mx-3">${customername}</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->


                <!-- Divider 
                <hr class="sidebar-divider">

                 Heading 
                <div class="sidebar-heading">
                    Interface
                </div>

                 Nav Item - Pages Collapse Menu -->


                <!-- Nav Item - Utilities Collapse Menu
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>Utilities</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header"></h6>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#ProfileModal">
                                Profile
                            </a>
                            <a class="collapse-item" href="">View Clients</a>
                        </div>
                    </div>
                </li>
                 -->

                <!-- Divider -->
                <hr class="sidebar-divider">
                <!-- Heading -->
                <div class="sidebar-heading">
                    Interface
                </div>
                <!-- Nav Item - Pages Collapse Menu -->
                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="SearchHouse.jsp">
                        <i class="fas fa-home"></i>
                        <span>Search House</span></a>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item">
                    <a class="nav-link" href="">
                        <i class="fas fa-home"></i>
                        <span>House Details</span></a>
                </li>
<li class="nav-item">
                    <a class="nav-link" href="feedbackuser.jsp">
                        <i class="fas fa-home"></i>
                        <span>Add Feedback |<br> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; Make Request</span></a>
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
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${customername}</span>
                                    <i class="fas fa-user"></i>
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#ProfileModal">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                

               

<body>
<div class="container">
    <h1>Booking Details</h1>
    <div class="customer-details">
        <h2>Customer Details</h2>
        <!-- Customer details form -->
        <form action="InsertBookingServlet" method="POST">
            <label for="customer_name">Name:</label>
            <input type="text" id="customer_name" name="customer_name"><br>
            <label for="customer_email">Email:</label>
            <input type="email" id="customer_email" name="customer_email"><br>
            <label for="customer_phone">Phone:</label>
            <input type="tel" id="customer_phone" name="customer_phone"><br>
            <label for="customer_otp">OTP:</label>
            <input type="number" id="customer_otp" name="customer_otp"><br>
       
    </div>
     <div class="customer-details">
        <h2>Owner Details</h2>
        <!-- Owner details form -->
            <label for="house_name">House Name:</label>
            <input type="text" id="house_name" name="house_name"><br>
            <label for="owner_phone">House Owner number:</label>
            <input type="number" id="owner_phone" name="owner_phone"><br>
    
        
    </div>
    <div class="payment-options">
        <h2>Payment Options</h2>
        <!-- Payment options -->
        <select id="payment_method" name="payment_method">
            <option value="upi_transfer">UPI Transfer</option>
            <option value="credit_card">Credit Card</option>
            <option value="bank_transfer">Bank Transfer</option>
        </select>
       
        <input type="number" placeholder="ENTER Transfer Number" id="transfer_number" name="transfer_number"><br><br>
        <button id="get_otp_button">Get OTP</button>
        <br><br><input type="number" placeholder="ENTER OTP" id="payment_otp" name="payment_otp"><br>
    </div>
    <div class="service-charge">
        <h2>Service Charge for Admin</h2>
        <!-- Service charge details -->
        <p>Rs.20</p>
    </div>
    <div class="button-container">
        <!-- Submit button -->
        <button id="submit" name="submit">Confirm Booking</button>
    </div>
</div>
                    </form>

</body>
</html>
