<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
<script>
    function addUser(email, password) {
        let newUser = {
          "email" : email,
          "password" : password
        };

        $.ajax({
            type: "POST",
            url: "/users/add",
            data: JSON.stringify(newUser),
            success: function(data) {
                        let resultList = "<ul>";
                        data.forEach(function (value, index, array) {
                            resultList += '<li>' + value["email"] +  '</li>';
                        });
                        resultList += '</ul>';
                        document.getElementById("usersTable").innerHTML = resultList;
            },
            contentType: "application/json",
            dataType: "json"
        });
    }
</script>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>EMAIL</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
            </tr>
        </#list>
    </table>
</div>
<h1>By FORM</h1>
<div>
    <form action="/users" method="post">
        <input type="text" name="email">
        <input type="password" name="password">
        <input type="submit" value="Submit">
    </form>
</div>
<br>
<h1>By Ajax Ajax</h1>
<div>
    <input id="emailForAjax" type="text" name="email">
    <input id="passwordForAjax" type="text" name="password">
    <button onclick="addUser($('#emailForAjax').val(), $('#passwordForAjax').val())">Submit</button>
</div>
<div id="usersTable">

</div>
</body>
</html>