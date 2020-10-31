<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<p class="h2">Hi ${username}! Welcome to add todo Page:</p>

<form:form class="form" method="POST"  modelAttribute="todo">
    <form:hidden path="id"></form:hidden>
    <fieldset class="form-group">
        <form:label path="desc">Description</form:label>
        <form:input type="text" path="desc" placeholder="Enter the Task" class="form-control" required="required"></form:input>
        <form:errors path="desc" cssClass="text-red"/>
    </fieldset>
    <fieldset class="form-group">
        <form:label path="targetDate">Target Date</form:label>
        <form:input type="text" path="targetDate" placeholder="Enter the Target Date" class="form-control" required="required"></form:input>
        <form:errors path="targetDate" cssClass="text-red"/>
    </fieldset>
     <div class="pad10">
      <button class="btn btn-primary" type="submit">Add Todo</button>
    </div>
</form:form>
</div>
<%@ include file="common/footer.jspf" %>