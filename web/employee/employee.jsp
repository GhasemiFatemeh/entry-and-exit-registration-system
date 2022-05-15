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
    <title>Title</title>
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
</style>
<body>
<div class=" m-4 p-1 text-center rounded" id="timeSetSection">
    <h4 class="text-center m-2">Choose the moment of your Entry or Exit</h4>
    <form action="/employee" method="Get">
        <button name="entranceTime" type="button" class="btn btn-success" onclick="setTime('entranceTime')">Entry
        </button>
        <button name="exitTime" type="button" class="btn btn-danger" onclick="setTime('exitTime')">Exit</button>
    </form>
    <p id="timeShow"></p>
</div>

</body>
<script>

    let nowDate = new Date;

    function setTime(timeType) {
        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/employee?" + timeType + "=" + nowDate.getTime(), false);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();
        document.getElementById("timeShow").innerHTML = timeType + ":  " + nowDate.toUTCString();
    }
</script>
</html>
