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
    <title>Sign Up</title>
    <link href="assets/bootstrap.min.css" rel="stylesheet">
</head>
<body onload="enableButtonConditionally()">
<header>
    <h1 class="h1 text-center text-capitalize m-2">Register</h1>
</header>
<div class="container border rounded m-auto p-4">
    <form action="/register">
        <div class="row mb-3">
            <div class="form-group col-6">
                <label for="inputName">First Name</label>
                <input type="text" name="name" class="form-control" id="inputName" placeholder="Enter Your Name...">
            </div>
            <div class="form-group col-6">
                <label for="inputFamily">Last Name</label>
                <input type="text" name="family" class="form-control" id="inputFamily"
                       placeholder="Enter your family...">
            </div>
        </div>
        <div class="row mb-3">
            <div class="form-group col-6">
                <label for="inputEmpCode">Employee Code</label>
                <input type="text" name="empCode" class="form-control" id="inputEmpCode" placeholder="Enter your Employee Code" required>
            </div>
            <div class="form-group col-6">
                <label for="inputPassword">password</label>
                <input type="password" name="password" class="form-control" id="inputPassword" required>
            </div>
        </div>
        <div class="form-group mb-3">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck">
                <label class="form-check-label" for="gridCheck">
                    I Agree to term and conditions
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary" id="submit-button">Sign in</button>
    </form>
</div>

</body>
<script>
    const checkBox = document.getElementById("gridCheck");
    // Retrieve reference to button
    const submitButton = document.getElementById("submit-button");

    function enableButtonConditionally(){
        submitButton.disabled = !checkBox.checked;
    }
    checkBox.addEventListener("change", (e) => {
        submitButton.disabled = !e.target.checked;
    });
</script>
</html>
