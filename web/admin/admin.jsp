<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>admin panel</title>
    <link href="../assets/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url("../images/7823414.jpg") no-repeat fixed;
            background-size: cover;
        }
        #snackbar {
            visibility: hidden;
            min-width: 250px;
            margin-left: -125px;
            background-color: whitesmoke;
            color: black;
            text-align: center;
            border-radius: 10px;
            padding: 16px;
            position: fixed;
            z-index: 1;
            left: 50%;
            bottom: 30px;
            font-size: 17px;
        }

        #snackbar.show {
            visibility: visible;
            -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
            animation: fadein 0.5s, fadeout 0.5s 2.5s;
        }

        @-webkit-keyframes fadein {
            from {bottom: 0; opacity: 0;}
            to {bottom: 30px; opacity: 1;}
        }

        @keyframes fadein {
            from {bottom: 0; opacity: 0;}
            to {bottom: 30px; opacity: 1;}
        }

        @-webkit-keyframes fadeout {
            from {bottom: 30px; opacity: 1;}
            to {bottom: 0; opacity: 0;}
        }

        @keyframes fadeout {
            from {bottom: 30px; opacity: 1;}
            to {bottom: 0; opacity: 0;}
        }
    </style>
</head>
<body>
<nav class="navbar">
    <div class="container-fluid row">
        <ul class="">
            <li class="nav-item d-inline m-3"><a href="#" class="text-decoration-none text-white" onclick="requestToDifferentPages('admin')">Admin Panel</a></li>
            <li class="nav-item d-inline m-3"><a href="#" class="text-decoration-none text-white" onclick="requestToDifferentPages('employee')">Employee Panel</a></li>
            <li class="nav-item d-inline m-3"><button class="btn btn-danger" onclick="logout()">log out</button></li>
        </ul>
    </div>
</nav>
<div class="container">
    <table class="table table-hover table-dark table-bordered table-responsive w-100">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>FAMILY</th>
            <th>Employee Code</th>
            <th>Entrance time</th>
            <th>Exit time</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="employee">
            <tr>
                <td>${employee.employeeId}</td>
                <td>${employee.name}</td>
                <td>${employee.family}</td>
                <td>${employee.empCode}</td>
                <td>${employee.entranceTime}</td>
                <td>${employee.exitTime}</td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
<script>
    function requestToDifferentPages(panel) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState===4){
                // Typical action to be performed when the document is ready:
                console.log(this.status);
                if (this.status===200){
                    location.href="../"+panel+"/"+panel+".do";
                }
            }
        };
        xhttp.open("GET", "/"+ panel+"/"+panel+".jsp");
        xhttp.send();
    }
    function logout() {
        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/logout.do");
        xhttp.send();
    }
</script>
</html>
