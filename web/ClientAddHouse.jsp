<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>House Registration</title>
        <style>
            body { 
                background: url(img/i2.jpg) no-repeat center center fixed; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
            .regform{
                padding: 20px;
                margin: 20px;
                background-color: #transparent;


            }
            .Cheadline{
                color: hotpink;
                display: flex;
                align-items: center;
                justify-content: center;
                font-style: italic;
                font-size: 30px;
            }
            label{
                color: white;
                font-size: 18px;
                font-style: italic;
                font-family: cursive;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm navbar-light" style="background-color: #e3f2fd;">
            <a class="navbar-brand" href="Home.jsp">House-Renting</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav ml-auto" style="margin-right: 20px;">
                    <a class="nav-item nav-link active" href="ClientAddHouse.jsp">Add House</a>
                    <a class="nav-item nav-link active" href="HouseDetails.jsp">House Details</a> 
                    <a class="nav-item nav-link active" href="clientLogin.jsp">LogOut</a> 
                </div>
            </div>
        </nav>
        <br><br>
        <div class="Cheadline">
            <%
                HttpSession sess = request.getSession(false);
                sess.getAttribute("fname");
            %>
            <br><h1> Add House Details</h1>
        </div>
            <br><br>
<div class="container">
        <section class="regform">
            <form action="<%=request.getContextPath()%>/AddHouse" enctype="multipart/form-data" method="post">
                <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="validationServer01">House name</label>
                <input type="text" class="form-control" name="hname" id="validationServer01" placeholder="House name" required>
            </div>
            <div class="col-md-4 mb-3">
                <label for="validationServer02">Category</label>
                <input type="text" class="form-control" name="category" id="validationServer02" placeholder="Category" required>
            </div>
            <div class="col-md-3 mb-2">
                <label for="validationServer04">Bedroom</label>
                <input type="text" class="form-control" name="bedroom" id="validationServer04" placeholder="Bedroom" required>
            </div>
            <div class="col-md-4 mb-3">
                <label for="validationServer02">Email</label>
                <input type="text" class="form-control" name="email" id="validationServer02" placeholder="Email" required>
            </div>
            <div class="col-md-3 mb-3">
                <label for="validationServer04">City</label>
                <input type="text" class="form-control" name="city" id="validationServer04" placeholder="City" required>
            </div>
            <div class="col-md-2 mb-3">
                <label for="validationServer05">Mobile</label>
                <input type="text" class="form-control" name="mobile" id="validationServer05" placeholder="Mobile" required>
            </div>
            <div class="col-md-2 mb-3">
                <label for="validationServer03">Price</label>
                <input type="text" class="form-control" name="price" id="validationServer03" placeholder="Price" required>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationServer03">Address</label>
                <input type="text" class="form-control" name="address" id="validationServer03" placeholder="Address" required>
            </div>
            <div class="col-md-6 mb-3">
                <label for="validationServer03">Description</label>
                <input type="text" class="form-control" name="description" id="validationServer03" placeholder="Description" required>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-3 mb-4">
                <label for="validationServer04">House Image</label>
                <input type="file" class="form-control" id="validationServer03" name="photo" required>
            </div>
        </div>
                 <div class="form-row">
            <div class="col-md-3 mb-4">
                <label for="validationServer04">Availability</label>
                <select class="form-control" name="availcheck" id="availcheck" required>
                    <option value="">Choose...</option>
                    <option value="available">Available</option>
                    <option value="not_available">Not Available</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="check" id="invalidCheck3" required>
                <label class="form-check-label" for="invalidCheck3">
                    Agree to terms and conditions
                </label>
            </div>
        </div>
        <button class="btn btn-primary" type="submit">Submit form</button>
    </form>
        </section>
</div>
   <style>
  .form-label {
            font-weight: bold;
            color: #000; /* Black color */
        }
        .container {
            background: rgba(0, 0, 0, 0.5); /* Transparent background */
            padding: 30px;
            border-radius: 10px;
            border: 2px solid #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease-in-out;
        }
        .container:hover {
            transform: scale(1.02);
            box-shadow: 0 0 30px rgba(0, 0, 0, 0.2);
        }
        .container h2 {
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }
        .btn-primary {
            background: #007bff;
            border: none;
            transition: background 0.3s ease-in-out;
        }
        .btn-primary:hover {
            background: #0056b3;
        }
        input[type="text"], input[type="file"], input[type="checkbox"] {
            transition: all 0.3s ease-in-out;
        }
        input[type="text"]:focus, input[type="file"]:focus, input[type="checkbox"]:focus {
            border-color: #007bff;
            box-shadow: 0 0 10px rgba(0, 123, 255, 0.5);
        }
    </style>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>