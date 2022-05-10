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
    <title>Title</title>
</head>
<body>
<button onclick="setTime('/entranceTime')" id="">Entry</button>
<button onclick="setTime('/exitTime')">Exit</button>
</body>
<script>
    function setTime(time) {
        const xhttp = new XMLHttpRequest();
        xhttp.open("POST", time);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send(moment().format('YYYY-MM-DD HH:mm:ss'));
    }
</script>
</html>
