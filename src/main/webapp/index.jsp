
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
<%--    <link href="/css/login.css" rel="stylesheet" media="screen" type="text/css"/>--%>
    <style>
        <%@ include file="/css/login.css" %>
    </style>

</head>
<body align="center">

<div class="rect2">
</div>
<div class="rect">
</div>

    <h1>Sign In</h1>
    <div id="wrapper">
        <form id="signin" method="post" action="" autocomplete="off">
            <input type="text" id="user" name="login" placeholder="login" />
            <input type="password" id="pass" name="password" placeholder="password" />
            <button type="submit">&#xf0da;</button>
            <p>have no account? <a href="registration">click here</a></p>
        </form>
    </div>


</body>
<script src="js/login.js"></script>
</html>
