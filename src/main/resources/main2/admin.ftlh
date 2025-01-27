<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!----======== CSS ======== -->


    <!----===== Iconscout CSS ===== -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />

    <title>Admin Panel</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600&display=swap');
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }
        :root{
            /* ===== Colors ===== */
            --primary-color: #0E4BF1;
            --panel-color: #FFF;
            --text-color: #000;
            --black-light-color: #ffffff;
            --border-color: #e6e5e5;
            --toggle-color: #DDD;
            --box1-color: #4DA3FF;
            --box2-color: #FFE6AC;
            --box3-color: #E7D1FC;
            --title-icon-color: #fff;

            /* ====== Transition ====== */
            --tran-05: all 0.5s ease;
            --tran-03: all 0.3s ease;
            --tran-03: all 0.2s ease;
        }
        body{
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            padding: 15px;
            overflow: hidden;
        }
        body.dark{
            --primary-color: #fdfcfc;
            --panel-color: #242526;
            --text-color: #CCC;
            --black-light-color: #CCC;
            --border-color: #fdfcfc;
            --toggle-color: #FFF;
            --box1-color: #ffffff;
            --box2-color: #ffffff;
            --box3-color: #ffffff;
            --title-icon-color: #CCC;
        }
        /* === Custom Scroll Bar CSS === */
        ::-webkit-scrollbar {
            width: 8px;
        }
        ::-webkit-scrollbar-track {
            background: #f1f1f1;
        }
        ::-webkit-scrollbar-thumb {
            background: var(--primary-color);
            border-radius: 12px;
            transition: all 0.3s ease;
        }
        ::-webkit-scrollbar-thumb:hover {
            background: #0b3cc1;
        }
        body.dark::-webkit-scrollbar-thumb:hover,
        body.dark .activity-data::-webkit-scrollbar-thumb:hover{
            background: #ffffff;
        }
        nav{
            background: #1abc9c;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 250px;
            padding: 10px 14px;
            border-right: 1px solid var(--border-color);
            transition: var(--tran-05);
        }
        nav.close{
            width: 73px;
        }
        nav .logo-name{
            display: flex;
            align-items: center;
        }
        nav .logo-image{
            display: flex;
            justify-content: center;
            min-width: 45px;
        }
        nav .logo-image img{
            width: 40px;
            object-fit: cover;
            border-radius: 50%;
        }
        nav .logo-name .logo_name{
            font-size: 22px;
            font-weight: 600;
            color: var(--text-color);
            margin-left: 14px;
            transition: var(--tran-05);
        }
        nav.close .logo_name{
            opacity: 0;
            pointer-events: none;
        }
        nav .menu-items{
            margin-top: 40px;
            height: calc(100% - 90px);
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }
        .menu-items li{
            background: #1abc9c;
            list-style: none;
        }
        .menu-items li a{
            background: #1abc9c;
            display: flex;
            align-items: center;
            height: 50px;
            text-decoration: none;
            position: relative;
        }
        .nav-links li a:hover:before{
            background: #1abc9c;
            content: "";
            position: absolute;
            left: -7px;
            height: 5px;
            width: 5px;
            border-radius: 50%;

        }
        body.dark li a:hover:before{
            background: #1abc9c;

        }
        .menu-items li a i{
            font-size: 24px;
            background: #1abc9c;
            min-width: 45px;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: var(--black-light-color);
        }
        .menu-items li a .link-name{
            font-size: 18px;
            font-weight: 400;
            color: var(--black-light-color);
            transition: var(--tran-05);
        }
        nav.close li a .link-name{
            opacity: 0;
            pointer-events: none;
        }
        .nav-links li a:hover i,
        .nav-links li a:hover .link-name{
            color: var(--primary-color);
        }
        body.dark .nav-links li a:hover i,
        body.dark .nav-links li a:hover .link-name{
            color: var(--text-color);
        }
        .menu-items .logout-mode{
            padding-top: 10px;
            border-top: 1px solid var(--border-color);
        }
        .menu-items .mode{
            display: flex;
            align-items: center;
            white-space: nowrap;
            background: #1abc9c;
        }
        .menu-items .mode-toggle{
            position: absolute;
            right: 14px;
            height: 50px;
            min-width: 45px;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }
        .mode-toggle .switch{
            position: relative;
            display: inline-block;
            height: 22px;
            width: 40px;
            border-radius: 25px;

            background: #1abc9c;
        }
        .switch:before{
            content: "";
            position: absolute;
            left: 5px;
            top: 50%;
            transform: translateY(-50%);
            height: 15px;
            width: 15px;
            background-color: var(--panel-color);
            border-radius: 50%;
            transition: var(--tran-03);
        }
        body.dark .switch:before{
            left: 20px;
        }
        .dashboard{
            position: relative;
            left: 250px;
            background: white;
            min-height: 100vh;
            width: calc(100% - 250px);
            padding: 10px 14px;
            transition: var(--tran-05);
        }
        nav.close ~ .dashboard{
            left: 73px;
            width: calc(100% - 73px);
        }
        .dashboard .top{
            position: fixed;
            top: 0;
            left: 250px;
            display: flex;
            width: calc(100% - 250px);
            justify-content: space-between;
            align-items: center;
            padding: 10px 14px;
            background-color: var(--panel-color);
            transition: var(--tran-05);
            z-index: 10;
        }
        nav.close ~ .dashboard .top{
            left: 73px;
            width: calc(100% - 73px);
        }
        .dashboard .top .sidebar-toggle{
            font-size: 26px;
            color: var(--text-color);
            cursor: pointer;
        }
        .dashboard .top .search-box{
            position: relative;
            height: 45px;
            max-width: 600px;
            width: 100%;
            margin: 0 30px;
        }
        .top .search-box input{
            position: absolute;
            border: 1px solid var(--border-color);
            background-color: var(--panel-color);
            border-radius: 5px;
            color: var(--text-color);
            font-size: 10px;
            font-weight: 400;
            outline: none;
        }
        .top .search-box i{
            position: absolute;
            font-size: 22px;
            z-index: 10;
            transform: translateY(-50%);
            color: var(--black-light-color);
        }
        .top img{
            width: 40px;
            border-radius: 50%;
        }
        .dashboard .dash-content{
            padding-top: 50px;
        }
        .dash-content .title{
            display: flex;
            align-items: center;
            margin: 60px 0 30px 0;
        }
        .dash-content .title i{
            position: relative;
            height: 35px;
            width: 35px;
            background-color: var(--primary-color);
            border-radius: 6px;
            color: var(--title-icon-color);
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
        }
        .dash-content .title .text{
            font-size: 24px;
            font-weight: 500;
            color: var(--text-color);
            margin-left: 10px;
        }
        .dash-content .boxes{
            display: flex;
            align-items: center;
            justify-content: center;
            flex-wrap: wrap;
        }
        .dash-content .boxes .box{
            display: flex;
            flex-direction: column;
            align-items: center;
            border-radius: 12px;
            width: calc(100% / 3 - 100px );
            padding: 15px 10px;
            margin :10px;
            background-color: var(--box1-color);
            transition: var(--tran-05);
        }
        .boxes .box i{
            font-size: 35px;
            color: var(--text-color);
        }
        .boxes .box .text{
            white-space: nowrap;
            font-size: 18px;
            font-weight: 500;
            color: var(--text-color);
        }
        .boxes .box .number{
            font-size: 40px;
            font-weight: 500;
            color: var(--text-color);
        }
        .boxes .box.box2{
            background-color: var(--box2-color);
        }
        .boxes .box.box3{
            background-color: var(--box3-color);
        }
        .dash-content .activity .activity-data{
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%;
        }
        .activity .activity-data{
            display: flex;
        }
        .activity-data .data{
            display: flex;
            flex-direction: column;
            margin: 0 15px;
        }
        .activity-data .data-title{
            font-size: 20px;
            font-weight: 500;
            color: var(--text-color);
        }
        .activity-data .data .data-list{
            font-size: 18px;
            font-weight: 400;
            margin-top: 20px;
            white-space: nowrap;
            color: var(--text-color);
        }

        .wrapper {
            background: #e7d1fc;
            border-radius: 5px;
            box-shadow: 0px 4px 10px 1px rgba(0, 0, 0, 0.1);
        }
        .wrapper .title {
            color: #fff;
            font-weight: 600;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .wrapper form {
            padding: 5px 5px;
        }
        .wrapper form .row {
            margin-top: 5px;
            position: relative;
        }
        .wrapper form .row input {
            outline: none;
            border-radius: 5px;
            border: 1px solid lightgrey;
            transition: all 0.3s ease;
        }
        form .row input::placeholder {
            color: #999;
        }
        .wrapper form .row i {

            color: #fff;
            border-radius: 5px 0 0 5px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .wrapper form .pass {
            margin-top: 5px;
        }
        .wrapper form .pass a {
            color: #16a085;
            text-decoration: none;
        }
        .wrapper form .pass a:hover {
            text-decoration: underline;
        }
        .wrapper form .button input {
            margin-top: 2px;
            padding: 3px;
            color: #fff;
            font-weight: 500;
            background: #16a085;
            border: 1px solid #16a085;
            cursor: pointer;
        }
        .button input {
            margin-top: 2px;
            padding: 3px;
            color: #fff;
            font-weight: 500;
            background: #16a085;
            border: 1px solid #16a085;
            cursor: pointer;
        }
        form .button input:hover {
            background: #12876f;
        }
        .button input:hover {
            background: #12876f;
        }
        .wrapper form .signup-link {
            text-align: center;
            font-size: 10px;
        }
        .wrapper form .signup-link a {
            color: #16a085;
            text-decoration: none;
        }
        form .signup-link a:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>
<nav>
    <div class="logo-name">
        <div class="logo-image">
            <img src="images/logo.png" alt="">
        </div>
        <span class="logo_name">CodingLab</span>
    </div>
    <div class="menu-items">
        <ul class="nav-links">
            <li><a href="#">
                    <i class="uil uil-estate"></i>
                    <span class="link-name">Dahsboard</span>
                </a></li>
            <li><a href="#">
                    <i class="uil uil-files-landscapes"></i>
                    <span class="link-name">Content</span>
                </a></li>
            <li><a href="#">
                    <i class="uil uil-chart"></i>
                    <span class="link-name">Analytics</span>
                </a></li>
            <li><a href="#">
                    <i class="uil uil-thumbs-up"></i>
                    <span class="link-name">Like</span>
                </a></li>
            <li><a href="#">
                    <i class="uil uil-comments"></i>
                    <span class="link-name">Comment</span>
                </a></li>
            <li><a href="#">
                    <i class="uil uil-share"></i>
                    <span class="link-name">Share</span>
                </a></li>
        </ul>

        <ul class="logout-mode">
            <li><a href="#">
                    <i class="uil uil-signout"></i>
                    <span class="link-name">Logout</span>
                </a></li>
            <li class="mode">
                <a href="#">
                    <i class="uil uil-moon"></i>
                    <span class="link-name">Dark Mode</span>
                </a>
                <div class="mode-toggle">
                    <span class="switch"></span>
                </div>
            </li>
        </ul>
    </div>
</nav>
<section class="dashboard">
    <div class="top">
        <div class="search-box">
            <i class="uil uil-search"></i>
            <input type="text" placeholder="Search here...">
        </div>

        <!--<img src="images/profile.jpg" alt="">-->
    </div>
    <div class="dash-content">
        <div class="overview">
            <div class="title">
                <i class="uil uil-tachometer-fast-alt"></i>
                <span class="text">Dashboard</span>
            </div>
            <div class="boxes">
                <div class="box box1">
                    <i class="uil uil-thumbs-up"></i>
                    <br>
                    <span class="text">Add</span>
                    <span class="text">Category</span>
                    <div class="wrapper2">
                        <form action="/admin/add_category" method="post" >
                            <div class="row">
                                <input type="text" placeholder="name "  name="name" required />
                            </div>

                                <div class="row button">
                                    <input type="submit" value="Add" />
                                </div>
                        </form>
                    </div>
                </div>
                <div class="box box2">
                    <i class="uil uil-comments"></i>
                    <span class="text">Add</span>
                    <span class="text">Author</span>
                    <div class="wrapper2">
                        <form action="/admin/add_author" method="post">
                            <div class="row">
                                <input type="text" placeholder="Author firstname "  name="firstName" required />
                            </div>
                            <div class="row">
                                <input type="text" placeholder="Author lastname" name="lastName" required />
                            </div>

                            <div class="row button">
                                <input type="submit" value="Add" />
                            </div>

                        </form>
                    </div>
                </div>
                <div class="box box3">
                    <i class="uil uil-share"></i>
                    <span class="text">Add</span>
                    <span class="text">Book</span>
                    <div class="wrapper">
                    <form action="/admin/add_book" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <input type="text" placeholder="title"  name="title" required />
                        </div>
                        <div class="row">
                            <input type="text" placeholder="description" name="description" required />
                        </div>
                        <div class="row">
                            <input type="text"  name="publisher" placeholder="publisher" required />
                        </div>
                        <div class="row">
                            <input type="number" placeholder="published year" name="year" required />
                        </div>
                        <div class="row">
                            <input type="file" placeholder="image "  name="file"  />
                        </div>
                        <span>Author</span>
                        <br>
                        <select name="author" id="author">
                            <#list authors as author>
                                <option value="${author.id}">${author.firstName} ${author.lastName}</option>
                            </#list>
                        </select>
                        <span> Category</span>
                        <br>
                        <select name="category" id="category">
                            <#list categories as category>
                                <option value="${category.id}">${category.name} </option>
                            </#list>
                        </select>
                        <div class="row button">
                            <input type="submit" value="Add" />
                        </div>
                    </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="activity">
            <div class="title">
                <i class="uil uil-clock-three"></i>
                <span class="text">Recent Activity</span>
            </div>
            <div class="activity-data">
                <div class="data names">
                    <span class="data-title">Name</span>
                    <span class="data-list">Prem Shahi</span>
                    <span class="data-list">Deepa Chand</span>
                    <span class="data-list">Manisha Chand</span>
                    <span class="data-list">Pratima Shahi</span>
                    <span class="data-list">Man Shahi</span>
                    <span class="data-list">Ganesh Chand</span>
                    <span class="data-list">Bikash Chand</span>
                </div>
                <div class="data email">
                    <span class="data-title">Email</span>
                    <span class="data-list">premshahi@gmail.com</span>
                    <span class="data-list">deepachand@gmail.com</span>
                    <span class="data-list">prakashhai@gmail.com</span>
                    <span class="data-list">manishachand@gmail.com</span>
                    <span class="data-list">pratimashhai@gmail.com</span>
                    <span class="data-list">manshahi@gmail.com</span>
                    <span class="data-list">ganeshchand@gmail.com</span>
                </div>
                <div class="data joined">
                    <span class="data-title">Joined</span>
                    <span class="data-list">2022-02-12</span>
                    <span class="data-list">2022-02-12</span>
                    <span class="data-list">2022-02-13</span>
                    <span class="data-list">2022-02-13</span>
                    <span class="data-list">2022-02-14</span>
                    <span class="data-list">2022-02-14</span>
                    <span class="data-list">2022-02-15</span>
                </div>
                <div class="data type">
                    <span class="data-title">Type</span>
                    <span class="data-list">New</span>
                    <span class="data-list">Member</span>
                    <span class="data-list">Member</span>
                    <span class="data-list">New</span>
                    <span class="data-list">Member</span>
                    <span class="data-list">New</span>
                    <span class="data-list">Member</span>
                </div>
                <div class="data status">
                    <span class="data-title">Status</span>
                    <span class="data-list">Liked</span>
                    <span class="data-list">Liked</span>
                    <span class="data-list">Liked</span>
                    <span class="data-list">Liked</span>
                    <span class="data-list">Liked</span>
                    <span class="data-list">Liked</span>
                    <span class="data-list">Liked</span>
                </div>
            </div>
        </div>
    </div>
</section>
