<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GTM">
    <title>Company manager</title>
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../static/css/style.css" rel="stylesheet">
</head>
<body>
<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">Company manager</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Employees<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="new-employee">Add Employee</a></li>
                        <li><a href="all-employees">All Employees</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Jobs<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="new-employee">Add Job</a></li>
                        <li><a href="all-employees">All Jobs</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Departments<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="new-department">Add Department</a></li>
                        <li><a href="all-departments">All Departments</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Welcome to Company Manager</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_ADDED'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>You added/changed the record</h1>
            </div>
        </div>
    </c:when>
</c:choose>
<script src="../../static/js/jquery-1.11.1.min.js"></script>
<script src="../../static/js/bootstrap.min.js"></script>
</body>
</html>