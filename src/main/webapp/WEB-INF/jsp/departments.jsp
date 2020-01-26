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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Employees<span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="new-employee">Add Employee</a></li>
                        <li><a href="all-employees">All Employees</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-expanded="false">Jobs<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="new-job">Add Job</a></li>
                        <li><a href="all-jobs">All Jobs</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Departments<span
                            class="caret"></span></a>
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
    <c:when test="${mode == 'MODE_ADDED'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>You added/changed the record</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_DEPARTMENTS'}">
        <div class="container text-center" id="departmentsDiv">
            <h3>Departments list</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th> Department Id</th>
                        <th> Department name</th>
                        <th> Manager id</th>
                        <th> Location id</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="department" items="${departments}">
                        <tr>
                            <td>${department.departmentId}</td>
                            <td>${department.departmentName}</td>
                            <td>${department.employeesByManagerId.employeeId}</td>
                            <td>${department.locationsByLocationId.locationId}</td>
                            <td><a href="delete-department?id=${department.departmentId}"><span
                                    class="glyphicon glyphicon-trash"></span></a><a/>
                                <a href="update-department?id=${department.departmentId}"><span
                                        class="glyphicon glyphicon-pencil"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
        <div class="container text-center">
            <h3>Manage department</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="save-department">
                <div class="form-group">
                    <label class="control-label col-md-3">Id
                    </label>
                    <div class="col-md-7">
                        <input type="number" class="form-control" name="departmentId"
                               value="${department.departmentId}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Department Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="departmentName"
                               value="${department.departmentName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Manager id</label>
                    <div class="col-md-7">
                        <input type="number" class="form-control" name="managerId"
                               value="${department.employeesByManagerId.employeeId}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Location Id</label>
                    <div class="col-md-7">
                        <input type="number" class="form-control" name="locationId"
                               value="${department.locationsByLocationId.locationId}"/>
                    </div>
                </div>
                <div class="pull-right">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </form>
        </div>
    </c:when>
</c:choose>
<script src="../../static/js/jquery-1.11.1.min.js"></script>
<script src="../../static/js/bootstrap.min.js"></script>
</body>
</html>