
<%@ page isELIgnored = "false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <style>
        <%@ include file="/css/signup.css" %>
    </style>
</head>
<body>
<div class="rect2">
</div>
<div class="rect">
</div>


<h1>Sign Up</h1>
<div id="wrapper">
    <form id="signup" action="#" method="post" >
        <input type="text" id="user" name="login" placeholder="login">
        <input type="text" id="firstname" name="firstname" placeholder="firstname">
        <input type="text" id="lastname" name="lastname" placeholder="lastname">
        <input type="text" id="email" name="email" placeholder="email">
        <input type="password"  name="password" placeholder="password">
        <input type="password" name="confirm_password" placeholder="confirm password">
        <button type="submit">&#xf0da;</button>
    <p>do you have account? <a href="index.jsp">click here</a></p>
    </form>


</div>

<%--    <form action="#" method="post">--%>
<%--        <div class="form-group">--%>
<%--            <label>Input your login</label>--%>
<%--            <input name="login" class="form-control" placeholder="login">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label>Input your password</label>--%>
<%--            <input type="password" class="form-control" name="password" placeholder="password">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label>Repeat your password</label>--%>
<%--            <input type="password" class="form-control" name="confirm_password" placeholder="repeat password">--%>
<%--        </div>--%>
<%--        <button type="submit" class="btn btn-primary">Enter</button>--%>
<%--    </form>--%>

</body>
</html>