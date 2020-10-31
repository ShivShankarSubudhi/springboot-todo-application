<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
   <p class="h2">Hi ${username}!  You have successfully logged in</p>
    <div><a class="text-link" href="/list-todos" >Click here</a> the list of todos </div>
</div>
<%@ include file="common/footer.jspf" %>