<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/8/2022
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="../assets/bootstrap.min.css" rel="stylesheet">
    <script src="../assets/bootstrap.min.js"></script>
    <script src="../assets/jquery.min.js"></script>
    <title>employee Panel</title>

</head>
<style>
    .btn:focus {
        outline: none;
        box-shadow: none;
    }

    body {
        background: url("../images/3013992.jpg") no-repeat fixed;
        background-size: cover;
    }

    #timeSetSection {
        background: #abbaab; /* fallback for old browsers */
        background: -webkit-linear-gradient(to right, #ffffff, #5c636a); /* Chrome 10-25, Safari 5.1-6 */
        background: linear-gradient(to right, #ffffff, #5c636a); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
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
                <li class="nav-item text-end m-3"><button class="btn btn-danger" onclick="logout()">log out</button></li>
            </ul>
        </div>
    </div>
</nav>
<div class=" m-4 p-1 text-center rounded" id="timeSetSection">
    <h4 class="text-center m-2">Choose the moment of your Entry or Exit</h4>
    <form action="/employee" method="Get">
        <button name="entranceTime" type="button" class="btn btn-success" onclick="setTime('entranceTime.do')">Entry
        </button>
        <button name="exitTime" type="button" class="btn btn-danger" onclick="setTime('exitTime.do')">Exit</button>
    </form>
    <p id="timeShow" class=""></p>
</div>

<div id="snackbar">You don't have access to admin panel!</div>
</body>
<script>

    let nowDate = new Date;

    function setTime(timeType) {
        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/employee/" + timeType, false);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();
        document.getElementById("timeShow").innerHTML = timeType.replace(".do","").replace("Time","") + ":  " + nowDate.toUTCString();
    }

    function myFunction() {
        var x = document.getElementById("snackbar");
        x.className = "show";
        setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    }

    function requestToDifferentPages(panel) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState===4){
                // Typical action to be performed when the document is ready:
                console.log(this.status);
                if (this.status===200){
                    location.href="../"+panel+"/"+panel+".do";
                }
                else {
                    myFunction();
                }
            }
        };
        xhttp.open("GET", "/"+ panel+"/"+panel+".do");
        xhttp.send();
    }
    function logout() {
        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/logout.do");
        xhttp.send();
    }
</script>

</html>
