<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<link href="webjars/bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
<title>${username} List Todos | Todo Application</title>
<style>
.padtb10{padding:10px 0;}
</style>
</head>
<body>
<div class="container">
    <h5 class="display-4">List of Todos for ${username}:</h5>
    <table class="table table-striped table-bordered">
    <tr class="text-center">
        <th scope="col">Sl No</th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
        <th scope="col">Target Date</th>
        <th scope="col">Completed</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    <c:forEach items="${todos}" var="todo">
    <tr class="text-center">
        <td scope="row">${todo.id}</td>
        <td>${todo.user}</td>
        <td>${todo.desc}</td>
        <td>${todo.targetDate}</td>
        <td>${todo.done}</td>
         <td><a type="button" class="btn btn-info" href="/update-todo?id=${todo.id}">UPDATE </a></td>
        <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">DELETE </a></td>

    </tr>
    </c:forEach>
    </table>


    <div class="padtb10"><a class="button" href="/add-todo" >Add Todo</a></div>

</div>
<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/4.5.3/js/bootstrap.min.js"></script>
</body>
</html>