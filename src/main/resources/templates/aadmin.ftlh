<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            background-color: rgba(250, 240, 230, 1);
            margin: auto;
        }

        li {
            display: inline-block;
            vertical-align: middle;
            margin-right: 35px;
        }

        header {
            display: flex;
            justify-content: center;
            color: #cfc6b2;
            font-size: 1.1rem;
        }
        .button2 {
            height:25px;
            width: 55px;

        }

        a {
            text-decoration: none;
            color: rgba(134, 134, 200, 1);
            font-size: 17px;

        }
        a:hover {
            color: #dd4192;
        }
    </style>

</head>
<body align ="center">
<h2>Create a new category</h2>
<form action="/admin/add_category" method="post">
    <h3 style="text-indent:30px">
        Category name <input type="text" name="name">
        <br>
        <br>
        <input type="submit" value="Add" class="button2">
    </h3>
</form>
<h2>Add a new author</h2>
<form action="/admin/add_author" method="post">
    <h3 style="text-indent:30px">
        Author firstname <input type="text" name="firstName">
        <br>
        Author lastname <input type="text" name="lastName">
        <br>
        <br>
        <input type="submit" value="Add" class="button2">
    </h3>
</form>
<h2>Add a new book</h2>
<form action="/admin/add_author" method="post">
    <h3 style="text-indent:30px">
        title <input type="text" name="title">
        <br>
        description <input type="text" name="description">
        <br>
        <br>
        publisher <input type="text" name="publisher">
        <br>
        <br>
        year <input type="number" step="1" name="year">
        <br>
        <br>
        author <select name="author" id="author">
           <#list authors as author>
              <option value="${author.id}">${author.firstName} ${author.lastName}</option>
           </#list>
        </select>
        <br>
        <br>
        category <select name="categories" id="category">
            <#list categories as category>
                <option value="${category.id}">${category.name} </option>
            </#list>
        </select>
        <br>

        <input type="submit" value="Add" class="button2">
    </h3>

</form>
</body>
</html>