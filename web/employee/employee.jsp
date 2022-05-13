<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/8/2022
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</style>
<body>
<div class="container border m-4 p-1 text-center">
    <h4>Choose the moment of your Entry or Exit</h4>
    <form action="/employee" method="Get">
        <button name="entranceTime" type="button" class="btn btn-success" onclick="setTime('entranceTime')">Entry</button>
        <button name="exitTime" type="button" class="btn btn-danger" onclick="setTime('exitTime')">Exit</button>
    </form>
    <p id="timeShow"></p>
</div>

</body>
<script>

    let nowDate = new Date;
    function setTime(timeType) {
        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/employee/?"+timeType+"="+nowDate.toUTCString(), false);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();
        document.getElementById("timeShow").innerHTML =timeType+":  "+ nowDate.toUTCString();
    }
</script>
</html>
