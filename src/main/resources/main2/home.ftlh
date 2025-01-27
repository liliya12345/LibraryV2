<!DOCTYPE html>
<html>
<head>
    <title>Bibliotek</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<#--    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">-->
<#--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">-->
<#--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">-->
<#--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->
<#--    <style>-->
<#--        .w3-sidebar a {-->
<#--            font-family: "Roboto", sans-serif-->
<#--        }-->

<#--        .buttop {-->
<#--            background: #f44336;-->
<#--        }-->

<#--        .demo-container {-->
<#--            margin: 4em auto;-->
<#--            max-width: 900px;-->
<#--        }-->

<#--        .demo-container .btn-search {-->
<#--            margin-left: -20px;-->
<#--            border-bottom-left-radius: 0;-->
<#--            border-top-left-radius: 0;-->
<#--        }-->

<#--        .demo-container .btn-search::before {-->
<#--            content: "\f002";-->
<#--            font-family: FontAwesome;-->
<#--            color: #FFFFFF;-->
<#--            float: left;-->
<#--        }-->

<#--        .demo-container .search-input {-->
<#--            padding-right: 40px;-->
<#--            border-right: 0;-->
<#--            border-left: 0;-->
<#--            border-radius: 0;-->
<#--            width: 100px;-->
<#--            outline: none !important;-->
<#--            outline: 0 !important;-->
<#--        }-->

<#--        .demo-container .form-select {-->
<#--            border-bottom-right-radius: 0;-->
<#--            border-top-right-radius: 0;-->
<#--            width: 80px;-->
<#--            background-color: #F0F0F0;-->
<#--            outline: none !important;-->
<#--            outline: 0 !important;-->
<#--        }-->

<#--        .demo-container textarea:focus,-->
<#--        .demo-container input[type="search"]:focus,-->
<#--        .demo-container input[type="submit"]:focus,-->
<#--        .demo-container .form-select:focus,-->
<#--        .demo-container .btn:focus {-->
<#--            border-color: rgba(208, 212, 218, 0.9);-->
<#--            box-shadow: none !important;-->
<#--            outline: 0 none !important;-->
<#--        }-->

<#--        body, h1, h2, h3, h4, h5, h6, .w3-wide {-->
<#--            font-family: "Montserrat", sans-serif;-->
<#--        }-->
<#--    </style>-->
</head>
<body class="w3-content" style="max-width:1200px">
<#--<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar">-->
<#--    <div class="w3-container w3-display-container w3-padding-16">-->
<#--        <i onclick="" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>-->
<#--        <h3 class="w3-wide"><b>Biblio</b></h3>-->
<#--    </div>-->

<#--    <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">-->
<#--        <a href="#" class="w3-bar-item w3-button">Books</a>-->
<#--        <a onclick="" href="" class="w3-button w3-block w3-white w3-left-align" id="myBtn">-->
<#--            Media <i class="fa fa-caret-down"></i>-->
<#--        </a>-->
        <#list categories as category>
            <a href="/hello/${category.id}" class="w3-bar-item w3-button">${category.id}</a>
        </#list>
    </div>


<#--</nav>-->
<#--<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">-->
<#--    <div class="w3-bar-item w3-padding-24 w3-wide">LOGO</div>-->
<#--    <a href="" class="w3-bar-item w3-button w3-padding-24 w3-right"><i-->
<#--                class="fa fa-bars"></i></a>-->
<#--</header>-->
<#--<div class="w3-overlay w3-hide-large" style="cursor:pointer" title="close side menu"-->
<#--     id="myOverlay"></div>-->

<#--<!-- !PAGE CONTENT! &ndash;&gt;-->
<#--<div class="w3-main" style="margin-left:250px">-->
<#--    <div class="w3-hide-large" style="margin-top:83px"></div>-->

<#--    <!-- Top header &ndash;&gt;-->
<#--    <header class="w3-container w3-xlarge">-->
<#--        <p class="w3-left">Books</p>-->
<#--        <a href="/login" class="fa fa-user w3-right w3-padding-large"></a>-->
<#--    </header>-->
<#--    <div class="w3-display-container w3-container">-->
<#--        &lt;#&ndash;        <img src="https://img.freepik.com/premium-photo/rustic-vintage-bookstore-filled-with-shelves-old-books-nostalgic-cozy-highquality-realistic_1310094-36304.jpg"&ndash;&gt;-->
<#--        &lt;#&ndash;             alt="library" style="width:100%">&ndash;&gt;-->
<#--        <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">-->
<#--            <h1 class="w3-jumbo w3-hide-small">Aktuella evenemang</h1>-->
<#--            <h1 class="w3-hide-large w3-hide-medium">Se alla evenemang</h1>-->
<#--            <h1 class="w3-hide-small">SpråkCafe</h1>-->
<#--            <p><a href="#jeans" class="w3-button buttop  w3-padding-large w3-large">MER INFO</a></p>-->
<#--        </div>-->
<#--    </div>-->
<#--    <div class="w3-container w3-text-grey" id="jeans">-->
<#--        <p>${size} items </p>-->
<#--    </div>-->
    <div >
        <div >
            <div >
                <#list books as book>
                    <div>
<#--                        <img src="/images/${book.id}" style="width: 200px; height: 300px">-->
                        <p>${book.title}<br> ${book.authorFirstName} <br>${book.authorLastName}
                            <b>${book.description}</b></p>
                    </div>
                </#list>
            </div>
        </div>


<#--    </div>-->
<#--</div>-->
</body>
</html>

