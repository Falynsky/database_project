<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GTM">

    <title>Employee manager | Home</title>
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../static/css/style.css" rel="stylesheet">

</head>

<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">Bootsample</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="new-employee">Manage Employees</a></li>
                <li><a href="all-employees">All Employees</a></li>
            </ul>
        </div>
    </div>
</div>


<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Welcome to Employee Manager</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_EMPLOYEES'}">
        <div class="container text-center" id="employeeDiv">
            <h3>My employees</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th> Id</th>
                        <th> First name</th>
                        <th> Last name</th>
                        <th> Email</th>
                        <th> Phone Number</th>
                        <th> Job Id</th>
                        <th> Salary</th>
                        <th> Department Id</th>
                        <th> Manager Id</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td>${employee.employeeId}</td>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>
                            <td>${employee.email}</td>
                            <td>${employee.phoneNumber}</td>
                            <td>${employee.jobsByJobId.jobId}</td>
                            <td>${employee.salary}</td>
                            <td>${employee.departmentsByDepartmentId.departmentId}</td>
                            <td>${employee.employeesByManagerId.employeeId}</td>
                            <td><a href="delete-employee?id=${employee.employeeId}"><span
                                    class="glyphicon glyphicon-trash"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        ;=jtrf
    </c:when>
    <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
        <div class="container text-center">
            <h3>Manage employees</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="save-employee">
                <div class="form-group">
                    <label class="control-label col-md-3">Id
                    </label>
                    <div class="col-md-7">
                        <input type="number" class="form-control" name="employeeId" value="${employee.employeeId}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">First Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="firstName" value="${employee.firstName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Last Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="lastName" value="${employee.lastName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Email</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="email" value="${employee.email}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Phone number</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="phoneNumber" value="${employee.phoneNumber}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Job Id</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="jobId"
                               value="${employee.jobsByJobId.jobJd}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Salary</label>
                    <div class="col-md-7">
                        <input type="number" class="form-control" name="salary" value="${employee.salary}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Department Id</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="departmentId"
                               value="${employee.departmentsByDepartmentId.departmentId}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Manager Id</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="managerId"
                               value="${employee.employeesByManagerId.employeeId}"/>
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