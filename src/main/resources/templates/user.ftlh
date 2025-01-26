<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Bibliotek</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .w3-sidebar a {
            font-family: "Roboto", sans-serif
        }

        .buttop {
            background: #f44336;
        }

        .demo-container {
            margin: 4em auto;
            max-width: 600px;
        }

        .demo-container .btn-search {
            margin-left: -20px;
            border-bottom-left-radius: 0;
            border-top-left-radius: 0;
        }

        .demo-container .btn-search::before {
            content: "\f002";
            font-family: FontAwesome;
            color: #FFFFFF;
            float: left;
        }

        .demo-container .search-input {
            padding-right: 40px;
            border-right: 0;
            border-left: 0;
            border-radius: 0;
            outline: none !important;
            outline: 0 !important;
        }

        .demo-container .form-select {
            border-bottom-right-radius: 0;
            border-top-right-radius: 0;
            width: 80px;
            background-color: #F0F0F0;
            outline: none !important;
            outline: 0 !important;
        }

        .card {
            /* Add shadows to create the "card" effect */
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            transition: 0.3s;
        }

        /* On mouse-over, add a deeper shadow */
        .card:hover {
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
        }

        /* Add some padding inside the card container */
        .container {
            padding: 2px 16px;
        }

        #myUL {
            /* Remove default list styling */
            list-style-type: none;
            padding: 0;
            margin: 0;
            visibility: hidden;
        }

        #myUL li a {
            border: 1px solid #ddd; /* Add a border to all links */
            margin-top: -1px; /* Prevent double borders */
            background-color: #f6f6f6; /* Grey background color */
            padding: 12px; /* Add some padding */
            text-decoration: none; /* Remove default text underline */
            font-size: 18px; /* Increase the font-size */
            color: #c37676; /* Add a black text color */
            display: block; /* Make it into a block element to fill the whole list */
        }

        #myUL li a:hover:not(.header) {
            background-color: #eee; /* Add a hover effect to all links, except for headers */
        }

        .form-control:focus {
            #myUL {
                visibility: visible;
            }
        }

        .demo-container textarea:focus,
        .demo-container input[type="search"]:focus,
        .demo-container input[type="submit"]:focus,
        .demo-container .form-select:focus,
        .demo-container .btn:focus {
            border-color: rgba(208, 212, 218, 0.9);
            box-shadow: none !important;
            outline: 0 none !important;

            #myUL {
                visibility: visible;
            }
        }

        .w3-button {
            margin-top: -3px;
        }

        @media only screen and (max-width: 600px) {
            .demo-container .form-select {
                width: 100%;
                margin-bottom: 1em;
            }

            .demo-container .btn-search {
                margin-left: 0;
                margin-top: 1em;
                border-bottom-left-radius: 4px;
                border-top-left-radius: 4px;
                width: 100%;
            }

            .demo-container .search-input {
                padding-right: 0;
                border-right: 1px solid rgba(208, 212, 218, 0.9);
                border-left: 1px solid rgba(208, 212, 218, 0.9);
                border-radius: 4px;
                width: 60%;
                outline: none !important;
                outline: 0 !important;
            }
        }


        body, h1, h2, h3, h4, h5, h6, .w3-wide {
            font-family: "Montserrat", sans-serif;
        }


    </style>
</head>
<body class="w3-content" style="max-width:1200px">

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:1;width:250px;height: 900px"
     id="mySidebar">
    <div class="w3-container w3-display-container w3-padding-16">
        <i onclick="" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
        <h3 class="w3-wide"><b>Biblio</b></h3>
    </div>

    <div class="w3-padding-15 w3-large w3-text-grey" style="font-weight:bold">
        <a href="/" class="w3-bar-item w3-button">Books</a>
        <a onclick="" href="" class="w3-button w3-block w3-white w3-left-align" id="myBtn">
            Media <i class="fa fa-caret-down"></i>
        </a>
        <#--       -->
        <#list categories as category>
            <a href="/books/${category.id}" class="w3-bar-item w3-button">${category.name}</a>
        </#list>
    </div>

</nav>

<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
    <div class="w3-bar-item w3-padding-24 w3-wide">LOGO</div>
    <a href="" class="w3-bar-item w3-button w3-padding-24 w3-right"><i
                class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" style="cursor:pointer" title="close side menu"
     id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

    <!-- Push down content on small screens -->
    <div class="w3-hide-large" style="margin-top:83px"></div>

    <!-- Top header -->
    <header class="w3-container w3-xlarge">
        <p class="w3-left">Books</p>
        <a href="/logout" class=" w3-right w3-padding-large">Logout</a>
        <a href="" class="w3-right w3-padding-large">${user.getFirstName()} ${user.getLastName()}</a>
    </header>

    <!-- Image header -->
    <div class="w3-display-container w3-container">
        <img src="https://img.freepik.com/premium-photo/rustic-vintage-bookstore-filled-with-shelves-old-books-nostalgic-cozy-highquality-realistic_1310094-36304.jpg"
             alt="library" style="width:100%">
        <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">
            <h1 class="w3-jumbo w3-hide-small">Aktuella evenemang</h1>
            <h1 class="w3-hide-large w3-hide-medium">Se alla evenemang</h1>
            <h1 class="w3-hide-small">SpråkCafe</h1>
            <p><a href="#jeans" class="w3-button buttop  w3-padding-large w3-large">MER INFO</a></p>
        </div>
    </div>


</div>
<div class="w3-container w3-text-grey" id="jeans">
    <br>
</div>
<!-- Subscribe section -->
<div class="w3-container w3-black w3-main w3-right" style="width: 930px">
    <h1 class="w3-center">Min sida</h1>

      <div class="card w3-margin">
          <div class="w3-row">
              <div class=" w3-col l6"> <img src="/images/1" alt="Avatar" style="width:40%"> </div>
              <div class=" w3-col l6">
                  <div class="row">
                      <div class=" w3-col l6">
                          <h4>${user.firstName}</h4>
                          <p><h4>${user.lastName}</h4></p>
                          <p><h4>${user.login}</h4></p>
                      </div>
                      <div class=" w3-col l6">
                          <a href="/change_my_profile" type="button" class="  w3-button w3-yellow w3-right w3-margin-top"
                             style="height: 38px"> BYT FIRSTNAME</a>
                      </div>
                  </div>

              </div>
          </div>
          <div class="container">
        <p>
            <p class="">Min lån historik</p>
            <#list info as info>

                ${info.id}.<h4>${info.bookTitle}</h4> från ${info.dateOfLoan} till ${info.dateOfReturn}
                <p>
                    <a href="/lan/${info.user}/${info.bookId}" type="button" class="  w3-button w3-red w3-right w3-margin-left"
                       style="height: 38px">LÅNA OM</a>
                    <a href="/return_book/${info.user}/${info.id}" type="button" class="  w3-button w3-red w3-right w3-margin-left"
                       style="height: 38px"> LÄMNA TILLBAKA</a>
                </p>
                <p>Status <#if info.returned> returned <#else> not returned </#if></p>
            </#list>
        </p>
        </div>
    </div>
    <div class="card">
    </div>
</div>


<!-- Newsletter Modal -->
<div id="newsletter" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
        <div class="w3-container w3-white w3-center">

            class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
            <h2 class="w3-wide">NEWSLETTER</h2>
            <p>Join our mailing list to receive updates on new arrivals and special offers.</p>
            <p><input class="w3-input w3-border" type="text" placeholder="Enter e-mail"></p>
            <button type="button" class="w3-button w3-padding-large w3-red w3-margin-bottom">
                Subscribe
            </button>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function myFunction() {
        // Declare variables
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('myInput');
        filter = input.value.toUpperCase();
        ul = document.getElementById("myUL");
        li = ul.getElementsByTagName('li');

        // Loop through all list items, and hide those who don't match the search query
        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName("a")[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
    }
</script>