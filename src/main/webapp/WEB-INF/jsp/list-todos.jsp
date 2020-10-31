<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

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
        <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
        <td>${todo.done}</td>
         <td><a type="button" class="btn btn-info" href="/update-todo?id=${todo.id}">UPDATE </a></td>
        <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">DELETE </a></td>

    </tr>
    </c:forEach>
    </table>


    <div class="padtb10"><a class="button" href="/add-todo" >Add Todo</a></div>

</div>
<%@ include file="common/footer.jspf" %>