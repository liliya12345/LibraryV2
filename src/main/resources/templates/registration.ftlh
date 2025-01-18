<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <style>
        body {
            background-color: #faf0e6;
            margin: auto;
        }
    </style>

</head>

<body>
<div align="center">
    <h2 style="color: #8686c8">Регистрация пользователя</h2>
    <br>
    <br>
    <br>

    <form action="/registration" method="post">
        <h3 style="text-indent:30px">
            First Name<input type="text" name="firstName">
            <br>
            <br>
            Last Name<input type="text" name="lastName">
            <br>
            <br>
            Birthday<input type="date" name="birthday">
            <br>
            <br>
            Login<input type="text" name="login">
            <br>
            <br>
            Password<input type="password" name="password">
            <br>
            <br>
            <input type="submit" value="Registration" class="button2">
        </h3>
    </form>







</div>

</body>
</html>
