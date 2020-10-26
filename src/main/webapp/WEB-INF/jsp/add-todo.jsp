<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>

<title>${username} Add Todo | Todo Application</title>
<link href="webjars/bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">

<style>
.text-bold{font-weight:bold;}
.pad10{padding:10px;}
.text-red{color:red;}
.text-link{color:blue;}
.text-link:hover{text-decoration:underline;}
</style>
</head>
<body>
<div class="container">
<p class="h2">Hi ${username}! Welcome to add todo Page:</p>

<form:form class="form" method="POST"  modelAttribute="todo">
    <form:hidden path="id"></form:hidden>
    <form:hidden path="targetDate"></form:hidden>
    <fieldset class="form-group">
        <form:label path="desc">Description</form:label>
        <form:input type="text" path="desc" placeholder="Enter the Task" class="form-control" required="required"></form:input>
        <form:errors path="desc" cssClass="text-red"/>
    </fieldset>
     <div class="pad10">
      <button class="btn btn-primary" type="submit">Add Todo</button>
    </div>
</form:form>
</div>

<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/4.5.3/js/bootstrap.min.js"></script>
</body>
</html>