<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rizki
  Date: 01/06/15
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link type="text/css" href="lib/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .bodyLogin {
            background-color: #1abc9c;
            border-color: #16a085;
        }
    </style>
</head>
<body class="bodyLogin">

<div class="container">
    <div class="row" style="padding-top: 100px">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">

            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Login</h3>
                </div>
                <div class="panel-body">
                    <form method="post" action="<c:url value='/j_spring_security_check?targetUrl=${targetUrl}' />">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input name="j_username" type="text" class="form-control" id="username" placeholder="Username">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input name="j_password" type="password" class="form-control" id="password" placeholder="Password">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="_spring_security_remember_me"> Remember Me
                            </label>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <button type="submit" class="btn btn-success btn-block">Login</button>
                    </form>
                </div>
                <div class="panel-footer">
                    <a href="/signUp">Register</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="lib/js/jquery-2.1.4.min.js"></script>
<script src="lib/js/bootstrap.min.js"></script>
</body>
</html>
