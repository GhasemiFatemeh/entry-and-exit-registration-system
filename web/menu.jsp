<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/25/2022
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar">
    <div class="container-fluid row">
        <div class="col-6">
            <ul class="">
                <li class="nav-item d-inline m-3"><a href="#" class="text-decoration-none text-white" onclick="requestToDifferentPages('admin')">Admin Panel</a></li>
                <li class="nav-item d-inline m-3"><a href="#" class="text-decoration-none text-white" onclick="requestToDifferentPages('employee')">Employee Panel</a></li>
            </ul>
        </div>
        <div class="col-6">
            <ul class="">
                <li class="nav-item text-end m-3" style="list-style: none"><button class="btn btn-danger" onclick="logout()">log out</button></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
