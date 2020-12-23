
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    <title>Restaurant Management System</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- <meta http-equiv="refresh" content="1"> -->

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Bree+Serif&display=swap" rel="stylesheet">


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/form-style.css">
</head>
<section class="fnavbar">
    <div class="navbar-fixed">
        <nav>
            <div class="nav-wrapper">
                <a href="#" class="brand-logo">RestroGirls</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="/RestroGirls" class="hvr-grow">Home</a></li>
                    <li><a href="/RestroGirls/about-restro-girls.php" class="hvr-grow">About Us</a></li>
                    <li><a href="food-categories.php" class="hvr-grow">Categories</a></li>
                    <li><a href="foods.php" class="hvr-grow">Foods</a></li>
                    <li><a href="#" class="hvr-grow" onclick="toggleModal('Contact Info', 'You can contact us directly by calling to this number +81-225-314-3456. Check the bottom Footer Section of the website for more info.');">Contact</a></li>

                    <li><a href="#" class="hvr-grow">Hi</a></li>
                    <li><a href="logout.jsp" class="hvr-grow">Logout</a></li>
                    <li><a href="login.jsp" class="hvr-grow modal-trigger" data-target="modal1">Login</a></li>
                    <li><a href="register.jsp" class="hvr-grow modal-trigger" data-target="modal2">Register</a></li>

                </ul>
            </div>
        </nav>
    </div>

    <ul class="sidenav" id="mobile-demo">
        <li><a href="/RestroGirls">Home</a></li>
        <li><a href="/RestroGirls/about-restro-girls.php">About Us</a></li>
        <li><a href="food-categories.php">Categories</a></li>
        <li><a href="foods.php">Foods</a></li>
        <li><a href="#" onclick="toggleModal('Contact Info', 'You can contact us directly by calling to this number +81-225-314-3456. Check the bottom Footer Section of the website for more info.');">Contact</a></li>

        <li><a href="#">Hi</a></li>
        <li><a href="logout.php">Logout</a></li>
        <li><a href="#" class="modal-trigger" data-target="modal1">Login</a></li>
        <li><a href="register.jsp" class="modal-trigger" data-target="modal2">Register</a></li>

    </ul>
</section>
