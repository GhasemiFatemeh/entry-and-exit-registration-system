<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/8/2022
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link href="assets/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header>
    <h1 class="h1 text-center text-capitalize m-2">login</h1>
</header>
<div class="container border rounded p-4">
    <form action="/login.do">
        <div class="form-group mb-3">
            <label for="code">Employee Code</label>
            <input class="form-control" id="code"  name="empCode" placeholder="Enter Your Employee code...">
            <small id="emailHelp" class="form-text text-muted">We'll never share your code with anyone else.</small>
        </div>
        <div class="form-group mb-3">
            <label for="pass">Password</label>
            <input type="password" class="form-control" id="pass" name="password" placeholder="Password">
        </div>
        <div class="form-check mb-3">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">keep my password</label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
